package br.com.dao;

import br.com.conexao.connect;
import br.com.model.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.view.status.*;

public class statusDao {
    
    public void Salvar(status stats){
         String sql = "Insert into Status(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,stats.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }


}
