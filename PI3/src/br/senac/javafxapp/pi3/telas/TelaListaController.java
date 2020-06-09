package br.senac.javafxapp.pi3.telas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.senac.javafxapp.pi3.Banco.DAOAlunos;
import static br.senac.javafxapp.pi3.Banco.DAOAlunos.listar;
import br.senac.javafxapp.pi3.Banco.DAOSuperList;
import static br.senac.javafxapp.pi3.Banco.DAOSuperList.listar;
import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.SuperListBean;
import static java.awt.PageAttributes.MediaType.C;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.print.Paper.C;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Guilherme
 */
public class TelaListaController implements Initializable {

    int type = 0;
    public SuperListBean listaEdicao;
    public static int id;

    @FXML
    private Button BTBack;
    @FXML
    private TextField TFSearch;
    @FXML
    private ComboBox<String> CBSearchType;

    private Stage backStage;
    @FXML
    private TableColumn<SuperListBean, String> TBCNomeLista;
    @FXML
    private TableColumn<SuperListBean, Integer> TBCCodigo;
    @FXML
    private Button BTDetalhes;
    @FXML
    private TableView<SuperListBean> TBLData;
    @FXML
    private Button BTUpdate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBSearchType.getItems().addAll(
                "Nome da Lista",
                "Código da Lista"
        );
        List resultados = null;

        DAOSuperList listas = new DAOSuperList();

        TBLData.getItems().clear();

