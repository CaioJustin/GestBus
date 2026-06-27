package br.com.dao;

import br.com.conexao.connect;

import br.com.model.viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class viagemDao {
    
    public void Salvar(viagem v){
         String sql = "Insert into viagem(descricao,data_partida,data_chegara,Escala_id,Linha_id) values (?,?,?,?,?) ";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setString(1,v.getDesc());
            stmt.setString(2,v.getDataPar());
            stmt.setString(3,v.getDataChe());
            stmt.setInt(4,v.getEscala());
            stmt.setInt(5,v.getLinha());
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }

    public void Deletar(int d){
         String sql = "Delete from viagem where id_viagem=?";

        try(Connection conexao =connect.obterConexao(); PreparedStatement stmt =conexao.prepareStatement(sql)){
            
            stmt.setInt(1,d);
            stmt.executeUpdate();
            

        } catch (SQLException e ) {
           System.err.println("Error : "+e);
        }


    }
    
    public viagem ListarInformacao(int idC){
        String sql = "Select * from viagem where id_viagem=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setInt(1, idC);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int idv=rs.getInt("id_viagem");
                String descv=rs.getString("descricao");
                String dataParv=rs.getString("data_partida");
                String dataCheV=rs.getString("data_chegara");
                int EscalaV=rs.getInt("Escala_id");
                int LinhaV=rs.getInt("Linha_id");
                return new viagem(idv,descv,dataParv,dataCheV,EscalaV,LinhaV);
            }


        } catch (Exception e) {
            System.out.println("Error d : "+e.getMessage());
        }
        return null;
    }

    public void Atualizar(viagem idc){
            String sql = "update viagem set descricao=?,data_partida=?,data_chegara=?,Escala_id=?,Linha_id=? where id_viagem =?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
        
            stmt.setString(1,idc.getDesc());
            stmt.setString(2,idc.getDataPar());
            stmt.setString(3,idc.getDataChe());
            stmt.setInt(4,idc.getEscala());
            stmt.setInt(5,idc.getLinha());
            stmt.setInt(6,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
}
