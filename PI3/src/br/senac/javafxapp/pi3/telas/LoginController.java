package br.senac.javafxapp.pi3.telas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class LoginController implements Initializable {

    @FXML
    private TextField TFUser;
    @FXML
    private PasswordField PFPassword;
    @FXML
    private Button BTLog;

    private Stage logarStage;
    @FXML
    private Button BTBack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getTFUser() {
        return TFUser;
    }

    public void setTFUser(TextField TFUser) {
        this.TFUser = TFUser;
    }

    public PasswordField getPFPassword() {
        return PFPassword;
    }

    public void setPFPassword(PasswordField PFPassword) {
        this.PFPassword = PFPassword;
    }

    @FXML
    private void User(ActionEvent event) {
    }

    @FXML
    private void Password(ActionEvent event) {
    }

    @FXML
    private void Log(ActionEvent event) throws IOException {
                String login = TFUser.getText();
                String senha = PFPassword.getText();
                Cliente cliente = new Cliente();
        if(login.equals("admin") && senha.equals("admin")){

        Parent telaPrincipal = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaPrincipal.fxml"
                )
        );
        Scene scene = new Scene(telaPrincipal);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Tela Principal");

        stage.show();
        Stage prevStage = (Stage) BTLog.getScene().getWindow();
        prevStage.close();
    
}
}

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
                            Stage stage = new Stage();
 
            Parent telaAnterior = FXMLLoader.load(
                    getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaInicial.fxml"
                    )
            );
                    Scene scene = new Scene(telaAnterior);

        stage.setScene(scene);       
        stage.show();
        Stage prevStage = (Stage) BTBack.getScene().getWindow();
        prevStage.close();
    }
}

