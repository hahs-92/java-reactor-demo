package com.sofka.demoreactor.model;

import java.time.LocalDate;

public class Purchase {
    private Integer purchaseId;
    private LocalDate date;

    public Purchase(Integer purchaseId, LocalDate date) {
        this.purchaseId = purchaseId;
        this.date = date;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", date=" + date +
                '}';
    }
}
