package ggc.core;

import java.io.Serializable;


public class Batch implements Serializable{
  private double _price;
  private int _quantity;
  private Product _product;
  private String _partner;

  /**
     * Constructor
    * @param product the product
    * @param price of the product
    * @param quantity of the product
    * @param partner that gave the product
    */
  public Batch(Product product, String price, String quantity, String partner){
      _price = Double.parseDouble(price);
      _quantity = Integer.parseInt(quantity);
      _product = product;
      _partner = partner;
  }

  /**
  * @param increment the quantity of the Product in the batch
  */
  public void changeQuantity(int increment){_quantity += increment;}

  
  /**
  * @return partner name
  */
  public String getPartner(){return _partner;}
 
  /**
  * @return the product
  */
  public Product getProduct(){return _product;}
  
   /**
  * @return the price of the product
  */
  public double getPrice(){return _price;}
  
   /**
  * @return the quantity of the product
  */
  public int getQuantity(){return _quantity;}
}