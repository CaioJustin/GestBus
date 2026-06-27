package br.com.dao;

import br.com.conexao.connect;

import br.com.model.onibus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class onibusDao {
       int corID,garagemID,statusID;
    public void Salvar(onibus bus){
         String sql = "Insert into onibus(placa,modelo,anoDeFabric,capacidade,dataCriação,Status_id,Cor_id,Garagem_id) values (?,?,?,?,?,?,?,?) ";
         String sqlStatus="Select * from status where id_status=? ";
         String sqlCor="Select * from cor where id_cor=?";
         String sqlGaragem="Select * from garagem where id_garagem=?";
      

        try(Connection conexao = connect.obterConexao()){

             try (PreparedStatement stmt = conexao.prepareStatement(sqlStatus)) {
                stmt.setInt(1, bus.getSta());
                ResultSet staid=stmt.executeQuery();

                if(staid.next()){
                 statusID=staid.getInt("id_status");
                }
                
         } catch (Exception e) {
           System.out.println("\nError na hora de busca o id do status");
         }

            try (PreparedStatement stmt = conexao.prepareStatement(sqlCor)) {
                stmt.setInt(1, bus.getCor());
                ResultSet Corid=stmt.executeQuery();
                 
                if(Corid.next()){
                  corID =Corid.getInt("id_cor");
                }

         } catch (Exception e) {
           System.out.println("\nError na hora de busca o id da Cor");
         }

            try (PreparedStatement stmt = conexao.prepareStatement(sqlGaragem)) {
                stmt.setInt(1, bus.getGaragem());
                ResultSet Garid=stmt.executeQuery();

                if(Garid.next()){
                    garagemID=Garid.getInt("id_garagem");
                }
                
         } catch (Exception e) {
           System.out.println("\nError na hora de busca o id da Garagem");
         }


        } catch (Exception e) {
            
        }

        

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
               stmt.setInt(1, bus.getPlaca()); 
               stmt.setString(2, bus.getModelo()); 
               stmt.setString(3, bus.getAnoFabri()); 
               stmt.setInt(4, bus.getCapacidade()); 
               stmt.setString(5, bus.getdataCriacao()); 
               stmt.setInt(6,statusID); 
               stmt.setInt(7,corID); 
               stmt.setInt(8, garagemID); 
               stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from onibus where placa=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    
     public onibus ListarInformacao(int idC){
        String sql = "Select * from onibus where placa=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int placaOni=rs.getInt("placa");
                String modeloOni=rs.getString("modelo");
                String anoFabricOni=rs.getString("anoDeFabric");
                int capacidadeOni=rs.getInt("capacidade");
                String dataCriacaoOni=rs.getString("dataCriação");
                int statusidOni=rs.getInt("Status_id");
                int coridOni=rs.getInt("Cor_id");
                int garagemidOni=rs.getInt("Garagem_id");
                return new onibus(placaOni,modeloOni,anoFabricOni,capacidadeOni,statusidOni,coridOni,garagemidOni,dataCriacaoOni);
            }
            

        } catch (Exception e) {
            System.out.println("Error d : "+e.getMessage());
        }
        return null;
    }


    public void Atualizar(onibus idc){
            String sql = "update onibus set modelo=?,anoDeFabric=?,capacidade=?,dataCriação=?,Status_id=?,Cor_id=?,Garagem_id=? where placa =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
             stmt.setString(1, idc.getModelo());
             stmt.setString(2, idc.getAnoFabri());
             stmt.setInt(3, idc.getCapacidade());
             stmt.setString(4, idc.getdataCriacao());
             stmt.setInt(5, idc.getSta());
             stmt.setInt(6, idc.getCor());
             stmt.setInt(7, idc.getGaragem());
             stmt.setInt(8, idc.getPlaca());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
}
