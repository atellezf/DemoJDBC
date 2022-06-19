module edu.utel.demojdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;

    opens edu.utel.demojdbc to javafx.fxml;
    exports edu.utel.demojdbc;
}