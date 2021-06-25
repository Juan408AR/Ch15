package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ControlCircle extends  Application{
    private CirclePane circlePane = new CirclePane();   // we create the circle object
    @Override
    public void start(Stage stage){
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().addAll(btEnlarge, btShrink);

        btEnlarge.setOnAction(new EnlargedHandler()); // handler delegates for button
        btShrink.setOnAction(new ShrinkHandler()); // linking the event handlers to the event sources

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER); // why BorderPane and what is setAlignment? So that it affects all BorderPane instances and setAlignment is the position of the node inside the borderpane cell

        Scene scene = new Scene(borderPane, 200, 150);
        stage.setTitle("Controlled Circle");
        stage.setScene(scene);
        stage.show();

    }

    /*
        In order to be a handler for an event it must implement the interface below.
        As well with the type of event, actionEvent in our case, then implement the
        required method in that interface...handle(event type).
     */
    class EnlargedHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.enlarge();
        }
    }

    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        }
    }
}

class CirclePane extends StackPane{     // we create and touch up a circle then add it to the stackpane
    private Circle circle = new Circle(50);

    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge(){  // we use built in methods to update the circle...below we check before updating
        circle.setRadius(circle.getRadius() + 5);
    }

    public void shrink(){
        circle.setRadius(circle.getRadius() > 5 ? circle.getRadius() - 5 : circle.getRadius());
    }
}