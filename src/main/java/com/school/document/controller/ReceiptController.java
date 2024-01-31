package com.school.document.controller;


import com.school.document.commen.ApiResponse;
import com.school.document.dto.ReceiptDto;
import com.school.document.service.ReceiptService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping(path = "addReceipt")
    public ResponseEntity<ApiResponse<String>> addReceipt(@RequestBody ReceiptDto receiptDto){
        return ResponseEntity.ok(new ApiResponse<>(receiptService.addReceipt(receiptDto), null));
    }

    @GetMapping(path = "/view-receipt/receiptId/{receiptId}")
    public ResponseEntity<String> getReceiptByReceiptId(@PathVariable String receiptId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        // Return the HTML content as part of the response
        return new ResponseEntity<>(receiptService.viewReceipt(receiptId, true), headers, HttpStatus.OK);
    }

    @GetMapping(path = "/view-receipt/transaction/{transactionId}")
    public ResponseEntity<String> getReceiptByTransactionId(@PathVariable String transactionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);

        // Return the HTML content as part of the response
        return new ResponseEntity<>(receiptService.viewReceipt(transactionId, false), headers, HttpStatus.OK);
    }
}
