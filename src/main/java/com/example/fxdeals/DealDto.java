package com.example.fxdeals;

import lombok.Data;

@Data
public class DealDto {
    private String dealUniqueId;
    private String orderingCurrency;
    private String deliveryCurrency;
    private String dealTimestamp;
    private Double amount;

    // Method to convert DTO to Entity
    public Deal toEntity() {
        Deal deal = new Deal();
        deal.setDealUniqueId(this.dealUniqueId);
        deal.setOrderingCurrency(this.orderingCurrency);
        deal.setDeliveryCurrency(this.deliveryCurrency);
        deal.setDealTimestamp(this.dealTimestamp);
        deal.setAmount(this.amount);
        return deal;
    }
}