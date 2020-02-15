/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testlogin;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RubriqueEvenementController implements Initializable {
    @FXML
    private JFXTextField tnom1;
    @FXML
    private ImageView image;
    @FXML
    private MenuItem evenement;
    @FXML
    private MenuItem challenge;
    @FXML
    private MenuItem formation;
    
   public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retour(MouseEvent event) {
    
           try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PageAccueilClient.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
            PageAccueilClientController apc=fxmlLoader.getController();
           apc.setTnom1((JFXTextField)tnom1);
           
           tnom1.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
          //  stage.show();
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
        
        
    }

    @FXML
    private void afficherEvenement(ActionEvent event) {
         try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RubriqueEvenement.fxml"));

            Parent root = (Parent) fxmlLoader.load();
         RubriqueEvenementController apc = fxmlLoader.getController();
            apc.setTnom1((JFXTextField) tnom1);

            tnom1.getScene().setRoot(root);
            // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
            //  stage.show();
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

    

    @FXML
    private void afficherChallenge(ActionEvent event) {
    }

    @FXML
    private void afficherFormation(ActionEvent event) {
    }
    
}
