package com.iakgoog.week1.entity;

public enum PaymentStatus {
    READY_TO_PAY("ready to pay"),
    PAID("paid");

    public final String label;

    private PaymentStatus(String label) {
        this.label = label;
    }
}
