package P1.generador;
import P1.modelo.Factura;
import P1.modelo.FacturaDocumento;

// Simulación de generación de factura en formato PDF - Implementa la interfaz GeneradorFactura
public class GeneradorFacturaPDF implements GeneradorFactura {

    @Override
    public FacturaDocumento generarFactura(Factura factura) {
        String contenidoPDF = "Factura PDF\nNúmero: " + factura.getNumeroFactura() + "\nMonto: " + factura.getMonto();
        return new FacturaDocumento(contenidoPDF);
    }

}

