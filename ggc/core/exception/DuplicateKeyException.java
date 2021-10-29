package ggc.core.exception;

public class DuplicateKeyException extends Exception{
    
    private String _key;

    /**
     * 
     * @param key given by the user
     */
    public DuplicateKeyException(String key){
        _key = key;
    }

    /**
     * 
     * @return the key
     */
    public String getKey(){return _key;}
}
