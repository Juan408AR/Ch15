package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;


public class AnonymousHandlerDemo extends Application {
    @Override
    public void start(Stage stage){
        // creating an hbox to store nodes
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        // creating buttons then storing them in our hbox
        Button newBt = new Button("New");
        Button openBt = new Button("Open");
        Button saveBt = new Button("Save");
        Button printBt = new Button("Print");
        hBox.getChildren().addAll(newBt, openBt, saveBt, printBt);

        // create and register the handler
        newBt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Process New");
            }
        });

        openBt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Process Open");
            }
        });

        saveBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Process Save");
            }
        });

        printBt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.out.println("Processing Print");
            }
        });

        Scene scene = new Scene(hBox, 300, 300);
        stage.setTitle("Anonymous Handler class");
        stage.setScene(scene);
        stage.show();


    }

}
