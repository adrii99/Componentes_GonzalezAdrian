package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CampoTextoBoton extends HBox {

    @FXML
    private TextField tfControl;

    @FXML
    private Button btControl;

    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "campotextoboton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return tfControl.textProperty();
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }

/*
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        public Object getBean() {
            return CampoTextoBoton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }

        //faltan cosas

       // public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty(){return onAction};
        //public final ObjectProperty<EventHandler<ActionEvent>> OnAction(EventHandler<ActionEvent> handler){onActionProperty().set(handler);};
       // public final ObjectProperty<ActionEvent> getOnAction(){return onAction};
    }*/


}
