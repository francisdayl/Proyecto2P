package ec.edu.espol.proyecto2p;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.soporte.FileManager;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        Pane vista = new Pane();
        Label lb = new Label("app javafx");
        vista.getChildren().add(lb);
        scene = new Scene(vista);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //test(); //solo es para probar codigo
        launch();
    }
    
    
    private static void test(){
        FileManager fm = new FileManager();
        Arbol<Long,String> a = fm.getDirTree(new File("D:\\Anime"));
        System.out.println(a.toStringClaveValor());
        System.out.println(a.getRoot().getValor());
    }
}