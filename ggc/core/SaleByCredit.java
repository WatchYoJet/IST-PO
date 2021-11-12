package ggc.core;

public class SaleByCredit extends Transaction{
    
    public SaleByCredit(int id, int paymentDate, double paymentAmount, 
        int quantity, Product product, Partner partner) {
        super(id, paymentDate, paymentAmount, quantity, product, partner);
    }
    

    @Override
    public String toString() {
        return "VENDA|"+getId()
                +"|"+getPartner().getID()
                +"|"+getProduct().getID()
                +"|"+getQuantity()
                +"|"+Math.round(getPaymentAmount())
                +"|"+Math.round(getPaymentAmount())
                +"|"+getPaymentDate();
    }
}
