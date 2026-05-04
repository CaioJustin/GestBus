package br.com.dao;


import br.com.conexao.connect;
import br.com.model.cor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class corDao {
    
    public void Salvar(cor cors){
         String sql = "Insert into Status(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,cors.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from cor where id_cor=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
    

