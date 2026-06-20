package br.com.dao;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
=======
>>>>>>> telas

import br.com.conexao.connect;
import br.com.model.cor;


<<<<<<< HEAD
public class corDao {
        String sql ="Insert into cor(nome) values (?)";

    public void Salvar(cor Cors){

        try(Connection conexao=connect.obterConexao(); PreparedStatement stmt= conexao.prepareStatement(sql)){
            
            stmt.setString(1,Cors.GetNome());
            stmt.executeUpdate();


        } catch (Exception e) {
            System.out.println("CorDao Mensagem : "+e.getMessage());
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class corDao {
    
    public void Salvar(cor cors){
         String sql = "Insert into Status(nome) values (?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,cors.GetNome());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
>>>>>>> telas
        }


    }

<<<<<<< HEAD
     public void Deletar(int id_Deleter){
        String sql="Delete from cor where id_cor =? ";
        try(Connection conn =connect.obterConexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setInt(1,id_Deleter);
           stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("na hora de deletar error !!");
        }

    }


=======
    public void Deletar(int d){
         String sql = "Delete from cor where id_cor=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    
     public cor ListarInformacao(int idC){
        String sql = "Select * from cor where id_cor =?";

        try(Connection conexao = connect.obterConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id =rs.getInt("id_cor");
                String nome=rs.getString("nome");
                return new cor(id,nome);
               
            }
            

        }catch(SQLException e ){
            System.err.println("Error de : "+e.getMessage());
        }
         return null;
    }


    public void Atualizar(cor idc){
            String sql = "update cor set nome=? where id_cor =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,idc.GetNome());
            stmt.setInt(2,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }

>>>>>>> telas
}
    

