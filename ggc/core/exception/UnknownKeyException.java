package ggc.core.exception;

public class UnknownKeyException extends Exception {
	
    String _id;

    public UnknownKeyException(String id){_id = id;}

    public String getId(){return _id;}

}
