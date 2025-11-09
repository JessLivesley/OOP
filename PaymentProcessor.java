interface PaymentMethod{
    void pay(double amount);
}

class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("Paying £" + amount + " with Credit Card.");
    }

}

class PayPal implements PaymentMethod{
    
    @Override
    public void pay(double amount) {
        System.out.println("Paying £" + amount + " with PayPal.");
    }

}

public class PaymentProcessor {
    
    public <T extends PaymentMethod> void processPayment(T method, double amount){
        method.pay(amount);
    }

}

class Main{
    public static void main(String[] args) {
        PaymentProcessor pp = new PaymentProcessor();
        pp.processPayment(new PayPal(), 100);
        pp.processPayment(new CreditCard(), 50);
    }
}
