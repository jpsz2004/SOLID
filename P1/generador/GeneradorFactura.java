package P1.generador;
import P1.modelo.Factura;
import P1.modelo.FacturaDocumento;

// Esta interfaz es una abstracción para generar documentos de factura
public interface GeneradorFactura {

    // Método para generar un documento de factura a partir de una factura
    FacturaDocumento generarFactura(Factura factura);
}
