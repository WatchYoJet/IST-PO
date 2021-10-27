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

  public void changePoints(int increment){_points += increment;}

  public String getName(){return _name;}
  public String getAddress(){return _address;}
  public Status getStatus(){return _status;}
  public String getID(){return _id;}
  public int getPoints(){return _points;}
  public double getBought(){return _bought;}
  public double getSellsDone(){return _sellsDone;}
  public double getSellsPaid(){return _sellsPaid;}
}
