package P2.Methods;

// Esta es la abstracción que implementan los diferentes métodos de pago
// Añadimos `getName()` para obtener un nombre legible del medio de pago
// y poder mostrar mensajes resumen sin depender del nombre de la clase.
public interface PaymentMethod {
    public void pay(double amount);

    /**
     * Devuelve un nombre legible para este método de pago (ej. "Credit Card", "PayPal" o el que se agregue).
     */
    public String getName();
}