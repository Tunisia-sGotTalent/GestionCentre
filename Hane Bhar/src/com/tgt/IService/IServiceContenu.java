/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tgt.IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IServiceContenu<T>{
   //  void ajouter(T t) throws SQLException;
    //void deleteSelonNomContenu(T t) throws SQLException;
 //  void updateSelonNom(T t) throws SQLException;
   List<T> retournerContenu() throws SQLException;
     //  public List<T> searchSelonNom(T t) throws SQLException ;
    //public List<T> trierParNom() throws SQLException ;
    
}
