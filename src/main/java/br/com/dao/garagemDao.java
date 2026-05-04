package br.com.dao;



import br.com.conexao.connect;
import br.com.model.garagem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class garagemDao {
    
    public void Salvar(garagem gara){
         String sql = "Insert into garagem(nome,cidade,rua,bairro,cep,vagas) values (?,?,?,?,?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,gara.getNome());
            stmt.setString(2,gara.getCidade());
            stmt.setString(3,gara.getRua());
            stmt.setString(4,gara.getBairro());
            stmt.setString(5,gara.getCep());
            stmt.setInt(6,gara.getVagas());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from garagem where id_garagem=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}

