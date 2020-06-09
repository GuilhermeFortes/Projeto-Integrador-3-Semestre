/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import br.senac.javafxapp.pi3.cliente.Cliente;
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
public class TelaPrincipalController implements Initializable {

    @FXML
    private Button BTShowList;
    @FXML
    private Button BTCreate;
    @FXML
    private Button BTBack;
    @FXML
    private Button BTCourses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Show(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente();

        Parent telaShow = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaLista.fxml")
        );

        Scene scene = new Scene(telaShow);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Superlist Listas Criadas");
        Stage prevStage = (Stage) BTShowList.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void Create(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente();

        Parent telaShow = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaCriar.fxml")
        );

        Scene scene = new Scene(telaShow);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        Stage prevStage = (Stage) BTShowList.getScene().getWindow();
        stage.setTitle("Superlist Criação de Lista");
        prevStage.close();
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente();

        Parent telaShow = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/Login.fxml")
        );

        Scene scene = new Scene(telaShow);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        Stage prevStage = (Stage) BTShowList.getScene().getWindow();
        stage.setTitle("Superlist Login");
        prevStage.close();
    }

    @FXML
    private void Courses(ActionEvent event) throws IOException {

        Cliente cliente = new Cliente();

        Parent telaShow = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaCursos.fxml")
        );

        Scene scene = new Scene(telaShow);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        Stage prevStage = (Stage) BTCourses.getScene().getWindow();
        stage.setTitle("Superlist Lista de Cursos");
        prevStage.close();

    }

}
