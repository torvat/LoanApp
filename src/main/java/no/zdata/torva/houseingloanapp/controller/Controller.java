package no.zdata.torva.houseingloanapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.zdata.torva.houseingloanapp.database.Connect;
import no.zdata.torva.houseingloanapp.objects.HouseingLoan;
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

    public void initialize() {
        amount.setMaxWidth(150);
        duration.setMaxWidth(150);
    }
    @FXML
    protected void calculateButtonClick() {
        output.setText("");
        try {
            int parsedDuration = Integer.parseInt(duration.getText());
            int parsedAmount = Integer.parseInt(amount.getText());
            if (parsedDuration <= 25) {
                loan = new HouseingLoan(parsedAmount, parsedDuration);
                output.setText("Monthly Payment: " + loan.printEstimate());
            } else {
                output.setText("The duration is not suitable for the amount");
            }
        } catch (NumberFormatException e) {
            output.setText("Invalid Value");
        } catch (RuntimeException e) {
            output.setText("Duration cannot be 0 or less");
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
                        "'" + parsedAmount + "','" + parsedDuration + "'," + "'" + Math.round(loan.calculateMonthlyPayment()) + "')");

                System.out.println("Insert succsess");

                statement.close();
                con.close();
            } catch (SQLException | NumberFormatException sql) {
                sql.printStackTrace();
            }
        }
    }
}