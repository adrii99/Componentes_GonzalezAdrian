package es.ieslosmontecillos.componentes_gonzalezadrian;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CampoTextoBoton extends HBox {
    @FXML private TextField tfControl;
    @FXML private Button btControl;

    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("campotextoboton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        btControl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
            }
        });
    }

    public String getText() {
        return tfControl.textProperty().get();
    }

    public void setText(String value) {
        tfControl.textProperty().set(value);
    }

    public StringProperty textProperty() {
        return tfControl.textProperty();
    }

    public String getBtnText() {
        return btControl.textProperty().get();
    }

    public void setBtnText(String btnValue){
        btControl.textProperty().set(btnValue);
    }

    public StringProperty btnTextProperty(){
        return btControl.textProperty();
    }

    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction
            = new SimpleObjectProperty<EventHandler<ActionEvent>>();

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return propertyOnAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> handler) {
        propertyOnAction.set(handler);
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return propertyOnAction.get();
    }
}