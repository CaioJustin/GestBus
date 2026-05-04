package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;

import br.com.conexao.*;
import br.com.model.garagem;
public class garagemDao {
    
    String sql = "Insert into garagem(nome,cidade,rua,bairro,cep,vagas) values(?,?,?,?,?,?)";

    public void Salvar(garagem gam){

        try(Connection conn=connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1,gam.getNome());
            stmt.setString(2,gam.getCidade());
            stmt.setString(3,gam.getRua());
            stmt.setString(4,gam.getBairro());
            stmt.setString(5,gam.getCep());
            stmt.setInt(6,gam.getVagas());
            stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro de : "+e.getMessage());
        }

    }

}
