package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.conexao.connect;
import br.com.model.cor;


public class corDao {
        String sql ="Insert into cor(nome) values (?)";

    public void Salvar(cor Cors){

        try(Connection conexao=connect.obterConexao(); PreparedStatement stmt= conexao.prepareStatement(sql)){
            
            stmt.setString(1,Cors.GetNome());
            stmt.executeUpdate();


        } catch (Exception e) {
            System.out.println("CorDao Mensagem : "+e.getMessage());
        }


    }

     public void Deletar(int id_Deleter){
        String sql="Delete from cor where id_cor =? ";
        try(Connection conn =connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setInt(1,id_Deleter);
           stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("na hora de deletar error !!");
        }

    }


}
