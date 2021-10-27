package ggc.core;

import java.util.Set;
import java.util.TreeMap;

public class Recepy {
    private TreeMap<String, Integer> _recepy;
    
    public Recepy(){
        _recepy = new TreeMap<>();
    }

    public void addElement(String key, Integer quantity){
        _recepy.put(key, quantity);
    }

    public int getQuantity(String key){
        return _recepy.get(key);
    }

    public Set<String> getElements(){
        return _recepy.keySet();
    }

    public boolean isEqual(String key, Product product){
        return key.equals(product.getID());
    }
}
