package ggc.core;

import java.security.PublicKey;

public class Acquisition extends Transaction {

    public Acquisition(int id, int paymentDate, double paymentAmount, int quantity,
     Product product, Partner partner, String type) {
        super(id, paymentDate, paymentAmount, quantity, product, partner, type);
    }

    @Override
    public String toString() {
        return ""+ getType() + "|"+ getId() +
        "|" + getPartner().getID()+
        "|" + getProduct().getID()+ 
        "|" + getQuantity()+
        "|" + Math.round(getPaymentAmount())+
        "|" + getPaymentDate();
    }
}