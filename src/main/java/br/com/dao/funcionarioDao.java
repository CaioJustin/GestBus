package br.com.dao;



import br.com.conexao.connect;
import br.com.model.funcionario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class funcionarioDao {
    
    public void Salvar(funcionario func){
         String sql = "Insert into funcionario(nome,sobrenome,cpf,Cargo_id,Status_id,Escala_id) values (?,?,?,?,?,?)";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,func.getNome());
            stmt.setString(2,func.getSobrenome());
            stmt.setString(3,func.getCpf());
            stmt.setInt(4,func.getCargo());
            stmt.setInt(5,func.getSta());
            stmt.setInt(6,func.getEscala());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from funcionario where id=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    


}
