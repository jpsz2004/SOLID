package P1.envio;
import P1.modelo.FacturaDocumento;

// Simulación de envío de factura por email - Implementa la interfaz EnviadorFactura
public class EnviadorEmail implements EnviadorFactura {

    @Override
    public void enviarFactura(FacturaDocumento facturaDocumento) {
        System.out.println("Enviando factura por email:\n" + facturaDocumento.getContenido());
    }
    
}
