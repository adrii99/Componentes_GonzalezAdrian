package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {

      FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(""))

        CampoTextoBoton campotextoboton = new CampoTextoBoton();

        stage.setScene(new Scene(campotextoboton));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }
}
