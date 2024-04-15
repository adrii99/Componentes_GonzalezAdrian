package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemporizadorEjemplo extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //Crea una instancia de Temporizador con un tiempo
        Temporizador temp = new Temporizador(5);

        VBox root = new VBox();
        System.out.println(temp.getTiempo());

        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Temporizador");
        stage.show();

        temp.setOnFinished(e -> {
            Label lbl = new Label("Se acabo el tiempo!!");
            root.getChildren().add(lbl);
        });

    }
    public static void main(String[] args) {
        launch(args);
    }
}
