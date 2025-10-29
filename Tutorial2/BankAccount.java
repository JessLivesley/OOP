import BankAccount;

package Tutorial2;
public class BankAccount {
    private double accountBalance;
    protected String accountType;
              String customerID;
    public double accountNumber;

    public BankAccount(double accountBalance, String accountType,String customerID, double accountNumber ){
        this.accountBalance=accountBalance;
        this.accountType=accountType;
        this.customerID=customerID;
        this.accountNumber=accountNumber;
    }

    public double getaccountBalance(){
        return accountBalance;
    }

    public void setaccountBalance(double accountBalance){
        this.accountBalance=accountBalance;
    }

    public String  getaccountType(){
        return accountType;
    }

    public void setaccountType(String accountType){
        this.accountType=accountType;
    }

    public String getcustomerID(){
        return customerID;
    }

    public void setcustomerID(String customerID){
        this.customerID = customerID;
    }

    public double getaccountNumber(){
        return accountNumber;
    }

    public void setaccountNumber(double accountNumber){
        this.accountNumber=accountNumber;
    }

    // Convenience methods matching calls in the code (getBalance / setBalance)
    public double getBalance() {
        return getaccountBalance();
    }

    public void setBalance(double balance) {
        setaccountBalance(balance);
    }

    // Display info (for testing)
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Balance: " + accountBalance);
    }

}

class SavingsAccount extends BankAccount{

    public SavingsAccount(double accountBalance, String accountType, String customerID, double accountNumber) {
        super(accountBalance, accountType, customerID, accountNumber);
        
    }

    public void showAccess() {
        System.out.println("\n--- Inside SavingsAccount subclass ---");

        // Public member (accessible)
        System.out.println("Account Number: " + accountNumber);

        // ✅ Protected member (accessible through inheritance)
        System.out.println("Account Type: " + accountType);

        // ❌ Package-private member (NOT accessible from a different package)
        // System.out.println("Customer ID: " + customerID); // <- ERROR

        // ❌ Private member (NOT accessible directly)
        // System.out.println("Balance: " + balance); // <- ERROR

        //BankAccount account = new BankAccount(5000.0, "Checking", "C001", "12345");
        //SavingsAccount savings = new SavingsAccount(8000.0, "Savings", "C002", "67890");
    }


}

class AccessTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, "Checking", "C001", 5000.0);
        SavingsAccount savings = new SavingsAccount(67890, "Savings", "C002", 8000.0);

        System.out.println("--- Inside AccessTest (different package) ---");

        // ✅ Public - accessible anywhere
        System.out.println("Account Number: " + account.accountNumber);

        // ❌ Protected - not accessible through object reference outside package
        //System.out.println("Account Type: " + account.accountType); // <- ERROR

        // ❌ Package-private - not accessible outside banking package
        //System.out.println("Customer ID: " + account.customerID); // <- ERROR

        // ❌ Private - not accessible outside its class
        //System.out.println("Balance: " + account.balance); // <- ERROR

        // ✅ Can use public methods to access private fields safely
        System.out.println("Balance (via getter): " + account.getBalance());

        // Test access from subclass
        savings.showAccess();
    }
}