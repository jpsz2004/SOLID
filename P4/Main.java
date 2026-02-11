package P4;

import P4.formato.*;
import P4.generacion.GeneradorVentas;
import P4.servicio.ServicioReportes;

public class Main {

    public static void main(String[] args) {
        
        ServicioReportes servicioPDF = new ServicioReportes (
            new GeneradorVentas(),
            new FormatoPDF()
        );

        servicioPDF.generarReporte(); // Genera un reporte de ventas en formato PDF

        ServicioReportes servicioCSV = new ServicioReportes (
            new GeneradorVentas(),
            new FormatoCSV()
        );

        servicioCSV.generarReporte(); // Genera un reporte de ventas en formato CSV
    }  
}