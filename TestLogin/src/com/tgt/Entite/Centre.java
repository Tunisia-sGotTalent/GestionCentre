/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tgt.Entite;

/**
 *
 * @author ASUS
 */
public class Centre implements Comparable<Centre>{
        private int id_centre;
    private String nom_centre;
    private String adresse_centre;
    private String das_centre;
    private String mail_centre;
    private int telephone_centre;
    private String image_centre;
    public Centre()
    { this.id_centre=0;
        this.nom_centre="";
        this.adresse_centre="";
        this.das_centre="";
        this.mail_centre="";
        this.telephone_centre=0;
        this.image_centre="";

    }
    public Centre(int id, String nom, String adresse, String das,String contacte, int numero) {
        this.id_centre = id;
        this.nom_centre = nom;
        this.adresse_centre = adresse;
        this.das_centre=das;
        this.mail_centre=contacte;
        this.telephone_centre = numero;
        
       

        
    }
    
    public Centre(int id, String nom, String adresse, String das,String contacte, int numero,String image) {
        this.id_centre = id;
        this.nom_centre = nom;
        this.adresse_centre = adresse;
        this.das_centre=das;
        this.mail_centre=contacte;
        this.telephone_centre = numero;
        this.image_centre=image;

        
    }

    public Centre(String nom, String adresse, String das,String contacte, int numero) {

        this.nom_centre = nom;
        this.adresse_centre = adresse;
        this.das_centre=das;
        this.mail_centre=contacte;
        this.telephone_centre = numero;
     

    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public String getNom_centre() {
        return nom_centre;
    }

    public void setNom_centre(String nom_centre) {
        this.nom_centre = nom_centre;
    }

    public String getAdresse_centre() {
        return adresse_centre;
    }

    public void setAdresse_centre(String adresse_centre) {
        this.adresse_centre = adresse_centre;
    }

    public String getDas_centre() {
        return das_centre;
    }

    public void setDas_centre(String das_centre) {
        this.das_centre = das_centre;
    }

    public String getMail_centre() {
        return mail_centre;
    }

    public void setMail_centre(String mail_centre) {
        this.mail_centre = mail_centre;
    }

    public int getTelephone_centre() {
        return telephone_centre;
    }

    public void setTelephone_centre(int telephone_centre) {
        this.telephone_centre = telephone_centre;
    }

    public String getImage_centre() {
        return image_centre;
    }

    public void setImage_centre(String image_centre) {
        this.image_centre = image_centre;
    }

   
    @Override
    public String toString() {
        return "Centre" + "id=" + id_centre + ", nom=" + nom_centre + ", adresse=" + adresse_centre + ", domaine d'activités=" + das_centre + ", contacte" + mail_centre +", numero de téléphone" + telephone_centre + "et d'image"+image_centre + '}';
    }
      
@Override
public  int compareTo(Centre c)
{
    return id_centre-c.id_centre;
}
}
