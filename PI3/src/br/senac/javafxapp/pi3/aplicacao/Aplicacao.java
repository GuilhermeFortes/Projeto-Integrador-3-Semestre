package br.senac.javafxapp.pi3.aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacao extends Application {
    public static void main(String[] args) {
         launch(args);
    }
    
    

    public void start(Stage stage) throws Exception {
        Parent telaCadastro = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaInicial.fxml"
                )
        );
        
        Scene scene = new Scene(telaCadastro);
        
        stage.setScene(scene);
        stage.setTitle("SuperList");
        stage.setMinHeight(438);
        stage.setMinWidth(622);
        
        stage.show();
    }   
    
}

    

