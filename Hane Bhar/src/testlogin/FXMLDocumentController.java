/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.tgt.Service.ServiceCentre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author 21695
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private JFXButton connexion;
    @FXML
    private JFXTextField tnom;
    @FXML
    private JFXButton inscri;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void connexion(ActionEvent event) {
        try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connexion.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            ConnexionController apc = fxmlLoader.getController();
            apc.setTnom1((JFXTextField) tnom);
            tnom.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

    public void setTnom(JFXTextField tnom) {
        this.tnom.setText(tnom.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML

    private void inscri(ActionEvent event) {
        try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("inscription.fxml"));

            Parent root = (Parent) fxmlLoader.load();
            InscriptionController apc = fxmlLoader.getController();
            apc.setTnom2((JFXTextField) tnom);
            tnom.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

}
