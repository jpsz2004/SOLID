package P4.generacion;

import P4.modelo.ReporteDatos;
import java.util.Arrays;
import java.util.List;

public class GeneradorVentas implements GeneradorDatosReporte {

    @Override
    public ReporteDatos generarDatos() {

        List<String> encabezados = Arrays.asList("Producto", "Cantidad", "Precio");
        List<List<String>> filas = Arrays.asList(
                Arrays.asList("Laptop", "2", "$1200"),
                Arrays.asList("Smartphone", "5", "$800"),
                Arrays.asList("Tablet", "3", "$600")
        );

        return new ReporteDatos("Reporte de Ventas", encabezados, filas);
    }   
}