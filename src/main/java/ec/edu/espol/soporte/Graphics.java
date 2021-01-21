/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.soporte;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.clases.Nodo;
import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
//import ec.edu.espol.clases.LinkedList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Claudio Olvera
 */
public class Graphics {
    int HEIGHT = 720;
    int WIDTH = 1280;
    boolean isHbox = true;
    int deepLvl = 3;
    LinkedList<Color> colors;
    Pos pos = Pos.BOTTOM_RIGHT;

    public Graphics() {
        setColors();
    }
    
    
    private Pane generarRectangulos(Arbol<Long,String> tree, double height, double width, boolean isHbox){
        long size = tree.getValor();
        
        if(isHbox){
            HBox pane = new HBox();
            pane.setBackground(this.getBacground());
            pane.setAlignment(pos);
            pane.setMinHeight(height);
            pane.setMinWidth(width);

            

            for(Arbol<Long,String> t:tree.getRoot().getHijos()){
                double porc =(t.getValor()*100)/size;
                if(porc>1){
                    double nw =width*porc/100;
                    double nh =height;
                    VBox b = generarRectangulosV(t, nh,nw);
                    /*
                    Label lb = new Label(t.toString()+": "+size+" Kb");
                    pane.getChildren().add(lb);
                    */
                    b.setBackground(this.getBacground());
                    b.setAlignment(pos);
                    pane.setAlignment(pos);
                    pane.getChildren().add(b);
                }
            }

            return pane;
        }else{
            VBox pane = new VBox();
            pane.setBackground(this.getBacground());
            pane.setAlignment(pos);
            pane.setMinHeight(height);
            pane.setMinWidth(width);

            for(Arbol<Long,String> t:tree.getRoot().getHijos()){
                double porc =(t.getValor()*100)/size;
                if(porc>1){
                    double nw =width;
                    double nh =height*porc/100;
                    HBox b = generarRectangulosH(t, nh,nw);
                    /*
                    Label lb = new Label(t.toString()+": "+size+" Kb");
                    pane.getChildren().add(lb);
                    */
                    b.setBackground(this.getBacground());
                    b.setAlignment(pos);
                    pane.setAlignment(pos);
                    pane.getChildren().add(b);
                }
            }

            return pane;
        }
        
    }
    
    private HBox generarRectangulosH(Arbol<Long,String> tree, double height, double width){
        long size = tree.getValor();
        HBox pane = new HBox();
        pane.setBackground(this.getBacground());
        pane.setMinHeight(height);
        pane.setMinWidth(width);
        
        for(Arbol<Long,String> t:tree.getRoot().getHijos()){
            double porc =(t.getValor()*100)/size;
            if(porc>1){
                double nw =width*porc/100;
                double nh =height;
                VBox vb = (VBox) generarRectangulosV(t,nh,nw);
                //vb.setMinWidth(nw);
                //vb.setMinHeight(nh);
                vb.setBackground(this.getBacground());
                vb.setAlignment(Pos.TOP_RIGHT);
                pane.setAlignment(Pos.TOP_RIGHT);
                pane.getChildren().add(vb);
            }
        }
        return pane;
        
    }
    
    private VBox generarRectangulosV(Arbol<Long,String> tree, double height, double width){
        long size = tree.getValor();
        VBox pane = new VBox();
                
        pane.setBackground(this.getBacground());
        pane.setMinHeight(height);
        pane.setMinWidth(width);
        
        for(Arbol<Long,String> t:tree.getRoot().getHijos()){
            double porc =(t.getValor()*100)/size;
            if(porc>1){
                double nw =width;
                double nh =height*porc/100;
                HBox hb = generarRectangulosH(t, nh,nw);
                //hb.setMinWidth(nw);
                //hb.setMinHeight(nh);
                hb.setBackground(this.getBacground());
                hb.setAlignment(pos);
                pane.setAlignment(pos);
                pane.getChildren().add(hb);
            }
        }
        return pane;
        
    }
    
    public Pane generarRectangulos(Arbol<Long,String> tree){
        return generarRectangulos(tree,HEIGHT,WIDTH, isHbox);
    }
    
    /**
     * @return Color de una lista rotativa y ciclica 
     */
    private Color getColor(){
        Color c = colors.remove(0);
        colors.addLast(c);
        return c;
    }
    
    private Background getBacground(){
        return new Background(new BackgroundFill(this.getColor(),null,null));
    }
    
    /**
     * aqui se añadiran los colores los cuales se tomaran en rotacion para el treemap
     */
    private void setColors(){
        colors = new LinkedList();
        colors.add(Color.rgb(85, 239, 196));
        colors.add(Color.rgb(129, 236, 236));
        colors.add(Color.rgb(116, 185, 255));
        colors.add(Color.rgb(162, 155, 254));
        colors.add(Color.rgb(223, 230, 233));
        colors.add(Color.rgb(255, 234, 167));
        colors.add(Color.rgb(250, 177, 160));
        colors.add(Color.rgb(255, 118, 117));
        colors.add(Color.rgb(253, 121, 168));
        
    }
    
    
}

