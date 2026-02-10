package P1;
import P1.envio.*;
import P1.modelo.*;
import P1.generador.*;
import P1.repositorio.*;
import P1.servicio.ServicioFacturacion;

public class Main {
    
    public static void main(String[] args) {

        // Diferentes componentes del sistema de facturación, cada uno con su propia responsabilidad - Single Responsibility Principle
        
        Factura factura = new Factura("001", 150000.00);

        GeneradorFactura generador = new GeneradorFacturaPDF();
        EnviadorFactura enviador = new EnviadorWap(); // Cambiamos el método de envío a WAP para demostrar la flexibilidad del sistema - Open/Closed Principle
        RepositorioFactura repositorio = new RepositorioFacturaBD();

        ServicioFacturacion servicio = new ServicioFacturacion(generador, enviador, repositorio); // Inyección de dependencias a través del constructor

        servicio.procesarFactura(factura);
    }
}
