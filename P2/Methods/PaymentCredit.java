package P2.Methods;

public class PaymentCredit implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con tarjeta de crédito de $" + amount);
    }

    @Override
    public String getName() {
        return "Tarjeta de Crédito";
    }
}