module es.ieslosmontecillos.componentes_gonzalezadrian {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_gonzalezadrian to javafx.fxml;
    exports es.ieslosmontecillos.componentes_gonzalezadrian;
}