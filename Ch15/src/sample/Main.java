package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new LinePane(), 200, 200);
        primaryStage.setTitle("ShowLine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class LinePane extends Pane{
        public LinePane(){
            Line line1 = new Line(10, 10, 10, 10);
            line1.endYProperty().bind(widthProperty().subtract(10));
            line1.endXProperty().bind(heightProperty().subtract(10));
            line1.setStrokeWidth(5);
            line1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            getChildren().add(line1);

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
