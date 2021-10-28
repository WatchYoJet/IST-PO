package ggc.core;
import java.io.Serializable;

public class Date implements Serializable{

  private int _days;

  public Date (){
    _days = 0;
  }

  public void add(int increment){
    _days += increment;
  }

  public int getDays(){
    return _days;
  }

  public int difference(Date date){
    return this.getDays() - date.getDays();
  }
}