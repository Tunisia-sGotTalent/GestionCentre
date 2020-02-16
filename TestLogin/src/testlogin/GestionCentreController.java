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
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.TravelModes;
import com.tgt.Entite.Centre;
import com.tgt.Service.ServiceCentre;
import java.io.File;
//import java.io.IOException;
import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
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
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.print.PrinterJob;
//import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import org.controlsfx.control.cell.MediaImageCell;

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
     public ObservableList<Centre> list=FXCollections.observableArrayList();

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
    private TableColumn<Centre, Integer> col_idcentre;

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
    private TableColumn<Centre, String> cil_imagecentre;
  List<Centre> arr = new ArrayList<>();
    

    @FXML
    void ajouterCentreAction(ActionEvent event) {
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
        
    }

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCentre ser=new ServiceCentre();
Centre C=new Centre();
        col_idcentre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
        cil_imagecentre.setCellValueFactory(new PropertyValueFactory<>("image_centre"));

          try {
           
            list=ser.readAllCentreAffichage(C);
                      table.setItems((ObservableList) list);
            System.out.println(list);
        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
        // mapView.addMapInializedListener(this);
      /*  mapView.addMapInializedListener(null);
        to.bindBidirectional(adresse_centre.textProperty());
        from.bindBidirectional(adresseto.textProperty());
*/
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
        DirectionsRequest request = new DirectionsRequest(from.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
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
        MapOptions options = new MapOptions();

        options.center(new LatLong(47.606189, -122.335842))
                .zoomControl(true)
                .zoom(12)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);
        directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();
    }
    
    @FXML
    void imprimerListeCentre(MouseEvent event) {
   /* System.out.println(" can I print?");
               PrinterJob printerJob = PrinterJob.createPrinterJob();
               if (printerJob.printPage(table_centre))
               {
                   printerJob.endJob();
                   System.out.println("printed");
               }
     */
           }

   
}

