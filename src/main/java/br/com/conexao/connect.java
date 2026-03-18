package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class connect {
    
    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL =dotenv.get("URL");
    private static final String KEY=dotenv.get("KEY");
    private static final String USER =dotenv.get("USER");

    public static Connection obterConexao() throws SQLException{
        return DriverManager.getConnection(URL, USER, KEY);
      
    }

}
