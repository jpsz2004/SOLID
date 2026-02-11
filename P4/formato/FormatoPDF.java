package P4.formato;

import P4.modelo.ReporteDatos;
import java.util.List;

public class FormatoPDF implements FormatoReporte {

    @Override
    public void exportar(ReporteDatos datos) {
        System.out.println("Exportando reporte a PDF...");
        System.out.println("Título: " + datos.getTitulo());
        System.out.println("Encabezados: " + String.join(", ", datos.getEncabezados()));
        for (List<String> fila : datos.getFilas()) {
            System.out.println("Fila: " + String.join(", ", fila));
        }
    }
    
}
