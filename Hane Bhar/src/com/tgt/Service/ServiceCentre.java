/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.tgt.Entite.Centre;
import com.tgt.IService.IServiceCentre;
import com.tgt.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class ServiceCentre implements IServiceCentre<Centre> {

    private final Connection con;
    private Statement ste;

    public ServiceCentre() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Centre t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `centre`(`id_centre`, `nom_centre`, `adresse_centre`, `das_centre`, `mail_centre`, `telephone_centre`,`image_centre`)"
                + " VALUES (NULL,'" + t.getNom_centre() + "', '" + t.getAdresse_centre() + "', '" + t.getDas_centre() + "', '" + t.getMail_centre() + "', '" + t.getTelephone_centre() + "','" + t.getImage_centre() + "');";
        int res = ste.executeUpdate(requeteInsert);
        System.out.println(res);
    }

  
    @Override
    public void deleteSelonNomCentre(Centre t) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM centre WHERE nom_centre = ? ;";
        PreparedStatement pst = con.prepareStatement(requeteDelete);
        pst.setString(1, t.getNom_centre());
        pst.executeUpdate();
       
    }

    @Override
    public void updateSelonId(Centre t) throws SQLException {
        ste = con.createStatement();
        System.out.println(t.getImage_centre());
        String requeteUpdate = "Update `centre` SET `nom_centre` ='" + t.getNom_centre() + "', `adresse_centre` ='" + t.getAdresse_centre() + "', `das_centre` ='" + t.getDas_centre() + "',`mail_centre` ='" + t.getTelephone_centre() + "' ,`image_centre`='" + t.getImage_centre() + "' WHERE id_centre ='" + t.getId_centre() + "' ;";
        ste.executeUpdate(requeteUpdate);

    }
 @Override
    public void updateSelonVu(Centre t) throws SQLException {
        ste = con.createStatement();
        System.out.print(t.getVu_centre());
        String requeteUpdate = "Update `centre` SET `vu_centre` ='" + t.getVu_centre()+ "' WHERE id_centre ='" + t.getId_centre() + "' ;";
        ste.executeUpdate(requeteUpdate);
       System.out.print(t.getVu_centre());


    }

    @Override
    public List<Centre> searchSelonNom(Centre t) throws SQLException {
        ste = con.createStatement();
        List<Centre> arr = new ArrayList<>();
        String requeteSearch = "Select * from `centre` WHERE nom_centre='" + t.getNom_centre() + "';";
        ResultSet rs = ste.executeQuery(requeteSearch);
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");

            String image = rs.getString("image_centre");
            if (!image.isEmpty()) {
                String ch1 = image.substring(0, 9);
                String ch2 = image.substring(9, 14);
                String ch3 = image.substring(14, image.length());
                String imagefinale = ch1 + "/" + ch2 + "/" + ch3;
                ImageView em1 = new ImageView(new Image(imagefinale));
                arr.add(new Centre(id, em1, nom, adresse, das, mail, telephone));
            }

        }
        return arr;

    }
      public List<Centre> searchSelonType(String domaine) throws SQLException {
        ste = con.createStatement();
        List<Centre> arr = new ArrayList<>();
        String requeteSearch = "Select * from `centre` WHERE das_centre='" +domaine+ "';";
        ResultSet rs = ste.executeQuery(requeteSearch);
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");

            String image = rs.getString("image_centre");
            if (!image.isEmpty()) {
                String ch1 = image.substring(0, 9);
                String ch2 = image.substring(9, 14);
                String ch3 = image.substring(14, image.length());
                String imagefinale = ch1 + "/" + ch2 + "/" + ch3;
                ImageView em1 = new ImageView(new Image(imagefinale));
                arr.add(new Centre(id, em1, nom, adresse, das, mail, telephone));
            }

        }
        return arr;

    }

    @Override
    public List<Centre> readAll() throws SQLException {
        List<Centre> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from centre");
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");
            String image = rs.getString("image_centre");

            Centre p = new Centre(id, nom, adresse, das, mail, telephone, image);
            arr.add(p);
        }
        return arr;
    }

    @Override
    public List<Centre> trierParNom() throws SQLException {
        List<Centre> arr = new ArrayList<>();
        ServiceCentre ser = new ServiceCentre();
        arr = ser.readAllCentreTrier();
        Collections.sort(arr, (e1, e2) -> e1.getNom_centre().compareTo(e2.getNom_centre()));
        return arr;
    }
     @Override
    public List<Centre> trierParVu() throws SQLException {
        List<Centre> arr = new ArrayList<>();
        ServiceCentre ser = new ServiceCentre();
        arr = ser.readAllCentreTrier();
       Collections.sort(arr, (e1, e2) -> e2.getVu_centre()-e1.getVu_centre());
       // System.out.println(arr);
        return arr;
    }

    @Override
    public ObservableList<Centre> readAllCentreAffichage() throws SQLException {

        ObservableList<Centre> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from centre");
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");
            String image = rs.getString("image_centre");
            arr.add(new Centre(id, nom, adresse, das, mail, telephone, image));
        }
        return arr;

    }
    public ObservableList<Centre> readAllCentreImage() throws SQLException {

        ObservableList<Centre> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from centre");
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");
            String image = rs.getString("image_centre");

            String ch1 = image.substring(0, 9);
            String ch2 = image.substring(9, 14);
            String ch3 = image.substring(14, image.length());
            String imagefinale = ch1 + "/" + ch2 + "/" + ch3;
         //   System.out.print("affciiher");
            //System.out.println(imagefinale);
            ImageView em1 = new ImageView(new Image(imagefinale));
            arr.add(new Centre(id, em1, nom, adresse, das, mail, telephone));
        }
        return arr;

    }
    
     public ObservableList<Centre> readAllCentreImageNote() throws SQLException {

        ObservableList<Centre> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from centre");
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");
            String image = rs.getString("image_centre");
            
            String ch1 = image.substring(0, 9);
            String ch2 = image.substring(9, 14);
            String ch3 = image.substring(14, image.length());
            String imagefinale = ch1 + "/" + ch2 + "/" + ch3;
         //   System.out.print("affciiher");
          //  System.out.println(imagefinale);
            ImageView em1 = new ImageView(new Image(imagefinale));
            arr.add(new Centre(id, em1, nom, adresse, das, mail, telephone,new ImageView(new Image("testlogin/image/note.png"))));
        }
        return arr;

    }
     
     public ObservableList<Centre> readAllCentreTrier() throws SQLException {

        ObservableList<Centre> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from centre");
        while (rs.next()) {
            int id = rs.getInt("id_centre");
            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");
            String image = rs.getString("image_centre");
            int vu = rs.getInt("vu_centre");
            arr.add(new Centre(id, nom, adresse, das, mail, image,telephone,vu));
            System.out.println(arr);
        }
        return arr;

    }

    @Override
    public int verifieCentre(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == '@' && i > 0 && i < s.length()) 
                {
                    r++;
                     System.out.println("test1");
                     System.out.println(r);
                }
            
            if (str == '.' && i < s.length() && i > 0) 
                {
                    r++;
                     System.out.println("test2");
                     System.out.println(r);
                }
           
            if (str == '?' || str == '*' || str == '%' || str == '/') 
                {
                     r--;
                           System.out.println("test3");
                     System.out.println(r);
                }
                    
            

        }
       
        return r;

    }

}
