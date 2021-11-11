package ggc.core;

import java.io.Serializable;

public abstract class Transaction implements Serializable{
    private int _id;
    private int _paymentDate;
    private double _paymentAmount;
    private int _quantity;
    private Product _product;
    private Partner _partner;

    public Transaction(int id, int paymentDate, double paymentAmount, 
                    int quantity, Product product, Partner partner) {
        _id = id;
        _paymentDate = paymentDate;
        _paymentAmount = paymentAmount;
        _quantity = quantity;
        _product = product;
        _partner = partner;
    }

    public Partner getPartner() {
        return _partner;
    }

    public Product getProduct() {
        return _product;
    }

    public int getId() {
        return _id;
    }

    public int getPaymentDate() {
        return _paymentDate;
    }

    public double getPaymentAmount() {
        return _paymentAmount;
    }

    public int getQuantity() {
        return _quantity;
    }
}
