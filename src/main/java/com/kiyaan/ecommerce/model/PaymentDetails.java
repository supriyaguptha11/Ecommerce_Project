package com.kiyaan.ecommerce.model;

import com.kiyaan.ecommerce.domain.PaymentStatus;
import lombok.Data;

@Data
public class PaymentDetails {

    private String paymentId;

    private String razorpayPaymentLinkId;

    private String razorpayPaymentLinkReferenceId;

    private String razorpayPaymentLinkStatus;

    private String razorpayPaymentIdZWSP;

    private PaymentStatus status;
}
