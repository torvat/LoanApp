module no.zdata.torva.houseingloanapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;
    requires xstream;
    requires lombok;
    requires jaxb.api;
    requires java.sql;


    opens no.zdata.torva.houseingloanapp to javafx.fxml;
    exports no.zdata.torva.houseingloanapp;
    exports no.zdata.torva.houseingloanapp.objects;
    exports no.zdata.torva.houseingloanapp.controller;
    opens no.zdata.torva.houseingloanapp.controller to javafx.fxml;
}