/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.tgt.Entite.Centre;
import com.tgt.Service.ServiceCentre;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.MessageFormat;
import java.util.ArrayList;
//import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/*
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import org.controlsfx.control.cell.MediaImageCell;
*/
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionCentreController implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {

    /**
     * Initializes the controller class.
     * 
     */

    @FXML
    private JFXTextField tnom1;
    
    @FXML
    private JFXTextField nom_centre;

    @FXML
    private JFXTextField adresse_centre;

    @FXML
    private JFXTextField das_centre;

    @FXML
    private JFXTextField mail_centre;

    @FXML
    private JFXTextField numero_centre;

    @FXML
    private JFXTextField image_centre;

    @FXML
    private JFXTextField adresseto;

    @FXML        
    private JFXButton ajouter_centre;
    private FileChooser image;
    private ExtensionFilter filtre;
    public static String path;
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;
    @FXML
    private GoogleMapView mapView;
    protected StringProperty from = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();
//ServiceCentre ser=new ServiceCentre();
       @FXML
    private TableView<Centre> table;

    @FXML
    private TableColumn<Centre,Integer> col_idcentre;

    @FXML
    private TableColumn<Centre,String> col_nomcentre;

    @FXML
    private TableColumn<Centre,String> col_adressecentre;

    @FXML
    private TableColumn<Centre,String> col_dascentre;

    @FXML
    private TableColumn<Centre,String> col_mailcentre;

    @FXML
    private TableColumn<Centre,Integer> col_telephonecentre;

    @FXML
    private TableColumn<Centre,String> col_imagecentre;
        //List<Centre> arr = new ArrayList<>();
       public ObservableList<Centre> list=FXCollections.observableArrayList();

    

    @FXML
    void ajouterCentreAction(ActionEvent event) {/*
        ServiceCentre ser=new ServiceCentre();

        Centre C = new Centre();
        C.setNom_Centre(nom_centre.getText()); 
    C.setAdresse_Centre(adresse_centre.getText());
       
         C.setContacte_Centre(mail_centre.getText());
        C.setDas_Centre(das_centre.getText());

        C.setNumero_Centre(Integer.parseInt(numero_centre.getText()));
        C.setImage_Centre(image_centre.getText());
   
         
       
     try {
//    
        System.out.println(C);
       // System.out.println(ser.verifieCentre(mail_centre.getText()));
       
              
            ser.ajouter(C);
            List<Centre> list = ser.readAll();
            System.out.println(list);
         
     }catch (SQLException ex) {
            System.out.println(ex);
             
          JOptionPane.showMessageDialog(null, "Veuillez saisir une adresse mail sous cette forme ex nom@gmail.com");
      } 
        */
    }

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }
    
    
    /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        Admin a= new Admin();    
       // ServiceAdmin ser = new ServiceAdmin();
        tfid.setCellValueFactory(new PropertyValueFactory<>("id_admin"));
        tfprenom.setCellValueFactory(new PropertyValueFactory<>("prenom_admin"));
        tfnom.setCellValueFactory(new PropertyValueFactory<>("nom_admin"));
        tfadresse.setCellValueFactory(new PropertyValueFactory<>("adresse_admin"));
        tfactivite.setCellValueFactory(new PropertyValueFactory<>("activite_admin"));
        tfemail.setCellValueFactory(new PropertyValueFactory<>("email_admin"));
        tfdatedenaissance.setCellValueFactory(new PropertyValueFactory<>("datedenaissance_admin"));
        tfmdp.setCellValueFactory(new PropertyValueFactory<>("mdp_admin"));
        tftelephone.setCellValueFactory(new PropertyValueFactory<>("telephone_admin"));
        tfimage.setCellValueFactory(new PropertyValueFactory<>("image_admin"));
        tfvideo.setCellValueFactory(new PropertyValueFactory<>("video_admin"));
       
    try {     
        ServiceAdmin ser = new ServiceAdmin();
        arr = ser.Afficher_Admin(a);
    } catch (SQLException ex) {
        Logger.getLogger(GestionUtilisateursController.class.getName()).log(Level.SEVERE, null, ex);
    }
    table.setItems((ObservableList<Admin>) arr);

      }
    }
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // ServiceCentre ser=new ServiceCentre();
Centre C=new Centre();
        col_idcentre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
        col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("image_centre"));

          try {
                ServiceCentre ser=new ServiceCentre();
            list=ser.readAllCentreAffichage();
          //  table.setItems((ObservableList<Centre>) list);
           // System.out.println(list);
        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        table.setItems((ObservableList<Centre>) list);
                   

        // mapView.addMapInializedListener(this);
      /*  mapView.addMapInializedListener(null);
        to.bindBidirectional(adresse_centre.textProperty());
        from.bindBidirectional(adresseto.textProperty());
*/
      
        table.setEditable(true);
        col_nomcentre.setCellFactory(TextFieldTableCell.forTableColumn());
 col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
  col_dascentre.setCellFactory(TextFieldTableCell.forTableColumn());
 col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
 col_mailcentre.setCellFactory(TextFieldTableCell.forTableColumn());
  //col_telephonecentre.setCellFactory(TextFieldTableCell.forTableColumn());
 col_imagecentre.setCellFactory(TextFieldTableCell.forTableColumn());


 
    }

   

   
    @FXML
    void ajouterImageCentre(MouseEvent event) {

        String path1 = filen();
        if (path1 == null) {

        } else {
            image_centre.setText(path1);
        }

    }

    private String filen() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = null;
            filename = f.getAbsolutePath();
            path = (filename);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez mettre une image");
        }
        return path;
    }

   
