package com.example.fxdeals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Deal {
    @Id
    private String dealUniqueId;
    private String orderingCurrency;
    private String deliveryCurrency;
    private String dealTimestamp;
    private double amount;

    public String getDealUniqueId() { return dealUniqueId; }
    public void setDealUniqueId(String id) { this.dealUniqueId = id; }
    public String getOrderingCurrency() { return orderingCurrency; }
    public void setOrderingCurrency(String c) { this.orderingCurrency = c; }
    public String getDeliveryCurrency() { return deliveryCurrency; }
    public void setDeliveryCurrency(String c) { this.deliveryCurrency = c; }
    public String getDealTimestamp() { return dealTimestamp; }
    public void setDealTimestamp(String t) { this.dealTimestamp = t; }
    public double getAmount() { return amount; }
    public void setAmount(double a) { this.amount = a; }

}
