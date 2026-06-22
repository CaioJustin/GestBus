package br.com.dao;



import br.com.conexao.connect;
import br.com.model.funcionario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;







public class funcionarioDao {
     int idcarg,idescal,idstatus;
    public void Salvar(funcionario func){
         String sql = "Insert into funcionario(nome,sobrenome,cpf,datanascimento,Cargo_id,Status_id,Escala_id) values (?,?,?,?,?,?)";
         String sqlCargo="select * from cargo where id_Cargo=?";
         String sqlstatus="select * from status where id_status =?";
         String sqlEscala="select * from escala where id_escala =?";

         idcarg=0;
         idescal=0;
         idstatus=0;

         try(Connection conn = connect.obterConexao()){

            //Buscando o id do Cargo
         try(PreparedStatement stmt =conn.prepareStatement(sqlCargo)){
            stmt.setInt(1, func.getCargo());
            ResultSet rscarg =stmt.executeQuery();

            if(rscarg.next()){
                idcarg=rscarg.getInt("id_Cargo");
                System.err.println("\nCargo encontrado : "+idcarg);
            }else{
                System.err.println("\nCargo não encontrado");
            }
            
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de Cargo");
         }
            
         //Buscando o id do Status
          try(PreparedStatement stmt =conn.prepareStatement(sqlstatus)){
            stmt.setInt(1, func.getSta());
             ResultSet rsStatus = stmt.executeQuery();

             if(rsStatus.next()){
                idstatus= rsStatus.getInt("id_status");
                System.err.println("\nStatus encontrado : "+idstatus);
             }else{
                System.err.println("\nStatus não encontrado");
             }

         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Status");
         }

         //Buscando o id da Escala
          try(PreparedStatement stmt =conn.prepareStatement(sqlEscala)){
              stmt.setInt(1, func.getEscala());
                ResultSet rsEscala = stmt.executeQuery();

            if(rsEscala.next()){
                idescal=rsEscala.getInt("id_escala");
                System.err.println("\nEscala encontrado : "+idescal);
            }else{
                System.err.println("\nEscala não encontrado");
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Escala");
         }

         //Salvando Funcionario
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
              stmt.setString(1,func.getNome());
            stmt.setString(2,func.getSobrenome());
            stmt.setString(3,func.getCpf());
            stmt.setString(4, func.getDataNas());
            stmt.setInt(5,idcarg);
            stmt.setInt(6,idstatus);
            stmt.setInt(7,idescal);
            stmt.executeUpdate();
            
         } catch (Exception e) {
            System.err.println("Não Foi Possivel adicionar esse Funcionario Error : "+e);
         }


         } catch (Exception e) {
            System.err.println("\n Não Foi Possivel ativar o evento Salvar Funcionario "+" \n Error de : "+e);
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
    

    public void Atualizar(funcionario idc){
            String sql = "update funcionario set nome=?,sobrenome=?,cpf=?,datanascimento=?,Cargo_id=?,Status=?,Escala_id where id=?";
        try(Connection conn = connect.obterConexao(); PreparedStatement stmt =conn.prepareStatement(sql)){
            stmt.setString(1,idc.getNome());
            stmt.setString(2,idc.getSobrenome());
            stmt.setString(3,idc.getCpf());
            stmt.setString(4,idc.getDataNas());
            stmt.setInt(5,idc.getCargo());
            stmt.setInt(6,idc.getSta());
            stmt.setInt(7,idc.getEscala());
            stmt.setInt(8,idc.Getid());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error de : "+e.getMessage());
        }



    }
}
