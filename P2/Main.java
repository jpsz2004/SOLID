package P2;
import P2.Methods.*;
import P2.Processor.PaymentProcessor;

public class Main {
    
    public static void main(String[] args) {
        // Se crea un procesador de pagos con un método de pago específico
        PaymentProcessor processor = new PaymentProcessor(new PaymentCredit());
        processor.processPayment(100.0);

        // Se cambia el método de pago a PayPal sin modificar el procesador para cumplir con el principio de abierto/cerrado
        processor = new PaymentProcessor(new PaymentPaypal()); // Se utiliza la sustitución de liskov al pasar una implementación de PaymentMethod
        processor.processPayment(200000.0);
    }
}

// Nota: PaymentProcessor depende de la abstracción PaymentMethod y no de implementaciones concretas, cumpliendo la inyección de dependencias. Además, se pueden agregar nuevos métodos de pago sin modificar el procesador, cumpliendo el principio de abierto/cerrado.