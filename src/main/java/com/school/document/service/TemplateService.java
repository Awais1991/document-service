package com.school.document.service;

import com.school.document.dto.ReceiptDto;
import com.school.document.entity.ReceiptDetail;
import com.school.document.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TemplateService {

    private final TemplateEngine templateEngine;

    public TemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateHtmlContent(ReceiptDto receiptDto) {
        Context context = new Context();
        context.setVariable("gName", receiptDto.getGuardianName());
        context.setVariable("datetime", DatetimeUtil.formatDatetime(receiptDto.getFeePaidAt()));
        context.setVariable("studentName", receiptDto.getStudentFirstName()+" "+ receiptDto.getStudentLastName());
        context.setVariable("studentId", receiptDto.getStudentId());
        context.setVariable("reference", receiptDto.getTransactionId());
        context.setVariable("cardnumber", receiptDto.getCardNumber());
        context.setVariable("currency", receiptDto.getCurrency());
        context.setVariable("schoolName", receiptDto.getSchoolName());
        context.setVariable("totalAmount", receiptDto.getTotalAmount());
        context.setVariable("feeDetail", receiptDto.getReceiptDetails());
        // Process the Thymeleaf template and return the HTML content
        return templateEngine.process("Skiply", context);
    }
}

