/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class TelaInicialController implements Initializable {

    @FXML
    private Button BTCadastrar;

    private Stage logarStage = new Stage();
    @FXML
    private Button BTLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Cadastrar(ActionEvent event) throws IOException {
                Parent telaLogar = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaRegistrar.fxml"
                )
        );
        Scene scene = new Scene(telaLogar);
        Stage stage = new Stage();
        Stage primaryStage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Superlist Cadastro de Aluno");
        primaryStage.close();

        stage.show();
        Stage prevStage = (Stage) BTCadastrar.getScene().getWindow();
        prevStage.close();
    }
    @FXML
    private void Login(ActionEvent event) throws IOException {

        Parent telaLogar = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/Login.fxml"
                )
        );
        Scene scene = new Scene(telaLogar);
        Stage stage = new Stage();
        Stage primaryStage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Superlist Login");
        primaryStage.close();

        stage.show();
        Stage prevStage = (Stage) BTLogin.getScene().getWindow();
        prevStage.close();

    }


    

}
