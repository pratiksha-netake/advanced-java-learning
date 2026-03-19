package model;

import java.security.Timestamp;

public class Account {
    private int account_id;
     private String name;
    private String email;
    private double balance;
   

    public Account(
    String name,
    String email,
    double balance
    ){
        
        this.name=name;
        this.email=email;
        this.balance=balance;
      

    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }    
}
