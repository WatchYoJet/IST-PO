package ggc.core;

public class Date {

  private int _days;
  
  public Date (int days){
    _days = days;
  }

  public Date (){
    _days = 0;
  }

  public Date add(int increment){
    _days += increment;
    return this;
  }

  public int getDays(){
    return _days;
  }

  public int difference(Date date){
    return this.getDays() - date.getDays();
  }
}