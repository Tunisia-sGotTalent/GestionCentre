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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
          //col_idcentre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
    //    col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("image_centre"));
 col_imagecentre.setPrefWidth(80);
       col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("photo_centre") );
  //     List<ImageView>  listem = new ArrayList()<>;
   
     try {
            ServiceCentre ser = new ServiceCentre();
           list = ser.readAllCentreImage();
           
     //   listem.
 //ImageView em2=new ImageView(new Image(this.getClass().getResourceAsStream(list.get(1).getImage_centre())));
// ImageView em0=new ImageView(new Image(this.getClass().getResourceAsStream(list.get(2).getImage_centre())));
//if() 
 //   ImageView em3=new ImageView(new Image(this.getClass().getResourceAsStream(list.get(3).getImage_centre())));
 //ImageView em1=new ImageView(new Image(this.getClass().getResourceAsStream(list.get(4).getImage_centre())));

         //Centre c=new Centre(em,"hane","hh","hh","hh",777);
         
        //list.add(c);
          // System.out.println(c);

        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
       table.setItems((ObservableList<Centre>)list);

        //table.setItems((ObservableList<Centre>)list);
        /*table.setEditable(true);
        col_nomcentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_dascentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_mailcentre.setCellFactory(TextFieldTableCell.forTableColumn());
        //col_telephonecentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_imagecentre.setCellFactory(TextFieldTableCell.forTableColumn());
*/
       
    }    

   
    
}
