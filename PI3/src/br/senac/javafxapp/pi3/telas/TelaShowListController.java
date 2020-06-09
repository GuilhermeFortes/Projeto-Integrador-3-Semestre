/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import br.senac.javafxapp.pi3.Banco.Banco;
import br.senac.javafxapp.pi3.Banco.DAOAlunos;
import static br.senac.javafxapp.pi3.Banco.DAOAlunos.listar;
import br.senac.javafxapp.pi3.Banco.DAOSuperList;
import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.SuperListBean;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author (((W)))
 */
public class TelaShowListController implements Initializable {
    
    
    
    

    @FXML
    private TableColumn<SuperListBean, String> TBCProfessor;
    @FXML
    private TableColumn<SuperListBean, String> TBCAluno1;
    @FXML
    private TableColumn<SuperListBean, String> TBCAluno2;
    @FXML
    private TableColumn<SuperListBean, String> TBCAluno3;
    @FXML
    private TableColumn<SuperListBean, String> TBCAluno4;
    @FXML
    private TableColumn<SuperListBean, String> TBCAluno5;
    @FXML
    private TableColumn<SuperListBean, String> TBCLista;
    @FXML
    private TableView<SuperListBean> TBLSuperList;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

                DAOSuperList superlist = new DAOSuperList();

        TBLSuperList.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        //List resultados = listarPesquisar();
        List resultados = null;

            resultados = listarPesquisar();

                
        TBLSuperList.setItems(
                FXCollections.observableArrayList(resultados)
        );
         TBCProfessor.setCellValueFactory(
                new PropertyValueFactory("nome_professor")
        );
 
        TBCAluno1.setCellValueFactory(
                new PropertyValueFactory("FK_id_aluno1")
        );
        TBCAluno2.setCellValueFactory(
                new PropertyValueFactory("FK_id_aluno2")
        );
                TBCAluno3.setCellValueFactory(
                new PropertyValueFactory("id_aluno3")
        );
        TBCAluno4.setCellValueFactory(
                new PropertyValueFactory("id_aluno4")
        );
         TBCAluno5.setCellValueFactory(
                new PropertyValueFactory("id_aluno5")
        );
                TBCLista.setCellValueFactory(
                new PropertyValueFactory("nome_lista")
        );
        TBCProfessor.setCellValueFactory(
                new PropertyValueFactory("nome_professor")
        );
    }    

               private List listarPesquisar() {
         List valores;
        try {
                valores = DAOSuperList.listarProcurar(TelaListaController.id);                
            
        }
        catch(Exception e) {
            e.printStackTrace();
            valores = null;
        }
        return valores;
    

    }


    }
    

