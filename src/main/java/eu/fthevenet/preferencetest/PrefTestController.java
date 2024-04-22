package eu.fthevenet.preferencetest;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class PrefTestController implements Initializable {
    public ListView<String> preferenceList;

    @FXML
    protected void onForceUpdate() {
        updatePreferences();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.getPreferences().addListener((InvalidationListener) c -> updatePreferences());
        updatePreferences();
    }

    private void updatePreferences(){
        preferenceList.getItems().clear();
        preferenceList.getItems().add("Last update: " + ZonedDateTime.now());
        preferenceList.getItems().add("Color scheme=" +Platform.getPreferences().getColorScheme());
        preferenceList.getItems().add("BG color=" +Platform.getPreferences().getBackgroundColor());
        preferenceList.getItems().add("FG color=" +Platform.getPreferences().getForegroundColor());
        preferenceList.getItems().add("---");
        Platform.getPreferences().forEach((s, o) -> preferenceList.getItems().add(s+ "="+ o.toString()));
    }
}