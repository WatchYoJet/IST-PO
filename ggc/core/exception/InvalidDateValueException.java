package ggc.core.exception;

public class InvalidDateValueException extends Exception {
    private int _increment;

    public InvalidDateValueException(int increment){
        _increment = increment;
        
    }

    public int getIncrement(){return _increment;}
}
