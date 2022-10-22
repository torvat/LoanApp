package no.zdata.torva.houseingloanapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.zdata.torva.houseingloanapp.database.Connect;
import no.zdata.torva.houseingloanapp.objects.HouseingLoan;

import no.zdata.torva.houseingloanapp.objects.lists.LoanList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    private HouseingLoan loan;
    @FXML
    private TextField amount;
    @FXML
    private TextField duration;
    @FXML
    private Label output;
    @FXML
    private Label invalidDuration;

    public void initialize() {
        amount.setMaxWidth(150);
        duration.setMaxWidth(150);
    }
    protected void addValue() {

        try {
            int parsedDuration = Integer.parseInt(duration.getText());
            int parsedAmount = Integer.parseInt(amount.getText());
            if (parsedDuration <= 25) {
                loan = new HouseingLoan(parsedAmount, parsedDuration);
            } else {
                invalidDuration.setText("The duration is not suitable for the amount");
            }
        } catch (NumberFormatException e) {
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
            output.setText("Monthly Payment: " + loan.printEstimate());
        } catch (NumberFormatException e) {
            output.setText("Invalid Value");
        }
    }
    @FXML
    protected void saveToDatabase() {

        Connection con = Connect.connect();

        if (con != null) {
            try {
                Statement statement = con.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS loans(id INTEGER PRIMARY KEY AUTOINCREMENT, amount INTEGER," +
                        " duration INTEGER, monthlypayment DOUBLE)");

                int parsedDuration = Integer.parseInt(duration.getText());
                int parsedAmount = Integer.parseInt(amount.getText());

                statement.executeUpdate("INSERT INTO loans(amount, duration, monthlypayment)VALUES (" +
                        "'" + parsedAmount + "','" + parsedDuration + "'," + "'" + Math.round(loan.calculateMothlyBackpay()) + "')");

                System.out.println("Insert succsess");

                statement.close();
                con.close();
            } catch (SQLException sql) {
                sql.printStackTrace();
            } catch (NumberFormatException num) {
                num.printStackTrace();
            }
        }
    }
}