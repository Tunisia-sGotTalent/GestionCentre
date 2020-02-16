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

/**
 *
 * @author ASUS
 */
public class ServiceCentre implements IServiceCentre<Centre> {

    private Connection con;
    private Statement ste;
    public ServiceCentre() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Centre t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `centre`(`id_centre`, `nom_centre`, `adresse_centre`, `das_centre`, `mail_centre`, `telephone_centre`,`image_centre`)"
                + " VALUES (NULL,'" + t.getNom_Centre() + "', '" + t.getAdresse_Centre() + "', '" + t.getDas_Centre() + "', '" + t.getContacte_Centre() + "', '" + t.getNumero_Centre() + "','" + t.getImage_Centre() + "');";
        int res = ste.executeUpdate(requeteInsert);
        System.out.println(res);
    }

    /*   public boolean chercher(Centre t) throws  SQLException
     {  String requeteSelect = "SELECT `id_centre`, `nom_centre`, `adresse_centre`, `das_centre`, `mail_centre`, `telephone_centre` FROM `centre` WHERE nom_centre=='t.getNom()'";
     ResultSet result= ste.executeQuery(requeteSelect); 
     return result.
     }
     */
    @Override
    public void deleteSelonNomCentre(Centre t) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM centre WHERE nom_centre = ? ;";
        PreparedStatement pst = con.prepareStatement(requeteDelete);
        pst.setString(1, t.getNom_Centre());
        pst.executeUpdate();
        /*int res= ste.executeUpdate(requeteDelete);
         System.out.print(res);*/
    }

    @Override
    public void updateSelonNom(Centre t) throws SQLException {
        ste = con.createStatement();
        String requeteUpdate = "UPDATE `centre` SET `adresse_centre`='" + t.getAdresse_Centre() + "',"
                + "`das_centre`='" + t.getDas_Centre() + "',`mail_centre`='" + t.getContacte_Centre() + "' WHERE nom_centre='" + t.getNom_Centre() + "' ;";

        ste.executeUpdate(requeteUpdate);

    }

    @Override
    public List<Centre> searchSelonNom(Centre t) throws SQLException {
        ste = con.createStatement();
        List<Centre> arr = new ArrayList<>();
        String requeteSearch = "Select * from `centre` WHERE nom_centre='" + t.getNom_Centre() + "';";
        ResultSet rs = ste.executeQuery(requeteSearch);
        while (rs.next()) {

            String nom = rs.getString("nom_centre");
            String adresse = rs.getString("adresse_centre");
            String das = rs.getString("das_centre");
            String mail = rs.getString("mail_centre");
            int telephone = rs.getInt("telephone_centre");

            Centre p = new Centre(nom, adresse, das, mail, telephone);
            arr.add(p);
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

            Centre p = new Centre(id, nom, adresse, das, mail, telephone);
            arr.add(p);
        }
        return arr;
    }

    @Override
    public List<Centre> trierParNom() throws SQLException {
        List<Centre> arr = new ArrayList<>();
        ServiceCentre ser = new ServiceCentre();
        arr = ser.readAll();
        Collections.sort(arr, (e1, e2) -> e1.getNom_Centre().compareTo(e2.getNom_Centre()));
        return arr;
    }

    @Override
    public ObservableList<Centre> readAllCentreAffichage(Centre c) throws SQLException {

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
            arr.add(c);
            arr.add(new Centre(id,nom,adresse,das,mail,telephone,image));
        
          //  System.out.println("jjjj");     
        }
        return arr;

    }
    @Override
  public int verifieCentre(String s)
    { int r=0;
       for (int i=0;i<s.length();i++)
       {  char str =s.charAt(i);
           if ( str=='@' && i>0 && i<s.length())
             r++;
           if (str=='.' && i<s.length() && i>0)
               r++;
           if (str=='?' || str=='*' || str=='%' || str=='/' )
           r--;
           
       } 
      return r;

 
}
}   