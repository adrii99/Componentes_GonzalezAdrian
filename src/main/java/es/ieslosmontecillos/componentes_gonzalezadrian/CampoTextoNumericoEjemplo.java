package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CampoTextoNumericoEjemplo extends Application {

    public void start(Stage stage) throws IOException {

        //Creando la escena
        VBox root = new VBox();

        //Creando los objetos y añadiendolos al root
        Label label = new Label("Introduce numero: ");
        CampoTextoNumerico ctn = new CampoTextoNumerico();

        root.getChildren().addAll(label,ctn);

        Scene scene = new Scene(root,600,400);

        stage.setTitle("Uso CampoTextoNumerico");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args)
    {
        launch(args);
    }
}
