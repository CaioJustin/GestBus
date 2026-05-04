package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.conexao.connect;
import br.com.model.cargo;
import br.com.model.linha;

public class linhaDao {
    
    
    public void Salvar(linha lin){
          String sql= "Insert into linha(nome,origem,destino) values(?,?,?)";  
        try(Connection conn=connect.obterConexao(); PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1,lin.getNome());
            stmt.setString(2,lin.getOrigem());
            stmt.setString(3,lin.getDestino());
            stmt.executeUpdate();
        } catch (Exception e) {
           System.err.println("Erro de : "+e.getMessage());
        }

    }

    public void Deletar(int id_Linha){
        String sql="Delete from linha where id_status =? ";
        try(Connection conn =connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setInt(1,id_Linha);
           stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("na hora de deletar error !!");
        }

    }
    
}
