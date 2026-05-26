package br.com.dao;

import br.com.conexao.connect;
import br.com.model.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class statusDao {
    
    public void Salvar(status stats){
         String sql = "Insert into status(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,stats.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from status where id_status=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    
    public status ListarInformacao(int idC){
        String sql = "Select * from status where id_status=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int statsid=rs.getInt("id_status");
                String statsname=rs.getString("nome");
                return new status(statsid,statsname);
            }


        } catch (Exception e) {
            System.out.println("Error d : "+e.getMessage());
        }
        return null;
    }

}
