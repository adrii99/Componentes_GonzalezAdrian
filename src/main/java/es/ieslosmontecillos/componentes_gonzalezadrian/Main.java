package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @javafx.fxml.FXML
    private CampoTextoNumerico ctnum;

    public void start(Stage stage) throws IOException {

      FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));

        CampoTextoNumerico campotextonumerico = new CampoTextoNumerico();

        stage.setScene(new Scene(campotextonumerico));
        stage.setTitle("Uso campo numerico");
        stage.setWidth(400);
        stage.setHeight(600);
        stage.show();
    }
    public static void main(String[] args){launch(args);}
}
