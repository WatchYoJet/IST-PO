package ggc.core;

public class Notification {
 
    private NotificationTypes _type;
    private double _price;
    private Product _product;

    public Notification(NotificationTypes type, Double price, Product product) {
        _type = type;
        _price = price;
        _product = product;
    }

    public NotificationTypes getType() {
        return _type;
    }

    public Double getPrice() {
        return _price;
    }

    public Product getProduct() {
        return _product;
    }

    @Override
    public String toString() {
        return "" + _type + "|" + _product.getID() + "|" + Math.round(_price);
    }

}
