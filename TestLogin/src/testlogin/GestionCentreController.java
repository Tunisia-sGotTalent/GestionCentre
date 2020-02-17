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

        if (JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter ce centre?", "Confirmer votre ajout", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            try {

                System.out.println(C);
                ser.ajouter(C);
                List<Centre> list = ser.readAll();
                System.out.println(list);

            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Veuillez saisir une adresse mail sous cette forme ex nom@gmail.com");
            }
        }
        list.addAll(ser.readAll());

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
        col_imagecentre.setCellValueFactory(new PropertyValueFactory<>("image_centre"));

        try {
            ServiceCentre ser = new ServiceCentre();
            list = ser.readAllCentreAffichage();

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
    public void modifierImageCentre(CellEditEvent editcell) throws SQLException {
        ServiceCentre ser = new ServiceCentre();
        Centre centreselectionne = table.getSelectionModel().getSelectedItem();
        centreselectionne.setImage_centre(editcell.getNewValue().toString());
        System.out.println(centreselectionne.getAdresse_centre());
        ser.updateSelonId(centreselectionne);

    }

    @FXML
    void supprimerCentre(ActionEvent event) throws SQLException, IOException {

        if (event.getSource() == supprimebouton) {

            if (JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer un centre, êtes  vous sur?", "Confirmer ta suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                ServiceCentre ser = new ServiceCentre();
                Centre c = table.getSelectionModel().getSelectedItem();
                ser.deleteSelonNomCentre(c);
                list.clear();
                list.addAll(ser.readAll());
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
            list = ser.readAllCentreAffichage();
            table.setItems((ObservableList<Centre>) list);
        }
        System.out.println(ser.searchSelonNom(C));

    }

}
