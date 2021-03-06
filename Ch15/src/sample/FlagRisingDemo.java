package sample;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.util.Duration;

import java.awt.*;

public class FlagRisingDemo extends Application {
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Image image = new Image("file:///C:/Users/Juan/Desktop/Flag_of_Mexico.png", 200, 200, true, true);
        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);

        PathTransition pt = new PathTransition(Duration.millis(6000),
                new Line(100, 800, 900,20), imageView);
        pt.setCycleCount(Timeline.INDEFINITE); // args is same as -1
        pt.setAutoReverse(true);
        pt.play();

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();

    }
}
