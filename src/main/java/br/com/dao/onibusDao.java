package br.com.dao;

import br.com.conexao.connect;

import br.com.model.onibus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class onibusDao {
    
    public void Salvar(onibus bus){
         String sql = "Insert into onibus(placa,modelo,anoDeFabric,capacidade,dataCriação,Status_id,Cor_id,Garagem_id) values (?,?,?,?,?,?,?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
               stmt.setInt(1, bus.getPlaca()); 
               stmt.setString(1, bus.getModelo()); 
               stmt.setString(1, bus.getAnoFabri()); 
               stmt.setInt(1, bus.getCapacidade()); 
               stmt.setString(1, bus.getdataCriacao()); 
               stmt.setInt(1, bus.getSta()); 
               stmt.setInt(1, bus.getCor()); 
               stmt.setInt(1, bus.getGaragem()); 
               stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from onibus where id_onibus=?";

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
