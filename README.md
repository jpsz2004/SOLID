**Proyecto SOLID — Taller Académico**

Descripción
- Este repositorio contiene ejercicios prácticos para comprender y aplicar los principios SOLID en Java. Cada subcarpeta P1..P5 implementa un escenario diferente (facturación, pagos, reportes, etc.) mostrando cómo diseñar código mantenible y testeable.

Estructura del proyecto
- P1: Implementación de facturación y envío (separación de responsabilidades y DI).
- P2: Procesamiento de pagos con distintos métodos (ISP y OCP).
- P3: Ejercicio minimal (punto de apoyo / plantilla).
- P4: Generación de reportes con formatos intercambiables (OCP y Strategy).
- P5: Ejercicio adicional / plantilla.

Resumen por ejercicio y relación con SOLID

**P1 — Facturación (Single Responsibility, Dependency Inversion)**
- Qué se hizo: Se separó la generación de la factura (`generador/`) del envío (`envio/`) y del almacenamiento (`repositorio/`). `ServicioFacturacion` orquesta la creación, persistencia y envío delegando en interfaces/implementaciones concretas.
- Archivos clave: [P1/servicio/ServicioFacturacion.java](P1/servicio/ServicioFacturacion.java), [P1/generador/GeneradorFactura.java](P1/generador/GeneradorFactura.java), [P1/envio/EnviadorEmail.java](P1/envio/EnviadorEmail.java), [P1/repositorio/RepositorioFacturaBD.java](P1/repositorio/RepositorioFacturaBD.java)
- Principio aplicado: Single Responsibility — cada clase tiene una sola razón para cambiar; Dependency Inversion — `ServicioFacturacion` depende de abstracciones (interfaces de envío/repositorio) y no de implementaciones concretas.

Ejemplo (patrón usado: inyección por constructor):
```java
// en ServicioFacturacion.java (simplificado)
public class ServicioFacturacion {
    private final RepositorioFactura repo;
    private final EnviadorFactura enviador;

    public ServicioFacturacion(RepositorioFactura repo, EnviadorFactura enviador) {
        this.repo = repo;
        this.enviador = enviador;
    }

    public void procesar(Factura factura) {
        repo.guardar(factura); // persistencia
        enviador.enviar(factura); // delega envío
    }
}
```

**P2 — Pagos (Interface Segregation, Open/Closed)**
- Qué se hizo: Se definió una interfaz común `PaymentMethod` que implementan `PaymentCredit` y `PaymentPaypal`. `PaymentProcessor` usa la interfaz para procesar pagos sin conocer detalles específicos.
- Archivos clave: [P2/Methods/PaymentMethod.java](P2/Methods/PaymentMethod.java), [P2/Methods/PaymentCredit.java](P2/Methods/PaymentCredit.java), [P2/Processor/PaymentProcessor.java](P2/Processor/PaymentProcessor.java)
- Principio aplicado: ISP — las interfaces son pequeñas y específicas; OCP — para agregar un nuevo `PaymentMethod` no se modifica `PaymentProcessor`.

Ejemplo:
```java
// PaymentProcessor.java
public class PaymentProcessor {
    public void process(PaymentMethod method, double amount) {
        if(method.isValid()) {
            method.pay(amount);
        }
    }
}
```

**P3 — Notificaciones (Strategy / Dependency Inversion / OCP)**
- Qué se hizo: `P3/Main.java` implementa un sistema de notificaciones con la interfaz `Notifier` y varias implementaciones (`EmailNotifier`, `SMSNotifier`, `PushNotifier`, `SlackNotifier`). `NotificationService` depende de la abstracción `Notifier` y permite cambiar la estrategia de envío en tiempo de ejecución.
- Archivos clave: [P3/Main.java](P3/Main.java)
- Principio aplicado: Dependency Inversion e Open/Closed — se pueden añadir nuevos notifiers sin modificar `NotificationService`.
- Comportamiento: el `Main` muestra cómo inyectar diferentes `Notifier` en `NotificationService` y enviar mensajes usando la misma API.

**P4 — Reportes (Open/Closed, Strategy)**
- Qué se hizo: Se definió `FormatoReporte` (interfaz) y varias implementaciones (`FormatoCSV`, `FormatoPDF`). Los generadores de reporte (`generacion/GeneradorVentas.java`) aceptan la estrategia de formato, permitiendo extender formatos sin modificar el generador.
- Archivos clave: [P4/formato/FormatoReporte.java](P4/formato/FormatoReporte.java), [P4/formato/FormatoPDF.java](P4/formato/FormatoPDF.java), [P4/generacion/GeneradorVentas.java](P4/generacion/GeneradorVentas.java)

Ejemplo (Strategy / OCP):
```java
public class GeneradorVentas {
    private final FormatoReporte formato;

    public GeneradorVentas(FormatoReporte formato) {
        this.formato = formato;
    }

    public void generar(ReporteDatos datos) {
        String salida = formato.formatear(datos);
        // guardar o mostrar salida
    }
}
```

**P5 — Roles de usuario (Open/Closed, Single Responsibility)**
- Qué se hizo: `P5/Main.java` define la interfaz `UserRole` y varias implementaciones (`AdminRole`, `ClientRole`, `GuestRole`, `ModeratorRole`). La clase `User` delega el comportamiento al rol asignado, permitiendo añadir nuevos roles sin modificar la lógica del usuario.
- Archivos clave: [P5/Main.java](P5/Main.java)
- Principio aplicado: Open/Closed — se extiende el sistema añadiendo `ModeratorRole` sin tocar `User`; Single Responsibility — cada rol encapsula su propia responsabilidad sobre el acceso.
- Comportamiento: el `Main` crea usuarios con distintos roles y llama a `accessSystem()` para ejecutar la lógica específica del rol.

Respuestas a las reflexiones del taller
- 1) ¿Qué beneficios aporta aplicar SOLID?
  - Mejora la mantenibilidad, facilita pruebas unitarias, reduce acoplamiento y hace el código más extensible.
- 2) Ejemplo de violación y corrección:
  - Violación: una clase `FacturaManager` que genera, persiste y envía facturas (múltiples responsabilidades). Corrección: separar en `GeneradorFactura`, `RepositorioFactura`, y `EnviadorFactura`, y orquestar en `ServicioFacturacion` (SRP + DIP).
- 3) ¿Cómo favorece la prueba unitaria?
  - Al depender de interfaces, se pueden mockear dependencias (repositorios, servicios de envío) y probar cada unidad aislada.
- 4) ¿Qué principio es más difícil y por qué?
  - Liskov (LSP) a veces es sutil: requiere que las subclases respeten contratos y comportamiento esperado; diseñar interfaces claras y precondiciones/postcondiciones ayuda.
- 5) ¿Cómo se refleja OCP en el repositorio?
  - Agregar nuevos formatos de reporte o nuevos métodos de pago sólo requiere crear nuevas clases que implementen la interfaz correspondiente sin cambiar la lógica del procesador/generador.

Cómo compilar y ejecutar (línea de comandos)
- Compilar un paquete (ejemplo P1):
```bash
javac -d out P1/**/*.java
java -cp out P1.Main
```
- Ejecutar un `Main` concreto, p. ej. P4:
```bash
javac -d out P4/**/*.java
java -cp out P4.Main
```
Creado por: Tomas Marulanda Aristizabal y Juan Pablo Sánchez Zapata
