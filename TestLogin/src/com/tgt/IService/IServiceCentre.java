/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.IService;

//import com.tgt.Entite.Centre;
import java.sql.SQLException;
import java.util.List;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 * @param <T>
 */
public interface IServiceCentre<T> {

    void ajouter(T t) throws SQLException;

    void deleteSelonNomCentre(T t) throws SQLException;

    void updateSelonId(T t) throws SQLException;

    List<T> readAll() throws SQLException;

    public List<T> searchSelonNom(T t) throws SQLException;

    public List<T> trierParNom() throws SQLException;

    public List<T> readAllCentreAffichage() throws SQLException;

    public int verifieCentre(String s);
}
