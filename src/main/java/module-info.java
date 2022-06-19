module edu.utel.demojdbc {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utel.demojdbc to javafx.fxml;
    exports edu.utel.demojdbc;
}