module com.example.houseingloanapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens no.zdata.torva.houseingloanapp to javafx.fxml;
    exports no.zdata.torva.houseingloanapp;
}