/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.MessageFormat;
import java.util.ArrayList;
//import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

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
public class GestionCentreController implements Initializable {

    /**
     * Initializes the controller class.
     *
     */
    @FXML
    private JFXButton supprimebouton;

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
    private JFXTextField nom_chercher;
    @FXML
    private JFXTextField image_centre;

    @FXML
    private JFXButton ajouter_centre;
    private FileChooser image;
    private ExtensionFilter filtre;
    public static String path;
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;
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
    private TableColumn<Centre, String> col_imagecentre;
    //List<Centre> arr = new ArrayList<>();
    public ObservableList<Centre> list = FXCollections.observableArrayList();

    @FXML
    void ajouterCentreAction(ActionEvent event) throws SQLException {
        ServiceCentre ser = new ServiceCentre();

        Centre C = new Centre();
        C.setNom_centre(nom_centre.getText());
        C.setAdresse_centre(adresse_centre.getText());
        C.setMail_centre(mail_centre.getText());
        C.setDas_centre(das_centre.getText());
        C.setTelephone_centre(Integer.parseInt(numero_centre.getText()));
        C.setImage_centre(image_centre.getText());
      /*   if(nom_centre.getText().equals("") || adresse_centre.getText().equals("") || das_centre.getText().equals("") || mail_centre.getText().equals("")  || image_centre.getText().equals("") ) {
                           JOptionPane.showMessageDialog(null, "Veuillez saisier les champs vides");

         }
     */
       if (JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter ce centre?", "Confirmer votre ajout", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            try {
         if (ser.searchSelonNom(C).size()!=0)
         {
              JOptionPane.showMessageDialog(null, "Centre existant");
         }
         else if(nom_centre.getText().length()==0)
         {
            JOptionPane.showMessageDialog(null, "Veuillez saisir le nom de votre centre");
 
         }
           else if(adresse_centre.getText().length()==0)
         {
            JOptionPane.showMessageDialog(null, "Veuillez saisir l'adresse de votre centre");
 
         }
         else if (ser.verifieCentre(mail_centre.getText())!=2  )
         { JOptionPane.showMessageDialog(null, "Veuillez saisir une adresse mail sous cette forme ex: nom@gmail.com");

         }
         else if (numero_centre.getText().length()!=8)
         {              JOptionPane.showMessageDialog(null, "Veuillez saisir un numéro ");

             
         }
           else if (image_centre.getText().length()==0)
         {              JOptionPane.showMessageDialog(null, "Veuillez une image ");

             
         }
         else
         {     
                System.out.println(C);
                ser.ajouter(C);
                JOptionPane.showMessageDialog(null, "Centre ajouté");
           nom_centre.setText("");
        adresse_centre.setText("");
        mail_centre.setText("");
        das_centre.setText("");
       numero_centre.setText("");
       image_centre.setText("");
         }
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Centre non ajouté");
            }
        }
        list.clear();
        list.addAll(ser.readAllCentreImage());
       
       

    }

    public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());
    }

    public JFXTextField getTnom1() {
        return tnom1;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        col_idcentre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
        col_nomcentre.setCellValueFactory(new PropertyValueFactory<>("nom_centre"));
        col_adressecentre.setCellValueFactory(new PropertyValueFactory<>("adresse_centre"));
        col_dascentre.setCellValueFactory(new PropertyValueFactory<>("das_centre"));
        col_mailcentre.setCellValueFactory(new PropertyValueFactory<>("mail_centre"));
        col_telephonecentre.setCellValueFactory(new PropertyValueFactory<>("telephone_centre"));
      //  col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("image_centre"));
        col_imagecentre.setPrefWidth(80);
        col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("photo_centre"));

        try {
            ServiceCentre ser = new ServiceCentre();
            list = ser.readAllCentreImage();

        } catch (SQLException ex) {
            Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setItems((ObservableList<Centre>) list);
        table.setEditable(true);
        col_nomcentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_dascentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_adressecentre.setCellFactory(TextFieldTableCell.forTableColumn());
        col_mailcentre.setCellFactory(TextFieldTableCell.forTableColumn());
        //col_telephonecentre.setCellFactory(TextFieldTableCell.forTableColumn());
      
               
      
       
    }

    @FXML
    void ajouterImageCentre(MouseEvent event) {

        String path1 = filen();

        if (path1 == null) {

        } else {
           String path2 = path1.substring(56, path1.length());
            image_centre.setText(path2);
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
    void imprimerListeCentre(MouseEvent event) {
        System.out.println(" can I print?");
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.printPage(table)) {
            printerJob.endJob();
            System.out.println("printed");
        }

    }

    @FXML
    public void modifierNomCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setNom_centre(editcell.getNewValue().toString());
        System.out.println(centreselectionne);
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    public void modifierAdresseCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setAdresse_centre(editcell.getNewValue().toString());
        System.out.println(centreselectionne.getAdresse_centre());
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    public void modifierDasCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setDas_centre(editcell.getNewValue().toString());
        System.out.println(centreselectionne.getDas_centre());
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    public void modifierMailCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setMail_centre(editcell.getNewValue().toString());
        System.out.println(centreselectionne.getMail_centre());
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    public void modifierTelephoneCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setTelephone_centre(Integer.parseInt(editcell.getNewValue().toString()));
        System.out.println(centreselectionne.getTelephone_centre());
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    public void modifierImageCentre(MouseEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();

        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        String path1 = filen();
        if (path1 == null) {

        } else {
            image_centre.setText(path1);
        }
        String path2 = path1.substring(56, path1.length());
        System.out.println(path2);
//Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setImage_centre(path2);
        ser.updateSelonId(centreselectionne);

       // System.out.println(centreselectionne.getAdresse_centre());
        //ser.updateSelonId(centreselectionne);
        list.clear();
        list.addAll(ser.readAllCentreImage());

    }

    @FXML
    void supprimerCentre(ActionEvent event) throws SQLException, IOException {

        if (event.getSource() == supprimebouton) {

            if (JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer un centre, êtes  vous sur?", "Confirmer ta suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                ServiceCentre ser = new ServiceCentre();
                Centre c = table.getSelectionModel().getSelectedItem();
                ser.deleteSelonNomCentre(c);
                list.clear();
                list.addAll(ser.readAllCentreImage());
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionner le centre à supprimer");
            }

        }
    }

    @FXML
    void rechercherCentreAction(ActionEvent event) throws SQLException {

        Centre C = new Centre();
        C.setNom_centre(nom_chercher.getText());
        System.out.println(C);
        ServiceCentre ser = new ServiceCentre();
        if (!(ser.searchSelonNom(C).isEmpty())) {
            list.clear();
            list.addAll(ser.searchSelonNom(C));
        } else if (ser.searchSelonNom(C).isEmpty()) {
            System.out.println("vide");
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner le nom du centre à chercher");
            list = ser.readAllCentreImage();
            table.setItems((ObservableList<Centre>) list);
        }
 //       System.out.println(ser.searchSelonNom(C));

    }
    private void applyValidators() {
        ValidationSupport vs = new ValidationSupport();
        vs.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vs.registerValidator(nom_centre, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));
        ValidationSupport vtel1 = new ValidationSupport();

        vtel1.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vtel1.registerValidator(adresse_centre, Validator.createRegexValidator("Il faut un nombre ", "^\\d+$", Severity.ERROR));

        ValidationSupport vdateD = new ValidationSupport();
        vdateD.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vdateD.registerValidator(das_centre, Validator.createEmptyValidator("Il faut un nombre " , Severity.ERROR));

        ValidationSupport vdateF = new ValidationSupport();
        vdateF.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vdateF.registerValidator(numero_centre, Validator.createEmptyValidator("Il faut un nombre ", Severity.ERROR));
       
        
        ValidationSupport vlieu = new ValidationSupport();
        vlieu.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vlieu.registerValidator(mail_centre, Validator.createRegexValidator("Il faut un nombre ", "\\S*+", Severity.ERROR));
        
         ValidationSupport vs1 = new ValidationSupport();
        vs1.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
        vs1.registerValidator(image_centre, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));
         ValidationSupport vs3 = new ValidationSupport();
       // vs3.setErrorDecorationEnabled(true); // we don't want errors to bother us for now.
       // vs3.registerValidator(tImage, Validator.createEmptyValidator("Cannot Be Empty!", Severity.ERROR));

    }
    
    private boolean checkValidInputs() {
        if (nom_centre.getText().isEmpty() || adresse_centre.getText().isEmpty() || !numero_centre.getText().matches("^\\d+$")
                || mail_centre.getText().isEmpty() || !image_centre.getText().matches("\\S")
               ) {
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void StatistiqueAction(ActionEvent event) throws Exception {
        StatistiqueVuCentre stat=new StatistiqueVuCentre();
      Stage primaryStage=new Stage();
        stat.start(primaryStage);
      stat.init( primaryStage);
     
    }

}
