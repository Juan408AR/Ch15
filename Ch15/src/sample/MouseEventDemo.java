package sample;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class MouseEventDemo extends Application{
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Text text = new Text(20, 20, "Programming is fun");
        pane.getChildren().add(text);
        text.setOnMouseDragged(e -> {   // e is on ActionEvent type, which means you can
            text.setX(e.getX());
            text.setY(e.getY());
        });

        Scene scene = new Scene(pane, 300, 100);
        stage.setTitle("Mouse Event Demo");
        stage.setScene(scene);
        stage.show();
    }
}
