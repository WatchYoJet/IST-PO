package ggc.core;

import java.io.Serializable;

import ggc.core.AggregateProduct;
import ggc.core.Partner;
import ggc.core.Product;

public class Batch implements Serializable{
  private double _price;
  private int _quantity;
  private Product _product;
  private String _partner;

  public Batch(Product p, String price, String quantity, String partner){
      _price = Double.parseDouble(price);
      _quantity = Integer.parseInt(quantity);;
      _product = p;
      _partner = partner;
  }

  public void setAggregateProduct(){
    _product = (AggregateProduct) _product; 
  }

  public void setSimpleProduct(){
    _product = (SimpleProduct) _product; 
  }

  public void changeQuantity(int increment){_quantity += increment;}

  public String getPartner(){return _partner;}
  public Product getProduct(){return _product;}
  public double getPrice(){return _price;}
  public int getQuantity(){return _quantity;}
}