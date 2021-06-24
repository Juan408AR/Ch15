package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btOk = new Button("OK");
        Button btCancel = new Button("Cancel");
        OKHandlerClass handler1 = new OKHandlerClass();
        CancelHandlerClass handler2 = new CancelHandlerClass();

        // when button is clicked it triggers the handler
        // the arg class is of type event-handler so it is able to be passed into this method that accepts only event-handler types
        btOk.setOnAction(handler1);
        btCancel.setOnAction(handler2);

        pane.getChildren().addAll(btOk, btCancel);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Event buttons");
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}

class OKHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Ok Button Clicked");
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Cancel Button Clicked");
    }
}

// Ch15: Event-Driven Programming and Animation
// 15.1: Button -> Event -> Handler
// Buttons are an event source that can trigger an event,
// the event is then handled by the handler. You also need to have an object
// be able to handle an event it must extend the EventHandler class