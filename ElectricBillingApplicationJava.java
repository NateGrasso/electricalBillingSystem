/* Nathan Grasso
 * CSC 240
 * Purpose: Program will calculate an energy bill using kilowatt hours and current
 * rate of residential power use in the state of Colorado, which the current month
 * is 12.14 cents per kilowatt hour (August 2021).
 */
package electricbillingapplication.java;

//import all needed classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import java.text.DecimalFormat;

public class ElectricBillingApplicationJava extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Create a FlowPane
        FlowPane pane = new FlowPane();
        //Set horizontal gaps,vertical gaps, and padding
        pane.setVgap(4);
        pane.setHgap(4);
        pane.setPadding(new Insets(5,5,5,5));
        
        //variable for current rate in colorado
        double rate = 0.1214;
        
        //Creating the textfields
        TextField tfFirst = new TextField();
        TextField tfLast = new TextField();
        TextField hours = new TextField();
        TextField bill = new TextField();
        
        //Setting the predicted character amount per text field
        tfFirst.setPrefColumnCount(10);
        tfLast.setPrefColumnCount(10);
        bill.setPrefColumnCount(6);
        hours.setPrefColumnCount(8);
        
        //Format variable for the bill result
        DecimalFormat decFor = new DecimalFormat("###.##");
        
        //label the text fields
        pane.getChildren().addAll(new Label("First Name: "), tfFirst,
                new Label("Last Name: "), tfLast, 
                new Label("Kilowatt Hours: "), hours,
                new Label ("Bill amount: $"), bill);
                
        //create an Hbox and button
        HBox hbox = new HBox(5);
        Button btn = new Button("Calculate");
        
        //align the button
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(btn);
        
        //container for the panes
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hbox);
        
        //Create a scene
        Scene scene = new Scene(borderPane, 250, 200);
        primaryStage.setTitle("Over Powered Energy Billing Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Calculation on button press using a lambda
        btn.setOnAction(e -> {
            bill.setText(decFor.format(Double.parseDouble(hours.getText()) *
                  rate) + "");
            //Print to console for verification
            System.out.println(tfFirst.getText() + " " + tfLast.getText() + '\n' + 
                    "Calculated Bill: $" + bill.getText() + '\n');
        });
    }

   //Launch the program
    public static void main(String[] args) {
        launch(args);
    }
    
}
