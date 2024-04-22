module eu.fthevenet.preferencetest {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.fthevenet.preferencetest to javafx.fxml;
    exports eu.fthevenet.preferencetest;
}