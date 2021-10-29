package ggc.core;
import java.io.Serializable;

public class Date implements Serializable{

  private int _days;
  /*Cunstructor*/
  public Date (){
    _days = 0;
  }

  /**
    * @param increment the number of days
    */
  public void add(int increment){
    _days += increment;
  }

  /**
     * Constructor
    * @return the current date
    */
  public int getDays(){
    return _days;
  }

  /**
     * Constructor
    * @param date sees the difference btween two dates
    */
  public int difference(Date date){
    return this.getDays() - date.getDays();
  }
}