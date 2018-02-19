package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button profileButton;
    @FXML
    private Button reservationsButton;
    @FXML
    private Button bookFacilityButton;
    @FXML
    private Button myReservationsButton;

    @FXML
    private AnchorPane injectablePane;

    @FXML
    private void loadProfileView() throws IOException{

        AnchorPane profileView = FXMLLoader.load(getClass().getResource("../view/profile_view.fxml"));
        injectablePane.getChildren().setAll(profileView);
    }

    @FXML
    private void loadReservationsView() throws IOException{

        AnchorPane reservationView = FXMLLoader.load(getClass().getResource("../view/reservations_view.fxml"));
        injectablePane.getChildren().setAll(reservationView);
    }

    @FXML
    private void loadBookReservationView() throws IOException{

        AnchorPane bookReservationView = FXMLLoader.load(getClass().getResource("../view/bookfacility_view.fxml"));
        injectablePane.getChildren().setAll(bookReservationView);
    }

    @FXML
    private void loadUserReservationsView() throws IOException{

        AnchorPane userReservationsView = FXMLLoader.load(getClass().getResource("../view/myreservations_view.fxml"));
        injectablePane.getChildren().setAll(userReservationsView);
    }
}
