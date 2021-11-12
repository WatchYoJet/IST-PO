package ggc.core;

import java.io.Serializable;

/*Product Class*/
public abstract class Product implements Serializable {
    private double _maxPrice;
    private String _id;
    private int _quantity;

    /**
     * 
     * @param id of the product
     */
    protected Product(String id){
        _maxPrice = 0;
        _id = id;
        _quantity = 0;
    }

    /**
     * Constructor
    * @param id of the Product
    * @param maxPrice of the product
    * @param quantity of the Product
    */
    protected Product(String id, String maxPrice, String quantity){
        _maxPrice = Double.parseDouble(maxPrice);
        _id = id;
        _quantity = Integer.parseInt(quantity);
    }
    
    /**
    * @param newPrice to set on the Product
    */
    public void setNewMaxPrice(double newPrice){_maxPrice = Math.max(newPrice, _maxPrice);}

    /**
    * @param increment to the quantity of the product 
    */
    public void changeQuantity(int increment){_quantity+=increment;}

    /**
     * Constructor
    * @return id of the product
    */
    public String getID(){return _id;}
    
    /**
     * Constructor
    * @return maxPrice of the product
    */
    public double getMaxPrice(){return _maxPrice;}
    
    /**
     * Constructor
    * @return quantity of the product
    */
    public int getQuantity(){return _quantity;}

    @Override
    public String toString(){
        return ""+getID()+"|"+Math.round(getMaxPrice())+"|"+getQuantity();
    }
}
