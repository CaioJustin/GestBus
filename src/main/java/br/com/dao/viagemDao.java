package br.com.dao;

import br.com.conexao.connect;
import br.com.model.status;
import br.com.model.viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.view.viagem.*;

public class viagemDao {
    
    public void Salvar(viagem v){
         String sql = "Insert into viagem(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,v.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from viagem where id_viagem=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
