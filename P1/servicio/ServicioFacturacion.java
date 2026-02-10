package P1.servicio;

import P1.envio.EnviadorFactura;
import P1.generador.GeneradorFactura;
import P1.repositorio.RepositorioFactura;
import P1.modelo.*;

// Este servicio realiza la inyección de dependencias a través del constructor, permitiendo la flexibilidad de cambiar las implementaciones de generación, envío y almacenamiento de facturas sin modificar el código del servicio. No estamos limitando el servicio a una forma concreta de generación o envío, lo que facilita la extensión futura del sistema.

public class ServicioFacturacion {

    private GeneradorFactura generadorFactura;
    private EnviadorFactura enviadorFactura;
    private RepositorioFactura repositorioFactura;

    public ServicioFacturacion(GeneradorFactura generadorFactura, EnviadorFactura enviadorFatura, RepositorioFactura repositorioFactura){
        this.generadorFactura = generadorFactura;
        this.enviadorFactura = enviadorFatura;
        this.repositorioFactura = repositorioFactura;
    }

    public void procesarFactura(Factura factura){
        FacturaDocumento documento = generadorFactura.generarFactura(factura);
        enviadorFactura.enviarFactura(documento);
        repositorioFactura.guardarFactura(documento);
    }
    
}
