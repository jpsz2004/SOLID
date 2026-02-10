package P1.envio;
import P1.modelo.FacturaDocumento;

// Simulación de envío de factura por WhatsApp - Implementa la interfaz EnviadorFactura
public class EnviadorWap implements EnviadorFactura {

    @Override
    public void enviarFactura(FacturaDocumento facturaDocumento) {
        System.out.println("Enviando factura por WhatsApp: "+ facturaDocumento.getContenido());
    }
}

// Realizar estas implentaciones por separado, permite una mayor flexibilidad y adherencia al principio de responsabilidad única, facilitando el mantenimiento y la extensión del código en el futuro. Por ejemplo, añadir otros medios de envío (como SMS o fax) sería sencillo sin afectar a las clases existentes.
