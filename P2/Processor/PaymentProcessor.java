package P2.Processor;

import P2.Methods.PaymentMethod;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        // Ejecuta el pago usando la pasarela concreta
        paymentMethod.pay(amount);

        // Mensaje resumen: cuánto se pagó y con qué medio.
        // Usamos `getName()` para obtener un nombre legible del método.
        System.out.println("Pago de $" + amount + " realizado con " + paymentMethod.getName() + "\n");
    }
}
