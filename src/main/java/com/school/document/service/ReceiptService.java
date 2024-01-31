package com.school.document.service;

import com.school.document.dto.ReceiptDetailDto;
import com.school.document.dto.ReceiptDto;
import com.school.document.entity.FeeDetail;
import com.school.document.entity.ReceiptDetail;
import com.school.document.enums.ErrorCode;
import com.school.document.exception.ApplicationException;
import com.school.document.mapper.ReceiptDetailMapper;
import com.school.document.mapper.ReceiptMapper;
import com.school.document.repo.ReceiptDetailRepository;
import com.school.document.validator.ReceiptRequestValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReceiptService {

    private final ReceiptDetailRepository receiptDetailRepository;
    private final ReceiptRequestValidator receiptRequestValidator;
    private final ReceiptMapper receiptMapper;
    private final ReceiptDetailMapper receiptDetailMapper;
    private final TemplateService templateService;

    public ReceiptService(ReceiptDetailRepository receiptDetailRepository, ReceiptRequestValidator receiptRequestValidator,
                          ReceiptMapper receiptMapper, ReceiptDetailMapper receiptDetailMapper, TemplateService templateService) {
        this.receiptDetailRepository = receiptDetailRepository;
        this.receiptRequestValidator = receiptRequestValidator;
        this.receiptMapper = receiptMapper;
        this.receiptDetailMapper = receiptDetailMapper;
        this.templateService = templateService;
    }

    public String addReceipt(ReceiptDto receiptDto){
        receiptRequestValidator.validateReceiptRequest(receiptDto);
       return Optional.ofNullable(receiptDto).filter(receiptDto1 -> !receiptDetailRepository.existsByTransactionId(receiptDto1.getTransactionId())).map(receiptDto1 -> {
            ReceiptDetail receiptDetail = receiptMapper.mapToEntity(receiptDto1);
            Set<FeeDetail> feeDetails =
                    receiptDto1.getReceiptDetails().stream().map(receiptDetailMapper::mapToEntity).map(feeDetail -> {
                        feeDetail.setFeeTransaction(receiptDetail);
                        return feeDetail;
                    }).collect(Collectors.toSet());
            receiptDetail.setFeeTransactionDetails(feeDetails);
            return receiptDetail;
        }).map(receiptDetailRepository::save).map(ReceiptDetail::getReceiptId)
               .orElseThrow(() -> new ApplicationException(ErrorCode.UNABLE_TO_GENERATE_RECEIPT));

    }
    public String viewReceipt(String receiptId, boolean isReceiptId){
        Optional<ReceiptDetail> receiptDetailOptional = isReceiptId ?
                receiptDetailRepository.findByReceiptId(receiptId) :
                receiptDetailRepository.findByTransactionId(receiptId);

        ReceiptDetail receiptDetail = receiptDetailOptional
                .orElseThrow(() -> new ApplicationException(ErrorCode.UNABLE_TO_FIND_RECEIPT));


        ReceiptDto receiptDto = receiptMapper.mapToDto(receiptDetail);
        receiptDetail.getFeeTransactionDetails().stream()
                .map(receiptDetailMapper::mapToDto).collect(Collectors.toList());
        receiptDto.setReceiptDetails(receiptDetail.getFeeTransactionDetails().stream()
                .map(receiptDetailMapper::mapToDto).collect(Collectors.toList()));



        return templateService.generateHtmlContent(receiptDto);

    }
}
