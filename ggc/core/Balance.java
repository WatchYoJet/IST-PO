package ggc.core;

public class Balance {
    
    private double balance;
    
    public Balance() {
        balance = 0;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
}
