package br.com.dao;

import br.com.conexao.connect;
import br.com.model.cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class cargoDao {
    
    public void Salvar(cargo car){
         String sql = "Insert into cargo(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,car.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from cargo where id_Cargo=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
