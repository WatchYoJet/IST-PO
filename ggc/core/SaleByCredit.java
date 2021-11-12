package ggc.core;

public class SaleByCredit extends Transaction{
    
    private int _paidDate;
    private Ticket _ticket;
    private double _value;
    private boolean _isPaid;

    public SaleByCredit(int id, int paymentDate, double paymentAmount, 
        int quantity, Product product, Partner partner, String type) {
        super(id, paymentDate, paymentAmount, quantity, product, partner, type);
        _paidDate = -1;
        _ticket = null;
        _value = paymentAmount;
        _isPaid = false;
    }
    
    private void calculateTicket(){
        int N = 5;
        if (_paidDate < N) _ticket = Ticket.P1;
        else if (_paidDate < getPaymentDate()) _ticket = Ticket.P2;
        else if (_paidDate <= getPaymentDate() + N) _ticket = Ticket.P3;
        else _ticket = Ticket.P4;
    }

    private void calculateValue() {
        double value = 0;
        int days = _paidDate - getPaymentDate();
        switch(_ticket){
            case P1:
                value = getPaymentAmount() * 0.9;
                break;
            case P2:
                if (getPartner().getStatus().equals(Status.NORMAL))
                    value = getPaymentAmount();
                else if (getPartner().getStatus().equals(Status.SELECTION))
                    if (days <= -2) value = getPaymentAmount() - (getPaymentAmount() * 0.05);
                    else value = getPaymentAmount();
                else if (getPartner().getStatus().equals(Status.ELITE))
                    value = getPaymentAmount() - (getPaymentAmount() * 0.1);
                break;
            case P3:
                if (getPartner().getStatus().equals(Status.NORMAL))
                    value = getPaymentAmount() + (getPaymentAmount() * (days/20));
                else if (getPartner().getStatus().equals(Status.SELECTION))
                    if (days > 1)
                        value = getPaymentAmount() + (getPaymentAmount() * ((days-1)*0.02));
                    else value = getPaymentAmount();
                else if (getPartner().getStatus().equals(Status.ELITE))
                    value = getPaymentAmount() - (getPaymentAmount() * 0.05);
                break;
            case P4:
                if (getPartner().getStatus().equals(Status.NORMAL))
                    value = getPaymentAmount() + (getPaymentAmount() * (days/10));
                else if (getPartner().getStatus().equals(Status.SELECTION))
                    value = getPaymentAmount() + (getPaymentAmount() * (days/20));
                else if (getPartner().getStatus().equals(Status.ELITE))
                    value = getPaymentAmount();
                break;
        default:
            break;
        }
        _value = value;
    }

    public void pay(int paidDate){
        if (!_isPaid){
            _paidDate = paidDate;
            calculateTicket();
            calculateValue();
            _isPaid = true;
        }
    }

    public double getCurrentValue(int paidDate){
        _paidDate = paidDate;
        calculateTicket();
        calculateValue();
        return _value;
    }

    public boolean isPaid(){
        return _isPaid;
    }

    public double getValue(){
        return _value;
    }

    @Override
    public String toString() {
        if (!_isPaid)return ""+getType()+"|"+getId()
                +"|"+getPartner().getID()
                +"|"+getProduct().getID()
                +"|"+getQuantity()
                +"|"+Math.round(getPaymentAmount())
                +"|"+Math.round(getPaymentAmount())
                +"|"+getPaymentDate();
        else return "VENDA|"+getId()
                +"|"+getPartner().getID()
                +"|"+getProduct().getID()
                +"|"+getQuantity()
                +"|"+Math.round(getPaymentAmount())
                +"|"+Math.round(_value)
                +"|"+getPaymentDate()
                +"|"+_paidDate;
    }
}
