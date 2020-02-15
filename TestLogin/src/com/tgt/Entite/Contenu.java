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
public class Contenu implements Comparable<Contenu> {
    private int id;
    private  String url_video;
    private String url_image;
     public Contenu()
    {
        this.id=0;
        this.url_video="";
        this.url_image="";
     
    }
    public Contenu(int id, String url_video, String url_image) {
        this.id = id;
        this.url_video = url_video;
        this.url_image = url_image;
      
    }

    public Contenu(String url_video, String url_image) {
        this.url_video = url_video;
        this.url_image = url_image;
    }
    

    public int getId_Contenu() {
        return id;
    }

    public void setId_Contenu(int id) {
        this.id = id;
    }

    public String getUrlVideo_Contenu() {
        return url_video;
    }

    public void setUrlVideo_Contenu(String url_video) {
        this.url_video = url_video;
    }

    public String getUrlImage_Contenu() {
        return url_image;
    }

    public void setUrlImage_Contenu(String url_image) {
        this.url_image = url_image;
    }

   
    @Override
    public String toString() {
        return "Contenu" + "id=" + id + ", url de l'image=" + url_image + ", url de la video=" + url_video +  '}';
    }
      
@Override
public  int compareTo(Contenu c)
{
    return id-c.id;
}
}
