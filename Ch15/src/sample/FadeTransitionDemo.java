package sample;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application{
    @Override
    public void start(Stage stage){
        // creating a pane
        Pane pane = new Pane();
        //creating an ellipse
        Ellipse ellipse = new Ellipse(10,10, 100, 50);
        ellipse.setFill(Color.BLACK);
        ellipse.setStroke(Color.RED);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));// bind ellipse to the properties of the pane so if the pane changes then so does the ellipse
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(pane.widthProperty().multiply(0.4));
        ellipse.radiusYProperty().bind(pane.heightProperty().multiply(0.4)); // the same as if dividing by 4

        // add the ellipse to the pane
        pane.getChildren().add(ellipse);

        // apply the fade transition to the ellipse
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse); // here we created a fade transition where it takes two args one being the time taken and the other being the node
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(-1); // should be the same as Timeline.INDEFINITE
        ft.setAutoReverse(true);
        ft.play();

        // control the animation
        ellipse.setOnMousePressed(e -> ft.pause());
        ellipse.setOnMouseReleased(e -> ft.play()); // if this was set to 'MousePressed' it would override the previous event

        // create the scene and add to the stage
        Scene scene = new Scene(pane,400, 400);
        stage.setTitle("FadeTransitionDemon");
        stage.setScene(scene);
        stage.show();



    }
}
