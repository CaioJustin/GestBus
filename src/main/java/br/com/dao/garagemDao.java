package br.com.dao;



import br.com.conexao.connect;

import br.com.model.garagem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    

    public garagem ListarInformacao(int idc){
        String sql ="Select * from garagem where id_garagem=? ";

        try(Connection conn = connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,idc);
            ResultSet rs =stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id_garagem");
                String nome= rs.getString("nome");
                String cidade= rs.getString("cidade");
                String rua= rs.getString("rua");
            String bairro= rs.getString("bairro");
                String cep= rs.getString("cep");
                int vagas= rs.getInt("vagas");
                return new garagem(id,nome,cidade,rua,bairro,cep,vagas);
            }

        } catch (Exception e) {
            System.out.println("Error de : "+e.getMessage());
        }
      return null;
    }

      public void Atualizar(garagem idc){
            String sql = "update garagem set nome=?,cidade=?,rua=?,bairro=?,cep=?,vagas=? where id_garagem=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,idc.getNome());
            stmt.setString(2,idc.getCidade());
            stmt.setString(3,idc.getRua());
            stmt.setString(4,idc.getBairro());
            stmt.setString(5,idc.getCep());
            stmt.setInt(6,idc.getVagas());
            stmt.setInt(7,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
}

