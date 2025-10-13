package com.banking;

//import com.banking.BankAccount;
//import com.banking.SavingsAccount;

public class Test {
    public static void main(String[]args){
        BankAccount acc1 = new BankAccount(1000.0, "Current", "C001", "12345");
        SavingsAccount sav1 = new SavingsAccount(500.0, "Savings", "S001", "67890");

    
    System.out.println("Account Number: " + acc1.accountNum);
    
    System.out.println("Balance through getter: " + acc1.getAccountBalance());

    System.out.println("From subclass");
    sav1.showAccess();
    
    
    }

}
