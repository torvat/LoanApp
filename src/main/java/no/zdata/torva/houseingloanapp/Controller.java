package no.zdata.torva.houseingloanapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.zdata.torva.houseingloanapp.objects.HouseingLoan;

public class Controller {

    private final HouseingLoan loan = new HouseingLoan();

    @FXML
    private TextField amount;

    @FXML
    private TextField duration;

    @FXML
    private Label output;
    @FXML
    private Label invalidDuration;


    public void initialize(){
        amount.setMaxWidth(150);
        duration.setMaxWidth(150);
    }

    protected void addValue(){
        int parsedDuration = Integer.parseInt(duration.getText());
        int parsedAmount = Integer.parseInt(amount.getText());

        try {
            loan.setAmount(parsedAmount);

            if(parsedDuration <= 25) {
                loan.setDuration(parsedDuration);
            }else{
                invalidDuration.setText("The duration is not suitable for the amount");
            }
        }catch (NumberFormatException e){
            System.out.println("Invalid Value");
        }
    }
    @FXML
    protected void calculateButtonClick() {
        invalidDuration.setText("");
        output.setText("");

        try {
            addValue();
            Math.round(loan.calculateMothlyBackpay());
            output.setText("Monthly Payment: " + loan);
        }catch (NumberFormatException e){
            output.setText("Invalid Value");
        }
    }
}