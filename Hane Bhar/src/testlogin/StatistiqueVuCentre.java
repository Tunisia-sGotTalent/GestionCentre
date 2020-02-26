/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.tgt.Entite.Centre;
import com.tgt.Service.ServiceCentre;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class StatistiqueVuCentre extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    public void init(Stage primaryStage) throws SQLException {
        ServiceCentre ser=new ServiceCentre();
        ObservableList<Centre> list=ser.readAllCentreTrier();
        
        HBox root = new HBox();
        Scene scene = new Scene(root, 450, 330);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Centre");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Nombre de vu");
        LineChart<String, Number> linechart = new LineChart<String, Number>(xAxis, yAxis);
        linechart.setTitle("Recommandation des centres");
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        for (int i=0;i<list.size();i++)
        {
             data.getData().add(new XYChart.Data<String, Number>(list.get(i).getNom_centre(), list.get(i).getVu_centre()));
        }
       
        linechart.getData().add(data);
        root.getChildren().add(linechart);
        primaryStage.setTitle("Statistique du nombre de vu des centres");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
