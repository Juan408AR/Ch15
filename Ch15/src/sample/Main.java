package sample;

import com.sun.source.tree.BreakTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane; // using this to organize other panes/nodes
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        HBox pane = new HBox(10);
//        pane.setAlignment(Pos.CENTER);
//        Button btOk = new Button("OK");
//        Button btCancel = new Button("Cancel");
//        OKHandlerClass handler1 = new OKHandlerClass();
//        CancelHandlerClass handler2 = new CancelHandlerClass();
//
//        // when button is clicked it triggers the handler
//        // the arg class is of type event-handler so it is able to be passed into this method that accepts only event-handler types
//        btOk.setOnAction(handler1);
//        btCancel.setOnAction(handler2);
//
//        pane.getChildren().addAll(btOk, btCancel);
//
//        Scene scene = new Scene(pane);
//        primaryStage.setTitle("Event buttons");
//        primaryStage.setScene(scene);
//        primaryStage.show();

        // 15.3
        StackPane pane = new StackPane();
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLUEVIOLET);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");

        hBox.getChildren().addAll(btEnlarge, btShrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER); // applies to anything that is a BorderPane? I think yes

        Scene scene = new Scene(borderPane, 200, 150); // notice how we had multple panes put into one pane in order to pass them into this scene
        primaryStage.setTitle("CircleWithoutEvents");
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
//
// Summaries Below:
//
// 15.1: Button -> Event -> Handler
// Buttons are an event source that can trigger an event,
// the event is then handled by the handler. You also need to have an object
// be able to handle an event it must extend the EventHandler class

// 15.2: Events and Event Sources:
// Reminder...Nodes are parts attached to a scene.
// Event Sources create and fire events.
// The children can fire events if their parent is able to fire events
// there are methods and classes for various events and even one to find the source event

// 15.3 Registering Handlers and Handling Events:
// Events must be linked to event sources and the event handler must implement the appropriate interface for events
// The event listeners/handlers are an instance of the interface they implement
// The source must set the handler/listener which is fired on order from the source
// ex...Button ok = new button("ok"); // creating an event source
//      OKHandler handler1 = new OKHandler() // creating an event handler
//      ok.setOnAction(handler1) // button sets handler as delegate

// !!! Creating files instead of putting all into one file

