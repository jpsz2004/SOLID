package P3;

public class Main {

    public static void main(String[] args) {

        Notifier email = new EmailNotifier();
        NotificationService service = new NotificationService(email);
        service.notify("Hola por Email");

        Notifier sms = new SMSNotifier();
        service = new NotificationService(sms);
        service.notify("Hola por SMS");

        Notifier slack = new SlackNotifier();
        service = new NotificationService(slack);
        service.notify("Hola por Slack");
    }
}

interface Notifier {
    void send(String message);
}

class NotificationService {

    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notify(String message) {
        notifier.send(message);
    }
}

class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("EMAIL -> " + message);
    }
}

class SMSNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("SMS -> " + message);
    }
}

class PushNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("PUSH -> " + message);
    }
}

class SlackNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("SLACK -> " + message);
    }
}