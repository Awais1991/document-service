package com.school.document.mapper;

import com.school.document.dto.ReceiptDto;
import com.school.document.entity.ReceiptDetail;
import com.school.document.util.ReceiptUtils;
import org.springframework.stereotype.Component;

@Component
public class ReceiptMapper {

   public ReceiptDetail mapToEntity(ReceiptDto receiptDto){
       ReceiptDetail receiptDetail = new ReceiptDetail();
       receiptDetail.setReceiptId(ReceiptUtils.generateReceiptId(15));
       receiptDetail.setTransactionId(receiptDto.getTransactionId());
       receiptDetail.setSchoolUuid(receiptDto.getSchoolUuid());
       receiptDetail.setSchoolName(receiptDto.getSchoolName());
       receiptDetail.setStudentUuid(receiptDto.getStudentUuid());
       receiptDetail.setStudentId(receiptDto.getStudentId());
       receiptDetail.setStudentFirstName(receiptDto.getStudentFirstName());
       receiptDetail.setStudentLastName(receiptDto.getStudentLastName());
       receiptDetail.setGuardianName(receiptDto.getGuardianName());
       receiptDetail.setTotalAmount(receiptDto.getTotalAmount());
       receiptDetail.setCardNumber(receiptDto.getCardNumber());
       receiptDetail.setCardNetwork(receiptDto.getCardNetwork());
       receiptDetail.setFeePaidAt(receiptDto.getFeePaidAt());
       receiptDetail.setTotalAmount(receiptDto.getTotalAmount());
       receiptDetail.setCurrency(receiptDto.getCurrency());
       return receiptDetail;
   }

   public ReceiptDto mapToDto(ReceiptDetail receiptDetail){
       ReceiptDto receiptDto = new ReceiptDto();
       receiptDto.setReceiptNumber(receiptDto.getReceiptNumber());
       receiptDto.setTransactionId(receiptDetail.getTransactionId());
       receiptDto.setSchoolUuid(receiptDetail.getSchoolUuid());
       receiptDto.setSchoolName(receiptDetail.getSchoolName());
       receiptDto.setStudentUuid(receiptDetail.getStudentUuid());
       receiptDto.setStudentId(receiptDetail.getStudentId());
       receiptDto.setStudentFirstName(receiptDetail.getStudentFirstName());
       receiptDto.setStudentLastName(receiptDetail.getStudentLastName());
       receiptDto.setGuardianName(receiptDetail.getGuardianName());
       receiptDto.setTotalAmount(receiptDetail.getTotalAmount());
       receiptDto.setCurrency(receiptDetail.getCurrency());
       receiptDto.setCardNumber(receiptDetail.getCardNumber());
       receiptDto.setCardNetwork(receiptDetail.getCardNetwork());
       receiptDto.setFeePaidAt(receiptDetail.getFeePaidAt());
       return receiptDto;

   }

}
