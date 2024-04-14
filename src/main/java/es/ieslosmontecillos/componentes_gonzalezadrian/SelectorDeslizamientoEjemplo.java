package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SelectorDeslizamientoEjemplo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creando la escena
        VBox root = new VBox();

        //Creando componentes y añadiendolos al root
        Label titulo = new Label("Selectores");

        SelectorDeslizamiento selector1 = new SelectorDeslizamiento();
        SelectorDeslizamiento selector2 = new SelectorDeslizamiento();

        Label lbl = new Label("");

        root.getChildren().addAll(titulo, selector1, selector2,lbl);

        //Gestion de eventos
        selector1.setOnAction(e -> {
            lbl.setText("Pulsado selector de arriba");
        });

        selector2.setOnAction((ActionEvent event) -> {
            lbl.setText("Pulsado selector de abajo");
        });

        //añadiendo valores a los selectores
        ArrayList<String> cosas = new ArrayList();
        cosas.add("DI");
        cosas.add("SGE");
        cosas.add("AD");

        selector1.setItems(cosas);

        ArrayList<String> items = new ArrayList();
        items.add("BMW");
        items.add("Audi");
        items.add("Mercedes");
        items.add("Cupra");

        selector2.setItems(items);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Selectores");
        primaryStage.show();

    }
    public static void main(String[]args)
    {
        launch(args);
    }

}

