package br.com.dao;

import br.com.conexao.connect;
import br.com.model.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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

    
    public void Deletar(int id_Deleter){
        String sql="Delete from status where id_status =? ";
        try(Connection conn =connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setInt(1,id_Deleter);
           stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("na hora de deletar error !!");
        }

    }
}
