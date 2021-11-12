package ggc.core;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

public class Recepy {
    private Map<String, Integer> _recepy;
    
    /*constructor*/
    public Recepy(){
        _recepy = new TreeMap<>();
    }

    public Recepy(Map<String, Integer> recepy){
        _recepy = recepy;
    }

    public Map<String, Integer> getRecepy(){
        return _recepy;
    }

    /**
    * @param key of the product
    * @param quantity of the product
    * @return boolean of the equality
    */
    public void addElement(String key, Integer quantity){
        _recepy.put(key, quantity);
    }

    /**
    * @return all the product quantities
    */
    public int getQuantity(String key){
        return _recepy.get(key);
    }

    /**
    * @return all the elements of the recepy
    */
    public Set<String> getElements(){
        return _recepy.keySet();
    }
    /**
    * @param product
    * @param name of the new Partner
    * @return boolean of the equality
    */
    public boolean isEqual(String key, Product product){
        return key.equals(product.getID());
    }
}
