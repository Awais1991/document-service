package com.school.document.validator;

import com.school.document.dto.ReceiptDto;
import org.springframework.stereotype.Component;

@Component
public class ReceiptRequestValidator implements RequestValidator{

    public boolean validateReceiptRequest(ReceiptDto receiptDto){
        validateNotNull(receiptDto, "Body is empty");
        validateNotBlank(receiptDto.getTransactionId(), "transactionId cannot be blank");
        validateNotBlank(receiptDto.getSchoolUuid(), "schoolId cannot be blank");
        validateNotBlank(receiptDto.getSchoolName(), "schoolName cannot be blank");
        validateNotBlank(receiptDto.getStudentId(), "studentId cannot be blank");
        validateNotBlank(receiptDto.getStudentFirstName(), "studentFirstName cannot be blank");
        validateNotBlank(receiptDto.getGuardianName(), "fatherName cannot be blank");
        validateNotNull(receiptDto.getTotalAmount(), "totalAmount cannot be blank");
        validateNotBlank(receiptDto.getCardNumber(), "cardNo cannot be blank");
        validateNotBlank(receiptDto.getCardNetwork(), "cardNetwork cannot be blank");
        validateNotNull(receiptDto.getFeePaidAt(), "feePaid time cannot be blank");
        validateNotNull(receiptDto.getReceiptDetails(), "fee details cannot be blank");
        return true;
    }

}
