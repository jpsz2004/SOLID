package P1.repositorio;
import P1.modelo.FacturaDocumento;

// Simulación de almacenamiento de factura en base de datos - Implementa la interfaz RepositorioFactura
public class RepositorioFacturaBD implements RepositorioFactura {

    @Override
    public void guardarFactura(FacturaDocumento facturaDocumento) {
        System.out.println("Guardando factura en la base de datos:\n" + facturaDocumento.getContenido());
    }
    
}
