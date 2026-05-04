package br.com.dao;



import br.com.conexao.connect;
import br.com.model.escala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class escalaDao {
    
    public void Salvar(escala esc){
         String sql = "Insert into escala(horario_inicio,horario_fim) values (?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,esc.getHorarioInicio());
            stmt.setString(2,esc.getHorarioFim());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from escala where id_escala=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
