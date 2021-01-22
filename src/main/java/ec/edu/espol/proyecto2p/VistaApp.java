/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.soporte.FileManager;
import ec.edu.espol.soporte.Graphics;
import ec.edu.espol.soporte.IndexFolder;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Natalia Ramirez
 */
public class VistaApp {
    private BorderPane root;
    private File file;
    public String titulo;
    
    public VistaApp() {
        this.root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setMaxSize(new Graphics().getWIDTH()+40, new Graphics().getHEIGHT()+120);
        root.setMinSize(new Graphics().getWIDTH()+40, new Graphics().getHEIGHT()+120);
        crearTop();
        
    }
    
    public void crearTop(){
        HBox contenedor = new HBox();
        Button enviar = new Button("ESCOGER DIRECTORIO");
        Button capturar = new Button("GUARDAR IMAGEN");
        capturar.setVisible(false);
        contenedor.setPadding(new Insets(5,5,5,5));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(30);
        contenedor.getChildren().addAll(enviar,capturar);
        
        root.setTop(contenedor);
        
        enviar.setOnAction( (e)-> {
            capturar.setVisible(true);
            DirectoryChooser directorios = new DirectoryChooser();
            file = directorios.showDialog(new Stage());
            System.out.println(file.getAbsolutePath());
            Arbol<IndexFolder, String> tree = new FileManager().getDirTree(file);
            titulo = "Estoy en el directorio: "+file.getName()+" de tamaño: "+transformacion(tree.getValor().getSize());
            App.cambiarTitulo(titulo);
            Pane treemap = new Graphics().generarRectangulos(tree);
            treemap.setMaxSize(new Graphics().getWIDTH(), new Graphics().getHEIGHT());
            root.setCenter(treemap);
        });
        
        
    }
    
    /*public void capturarYGuardarDisplay(){
        FileChooser filechooser = new FileChooser();
        
        filechooser.getExtensionFilters().add(new)
    }*/
    
    public static String transformacion(Long bytes){
        
        if((bytes/1024) < 1024){
            return String.valueOf(bytes)+" Bytes";
        }
        else if((bytes/(1024*1024)) < 1024){
            return String.valueOf((int)(bytes/1024))+" KB";
        }
        else if((bytes/(1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024)))+" MB";
        }
        else if((bytes/(1024*1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024*1024)))+" GB";
        }
        else if((bytes/(1024*1024*1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024*1024*1024)))+" TB";
        }
        
        return String.valueOf(bytes)+" Bytes";
    }
    
    
    public BorderPane getRoot(){
        return this.root;
    }
}
