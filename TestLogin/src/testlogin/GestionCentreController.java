/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionCentreController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private JFXTextField tnom1;
  @FXML
    private TableView<Centre> Table_Centre;
     private TableColumn<Centre, String> col_nom;

    @FXML
    private TableColumn<Centre, String> col_adresse;

    @FXML
    private TableColumn<Centre, String> col_domaine;

    @FXML
    private TableColumn<Centre, String>col_mail;

    @FXML
    private TableColumn<Centre, Integer> col_numero;

    @FXML
    private TableColumn<Centre, String> col_image;
    
     public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());    }

    public JFXTextField getTnom1() {
        return tnom1;
    }
      @FXML
    void connexionAction(ActionEvent event) {

    }

    @FXML
    void gestionCentreAction(ActionEvent event) {

    }

    @FXML
   
    void retour(MouseEvent event) {
        
          try {
            //   try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PagaAccueilAdministrateur.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
            PagaAccueilAdministrateurController apc=fxmlLoader.getController();
           apc.setTnom1((JFXTextField)tnom1);
           
           tnom1.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
          //  stage.show();
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connexionAction(MouseEvent event) {
    }


 
  
    
}
