package P4.servicio;

import P4.formato.FormatoReporte;
import P4.generacion.GeneradorDatosReporte;
import P4.modelo.ReporteDatos;

public class ServicioReportes {
    
    private GeneradorDatosReporte generador;
    private FormatoReporte formato;

    public ServicioReportes(GeneradorDatosReporte generadorDatos, FormatoReporte formatoReporte) {
        this.generador = generadorDatos;
        this.formato = formatoReporte;
    }

    public void generarReporte() {
        ReporteDatos datos = generador.generarDatos();
        formato.exportar(datos);
    }
}
