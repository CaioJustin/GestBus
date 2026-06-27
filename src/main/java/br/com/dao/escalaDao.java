package br.com.dao;



import br.com.conexao.connect;
import br.com.model.escala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
     public escala ListarInformacao(int idC){
        String sql = "Select * from escala where id_escala =?";

        try(Connection conexao = connect.obterConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id =rs.getInt("id_escala");
                String Hi=rs.getString("horario_inicio");
                String Hf=rs.getString("horario_fim");
                String date=rs.getString("data_criar");
                return new escala(id,Hf,Hi,date);
               
            }
            

        }catch(SQLException e ){
            System.err.println("Error de : "+e.getMessage());
        }
         return null;
    }

    public void Atualizar(escala idc){
            String sql = "update escala set horario_inicio=?,horario_fim=? where id_escala =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,idc.getHorarioInicio());
            stmt.setString(2,idc.getHorarioFim());
            stmt.setInt(3, idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
}
