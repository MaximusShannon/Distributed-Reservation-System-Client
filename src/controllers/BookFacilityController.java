package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BookFacilityController implements Initializable {

    @FXML
    private ChoiceBox facilityPicker;

    @FXML
    private ChoiceBox timePicker;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Text unavailableText;

    @Override
    public void initialize(URL url, ResourceBundle rb){

        facilityPicker.setItems(FXCollections.observableArrayList("Tennis Courts", "Pool Time", "Spa Time"));
        facilityPicker.getSelectionModel().selectFirst();

        timePicker.setItems(FXCollections.observableArrayList("9AM", "10AM", "11AM", "12MM", "1PM",
                "2PM", "3PM", "4PM", "5PM"));
        timePicker.getSelectionModel().selectFirst();

        unavailableText.setVisible(false);

    }
}
