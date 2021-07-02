package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import javax.swing.*;

public class LambdaHandlerDemo extends Application{
    @Override
    public void start(Stage stage){
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btNew = new Button("new");
        Button btOpen = new Button("open");
        Button btSave = new Button("save");
        Button btPrint = new Button("print");
        hBox.getChildren().addAll(btNew, btPrint, btOpen, btSave);

        // create and register handlers
        btNew.setOnAction((ActionEvent e) -> {
            System.out.println("Process New");
        });

        btOpen.setOnAction((e) -> {
            System.out.println("Process Open");
        });

        btSave.setOnAction(e -> {
            System.out.println("Process Save");
        });

        btPrint.setOnAction(e -> System.out.println("Process Print"));

        Scene scene = new Scene(hBox, 300, 300);
        stage.setTitle("LambdaHandlerDemo");
        stage.setScene(scene);
        stage.show();
    }


}
