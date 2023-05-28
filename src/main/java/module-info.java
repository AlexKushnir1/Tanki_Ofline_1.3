module com.example.plantera_1_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.plantera_1_1 to javafx.fxml;
    exports com.example.plantera_1_1;
}