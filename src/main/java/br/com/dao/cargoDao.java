package br.com.dao;

import br.com.conexao.connect;
import br.com.model.cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cargoDao{


    public void Salvar(cargo cargs){
      String sql ="Insert into cargo(nome) values (?)";

        try(Connection conexao = connect.obterConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)){
                stmt.setString(1,cargs.GetNome());
                stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: Na hora de adicionar no banco : "+e.getMessage());
        }

    }

    public void Deletar(int del){
        String sql="Delete from cargo where id_Cargo =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,del);
            stmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }




}