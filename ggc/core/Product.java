package ggc.core;

import java.io.Serializable;


public abstract class Product implements Serializable {
    private double _maxPrice;
    private String _id;
    private int _quantity;

    protected Product(String id){
        _maxPrice = 0;
        _id = id;
        _quantity = 0;
    }
    
    public void setNewMaxPrice(double newPrice){_maxPrice = Math.max(newPrice, _maxPrice);}
    //protected abstract void checkQuantity(int quantity, Partner partner);
    public String getID(){return _id;}
    public double getMaxPrice(){return _maxPrice;}
    public int getQuantity(){return _quantity;}
}
