package P1.modelo;

public class Factura {

    // Algunos atributos posibles de la factura
    private String numeroFactura;
    private double monto;

    // Constructor para inicializar la factura
    public Factura(String numeroFactura, double monto){
        this.numeroFactura = numeroFactura;
        this.monto = monto;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public double getMonto() {
        return monto;
    }
    
}
