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

    public int getId_Centre() {
        return id_centre;
    }

    public void setId_Centre(int id) {
        this.id_centre = id;
    }

    public String getNom_Centre() {
        return nom_centre;
    }

    public void setNom_Centre(String nom) {
        this.nom_centre = nom;
    }

    public String getAdresse_Centre() {
        return adresse_centre;
    }

    public void setAdresse_Centre(String adresse) {
        this.adresse_centre = adresse;
    }

    public String getDas_Centre()
    {
        return das_centre;
    }
    public void setDas_Centre(String das)
    {
        this.das_centre=das;
    }
    public String getContacte_Centre()
    {
        return mail_centre;
    }
    public void setContacte_Centre(String contacte)
    {
        this.mail_centre=contacte;
    }
    public int getNumero_Centre() {
        return telephone_centre;
    }
    public void setNumero_Centre(int numero)
    {
        this.telephone_centre=numero;
    }
 public String getImage_Centre() {
        return image_centre;
    }
    public void setImage_Centre(String image)
    {
        this.image_centre=image;
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
