module com.example.assignment2gc200486396 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.assignment2gc200486396 to javafx.fxml, com.google.gson;
    exports com.example.assignment2gc200486396;
}