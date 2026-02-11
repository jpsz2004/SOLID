package P4.formato;

import P4.modelo.ReporteDatos;
import java.util.List;

public class FormatoCSV implements FormatoReporte {

    @Override
    public void exportar(ReporteDatos datos) {
        System.out.println("Exportando reporte a CSV...");
        System.out.println("Título: " + datos.getTitulo());
        System.out.println("Encabezados: " + String.join(", ", datos.getEncabezados()));
        for (List<String> fila : datos.getFilas()) {
            System.out.println("Fila: " + String.join(", ", fila));
        }
    }
    
}

// Este diseño permite agregar nuevos formatos de exportación sin modificar las clases existentes, cumpliendo con el principio de abierto/cerrado. Cada nuevo formato simplemente implementa la interfaz FormatoReporte, lo que facilita la extensión del sistema sin afectar su funcionamiento actual.
