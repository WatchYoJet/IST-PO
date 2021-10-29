package ggc.core.exception;

public class InvalidDateValueException extends Exception {
    private int _increment;

    /**
     * 
     * @param increment given by the user
     */
    public InvalidDateValueException(int increment){
        _increment = increment;
        
    }

    /**
     * 
     * @return the increment given
     */
    public int getIncrement(){return _increment;}
}
