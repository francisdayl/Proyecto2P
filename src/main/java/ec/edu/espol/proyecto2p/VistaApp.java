/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Natalia Ramirez
 */
public class VistaApp {
    private GridPane root;

    public VistaApp() {
        this.root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(5.0);
        root.setHgap(5.0);
        int[] valores = {200,400};
        crearTreemap(valores);
    }
    
    public void crearTreemap(int[] valores){
        Map<Double, Double[]> map = new HashMap<>();
        Double[] l1 = {50.0,20.0,84.0};
        Double[] l2 = {50.0,78.0,84.0};
        Double[] l3 = {45.0,84.0};
        map.put(154.0, l1);
        map.put(212.0, l2);
        map.put(129.0, l3);
        int cont = 0;
        /*for(int valor : valores){
            //root.getChildren().add(new Rectangle(valor,valor));
            root.add(new Rectangle(Math.sqrt(valor),Math.sqrt(valor)), 0, cont);
            cont++;
        }*/
        GridPane gp = new GridPane();
        gp.setVgap(5.0);
        gp.setHgap(5.0);
        
        for(Entry<Double,Double[]> entry : map.entrySet()){
            gp.add(generateGridPane(entry,495.0), 0, cont);
            cont++;
        }
        /*GridPane gp = new GridPane();
        
        gp.setVgap(5.0);
        gp.setHgap(5.0);
        root.add(new Rectangle(70,100), 0, cont);
        Rectangle r = new Rectangle();
        double x =Math.round(((double)20/(double)30)*100);
        System.out.println(x);
        gp.add(new Rectangle(30, x-2.5), 0, 0);
        gp.add(new Rectangle(30, Math.round(((double)10/(double)30)*100)-2.5), 0, 1);
        //root.add(new Rectangle(30,100), cont+1, 0);
        root.add(gp, cont+1, 0);*/
        root.add(gp, 0, 0);
    }
    
    public GridPane generateGridPane(Entry<Double,Double[]> entry, Double h){
        GridPane gp = new GridPane();
        gp.setVgap(5.0);
        gp.setHgap(5.0);
        int cont = 0;
        for(Double i : entry.getValue()){
            gp.add(new Rectangle(entry.getKey(), Math.round(((i/entry.getKey())*h)-2.5)), cont, 0);
            cont++;
        }
        return gp;
    }
    public GridPane getRoot(){
        return this.root;
    }
}
