package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends VBox {

    private IntegerProperty tiempo = new SimpleIntegerProperty();

    //Creamos un objeto privado de un Action Event
    private ObjectProperty<EventHandler<ActionEvent>> alTerminar
            = new SimpleObjectProperty<EventHandler<ActionEvent>>();
    @FXML
    private Label lbl;
    private final Timeline timeline = new Timeline();

    public Temporizador()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

       tiempo.addListener(new ChangeListener<Number>() {
           @Override
           public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {

               lbl.setText(String.valueOf(newValue));

           }
       });
    }

    public Integer getTiempo(){return  tiempo.get();}

    public void setTiempo(Integer t){tiempo.set(t);}

    public IntegerProperty tiempoProperty(){return tiempo;}


    public void setAlTerminar(EventHandler<ActionEvent> handler) {
        alTerminar.set(handler);
    }

    public  EventHandler<ActionEvent> getAlTerminar() {
        return alTerminar.get();
    }

    public  ObjectProperty<EventHandler<ActionEvent>> alTerminarProperty() {
        return alTerminar;
    }

    public void iniciarTemporizador()
    {

        final KeyValue kv = new KeyValue(tiempo, 0);
        final KeyFrame kf = new KeyFrame(Duration.seconds(getTiempo()),getAlTerminar(),kv);

        lbl.setText(String.valueOf(getTiempo()));

        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

}
