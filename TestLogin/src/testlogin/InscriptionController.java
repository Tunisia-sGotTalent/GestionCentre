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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 21695
 */

public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField tnom2;
    
  public void setTnom2(JFXTextField tnom1) {
        this.tnom2.setText(tnom1.getText());    }

    public JFXTextField getTnom2() {
        return tnom2;
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
            FXMLDocumentController apc=fxmlLoader.getController();
           apc.setTnom((JFXTextField)tnom2);
           
           tnom2.getScene().setRoot(root);
           // stage.setTitle("hello");
            //       stage.setScene(new Scene(root));
          //  stage.show();
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
        
        
    }
    
}
