package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {

      FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));

      Scene scene = new Scene(fxmlLoader.load(),600,400);

      stage.setTitle("Uso Campo Texto Numerico");
      stage.setScene(scene);
      stage.show();
    }

    public static void main(String[]args)
    {
        launch(args);
    }
}
