package sample;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class LoanCalculator extends Application{
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage stage){
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);
        pane.add(new Label("Annual Interest Rate:"), 0, 0);
        pane.add(tfAnnualInterestRate, 1, 0);
        pane.add(new Label("Number of Years:"), 0, 1);
        pane.add(tfNumberOfYears, 1, 1);
        pane.add(new Label("Loan Amount:"),0, 2);
        pane.add(tfLoanAmount, 1, 2);
        pane.add(new Label("Monthly Payment:"), 0, 3);
        pane.add(tfMonthlyPayment, 1, 3);
        pane.add(new Label("Total Payment"), 0, 4);
        pane.add(tfTotalPayment, 1, 4);
        pane.add(btCalculate, 1, 5);

        // setting properties for the user interface: such as the cells content, labels, and the button
        pane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setEditable(false); // indicates whether this can be edited or not;
        GridPane.setHalignment(btCalculate, HPos.RIGHT);  // sets the alignment of the children

        // process the event using lambda,  assigning event to eventsource
        btCalculate.setOnAction(e -> calculateLoanPayment()); // is of event type


        Scene scene = new Scene(pane, 300, 200);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void calculateLoanPayment(){
        double interest = Double.parseDouble(tfAnnualInterestRate.getText()); // get the text inside of the field and turn it into ta double by using the parse function....the Double's static method is used and indicated by the 'Double.'
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());

        Loan loan = new Loan(interest, year, loanAmount);

         // display info
        tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
    }

}
