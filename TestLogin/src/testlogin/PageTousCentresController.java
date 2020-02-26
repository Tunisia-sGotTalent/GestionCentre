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
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PageTousCentresController implements Initializable {

    @FXML
    private JFXTextField tnom1;
    @FXML
    private TableView<Centre> table;

    @FXML
    private TableColumn<Centre, String> col_nomcentre;

    @FXML
    private TableColumn<Centre, String> col_adressecentre;

    @FXML
    private TableColumn<Centre, String> col_dascentre;

    @FXML
    private TableColumn<Centre, String> col_mailcentre;

    @FXML
    private TableColumn<Centre, Integer> col_telephonecentre;

    @FXML
    private TableColumn<Centre, String> col_imagecentre;
   // @FXML
    @FXML
    private TableColumn<Centre, Label> col_notecentre;
    //List<Centre> arr = new ArrayList<>();
    public ObservableList<Centre> list = FXCollections.observableArrayList();

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
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
        col_imagecentre.setPrefWidth(80);
        col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("photo_centre"));
       col_notecentre.setCellValueFactory(new PropertyValueFactory<>("note_centre"));
        try {
            ServiceCentre ser = new ServiceCentre();
            list = ser.readAllCentreImage();

        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems((ObservableList<Centre>) list);

    }

}
