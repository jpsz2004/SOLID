package P1.modelo;

// Esta clase representa una simulación de un documento de factura, que podría ser un archivo PDF, un XML, etc.
public class FacturaDocumento {
    
    private String contenido;

    public FacturaDocumento(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
}
