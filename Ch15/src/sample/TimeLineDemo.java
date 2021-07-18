package sample;
import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.sql.Time;

public class TimeLineDemo extends Application{
    @Override
    public void start(Stage stage){
        StackPane pane = new StackPane();
        Text text = new Text(20, 50,"Programming is fun");
        text.setFill(Color.PINK);
        pane.getChildren().add(text);

        // create a handler for the changing text
        EventHandler<ActionEvent> eventEventHandler = e -> {    // generic type actionevent
            if(text.getText().length() != 0)    // if not empty
                text.setText("");
            else
                text.setText("Programming is fun");
        };

        // creating an animation for alternating
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500),
                eventEventHandler)); // we passed our handler into the Timeline args...takes in a keyframe and a handler
        animation.setCycleCount(-1);
        animation.play(); // play/start the animation

        // pause and resume the text alternate when the mouse is clicked
        text.setOnMouseClicked(e -> {
            if(animation.getStatus() == Animation.Status.PAUSED)
                animation.play();
            else
                animation.pause();
        });

        Scene scene = new Scene(pane,400,400);
        stage.setTitle("TimeLineDemon.java");
        stage.setScene(scene);
        stage.show();

    }
}
