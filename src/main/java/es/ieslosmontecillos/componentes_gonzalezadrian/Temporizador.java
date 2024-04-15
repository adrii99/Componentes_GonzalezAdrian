package es.ieslosmontecillos.componentes_gonzalezadrian;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends VBox {

    @javafx.fxml.FXML
    private Label lbl;

    private Integer tiempo;

    public Temporizador(Integer tiempo)
    {
        this.setTiempo(tiempo);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        //fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        lbl.setText(tiempo.toString());

        Timeline tl = new Timeline();

        tl.setCycleCount(getTiempo());

        KeyFrame kf =new KeyFrame(Duration.seconds(1), e -> {
            setTiempo(getTiempo()-1);
            lbl.setText(getTiempo().toString());
        });

        tl.getKeyFrames().addAll(kf);

        //Pasamos esta propiedad desde el constructor
        tl.setOnFinished((ActionEvent event) -> {
            onFinishedProperty().get().handle(event);
        });

        tl.play();
    }

    //Constructor vacio
    public Temporizador(){}


    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    //Creamos un objeto privado de un Action Event
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnFinished
            = new SimpleObjectProperty<EventHandler<ActionEvent>>();

    //Creamos un metodo para recuperar ese objeto privado de tipo object property action event
    public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
        return propertyOnFinished;
    }

    //Creamos un setter de esta propiedad
    public final void setOnFinished(EventHandler<ActionEvent> handler) {
        propertyOnFinished.set(handler);
    }

    //Creamos un getter
    public final EventHandler<ActionEvent> getOnFinished() {
        return propertyOnFinished.get();
    }
}
