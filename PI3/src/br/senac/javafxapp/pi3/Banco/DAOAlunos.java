/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.Banco;

import br.senac.javafxapp.pi3.Banco.Banco;
import br.senac.javafxapp.pi3.cliente.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel.bfreitas1
 */
public class DAOAlunos {
    
    public static void inserir(Cliente cliente) throws Exception {
    //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO gafanhotos (nome,profissao, nascimento, sexo, peso, altura, nacionalidade) "
                + " VALUES (?, ?, ?, ?, ?, ?,?)";

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
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getProfissao());
        preparedStatement.setDate(3, Date.valueOf(cliente.getNascimento()));
        preparedStatement.setString(4, cliente.getSexo());
        preparedStatement.setFloat(5, cliente.getPeso());
        preparedStatement.setFloat(6, cliente.getAltura());
        preparedStatement.setString(7, cliente.getNacionalidade());
        

        

       

        //Executa o comando no banco de dados
        preparedStatement.execute();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();
    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(Cliente cliente)
            throws Exception {

        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE cliente SET nome=?, profissao =?, nascimento=?, sexo =?,"
                + " peso=?, altura =?, "
                + "nacionalidade=?"
                + " WHERE (id=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setInt(10, cliente.getId());
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getProfissao());
        preparedStatement.setDate(3, Date.valueOf(cliente.getNascimento()));
        preparedStatement.setString(4, cliente.getSexo());
        preparedStatement.setFloat(5, cliente.getPeso());
        preparedStatement.setFloat(6, cliente.getAltura());
        preparedStatement.setString(7, cliente.getNacionalidade());

            /**
     * id
     * cpf
     * nome
     * profissao
     * nascimento
     * sexo
     * peso
     * altura
     * nacionalidade
     */
        
      
        

