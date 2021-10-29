package ggc.core.exception;

public class DuplicateKeyException extends Exception{
    
    private String _key;

    public DuplicateKeyException(String key){
        _key = key;
    }

    public String getKey(){return _key;}
}
