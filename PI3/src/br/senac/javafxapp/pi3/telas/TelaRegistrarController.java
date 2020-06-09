/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import br.senac.javafxapp.pi3.Banco.DAOAlunos;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class TelaRegistrarController implements Initializable {
    
    private boolean editMode = false;
    private Cliente clienteEdicao;
    @FXML
    private TextField TFNacio;
    @FXML
    private DatePicker DPNasc;
    @FXML
    private TextField TFName;
    @FXML
    private TextField TFSexo;
    @FXML
    private Button BTRegistrar;
    @FXML
    private Button BTBack;
    @FXML
    private TextField TFProfissao;
    @FXML
    private TextField TFPeso;
    @FXML
    private TextField TFAltura;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    
    
    
    } 




    @FXML
    private void Registrar(ActionEvent event) throws Exception {
        
        if(TFNacio.getText().equals("") || TFName.getText().equals("")|| TFProfissao.getText().equals("")|| TFSexo.getText().equals("")|| DPNasc.getValue().equals("")){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO!");
        alert.setContentText("Campos Obrigatórios Faltando!");
        alert.showAndWait();
        }
        else{
                if (editMode != true) {
            //Cria um novo item de modelo de cliente
            Cliente cliente = new Cliente();
            DAOAlunos alunos = new DAOAlunos();
            //Configura os valores no item de modelo
            
            float convertAltura = Float.parseFloat(TFAltura.getText().replaceAll(",", "."));
            float convertPeso = Float.parseFloat(TFPeso.getText().replaceAll(",", "."));
            
            cliente.setNome(TFName.getText());
            cliente.setProfissao(TFProfissao.getText());
            cliente.setSexo(TFSexo.getText());
            cliente.setNacionalidade(TFNacio.getText());
            cliente.setPeso(convertPeso);
            cliente.setNascimento(DPNasc.getValue());
            cliente.setAltura(convertAltura);
                
            //Insere o cliente no mock
            alunos.inserir(cliente);

            //Limpa os campos após a inserção
            limparCampos();
                
            
            
        } else {
            //Configura os valores no item de modelo
            float convertAltura = Float.parseFloat(TFAltura.getText().replaceAll(",", "."));
            float convertPeso = Float.parseFloat(TFPeso.getText().replaceAll(",", "."));
            clienteEdicao.setNome(TFName.getText());
            clienteEdicao.setProfissao(TFProfissao.getText());
            clienteEdicao.setNascimento(DPNasc.getValue());
            clienteEdicao.setSexo(TFSexo.getText());
            clienteEdicao.setPeso((convertPeso));
            clienteEdicao.setAltura(convertAltura);
            clienteEdicao.setNacionalidade(TFNacio.getText());
           
            //Atualiza o cliente no mock
//            atualizarCliente(clienteEdicao);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso!");
        alert.setContentText("Aluno Registrado!");
        alert.showAndWait();

            //Limpa os campos após a edição
            limparCampos();
        }
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

    @FXML
    private void Profissao(ActionEvent event) {
    }

    @FXML
    private void Peso(ActionEvent event) {
    }

    @FXML
    private void Altura(ActionEvent event) {
    }
        @FXML
    private void Nacio(ActionEvent event) {
    }

    @FXML
    private void Nasc(ActionEvent event) {
    }


    @FXML
    private void Name(ActionEvent event) {
    }

    @FXML
    private void Sexo(ActionEvent event) {
    }

    private void limparCampos() {
        TFName.setText("");
        TFProfissao.setText("");
        TFSexo.setText("");
        TFNacio.setText("");
        TFPeso.setText("");
        DPNasc.setValue((null));
        TFAltura.setText("");


        BTRegistrar.setText("Inserir");
        editMode = false;
        
        /**
         *            cliente.setNome(TFName.getText());
            cliente.setProfissao(TFProfissao.getText());
            cliente.setSexo(TFSexo.getText());
            cliente.setNacionalidade(TFNacio.getText());
            cliente.setPeso(TFPeso.getFloat());
            cliente.setNascimento(DPNasc.getDate());
            cliente.setAltura(TFAltura.getFloat());
         */
    }
    
    
    
}