        //Executa o comando no banco de dados
        preparedStatement.execute();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();
    }

    //Realiza a exclusão lógica de um cliente no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //cliente, configurando um atributo específico, a ser ignorado
    //em todas as consultas de cliente ("enabled").
    public static void excluir(Integer id) throws Exception {

        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "delete from gafanhotos WHERE (id=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão e execução de
        //comandos SQL
        PreparedStatement preparedStatement = null;

        //Abre uma conexão com o banco de dados
        connection = Banco.getConnection();

        //Cria um statement para execução de instruçães SQL
        preparedStatement = connection.prepareStatement(sql);

        //Configura os parâmetros do "PreparedStatement"
        preparedStatement.setInt(1, id);

        //Executa o comando no banco de dados
        preparedStatement.execute();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();
    }

    //Lista todos os clientes da tabela clientes
    public static List<Cliente> listar()
            throws Exception {
        
        

        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM gafanhotos;";

        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;

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
            if (listaClientes == null) {
                listaClientes = new ArrayList<Cliente>();
            }
            
            Date data = result.getDate("nascimento");
            LocalDate convert = data.toLocalDate() ;
            
            
            //Cria uma instância de Cliente e popula com os valores do BD
            Cliente cliente = new Cliente();
            cliente.setId(result.getInt("id"));
            cliente.setNome(result.getString("nome"));
            cliente.setProfissao(result.getString("profissao"));
            cliente.setNascimento(convert);
            cliente.setSexo(result.getString("sexo"));
            cliente.setPeso(result.getFloat("peso"));
            cliente.setAltura(result.getFloat("altura"));
            cliente.setNacionalidade(result.getString("nacionalidade"));
            
                        /**
     * id
     * cpf
     * nome
     * profissao
     * nascimento
     * sexo
     * peso
     * altura
     * nacionalidade
     */
            
            //Adiciona a instância na lista
            listaClientes.add(cliente);

        }

        //Fecha o result        
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaClientes;   
    }

    //Procura um cliente no banco de dados, de acordo com o nome passado como parãmetro
    public static List<Cliente> procurar(String valor)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM gafanhotos WHERE nome LIKE ?";

        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;

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
        preparedStatement.setString(1, "%"+valor + "%");
       
        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaClientes == null) {
                listaClientes = new ArrayList<Cliente>();
            }

            
           
                        Date data = result.getDate("nascimento");
            LocalDate convert = data.toLocalDate() ;
            //Cria uma instância de Cliente e popula com os valores do BD
            Cliente cliente = new Cliente();
            cliente.setId(result.getInt("id"));
            cliente.setNome(result.getString("nome"));
            cliente.setProfissao(result.getString("profissao"));
            cliente.setNascimento(convert);
            cliente.setSexo(result.getString("sexo"));
            cliente.setPeso(result.getFloat("peso"));
            cliente.setAltura(result.getFloat("altura"));
            cliente.setNacionalidade(result.getString("nacionalidade"));
            
                        /**
     * id
     * cpf
     * nome
     * profissao
     * nascimento
     * sexo
     * peso
     * altura
     * nacionalidade
     */
            

            //Adiciona a instância na lista
            listaClientes.add(cliente);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaClientes;

    }
    
        public static List<Cliente> procurarId(Integer valor)
            throws Exception {

        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parãmetro para busca na coluna de
        //nome. Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")		
        String sql = "SELECT * FROM gafanhotos WHERE (id LIKE ?)";

        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;

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
        preparedStatement.setInt(1,  valor);
       
        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Itera por cada item do resultado
        while (result.next()) {

            //Se a lista não foi inicializada, a inicializa
            if (listaClientes == null) {
                listaClientes = new ArrayList<Cliente>();
            }

            
           
                        Date data = result.getDate("nascimento");
            LocalDate convert = data.toLocalDate() ;
            //Cria uma instância de Cliente e popula com os valores do BD
            Cliente cliente = new Cliente();
            cliente.setId(result.getInt("id"));
            cliente.setNome(result.getString("nome"));
            cliente.setProfissao(result.getString("profissao"));
            cliente.setNascimento(convert);
            cliente.setSexo(result.getString("sexo"));
            cliente.setPeso(result.getFloat("peso"));
            cliente.setAltura(result.getFloat("altura"));
            cliente.setNacionalidade(result.getString("nacionalidade"));
            
                        /**
     * id
     * cpf
     * nome
     * profissao
     * nascimento
     * sexo
     * peso
     * altura
     * nacionalidade
     */
            

            //Adiciona a instância na lista
            listaClientes.add(cliente);

        }

        //Fecha o result
        result.close();

        //Fecha o statement
        preparedStatement.close();

        //Fecha a conexão
        connection.close();

        //Retorna a lista de clientes do banco de dados
        return listaClientes;

    }

    //Obtém uma instância da classe "Cliente" através de dados do
    //banco de dados, de acordo com o ID fornecido como parãmetro
    public static Cliente obter(Integer id)
            throws Exception {

        //Compãe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM gafanhotos WHERE (id=?)";

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
        preparedStatement.setBoolean(2, true);

        //Executa a consulta SQL no banco de dados
        result = preparedStatement.executeQuery();

        //Verifica se há pelo menos um resultado
        if (result.next()) {
            Date data = result.getDate("nascimento");
            LocalDate convert = data.toLocalDate() ;
            //Cria uma instância de Cliente e popula com os valores do BD
            Cliente cliente = new Cliente();
            cliente.setId(result.getInt("id"));
            cliente.setNome(result.getString("nome"));
          
            cliente.setNascimento(convert);
            String genero = result.getString("sexo");

            if ("F".equals(genero)) {
                cliente.setSexo("Feminino");
            } else {
                cliente.setSexo("Masculino");
            }

            //Fecha o result
            result.close();

            //Fecha o statement
            preparedStatement.close();

            //Fecha a conexão
            connection.close();

            //Retorna o resultado
            return cliente;

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
    
    
    
}