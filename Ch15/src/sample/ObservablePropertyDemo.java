package sample;
import javafx.beans.Observable;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo{
    public static void main(String [] args){
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(new InvalidationListener(){ // This is the listener.object instance and method go in parameter. You could use lambda here
            public void invalidated(Observable ov){ // handle the change
                System.out.println("The new value is " +
                        balance.doubleValue());
            }
        });
        balance.set(4.5); // because balance has a listener, it triggers the listener's invalidated method which displays a message each time the balance is changed.
    } // end of main
}