        try {
            resultados = DAOSuperList.listar();
        } catch (Exception ex) {
            Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Se há resultados, atualiza a tabela
        if (resultados != null) {
            TBLData.setItems(
                    FXCollections.observableArrayList(resultados)
            );
        }
        TBCCodigo.setCellValueFactory(
                new PropertyValueFactory("id_lista")
        );
        TBCNomeLista.setCellValueFactory(
                new PropertyValueFactory("nome_professor")
        );

        if (type == 1) {
            String nome = TFSearch.getText();
            try {
                DAOSuperList.listarProcurarNome(nome);
            } catch (Exception ex) {
                Logger.getLogger(TelaListaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (type == 2) {
            String id = TFSearch.getText();

            int intid = Integer.parseInt(id);

            try {
                DAOSuperList.listarProcurar(intid);
            } catch (Exception ex) {
                Logger.getLogger(TelaListaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Se há resultados, atualiza a tabela
        if (resultados != null) {
            TBLData.setItems(
                    FXCollections.observableArrayList(resultados)
            );
        }
        TBCNomeLista.setCellValueFactory(
                new PropertyValueFactory("nome_lista")
        );
        TBCCodigo.setCellValueFactory(
                new PropertyValueFactory("id_lista")
        );

    }

    private void acaoPesquisar(ActionEvent event) {

        TBLData.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        List resultados = listarPesquisar();

        //Se há resultados, atualiza a tabela
        if (resultados != null) {
            TBLData.setItems(
                    FXCollections.observableArrayList(resultados)
            );
        } else {
            System.out.println("TABELA VAZIA");
        }

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
    private void Search(ActionEvent event) throws Exception {

        if (CBSearchType.getValue() != null) {
            switch (CBSearchType.getValue()) {

                case "Nome do Curso":
                    type = 1;
                    break;

                case "Código do Curso":
                    type = 2;
                    break;
            }

        }

        if (type == 1) {
//int convert = Integer.parseInt(tfsearch);

            TBLData.getItems().clear();

            //Obtém os resultados de pesquisa do mock
            //List resultados = listarPesquisar();
            List resultados = null;

            String tfsearch = TFSearch.getText();

            if (tfsearch.equals("") || tfsearch.equals(" ")) {

                resultados = DAOSuperList.listar();
            } else {
                try {
                    resultados = DAOSuperList.procurarNOME(tfsearch);
                } catch (Exception ex) {
                    Logger.getLogger(TelaListaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            TBLData.setItems(
                    FXCollections.observableArrayList(resultados)
            );

            TBCCodigo.setCellValueFactory(
                    new PropertyValueFactory("id_lista")
            );
            TBCNomeLista.setCellValueFactory(
                    new PropertyValueFactory("nome_lista")
            );

        }
        if (type == 2) {
//

            TBLData.getItems().clear();

            //Obtém os resultados de pesquisa do mock
            //List resultados = listarPesquisar();
            List resultados = null;

            String tfsearch = TFSearch.getText();
            int convert = Integer.parseInt(tfsearch);

            if (tfsearch.equals("") || tfsearch.equals(" ")) {

                resultados = DAOSuperList.listar();
            } else {
                try {
                    resultados = DAOSuperList.procurarID(convert);
                } catch (Exception ex) {
                    Logger.getLogger(TelaListaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            TBLData.setItems(
                    FXCollections.observableArrayList(resultados)
            );

            TBCCodigo.setCellValueFactory(
                    new PropertyValueFactory("id_lista")
            );
            TBCNomeLista.setCellValueFactory(
                    new PropertyValueFactory("nome_lista")
            );

        }

    }

    @FXML
    private void SearchType(ActionEvent event) {
    }

//    private void Database(SortEvent<SuperListBean> event) throws Exception {
    //  }
    private List listarPesquisar() {
        List resultados;
        //Obtém os itens do mock
        try {
            //Se há dados para pesquisa, faz uma busca pelo valor no mock
            //Caso contrário, faz a listagem
            if (TFSearch.getText().equals("")) {
                resultados = DAOSuperList.listar();
            } else {
                resultados = DAOSuperList.procurarNOME(TFSearch.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultados = null;
        }
        return resultados;
    }

    private List listarPesquisarNome() {
        List resultados;
        //Obtém os itens do mock
        try {
            //Se há dados para pesquisa, faz uma busca pelo valor no mock
            //Caso contrário, faz a listagem
            if (TFSearch.getText().equals("")) {
                resultados = DAOSuperList.listar();
            } else {
                resultados = DAOSuperList.procurarNOME(TFSearch.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultados = null;
        }
        return resultados;
    }

    @FXML
    private void Detalhes(ActionEvent event) throws IOException, Exception {

        SuperListBean up = new SuperListBean();
        up = TBLData.getSelectionModel().getSelectedItem();

        id = up.getId_lista();

        System.out.println(id);

        if (up != null) {

            DAOSuperList.listarProcurar(id);

            Stage stage = new Stage();

            Parent telaAnterior = FXMLLoader.load(
                    getClass().getResource(
                            "/br/senac/javafxapp/pi3/telas/TelaShowList.fxml"
                    )
            );
            Scene scene = new Scene(telaAnterior);

            stage.setScene(scene);
            stage.show();
            Stage prevStage = (Stage) BTBack.getScene().getWindow();
            //prevStage.close();

        }

    }

    @FXML
    private void DataList(SortEvent<SuperListBean> event) {

    }

    @FXML
    private void Update(ActionEvent event) throws Exception {

        if (CBSearchType.getValue() != null) {
            switch (CBSearchType.getValue()) {

                case "Nome da Lista":
                    type = 1;
                    break;

                case "Código da Lista":
                    type = 2;
                    break;
            }

        }

        TBLData.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        //List resultados = listarPesquisar();
        List resultados = null;

        String tfsearch = TFSearch.getText();

        if (tfsearch.equals("") || tfsearch.equals(" ")) {

            resultados = DAOSuperList.listar();
        } else {
            if(type == 1){
            try {
                resultados = DAOSuperList.procurarNOME(tfsearch);
            } catch (Exception ex) {
                Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            if(type == 2){
                try {
                    int idconvert = Integer.parseInt(tfsearch);
                resultados = DAOSuperList.procurarID(idconvert);
            } catch (Exception ex) {
                Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            }
        }
        TBLData.setItems(
                FXCollections.observableArrayList(resultados)
        );
        TBCCodigo.setCellValueFactory(
                new PropertyValueFactory("id_lista")
        );
        TBCNomeLista.setCellValueFactory(
                new PropertyValueFactory("nome_lista")
        );
    }

}
