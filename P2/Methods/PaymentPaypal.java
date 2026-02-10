package P2.Methods;

public class PaymentPaypal implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago por PayPal de $" + amount);
    }

    @Override
    public String getName() {
        return "PayPal";
    }
}

// Se pueden agregar más métodos de pago siguiendo la misma estructura
// como PaymentDebit, PaymentBitcoin, etc. para cumplir con el principio de abierto/cerrado.