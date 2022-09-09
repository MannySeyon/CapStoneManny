
module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires validatorfx;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
//    requires java.mail;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;

    opens com.example.demo.Admin to javafx.fxml;
    exports com.example.demo.Admin;
}