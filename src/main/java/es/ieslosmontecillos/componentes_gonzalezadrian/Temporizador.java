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

/**
 * La clase Temporizador extiende de VBox y proporciona la funcionalidad de un temporizador
 * que puede ser configurado y visualizado utilizando un archivo FXML.
 *
 * @author Adrián González García
 * @version 1.0
 * @since 23-05-2024
 */
public class Temporizador extends VBox {

    private IntegerProperty tiempo = new SimpleIntegerProperty();

    //Creamos un objeto privado de un Action Event
    private ObjectProperty<EventHandler<ActionEvent>> alTerminar
            = new SimpleObjectProperty<EventHandler<ActionEvent>>();
    @FXML
    private Label lbl;
    private final Timeline timeline = new Timeline();

    /**
     * Constructor vacio de la clase Temporizador.
     * Carga el archivo FXML y configura el temporizador para actualizar la etiqueta lbl
     * con el tiempo restante.
     * Añade un listener a la propiedad de tiempo para actualizar la etiqueta
     * con cada cambio en el valor del tiempo.
     * @throws RuntimeException si hay un error al cargar el archivo FXML.
     */
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

    /**
     * Obtiene el tiempo restante del temporizador.
     *
     * @return el tiempo restante de tipo Integer.
     */
    public Integer getTiempo(){return  tiempo.get();}

    /**
     * Establece el tiempo del temporizador.
     *
     * @param t el tiempo a establecer de tipo Integer.
     */
    public void setTiempo(Integer t){tiempo.set(t);}

    /**
     * Obtiene la propiedad del tiempo del temporizador.
     *
     * @return la propiedad del tiempo de tipo IntegerProperty.
     */
    public IntegerProperty tiempoProperty(){return tiempo;}

    /**
     * Establece el manejador de eventos que se ejecutará al terminar el temporizador.
     *
     * @param handler el manejador de eventos a establecer.
     */
    public void setAlTerminar(EventHandler<ActionEvent> handler) {
        alTerminar.set(handler);
    }

    /**
     * Obtiene el manejador de eventos que se ejecutará al terminar el temporizador.
     *
     * @return EventHandler<ActionEvent> el manejador de eventos.
     */
    public  EventHandler<ActionEvent> getAlTerminar() {
        return alTerminar.get();
    }

    /**
     * Obtiene la propiedad del manejador de eventos al terminar el temporizador.
     *
     * @return ObjectProperty<EventHandler<ActionEvent>> la propiedad del manejador de eventos.
     */
    public  ObjectProperty<EventHandler<ActionEvent>> alTerminarProperty() {
        return alTerminar;
    }

    /**
     * Inicia el temporizador y actualiza la etiqueta con el tiempo restante.
     * Al finalizar el tiempo, ejecuta el manejador de eventos configurado.
     */

    public void iniciarTemporizador()
    {

        final KeyValue kv = new KeyValue(tiempo, 0);
        final KeyFrame kf = new KeyFrame(Duration.seconds(getTiempo()),getAlTerminar(),kv);

        lbl.setText(String.valueOf(getTiempo()));

        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

}
