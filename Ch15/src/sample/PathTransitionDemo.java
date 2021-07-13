package sample;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.awt.image.CropImageFilter;


public class PathTransitionDemo extends Application{
    @Override
    public void start(Stage stage){
        // creating a pane
        Pane pane = new Pane();

        // creating a rectangle
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);

        //creating a circle
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // adding our shapes to the pane
        pane.getChildren().addAll(rectangle, circle);

        // creating a path for our shapes
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle); // the path will be the circle
        pt.setNode(rectangle); // the node that will travel the path in the rectangle
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);    // orientate the rectangle
        pt.setCycleCount(Timeline.INDEFINITE);  // how many times it will loop
        pt.setAutoReverse(true);
        pt.play();  // start the animation

        circle.setOnMousePressed(e -> pt.pause()); // this is a lambda event
        circle.setOnMouseReleased(e -> pt.play());

        // creating a scene
        Scene scene = new Scene(pane);
        stage.setTitle("PathTransitionDemon");
        stage.setScene(scene);
        stage.show();





    }
}
