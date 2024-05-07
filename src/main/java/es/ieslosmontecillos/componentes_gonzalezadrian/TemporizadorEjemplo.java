package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TemporizadorEjemplo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //Crea una instancia de Temporizador
        Temporizador temp = new Temporizador();
        Label lbl = new Label();

        VBox root = new VBox();
        root.getChildren().addAll(temp,lbl);

        temp.setTiempo(10);

        temp.setAlTerminar(e -> {
            lbl.setText("Se acabo el tiempo");
        });

        temp.iniciarTemporizador();

        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Temporizador");
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
