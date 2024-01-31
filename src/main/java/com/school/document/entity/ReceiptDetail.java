package com.school.document.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "receipt_detail")
public class ReceiptDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "receiptId", nullable = false, unique = true)
    private String receiptId;
    @Column(name = "transaction_id", nullable = false, unique = true)
    private String transactionId;
    @Column(name = "school_uuid", nullable = false)
    private String schoolUuid;
    @Column(name = "school_name", nullable = false)
    private String schoolName;
    @Column(name = "student_uuid", nullable = false)
    private String studentUuid;
    @Column(name = "student_id", nullable = false)
    private String studentId;
    @Column(name = "student_first_name", nullable = false)
    private String studentFirstName;
    @Column(name = "student_last_name", nullable = false)
    private String studentLastName;
    @Column(name = "guardian_name", nullable = false)
    private String guardianName;
    @Column(name = "total_fee_amount", nullable = false)
    private BigDecimal totalAmount;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "card_number", nullable = false)
    private String cardNumber;
    @Column(name = "card_network", nullable = false)
    private String cardNetwork;
    @Column(name = "fee_paid_at", nullable = false)
    private LocalDateTime feePaidAt;

    @OneToMany(mappedBy = "feeTransaction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<FeeDetail> feeTransactionDetails;

    public Set<FeeDetail> getFeeTransactionDetails() {
        return feeTransactionDetails;
    }

    public void setFeeTransactionDetails(Set<FeeDetail> feeTransactionDetails) {
        this.feeTransactionDetails = feeTransactionDetails;
    }
    public void addFeeTransactionDetails(FeeDetail feeTransactionDetail) {
        if (null == feeTransactionDetails)
            feeTransactionDetails = new HashSet<>();
        feeTransactionDetails.add(feeTransactionDetail);
    }
}
