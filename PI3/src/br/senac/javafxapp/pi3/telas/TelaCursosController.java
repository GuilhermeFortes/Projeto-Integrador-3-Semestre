/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.telas;

import br.senac.javafxapp.pi3.Banco.DAOCursos;
import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.CursosBean;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author (((W)))
 */
public class TelaCursosController implements Initializable {

    private CursosBean ListEdicao;
    private boolean editMode = false;
    private int type;

    @FXML
    private TableView<CursosBean> TBLCursos;
    @FXML
    private TableColumn<CursosBean, Integer> TBCID;
    @FXML
    private TableColumn<CursosBean, String> TBCNome;
    @FXML
    private TableColumn<CursosBean, String> TBCDescricao;
    @FXML
    private TableColumn<CursosBean, Integer> TBCCarga;
    @FXML
    private TableColumn<CursosBean, Integer> TBCTotaulas;
    @FXML
    private TableColumn<CursosBean, Integer> TBCAno;
    @FXML
    private Button BTBack;
    @FXML
    private TextField TFSearch;
    @FXML
    private ComboBox<String> TBCSearchType;
    @FXML
    private Button BTUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TBCSearchType.getItems().addAll(
                "Nome do Curso",
                "Código do Curso"
        );
        DAOCursos cursos = new DAOCursos();

        TBLCursos.getItems().clear();

        //Obtém os resultados de pesquisa do mock
        List resultados = null;
        try {
            resultados = cursos.listar();
        } catch (Exception ex) {
            Logger.getLogger(TelaCriarController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Se há resultados, atualiza a tabela
        if (resultados != null) {
            TBLCursos.setItems(
                    FXCollections.observableArrayList(resultados)
            );
        }
        TBCID.setCellValueFactory(
                new PropertyValueFactory("idcurso")
        );
        TBCNome.setCellValueFactory(
                new PropertyValueFactory("nome")
        );
        TBCDescricao.setCellValueFactory(
                new PropertyValueFactory("descricao")
        );
        TBCCarga.setCellValueFactory(
                new PropertyValueFactory("carga")
        );
        TBCTotaulas.setCellValueFactory(
                new PropertyValueFactory("totaulas")
        );
        TBCAno.setCellValueFactory(
                new PropertyValueFactory("ano")
        );
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Cliente cliente = new Cliente();

        Parent telaShow = FXMLLoader.load(
                getClass().getResource(
                        "/br/senac/javafxapp/pi3/telas/TelaPrincipal.fxml")
        );

        Scene scene = new Scene(telaShow);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        Stage prevStage = (Stage) BTBack.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void SearchType(ActionEvent event) {
    }

    @FXML
    private void Update(ActionEvent event) throws Exception {
        if (TBCSearchType.getValue() != null) {
            switch (TBCSearchType.getValue()) {

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

            TBLCursos.getItems().clear();

            //Obtém os resultados de pesquisa do mock
            //List resultados = listarPesquisar();
            List resultados = null;

            String tfsearch = TFSearch.getText();

            if (tfsearch.equals("") || tfsearch.equals(" ")) {

                resultados = DAOCursos.listar();
            } else {
                try {
                    resultados = DAOCursos.procurarNOME(tfsearch);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCursosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            TBLCursos.setItems(
                    FXCollections.observableArrayList(resultados)
            );

            TBCID.setCellValueFactory(
                    new PropertyValueFactory("idcurso")
            );
            TBCNome.setCellValueFactory(
                    new PropertyValueFactory("nome")
            );
            TBCDescricao.setCellValueFactory(
                    new PropertyValueFactory("descricao")
            );
            TBCCarga.setCellValueFactory(
                    new PropertyValueFactory("carga")
            );
            TBCTotaulas.setCellValueFactory(
                    new PropertyValueFactory("totaulas")
            );
            TBCAno.setCellValueFactory(
                    new PropertyValueFactory("ano")
            );

        }
        if (type == 2) {
//

            TBLCursos.getItems().clear();

            //Obtém os resultados de pesquisa do mock
            //List resultados = listarPesquisar();
            List resultados = null;

            String tfsearch = TFSearch.getText();
            int convert = Integer.parseInt(tfsearch);

            if (tfsearch.equals("") || tfsearch.equals(" ")) {

                resultados = DAOCursos.listar();
            } else {
                try {
                    resultados = DAOCursos.procurarID(convert);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCursosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            TBLCursos.setItems(
                    FXCollections.observableArrayList(resultados)
            );

            TBCID.setCellValueFactory(
                    new PropertyValueFactory("idcurso")
            );
            TBCNome.setCellValueFactory(
                    new PropertyValueFactory("nome")
            );
            TBCDescricao.setCellValueFactory(
                    new PropertyValueFactory("descricao")
            );
            TBCCarga.setCellValueFactory(
                    new PropertyValueFactory("carga")
            );
            TBCTotaulas.setCellValueFactory(
                    new PropertyValueFactory("totaulas")
            );
            TBCAno.setCellValueFactory(
                    new PropertyValueFactory("ano")
            );

        }

    }

}
