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
//        StackPane pane = new StackPane();
//        Circle circle = new Circle(50);
//        circle.setStroke(Color.BLUEVIOLET);
//        circle.setFill(Color.WHITE);
//        pane.getChildren().add(circle);
//
//        HBox hBox = new HBox();
//        hBox.setSpacing(10);
//        hBox.setAlignment(Pos.CENTER);
//
//        Button btEnlarge = new Button("Enlarge");
//        Button btShrink = new Button("Shrink");
//
//        hBox.getChildren().addAll(btEnlarge, btShrink);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setCenter(pane);
//        borderPane.setBottom(hBox);
//        BorderPane.setAlignment(hBox, Pos.CENTER); // applies to anything that is a BorderPane? I think yes
//
//        Scene scene = new Scene(borderPane, 200, 150); // notice how we had multple panes put into one pane in order to pass them into this scene
//        primaryStage.setTitle("CircleWithoutEvents");
//        primaryStage.setScene(scene);
//        primaryStage.show();

        // 15.5 Anonymous Inner Class Handler:


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

// 15.4 Inner Classes:
/*
    Inner classes are usually handler classes like event handlers.
    Inner classes can reference/obtain outer class methods and data fields.
    Dependent classes are placed inside.
    Normally the inner class belongs only to the outer class.
    The file looks like outer$inner.class
    Inner can be static in order to be used by the outer without an instance.
    Inner can have visibility modifiers.
    Usually the outer creates an instance of the inner but you can also create an instance
    of the inner in another class by...Outer.Inner referenceVar = new Outer.Inner();
    If the inner is static you can make the referenceVar of type outer because it will be able to access the static inner
    Benefits are combining two dependent classes and reduce clutter, the
    naming would be...outer$inner.class.
    Because handlers are usually associated only with one class, it is best to make the handler
    class an inner class. You also avoid naming conflicts by doing so.

 */

// 15.5 Anonymous Inner Class Handlers: an inner class without a name, useful because they usually belong to only
// one class and arent usually access or used by any outside classes.
/*
    Syntax...method.setOnActoni(new EventHandler<ActionEvent>() { method{ and innner scope}});
    Syntax from book point of view...new superclassname/interfacename(){ implement/override methods in superclass or interface}
    Rules of anonymous innerclass: must always extend a superclass or interface, must implement abstract methods, must use no-arg constructor, if it is an interface then Object(),
    naming of the file is outclass$n.class where n is the number associated to the anonymous class.

 */

// 15.6 Simplifying Event Handling Using Lambda Expressions:
/*
    Making coding more simple by being less verbose...instead of stating eventhandler and override method,
    simply use the following syntax: btEnlarge.setOnAction(e -> {}); //uses the fat arrow
    In simple terms, it gets rid of the verbose from the anonymous class.
    Syntax: (type1 param1, type 2 param2...) -> expression
    or
    (type1 param1, type 2 param2...) -> {statements};
    notice how one requires brackets because has multiple statements but if is only one then you do not need brackets
    type such as type1 above can be explicit or implicit...also if there is only one parameter then you can exclude the parenthesis
    sample...
        e->{code...}

    lambda expression are treated as objects created from anonymous inner classes,
    How it works is that an actionevent method can only take a parameter of handletype
    so it make e of type actionevent implicitly because that is the only data type that is expected as a parameter
    and that the statements inside of the body belong to the e object.
    !!! compiler can only understand one lambda expression method inside of the parameter.
    Functional interface or SAM(single abstract method) is needed for lambda expression to work.
 */

// 15.7 Case Study: loan Calculator: using event driven programming to create a gui to create a loan calculator.
/*
    Recap: shows how to separated related chunks of code, form from function.

    We don't use a scanner to store input.Instead we store it in the textfield and on the action,
    we extract the info in the textfield and set-it as text inside other textfields to display it.
    Also, we use a method to prevent the user from altering the calculate info inside of the textbox


 */

// 15.8 Mouse Events: whenever a mouse: clicks, released, clicked, moved, or dragged on node or scene
// a Mouse Event is fired.
/*
    There are function that indicate which buttons where pressed.
 */

// 15.9 Key Events:
/*
    When is a key is: pressed, held, or released an event could be fired.
    Keyevents are responsible for control, perform actions, get input from keyboard.
    Key events are encapsulated by keyevents.
    We learned how to add multiple types of events to a program.
    One issue encountered was with focus.
    When a button is clicked on the window/scene the focus is shifted to the button label
    so you need to refocus the program to the scene instead of the button after
    each instance of a button being clicked.
 */

// 15.10 Listeners for Observable Objects: a listener waits for changes then reacts, it basically processes a value change
/*
    Detect changes to an object of an observable type and proceed with an action if you would like.
 */

// 15.11 Animation: Animation class with the features necessary for animation
/*
    we will learn about transition,fade, and timeline.
    Pathtransition: moves the nodes along a path.
    15.11.11:
 */