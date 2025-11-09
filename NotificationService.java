interface Notifier{
    void send(String message);
}

class EmailNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
    
}

class SmsNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " +message);
    }

    
}


public class NotificationService {

    public <T extends Notifier> void notifyUser(T notifier, String message){
        notifier.send(message);
    }
    
}

class main{
    public static void main(String[] args) {
        NotificationService NS1 = new NotificationService();
        NS1.notifyUser(new SmsNotifier(), "Have a nice day!");
        NS1.notifyUser( new EmailNotifier(), "Good Morning");
    }
}