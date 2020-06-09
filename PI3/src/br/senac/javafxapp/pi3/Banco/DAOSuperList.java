/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.Banco;

import br.senac.javafxapp.pi3.cliente.Cliente;
import br.senac.javafxapp.pi3.cliente.SuperListBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOSuperList {
    
    

    public static List<SuperListBean> listar()
            throws Exception {

        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM superlist;";

        //Lista de Alunos de resultado
        List<SuperListBean> listaAlunos = null;

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
            if (listaAlunos == null) {
                listaAlunos = new ArrayList<SuperListBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_professor(result.getString("nome_professor"));
            rel.setFK_id_aluno1(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));

//Adiciona a instância na lista
            listaAlunos.add(rel);

        }

        //Fecha o result        
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaAlunos;
    }

    public static List<SuperListBean> procurarNOME(String valor)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM superlist WHERE (nome_lista LIKE ?)";

        //Lista de clientes de resultado
        List<SuperListBean> listaAlunos = null;

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
            if (listaAlunos == null) {
                listaAlunos = new ArrayList<SuperListBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_professor(result.getString("nome_professor"));
            rel.setFK_id_curso(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));

            //Adiciona a instância na lista
            listaAlunos.add(rel);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaAlunos;

    }

    public static List<SuperListBean> procurarID(Integer valor)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM superlist WHERE (id_lista LIKE ?)";

        //Lista de clientes de resultado
        List<SuperListBean> listaAlunos = null;

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
        preparedStatement.setInt(1, valor);

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaAlunos == null) {
                listaAlunos = new ArrayList<SuperListBean>();
            }

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_professor(result.getString("nome_professor"));
            rel.setFK_id_curso(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));

            //Adiciona a instância na lista
            listaAlunos.add(rel);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaAlunos;

    }

    //Obtém uma instância da classe "SuperListBean" através de dados do
    //banco de dados, de acordo com o ID fornecido como parãmetro
    public static SuperListBean obter(Integer id)
            throws Exception {

        //Compãe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM superlist WHERE (id_lista=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão e execução de
        //comandos SQL
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setInt(1, id);

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Verifica se há pelo menos um resultado
        if (result.next()) {

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_lista(result.getString("nome_professor"));
            rel.setFK_id_aluno1(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));
            //Fecha o result
            result.close();

            //Fecha o statement
            preparedStatement.close();

            //Fecha a conexão
            connection.close();

            //Retorna o resultado
            return rel;

        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não hã um elemento a retornar, então retornamos "null"
        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        return null;

    }

    public static List<SuperListBean> listarProcurar(Integer id)
            throws Exception {
        
                SuperListBean beans = new SuperListBean();
        
                List<SuperListBean> listaAlunos = null;

        //Compãe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM superlist WHERE id_lista LIKE ?";

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
            if (listaAlunos == null) {
                listaAlunos = new ArrayList<SuperListBean>();
            }


        //Verifica se há pelo menos um resultado
        

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_professor(result.getString("nome_professor"));
            rel.setFK_id_curso(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));
            
                        //Adiciona a instância na lista
            listaAlunos.add(rel);
         }
        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaAlunos;

       

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não hã um elemento a retornar, então retornamos "null"


    }
                    public static List<SuperListBean> listarProcurarNome(String nome)
            throws Exception {
        
                SuperListBean beans = new SuperListBean();
        
                List<SuperListBean> listaAlunos = null;

        //Compãe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM superlist WHERE (nome_lista=?)";

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
        preparedStatement.setString(1, "%" + nome + "%");
       
        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaAlunos == null) {
                listaAlunos = new ArrayList<SuperListBean>();
            }


        //Verifica se há pelo menos um resultado
        if (result.next()) {

            //Cria uma instância de Cliente e popula com os valores do BD
            SuperListBean rel = new SuperListBean();
            rel.setId_lista(result.getInt("id_lista"));
            rel.setNome_lista(result.getString("nome_lista"));
            rel.setNome_professor(result.getString("nome_professor"));
            rel.setFK_id_aluno1(result.getInt("FK_id_curso"));
            rel.setFK_id_aluno1(result.getInt("FK_id_aluno1"));
            rel.setFK_id_aluno2(result.getInt("FK_id_aluno2"));
            rel.setId_aluno3(result.getInt("id_aluno3"));
            rel.setId_aluno4(result.getInt("id_aluno4"));
            rel.setId_aluno5(result.getInt("id_aluno5"));
            
                        //Adiciona a instância na lista
            listaAlunos.add(beans);
        }
        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaAlunos;

        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não hã um elemento a retornar, então retornamos "null"
        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        return null;

    }

    public static void inserir(SuperListBean superlist) throws Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO superlist (nome_lista, nome_professor, FK_id_curso, FK_id_aluno1, FK_id_aluno2, id_aluno3, id_aluno4, id_aluno5) "
                + " VALUES (?, ?, ?, ?, ?, ?,?, ?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão e execução de
        //comandos SQL
        PreparedStatement preparedStatement = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruções SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setString(1, superlist.getNome_lista());
        preparedStatement.setString(2, superlist.getNome_professor());
        preparedStatement.setInt(3, superlist.getFK_id_curso());
        preparedStatement.setInt(4, superlist.getFK_id_aluno1());
        preparedStatement.setInt(5, superlist.getFK_id_aluno2());
        preparedStatement.setInt(6, superlist.getId_aluno3());
        preparedStatement.setInt(7, superlist.getId_aluno4());
        preparedStatement.setInt(8, superlist.getId_aluno5());

        //Executa o comando no banco de dados
        preparedStatement.execute();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();
    }

}
