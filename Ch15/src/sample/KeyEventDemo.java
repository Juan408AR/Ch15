package sample;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class KeyEventDemo extends Application{
    @Override
    public void start(Stage stage){
        // creating a pane and creating text
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");

        // adding text to the pane and we are gonna add an action in
        // order to control the position of
        // the text inside of the pane using the keyboard...action events of keyevent
        pane.getChildren().add(text);
        // passing the appropriate arg type as well as a function inside of the parenthesis
        text.setOnKeyPressed(e -> { // e is assumed to event type because it is what is expected as an arg because of lambda
            // will be using a switch to detect the key pressed and do the appropriate action
            switch(e.getCode()){ // getcode returns a constant
                case DOWN: text.setY(text.getY() + 10); break;
                case UP: text.setY(text.getY() - 10); break;
                case RIGHT: text.setX(text.getX() + 10); break;
                case LEFT: text.setX(text.getX() - 10); break;
                // if anything other than the arrows are entered and it is a letter or digit
                // then that letter or digit will be set as the new text name
                default:
                    if((Character.isLetterOrDigit(e.getText().charAt(0))))
                        text.setText(e.getText());
            }
        });

        Scene scene = new Scene(pane, 300, 300);
        stage.setTitle("Key Event Demo");
        stage.setScene(scene);
        stage.show();

        text.requestFocus();

    }
}