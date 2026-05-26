package br.com.dao;



import br.com.conexao.connect;
import br.com.model.funcionario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

      public funcionario ListarInformacao(int idC){
        String sql = "Select * from funcionario where id =?";

        try(Connection conexao = connect.obterConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id =rs.getInt("id");
                String nome=rs.getString("nome");
                String sobrenome=rs.getString("sobrenome");
                String cpf=rs.getString("cpf");
                String data=rs.getString("datanascimento");
                int Cargo=rs.getInt("Cargo_id");
                int Status=rs.getInt("Status_id");
                int Escala=rs.getInt("Escala_id");
                return new funcionario(id,nome,sobrenome,cpf,Status,Cargo,Escala,data);
               
            }
            

        }catch(SQLException e ){
            System.err.println("Error de : "+e.getMessage());
        }
         return null;
    }
    


}
