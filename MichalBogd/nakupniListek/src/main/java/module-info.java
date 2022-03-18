module com.example.nakupnilistek {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nakupnilistek to javafx.fxml;
    exports com.example.nakupnilistek;
}