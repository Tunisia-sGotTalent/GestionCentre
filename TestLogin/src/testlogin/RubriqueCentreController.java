/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import com.tgt.Service.ServiceCentre;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RubriqueCentreController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    @FXML
    private ImageView image_centre;
    @FXML
    private ImageView image1_centre;
    @FXML
    private ImageView image2_centre;
    @FXML
    private Label nom_centre1;
    @FXML
    private Label adresse_centre1;
    @FXML
    private Label domaine_centre1;

    @FXML
    private Label mail_centre1;

    @FXML
    private Label telephone_centre1;
    @FXML
    private Label nom_centre2;

    @FXML
    private Label adresse_centre2;

    @FXML
    private Label domaine_centre2;

    @FXML
    private Label mail_centre2;
    @FXML
    private Label nom_centre3;

    @FXML
    private Label adresse_centre3;

    @FXML
    private Label domaine_centre3;

    @FXML
    private Label mail_centre3;

    @FXML
    private Label telephone_centre2;

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    /**
     * Initializes the controller class.
     */
    private Image image;
    private Image image1;
    private Image image2;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCentre ser = new ServiceCentre();
        try {
            List<Centre> list = (List) ser.readAllCentreAffichage();
            System.out.println(list);
            System.out.println(list.get(1).getImage_centre());
            System.out.println(list.get(2).getImage_centre());
            System.out.println(list.get(0).getImage_centre());
            String lien1 = list.get(0).getImage_centre();
            String lien2 = list.get(1).getImage_centre();
            String lien3 = list.get(2).getImage_centre();
            image = new Image(lien1);
            image1 = new Image(lien2);
            image2 = new Image(lien3);
            image1_centre.setImage(image1);
            image2_centre.setImage(image2);
            image_centre.setImage(image);
            nom_centre1.setText(list.get(0).getNom_centre());
            adresse_centre1.setText(list.get(0).getAdresse_centre());
            domaine_centre1.setText(list.get(0).getDas_centre());
            mail_centre1.setText(list.get(0).getMail_centre());
            nom_centre2.setText(list.get(1).getNom_centre());
            adresse_centre2.setText(list.get(1).getAdresse_centre());
            domaine_centre2.setText(list.get(1).getDas_centre());
            mail_centre2.setText(list.get(1).getMail_centre());
            nom_centre3.setText(list.get(2).getNom_centre());
            adresse_centre3.setText(list.get(2).getAdresse_centre());
            domaine_centre3.setText(list.get(2).getDas_centre());
            mail_centre3.setText(list.get(2).getMail_centre());

        } catch (SQLException ex) {
            Logger.getLogger(RubriqueCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void retour(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PageAccueilClient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PageAccueilClientController apc = fxmlLoader.getController();
            apc.setTnom1((JFXTextField) tnom1);
            tnom1.getScene().setRoot(root);
           
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

}
