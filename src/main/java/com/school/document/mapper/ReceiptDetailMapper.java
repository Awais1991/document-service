package com.school.document.mapper;

import com.school.document.dto.ReceiptDetailDto;
import com.school.document.dto.ReceiptDto;
import com.school.document.entity.FeeDetail;
import com.school.document.entity.ReceiptDetail;
import com.school.document.util.ReceiptUtils;
import org.springframework.stereotype.Component;

@Component
public class ReceiptDetailMapper {

   public FeeDetail mapToEntity(ReceiptDetailDto  receiptDetailDto){
       FeeDetail feeDetail = new FeeDetail();
       feeDetail.setFeeUuid(receiptDetailDto.getFeeUuid());
       feeDetail.setFeeType(receiptDetailDto.getFeeType());
       feeDetail.setFeeTypeDesc(receiptDetailDto.getFeeTypeDesc());
       feeDetail.setFeeAmount(receiptDetailDto.getFeeAmount());
       feeDetail.setFeeCurrency(receiptDetailDto.getFeeCurrency());
       feeDetail.setFeeGrade(receiptDetailDto.getFeeGrade());
       return feeDetail;

   }
   public ReceiptDetailDto mapToDto(FeeDetail feeDetail){
       ReceiptDetailDto receiptDetailDto = new ReceiptDetailDto();
       receiptDetailDto.setFeeUuid(feeDetail.getFeeUuid());
       receiptDetailDto.setFeeType(feeDetail.getFeeType());
       receiptDetailDto.setFeeTypeDesc(feeDetail.getFeeTypeDesc());
       receiptDetailDto.setFeeAmount(feeDetail.getFeeAmount());
       receiptDetailDto.setFeeCurrency(feeDetail.getFeeCurrency());
       receiptDetailDto.setFeeGrade(feeDetail.getFeeGrade());
       return receiptDetailDto;
   }

}
