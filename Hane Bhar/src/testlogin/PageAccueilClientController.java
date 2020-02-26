/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import com.tgt.Entite.Contenu;
import com.tgt.Service.ServiceCentre;
import com.tgt.Service.ServiceContenu;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PageAccueilClientController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    private MediaPlayer mediaPlayer1;
    private Media media1;
    private MediaPlayer mediaPlayer6;
    private Media media6;
    private MediaPlayer mediaPlayer2;
    private Media media2;
    private MediaPlayer mediaPlayer3;
    private Media media3;
    private MediaPlayer mediaPlayer4;
    private Media media4;
    private MediaPlayer mediaPlayer5;
    private Media media5;

    @FXML
    private MediaView mediaView1;

    @FXML
    private MediaView mediaView2;

    @FXML
    private MediaView mediaView3;

    @FXML
    private MediaView mediaView4;

    @FXML
    private MediaView mediaView5;
    @FXML
    private MediaView mediaView6;
    @FXML
    private ImageView image;

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Contenu C = new Contenu();
        
        ServiceContenu ser = new ServiceContenu();
        List<Media> listmedia = new ArrayList<>();
        listmedia.add(media1);
        try {
            List<Contenu> list = ser.retournerContenu();
            String lien = list.get(0).getUrlVideo_Contenu();
            String path = new File(lien).getAbsolutePath();
            media1 = new Media(new File(path).toURI().toString());
            mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.setVolume(0);
            mediaView1.setMediaPlayer(mediaPlayer1);
            mediaPlayer1.setAutoPlay(true);
            String lien1 = list.get(1).getUrlVideo_Contenu();
            String path1 = new File(lien1).getAbsolutePath();
            media2 = new Media(new File(path1).toURI().toString());
            mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setVolume(0);
            mediaView2.setMediaPlayer(mediaPlayer2);
            mediaPlayer2.setAutoPlay(true);
            String lien3 = list.get(2).getUrlVideo_Contenu();
            String path3 = new File(lien3).getAbsolutePath();
            media3 = new Media(new File(path3).toURI().toString());
            mediaPlayer3 = new MediaPlayer(media3);
            mediaPlayer3.setVolume(0);
            mediaView3.setMediaPlayer(mediaPlayer3);
            mediaPlayer3.setAutoPlay(true);
            String lien4 = list.get(3).getUrlVideo_Contenu();
            String path4 = new File(lien4).getAbsolutePath();
            media4 = new Media(new File(path4).toURI().toString());
            mediaPlayer4 = new MediaPlayer(media4);
            mediaView4.setMediaPlayer(mediaPlayer4);
            mediaPlayer4.setVolume(0);
            mediaPlayer4.setAutoPlay(true);
            String lien5 = list.get(4).getUrlVideo_Contenu();
            String path5 = new File(lien5).getAbsolutePath();
            media5 = new Media(new File(path5).toURI().toString());
            mediaPlayer5 = new MediaPlayer(media5);
            mediaPlayer5.setVolume(0);
            mediaView5.setMediaPlayer(mediaPlayer5);
            mediaPlayer5.setAutoPlay(true);
            String lien6 = list.get(5).getUrlVideo_Contenu();
            String path6 = new File(lien6).getAbsolutePath();
            media6 = new Media(new File(path6).toURI().toString());
            mediaPlayer6 = new MediaPlayer(media6);
            mediaPlayer6.setVolume(0);
            mediaView6.setMediaPlayer(mediaPlayer6);
            mediaPlayer6.setAutoPlay(true);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void retour(MouseEvent event) {
        try {
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            FXMLDocumentController apc = fxmlLoader.getController();
            apc.setTnom((JFXTextField) tnom1);
            tnom1.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

    @FXML
    void afficherCentre(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RubriqueCentre.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            RubriqueCentreController apc = fxmlLoader.getController();
            apc.setTnom1((JFXTextField) tnom1);
            tnom1.getScene().setRoot(root);
          
        } catch (IOException e) {
            System.out.println("can't load new window");
        }

    }

}
