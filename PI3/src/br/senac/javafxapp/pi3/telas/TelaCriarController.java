/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import br.senac.javafxapp.pi3.Banco.DAOAlunos;
import static br.senac.javafxapp.pi3.Banco.DAOAlunos.listar;
import br.senac.javafxapp.pi3.Banco.DAOSuperList;
import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.SuperListBean;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class TelaCriarController implements Initializable {

    private SuperListBean ListEdicao;
    private boolean editMode = false;
    @FXML
    private TableView<Cliente> TBLAlunosFora;
    @FXML
    private TextField TFList;
    @FXML
    private TextField TFTeacher;
    @FXML
    private TextField TFSearch;
    @FXML
    private TextField TFCourse;
    @FXML
    private Button BTBack;
    @FXML
    private Button BTCreate;
    @FXML
    private TableColumn<Cliente, String> TBCNomeAluno;
    @FXML
    private TableColumn<Cliente, String> TBCID;
    @FXML
    private Button BTUpdate;
    @FXML
    private TextField TFAluno1;
    @FXML
    private TextField TFAluno2;
    @FXML
    private TextField TFAluno3;
    @FXML
    private TextField TFAluno4;
    @FXML
    private TextField TFAluno5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DAOAlunos alunos = new DAOAlunos();

        TBLAlunosFora.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        List resultados = null;
        try {
            resultados = listar();
        } catch (Exception ex) {
            Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Se há resultados, atualiza a tabela
        if (resultados != null) {
            TBLAlunosFora.setItems(
                    FXCollections.observableArrayList(resultados)
            );
        }
        TBCID.setCellValueFactory(
                new PropertyValueFactory("id")
        );
        TBCNomeAluno.setCellValueFactory(
                new PropertyValueFactory("nome")
        );

    }

    @FXML
    private void List(ActionEvent event) {
    }

    @FXML
    private void Teacher(ActionEvent event) {
    }

    @FXML
    private void Search(ActionEvent event) {
    }

    @FXML
    private void Course(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        Parent telaAnterior = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaPrincipal.fxml"
                )
        );
        Scene scene = new Scene(telaAnterior);

        stage.setScene(scene);
        stage.show();
        Stage prevStage = (Stage) BTBack.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void Create(ActionEvent event) throws Exception {

        SuperListBean beans = new SuperListBean();
        DAOSuperList lista = new DAOSuperList();
        String curso = TFCourse.getText();
        int idcurso = Integer.parseInt(curso);

        String aluno1 = TFAluno1.getText();
        int idaluno1 = Integer.parseInt(aluno1);

        String aluno2 = TFAluno2.getText();
        int idaluno2 = Integer.parseInt(aluno2);

        String aluno3 = TFAluno3.getText();
        int idaluno3 = Integer.parseInt(aluno3);

        String aluno4 = TFAluno4.getText();
        int idaluno4 = Integer.parseInt(aluno4);

        String aluno5 = TFAluno5.getText();
        int idaluno5 = Integer.parseInt(aluno5);
        //Configura os valores no item de modelo

        beans.setNome_lista(TFList.getText());
        beans.setNome_professor(TFTeacher.getText());
        beans.setFK_id_curso(idcurso);
        beans.setFK_id_aluno1(idaluno1);
        beans.setFK_id_aluno2(idaluno2);
        beans.setId_aluno3(idaluno3);
        beans.setId_aluno4(idaluno4);
        beans.setId_aluno5(idaluno5);

        //Insere o cliente no mock
        lista.inserir(beans);

        //Limpa os campos após a inserção
        limparCampos();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso!");
        alert.setContentText("Nova Lista Criada!");
        alert.showAndWait();

    }

    private List listarPesquisar() {
        List resultados;
        try {
            //Se há dados para pesquisa, faz uma busca pelo valor no mock
            //Caso contrário, faz a listagem
            if (TFSearch.getText().equals("")) {
                resultados = DAOAlunos.listar();
            } else {
                resultados = DAOAlunos.procurar(TFSearch.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultados = null;
        }
        return resultados;

    }

    @FXML
    private void Update(ActionEvent event) throws Exception {

        TBLAlunosFora.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        //List resultados = listarPesquisar();
        List resultados = null;

        String tfsearch = TFSearch.getText();

        if (tfsearch.equals("") || tfsearch.equals(" ")) {

            resultados = DAOAlunos.listar();
        } else {
            try {
                resultados = DAOAlunos.procurar(tfsearch);
            } catch (Exception ex) {
                Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TBLAlunosFora.setItems(
                FXCollections.observableArrayList(resultados)
        );
        TBCID.setCellValueFactory(
                new PropertyValueFactory("id")
        );
        TBCNomeAluno.setCellValueFactory(
                new PropertyValueFactory("nome")
        );

    }

    private void limparCampos() {
        TFAluno1.setText("");
        TFAluno2.setText("");
        TFAluno3.setText("");
        TFAluno4.setText("");
        TFAluno5.setText("");
        TFCourse.setText("");
        TFList.setText("");
        TFTeacher.setText("");
        TFSearch.setText("");

        editMode = false;

    }

}
