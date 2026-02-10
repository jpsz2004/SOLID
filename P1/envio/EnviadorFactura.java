package P1.envio;
import P1.modelo.FacturaDocumento;

public interface EnviadorFactura {
    
    // Método para enviar la factura 
    void enviarFactura(FacturaDocumento facturaDocumento);
}
