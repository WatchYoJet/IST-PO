package ggc.core;

public class AggregateProduct extends Product {
    private final Recepy _recepy = new Recepy(); 
    public AggregateProduct(String id){super(id);}

    protected void addToRecepy(String key, int quantity){
        _recepy.addElement(key, quantity);
    }

    public Recepy getRecepy(){
        return _recepy;
    }
}
