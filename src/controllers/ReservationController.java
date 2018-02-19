package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {

    @FXML
    private VBox reservationVbox;


    @Override
    public void initialize(URL url, ResourceBundle rb){

        try{
            addItemsToVbox();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void addItemsToVbox()throws IOException{

        Node reservationNode = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode2 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode3 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode4 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode5 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode6 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode7 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode8 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode9 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode10 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode11 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        Node reservationNode12 = FXMLLoader.load(getClass().getResource("/view/reservation.fxml"));
        reservationVbox.getChildren().addAll(reservationNode,reservationNode2, reservationNode3, reservationNode4, reservationNode5,
                reservationNode6, reservationNode7, reservationNode8, reservationNode9, reservationNode10, reservationNode11, reservationNode12);

    }




}