@FXML
    private void toTextFieldAction(ActionEvent event) {
    /*    DirectionsRequest request = new DirectionsRequest(from.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));*/
    }

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }

  /*  @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
        to.bindBidirectional(adresse_centre.textProperty());
        from.bindBidirectional(adresseto.textProperty());
    }
*/
    @Override
    @FXML
    public void mapInitialized() {
  /*      MapOptions options = new MapOptions();

        options.center(new LatLong(47.606189, -122.335842))
                .zoomControl(true)
                .zoom(12)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);
        directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();*/
    }
    
    @FXML
    void imprimerListeCentre(MouseEvent event) {
    System.out.println(" can I print?");
               PrinterJob printerJob = PrinterJob.createPrinterJob();
               if (printerJob.printPage(table))
               {
                   printerJob.endJob();
                   System.out.println("printed");
               }
     
           }
    @FXML
    public void modifierNomCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setNom_centre(editcell.getNewValue().toString());
System.out.println(centreselectionne);
  ser.updateSelonId(centreselectionne);
   
}
    @FXML
    public void modifierAdresseCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setAdresse_centre(editcell.getNewValue().toString());
System.out.println(centreselectionne.getAdresse_centre());
  ser.updateSelonId(centreselectionne);
   
}

    @FXML
    public void modifierDasCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setDas_centre(editcell.getNewValue().toString());
System.out.println(centreselectionne.getDas_centre());
  ser.updateSelonId(centreselectionne);
   
}

    @FXML
    public void modifierMailCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setMail_centre(editcell.getNewValue().toString());
System.out.println(centreselectionne.getMail_centre());
  ser.updateSelonId(centreselectionne);
   
}

    @FXML
    public void modifierTelephoneCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setTelephone_centre(Integer.parseInt(editcell.getNewValue().toString()));
System.out.println(centreselectionne.getTelephone_centre());
  ser.updateSelonId(centreselectionne);
   
}


    @FXML
  public void modifierImageCentre(CellEditEvent editcell) throws SQLException
{ ServiceCentre ser=new ServiceCentre();
    Centre centreselectionne=table.getSelectionModel().getSelectedItem();
centreselectionne.setImage_centre(editcell.getNewValue().toString());
System.out.println(centreselectionne.getAdresse_centre());
  ser.updateSelonId(centreselectionne);
   
}
 @FXML
    void supprimerCentre(ActionEvent event) throws SQLException {
     Centre c= table.getSelectionModel().getSelectedItem();
    ServiceCentre ser=new ServiceCentre();
        ser.deleteSelonNomCentre(c);
        list.clear();
        list.addAll(ser.readAll());
      
    }
    }
   


