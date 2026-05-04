package br.com.dao;


import br.com.conexao.connect;
import br.com.model.linha;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class linhaDao {
    
    public void Salvar(linha lin){
         String sql = "Insert into linha(nome,origem,destino) values (?,?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,lin.getNome());
            stmt.setString(2,lin.getOrigem());
            stmt.setString(3,lin.getDestino());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from linha where id_linha=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
