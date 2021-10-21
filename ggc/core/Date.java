package ggc.core;

public class Date {

  private int _date = 0;
  
  public Date (int days){
    _date = days;
  }

  public Date add(int increment){
    _date += increment;
    return this;
  }

  public int getDate(){
    return _date;
  }

  public int difference(Date date){
    return this.getDate() - date.getDate();
  }
}
