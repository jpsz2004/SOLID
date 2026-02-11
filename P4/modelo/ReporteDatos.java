package P4.modelo;
import java.util.List;

public class ReporteDatos {
    private String titulo;
    private List<String> encabezados;
    private List<List<String>> filas;

    public ReporteDatos(String titulo, List<String> encabezados, List<List<String>> filas) {
        this.titulo = titulo;
        this.encabezados = encabezados;
        this.filas = filas;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getEncabezados() {
        return encabezados;
    }

    public List<List<String>> getFilas() {
        return filas;
    }
}