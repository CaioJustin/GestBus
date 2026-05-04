package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.conexao.connect;
import br.com.model.escala;

public class escalaDao {
    
    String sql ="Insert into escala(horario_inicio,horario_fim) values(?,?)";
    public void Salvar(escala esc){

        try(Connection conn =connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,esc.getHorarioInicio());
            stmt.setString(2,esc.getHorarioFim());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error de : "+e.getMessage());
        }


    }

    public void Deletar(int del){

        String sql = "delete from escala where id_escala = ?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,del);
                stmt.executeUpdate();
        } catch (Exception e) {
             System.err.println("Error de : "+e.getMessage());
        }

    }


}
