/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.javafxapp.pi3.Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Banco {

public static Connection getConnection() throws Exception {
    	
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Só tenta abrir uma conexão se não existir ou estiver fechada            
        //Endereço de conexão com o banco de dados
        String dbURL = "jdbc:mysql://localhost:3306/cadastro";
        
        //Propriedades para armazenamento de usuário e senha
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone", "UTC");
        
        //Realiza a conexão com o banco
/**        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(dbURL, properties);

* 
*/
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, "root", "");
            return connection;
        } catch (Exception ex) {
            return connection;
        }
        //Retorna a conexão
//        return connection;
    }
    
}
/**
 *         try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
 */