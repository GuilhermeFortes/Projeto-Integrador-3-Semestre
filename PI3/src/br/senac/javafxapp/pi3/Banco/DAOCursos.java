/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.Banco;

import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.CursosBean;
import br.senac.javafxapp.pi3.cliente.SuperListBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCursos {
    
    

    public static List<CursosBean> listar()
            throws Exception {

        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM cursos;";

        //Lista de Alunos de resultado
        List<CursosBean> listaCursos = null;

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão e execução de
        //comandos SQL
        PreparedStatement preparedStatement = null;
        //Armazenarã os resultados do banco de dados
        ResultSet result = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaCursos == null) {
                listaCursos = new ArrayList<CursosBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            CursosBean rel = new CursosBean();
            rel.setIdcurso(result.getInt("idcurso"));
            rel.setNome(result.getString("nome"));
            rel.setDescricao(result.getString("descricao"));
            rel.setCarga(result.getInt("carga"));
            rel.setTotaulas(result.getInt("totaulas"));
            rel.setAno(result.getInt("ano"));


//Adiciona a instância na lista
            listaCursos.add(rel);

        }

        //Fecha o result        
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaCursos;
    }
    
    public static List<CursosBean> procurarNOME(String valor)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM cursos WHERE (nome LIKE ?)";

        //Lista de clientes de resultado
        List<CursosBean> listaCursos = null;

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenarã os resultados do banco de dados
        ResultSet result = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setString(1, "%" + valor + "%");

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaCursos == null) {
                listaCursos = new ArrayList<CursosBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            CursosBean rel = new CursosBean();
            rel.setIdcurso(result.getInt("idcurso"));
            rel.setNome(result.getString("nome"));
            rel.setDescricao(result.getString("descricao"));
            rel.setCarga(result.getInt("carga"));
            rel.setTotaulas(result.getInt("totaulas"));
            rel.setAno(result.getInt("ano"));


            //Adiciona a instância na lista
            listaCursos.add(rel);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaCursos;

    }
    
        public static List<CursosBean> procurarID(int id)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM cursos WHERE (idcurso LIKE ?)";

        //Lista de clientes de resultado
        List<CursosBean> listaCursos = null;

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenarã os resultados do banco de dados
        ResultSet result = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setInt(1, id);

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaCursos == null) {
                listaCursos = new ArrayList<CursosBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            CursosBean rel = new CursosBean();
            rel.setIdcurso(result.getInt("idcurso"));
            rel.setNome(result.getString("nome"));
            rel.setDescricao(result.getString("descricao"));
            rel.setCarga(result.getInt("carga"));
            rel.setTotaulas(result.getInt("totaulas"));
            rel.setAno(result.getInt("ano"));


            //Adiciona a instância na lista
            listaCursos.add(rel);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaCursos;

    }
    
    
    
}