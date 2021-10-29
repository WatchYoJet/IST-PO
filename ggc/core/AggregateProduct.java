package ggc.core;

public class AggregateProduct extends Product {
    private final Recepy _recepy = new Recepy(); 
    
    /**
     * Constructor
     * @param id of the product
     */
    public AggregateProduct(String id){super(id);}

    /**
     * @param key of the recepy
     * @param quantity of the product
     * @return the recepy
     */
    protected void addToRecepy(String key, int quantity){
        _recepy.addElement(key, quantity);
    }
    
    /**
     * Constructor
     * @return the recepy
     */
    public Recepy getRecepy(){
        return _recepy;
    }
}
