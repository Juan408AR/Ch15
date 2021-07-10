package sample;
import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox; // horizontal box
import javafx.scene.layout.BorderPane; // ? this will go in the hbox?
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode; // to get keys such as shift and what not...we could not do this with our previous program in keyeventDemo.java
import javafx.scene.input.MouseButton;


public class ControlCircleWithMouseAndKey extends Application{
    private CirclePane circlePane = new CirclePane();   // circlepane is actually an inner class of the controlCircle class

    @Override
    public void start(Stage stage){
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");

        hBox.getChildren().addAll(btEnlarge,btShrink);

        // create and register the handlers for the events
        btEnlarge.setOnAction(e -> {
            circlePane.enlarge();
            circlePane.requestFocus();  // this resets the requestFocus to the scene
        });
        btShrink.setOnAction(e -> {
            circlePane.shrink();
            circlePane.requestFocus();
        });

        circlePane.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY) circlePane.enlarge();
            else if(e.getButton() == MouseButton.SECONDARY) circlePane.shrink();
        });

        circlePane.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.U) circlePane.enlarge();
            else if(e.getCode() == KeyCode.D) circlePane.shrink();
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane); // putting the circle in the center of the pane
//        borderPane.setBottom(btEnlarge,btShrink); // not valide because can only take a node
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);// set alignment for BorderPane with an Hbox, followed by a Pos

        Scene scene = new Scene(borderPane, 500, 500);
        stage.setTitle("Control Circle with mouse and key");
        stage.setScene(scene);
        stage.show();

        circlePane.requestFocus(); // allows for circlepane to recieve key events
        // important note regarding focus!!!!!!!!!! in main
    }
}
