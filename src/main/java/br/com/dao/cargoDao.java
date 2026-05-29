package br.com.dao;

import br.com.conexao.connect;
import br.com.model.cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class cargoDao {
    
    public void Salvar(cargo car){
         String sql = "Insert into cargo(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,car.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from cargo where id_Cargo=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    
    public cargo ListarInformacao(int idC){
        String sql = "Select * from cargo where id_cargo =?";

        try(Connection conexao = connect.obterConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id =rs.getInt("ID_Cargo");
                String nome=rs.getString("nome");
                return new cargo(id,nome);
               
            }
            

        }catch(SQLException e ){
            System.err.println("Error de : "+e.getMessage());
        }
         return null;
    }

    public void Atualizar(cargo idc){
            String sql = "update cargo set nome=? where id_Cargo =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,idc.GetNome());
            stmt.setInt(2,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }

}
