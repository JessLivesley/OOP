package com.banking;

public class SavingsAccount extends BankAccount{

   public SavingsAccount (double accountBalance, String accountType, String customerID, String accountNum) {
        super(accountBalance, accountType, customerID, accountNum);

    }

    public void showAccess(){
        System.out.println("Account Number: " + accountNum);
        System.out.println("Account Type: "+ accountType);
        
        System.out.println("Account Balance: "+ getAccountBalance());

    }
}