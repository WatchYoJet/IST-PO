package ggc.core;

import java.io.Serializable;

public class Partner implements Serializable{
  private String _name;
  private String _address;
  private Status _status;
  private String _id;
  private int _points;
  private double _bought;
  private double _sellsDone;
  private double _sellsPaid;
  
  /**
     * Constructor
    * @param name of the Partner
    * @param address of the Partner
    * @param id of the Partner
    */
  public Partner(String name, String address, String id){
    _name = name;
    _address = address;
    _points = 0;
    _status = Status.NORMAL;
    _id = id;
    _bought = 0;
    _sellsDone = 0;
    _sellsPaid = 0;
  }

  /**
    * @param increment the points of the Partner
  */
  public void changePoints(int increment){
    _points += increment;
    promote();
  }

  public void promote(){
    if(_points >= 25000)
      _status = Status.ELITE;
    else if(_points >= 2000)
      _status = Status.SELECTION;
  }

  /**
    * @return the name of the Partner
  */
  public String getName(){return _name;}
  
  /**
    * @return the address of the Partner
  */
  public String getAddress(){return _address;}
  
  /**
    * @return the status of the Partner
  */
  public Status getStatus(){return _status;}
  
  /**
    * @return the ID of the Partner
  */
  public String getID(){return _id;}
  
  /**
    * @return the points of the Partner
  */
  public int getPoints(){return _points;}
  
  /**
    * @return the number of sells bought of the Partner
  */
  public double getBought(){return _bought;}

  /**
    * Changes the value of sells bought from the Partner
  */
  public void changeBought(double increment){_bought += increment;}
  
  /**
    * @return the number of sellsDone of the Partner
  */
  public double getSellsDone(){return _sellsDone;}
  
  public void changeSellsDone(double increment){_sellsDone += increment;}

  public void changeSellsPaid(double increment){_sellsPaid += increment;}

  /**
    * @return the number of sellsPaid of the Partner
  */
  public double getSellsPaid(){return _sellsPaid;}

  public void demote(){
    if (_status == Status.SELECTION)
      _status = Status.NORMAL;
    else if(_status == Status.ELITE)
      _status = Status.SELECTION;
    
  }

  @Override
  public String toString(){
    return ""+getID()+"|"
    +getName()+"|"
    +getAddress()+"|"
    +getStatus()+"|"
    +getPoints()+"|"
    +Math.round(getBought())+"|"
    +Math.round(getSellsDone())+"|"
    +Math.round(getSellsPaid());
  }

}
