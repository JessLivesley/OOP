public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount (String ownerName, double balance){
        this.ownerName=ownerName;
        this.balance=balance;
    }

    public void deposit(double amount){
         System.out.println(ownerName +  " has deposited £" + amount + ".\n");

        balance = balance + amount; 
    }

    public void withdraw(double amount){
        System.out.println(ownerName +  " has withdrawn £" + amount + ".\n");
        balance = balance - amount;
    }

    public void printStatus(){
        System.out.println("Owner: " + ownerName + ", Balance: £" + balance + "\n");

    }

    public double getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount ("Jess", 7888);
        BankAccount account2 = new BankAccount ("Rob", 3728);

        account1.printStatus();
        account2.printStatus();

        account1.deposit(10);
        account2.deposit(700);

        account1.printStatus();
        account2.printStatus();

        account1.withdraw(5);
        account2.withdraw(50);

        account1.printStatus();
        account2.printStatus();


    }

}
