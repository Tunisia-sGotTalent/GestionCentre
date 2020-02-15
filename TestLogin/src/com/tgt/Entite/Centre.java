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
        private int id;
    private String nom;
    private String adresse;
    private String das;
    private String contacte;
    private int numero;
    public Centre()
    {
        this.nom="";
        this.adresse="";
        this.das="";
        this.contacte="";
        this.numero=0;
    }
    public Centre(int id, String nom, String adresse, String das,String contacte, int numero) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.das=das;
        this.contacte=contacte;
        this.numero = numero;
        
    }

    public Centre(String nom, String adresse, String das,String contacte, int numero) {
        this.nom = nom;
        this.adresse = adresse;
        this.das=das;
        this.contacte=contacte;
        this.numero = numero;
    }

    public int getId_Centre() {
        return id;
    }

    public void setId_Centre(int id) {
        this.id = id;
    }

    public String getNom_Centre() {
        return nom;
    }

    public void setNom_Centre(String nom) {
        this.nom = nom;
    }

    public String getAdresse_Centre() {
        return adresse;
    }

    public void setAdresse_Centre(String adresse) {
        this.adresse = adresse;
    }

    public String getDas_Centre()
    {
        return das;
    }
    public void setDas_Centre(String das)
    {
        this.das=das;
    }
    public String getContacte_Centre()
    {
        return contacte;
    }
    public void setContacte_Centre(String contacte)
    {
        this.contacte=contacte;
    }
    public int getNumero_Centre() {
        return numero;
    }
    public void setNumero_Centre(int numero)
    {
        this.numero=numero;
    }

  
    @Override
    public String toString() {
        return "Centre" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", domaine d'activités=" + das + ", contacte" + contacte +", numero de téléphone" + numero +  '}';
    }
      
@Override
public  int compareTo(Centre c)
{
    return id-c.id;
}
}
