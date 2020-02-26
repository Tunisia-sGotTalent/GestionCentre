/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;

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
        public ObservableList<String> list1 = FXCollections.observableArrayList("Musique","Cinema","Theatre","Tous types");

    @FXML
    private JFXComboBox<String> chercher_centre;

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
        chercher_centre.setItems(list1);
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
        col_imagecentre.setPrefWidth(80);
        col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("photo_centre"));
        
      
        try {
            ServiceCentre ser = new ServiceCentre();
            list = ser.readAllCentreImageNote();

        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems((ObservableList<Centre>) list);
           table.setEditable(true);
     /*        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setVu_centre(centreselectionne.getVu_centre()+1);
        System.out.println(centreselectionne.getVu_centre());
        try {
            ser.updateSelonVu(centreselectionne);
        } catch (SQLException ex) {
            Logger.getLogger(PageTousCentresController.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
  
    }

    @FXML
    private void noterCentreAction(MouseEvent editcell) throws SQLException {
       ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
       if(table.getSelectionModel().isEmpty())
{
              JOptionPane.showMessageDialog(null, "Veuillez sélectionner le centre à recommander");
 
}
     else if (JOptionPane.showConfirmDialog(null, "Voulez-vous recommander ce centre?", "Confirmer votre recommandation", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            
      
        centreselectionne.setVu_centre(centreselectionne.getVu_centre()+1);
        System.out.println(centreselectionne.getVu_centre());
        ser.updateSelonVu(centreselectionne);
       JOptionPane.showMessageDialog(null, "Centre recommandé");
      
     }
    }

    @FXML
    private void chercherCentreAction(MouseEvent event) throws SQLException {
           ServiceCentre ser = new ServiceCentre();
        if (!(ser.searchSelonType(chercher_centre.getValue()).isEmpty()))
        {list.clear();
            list.addAll(ser.searchSelonType(chercher_centre.getValue()));
    
            
        }
           
    else if (ser.searchSelonType(chercher_centre.getValue()).isEmpty()) {
            list = ser.readAllCentreImageNote();
        table.setItems((ObservableList<Centre>) list);
        //    table.setItems((ObservableList<Centre>) list);
        }


   
   

 

}
}