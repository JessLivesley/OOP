import java.util.Arrays;
import java.util.List;

public abstract class Payment {
    protected double amount;
    protected String paymentId;
    protected String date;

    public Payment(double amount, String paymentId, String date) {
        this.amount = amount;
        this.paymentId = paymentId;
        this.date = date;
    }

    public abstract boolean processPayment();
    public abstract String getPaymentDetails();
    public abstract double calculateFee();
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String paymentId, String date, String cardNumber) {
        super(amount, paymentId, date);
        this.cardNumber = cardNumber;
    }

    private boolean validateCard() {
        return cardNumber != null && cardNumber.replaceAll("\\s+","").length() >= 12;
    }

    @Override
    public boolean processPayment() {
        if (!validateCard()) {
            return false;
        }
        // simulate processing...
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("CreditCardPayment[id=%s,date=%s,amount=%.2f,card=%s,fee=%.2f]",
                paymentId, date, amount, mask(cardNumber), calculateFee());
    }

    @Override
    public double calculateFee() {
        return amount * 0.025;
    }

    private String mask(String card) {
        if (card == null) return "N/A";
        String cleaned = card.replaceAll("\\s+","");
        if (cleaned.length() <= 4) return cleaned;
        return "****-****-****-" + cleaned.substring(cleaned.length()-4);
    }
}

class DebitCardPayment extends Payment {
    private String cardNumber;
    private String pin;

    public DebitCardPayment(double amount, String paymentId, String date, String cardNumber, String pin) {
        super(amount, paymentId, date);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    private boolean verifyPin() {
        return pin != null && pin.matches("\\d{4,6}");
    }

    @Override
    public boolean processPayment() {
        if (!verifyPin()) return false;
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("DebitCardPayment[id=%s,date=%s,amount=%.2f,card=%s,fee=%.2f]",
                paymentId, date, amount, mask(cardNumber), calculateFee());
    }

    @Override
    public double calculateFee() {
        return amount * 0.015;
    }

    private String mask(String card) {
        if (card == null) return "N/A";
        String cleaned = card.replaceAll("\\s+","");
        if (cleaned.length() <= 4) return cleaned;
        return "****-****-****-" + cleaned.substring(cleaned.length()-4);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(double amount, String paymentId, String date, String email) {
        super(amount, paymentId, date);
        this.email = email;
    }

    private boolean verifyEmail() {
        return email != null && email.contains("@");
    }

    @Override
    public boolean processPayment() {
        if (!verifyEmail()) return false;
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("PayPalPayment[id=%s,date=%s,amount=%.2f,email=%s,fee=%.2f]",
                paymentId, date, amount, email, calculateFee());
    }

    @Override
    public double calculateFee() {
        return amount * 0.03;
    }
}

class CryptocurrencyPayment extends Payment {
    private String walletAddress;

    public CryptocurrencyPayment(double amount, String paymentId, String date, String walletAddress) {
        super(amount, paymentId, date);
        this.walletAddress = walletAddress;
    }

    private boolean verifyWallet() {
        return walletAddress != null && !walletAddress.trim().isEmpty();
    }

    @Override
    public boolean processPayment() {
        if (!verifyWallet()) return false;
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("CryptocurrencyPayment[id=%s,date=%s,amount=%.2f,wallet=%s,fee=%.2f]",
                paymentId, date, amount, shortWallet(walletAddress), calculateFee());
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    private String shortWallet(String w) {
        if (w == null) return "N/A";
        if (w.length() <= 10) return w;
        return w.substring(0,6) + "..." + w.substring(w.length()-4);
    }
}

class CashPayment extends Payment {
    private boolean inPersonConfirmed;

    public CashPayment(double amount, String paymentId, String date, boolean inPersonConfirmed) {
        super(amount, paymentId, date);
        this.inPersonConfirmed = inPersonConfirmed;
    }

    @Override
    public boolean processPayment() {
        return inPersonConfirmed;
    }

    @Override
    public String getPaymentDetails() {
        return String.format("CashPayment[id=%s,date=%s,amount=%.2f,inPerson=%s,fee=%.2f]",
                paymentId, date, amount, inPersonConfirmed, calculateFee());
    }

    @Override
    public double calculateFee() {
        return 0.0;
    }
}

class PaymentProcessor {
    public String processPayment(Payment p) {
        boolean success = p.processPayment();
        String status = success ? "SUCCESS" : "FAILED";
        String receipt = String.format("RECEIPT: %s | %s | Amount: %.2f | Fee: %.2f",
                p.paymentId, status, p.amount, p.calculateFee());
        return receipt;
    }

    public double totalFees(List<Payment> payments) {
        return payments.stream().mapToDouble(Payment::calculateFee).sum();
    }
}

class PaymentDemo {
    public static void main(String[] args) {
        List<Payment> payments = Arrays.asList(
                new CreditCardPayment(100.0, "CC100", "2025-11-09", "4242 4242 4242 4242"),
                new PayPalPayment(50.0, "PP50", "2025-11-09", "user@example.com"),
                new CryptocurrencyPayment(200.0, "CR200", "2025-11-09", "0xABCDEF0123456789"),
                new CashPayment(75.0, "CA75", "2025-11-09", true)
        );

        PaymentProcessor processor = new PaymentProcessor();

        for (Payment p : payments) {
            String receipt = processor.processPayment(p);
            System.out.println(receipt);
            System.out.println("Details: " + p.getPaymentDetails());
            System.out.println();
        }

        double totalFees = processor.totalFees(payments);
        System.out.printf("Total fees collected: %.2f%n", totalFees);
    }
}
