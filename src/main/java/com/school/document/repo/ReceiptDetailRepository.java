package com.school.document.repo;

import com.school.document.entity.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long> {

    boolean existsByTransactionId(String transactionId);
    Optional<ReceiptDetail> findByReceiptId(String receiptId);
    Optional<ReceiptDetail> findByTransactionId(String receiptId);
}
