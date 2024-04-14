package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CampoTextoBotonEjemplo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        CampoTextoBoton ctb = new CampoTextoBoton();

        stage.setScene(new Scene(ctb));
        stage.setTitle("Uso CampoTextoBoton");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();

        ctb.setText("Hello world!");
        ctb.setBtnText("Boton");

        ctb.setOnAction( e ->   {
            System.out.println("Has pulsado el boton");
        });
    }
    public static void main(String[]args)
    {
        launch(args);
    }
}
