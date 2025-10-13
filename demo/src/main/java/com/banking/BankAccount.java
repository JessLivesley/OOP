package com.banking;

public class BankAccount {
    private double accountBalance;
    protected String accountType;
    String customerID;
    public String accountNum;

    public BankAccount (double accountBalance, String accountType, String customerID, String accountNum) {
        this.accountBalance=accountBalance;
        this.accountType=accountType;
        this.customerID=customerID;
        this.accountNum=accountNum;

    }
    
    public double getAccountBalance(){
        return accountBalance;
    }

    public void setAccountBalance(double newBalance){
        this.accountBalance=newBalance;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}

