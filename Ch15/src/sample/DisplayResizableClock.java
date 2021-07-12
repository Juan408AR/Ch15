package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayResizableClock extends Application{
    @Override
    public void start(Stage stage){
        ClockPane clock = new ClockPane();
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond;

        Label lblCurrentTime = new Label(timeString);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("DisplayResizableClock");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
        pane.heightProperty().addListener(ov -> clock.setY(pane.getHeight()));

    }
}
