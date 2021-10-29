package ggc.core.exception;

public class UnknownKeyException extends Exception {
	
    String _id;

    /**
     * 
     * @param id given by the user
     */
    public UnknownKeyException(String id){_id = id;}

    /**
     * 
     * @return the id given
     */
    public String getId(){return _id;}

}
