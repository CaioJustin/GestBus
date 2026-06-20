package br.com.dao;

<<<<<<< HEAD
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
=======

import br.com.conexao.connect;
import br.com.model.linha;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class linhaDao {
    
    public void Salvar(linha lin){
         String sql = "Insert into linha(nome,origem,destino) values (?,?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
>>>>>>> telas
            stmt.setString(1,lin.getNome());
            stmt.setString(2,lin.getOrigem());
            stmt.setString(3,lin.getDestino());
            stmt.executeUpdate();
<<<<<<< HEAD
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
    
=======
            

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
    
    public linha ListarInformacao(int idC){
        String sql = "Select * from linha where id_linha=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int idl=rs.getInt("id_linha");
                String nome=rs.getString("nome");
                String origem=rs.getString("origem");
                String destino=rs.getString("destino");
                return new linha(idl,nome,origem,destino);
            }


        } catch (Exception e) {
            System.out.println("Error d : "+e.getMessage());
        }
        return null;
    }

    public void Atualizar(linha idc){
            String sql = "update linha set nome=?,origem=?,destino=? where id_linha =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
           stmt.setString(1, idc.getNome());
           stmt.setString(2,idc.getOrigem());
           stmt.setString(3, idc.getDestino());
           stmt.setInt(4,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
>>>>>>> telas
}
