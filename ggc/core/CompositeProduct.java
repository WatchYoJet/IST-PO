package ggc.core;

import java.util.Map;

public class CompositeProduct extends Product {
    private final Recepy _recepy; 
    private double _agravement;
    
    /**
     * Constructor
     * @param id of the product
     * @param price of the product
     * @param quantity of the product
     * @param recepy of the product
     */
    public CompositeProduct(String id, String price , String quantity, Recepy recepy, String agravement) {
        super(id, price ,quantity);
        _recepy = recepy;
        _agravement = Double.parseDouble(agravement);
    }

    public double getAgravement() {
        return _agravement;
    }

    /**
     * Constructor
     * @return the recepy
     */
    public Map<String, Integer> getRecepy(){
        return _recepy.getRecepy();
    }
}
