package br.com.view.status;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.statusDao;
import br.com.model.status;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
public class attstatus  extends JFrame{
      JTextField nameStatusField;
      JTextField idField;
   JPanel form;
   JButton BEnviar;
JLabel NC;
    public attstatus(){
        super("GestBus :: Atualizar Status");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        criarPanel();
    }

 public void criarPanel(){
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Carg();
   painel.add(form);
   
 }


 public void Carg(){
   JLabel text_auxiliar= new JLabel("Atualizar Status",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));

   JLabel IdCampo = new JLabel("Id Dos status ",JLabel.CENTER);
   IdCampo.setFont(new Font("Segoe UI",Font.BOLD,20));
    idField = new JTextField();


    NC = new JLabel("Nome do Status",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    nameStatusField = new JTextField();
     BEnviar = new JButton("Adicionar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(IdCampo);
   dadospes.add(idField);
   dadospes.add(NC);
   dadospes.add(nameStatusField);
   dadospes.add(BEnviar);
   form.add(dadospes);
  

  

   statusDao StatusDao = new statusDao();

  BEnviar.addActionListener(e ->{
      String nomeStats = nameStatusField.getText().trim();
      int idcampo = Integer.parseInt(idField.getText().trim());
    status stats = new status(idcampo,nomeStats);
    
    try {
      StatusDao.Atualizar(stats); 
      System.err.println("Salvo com Sucesso no banco de dados!! ");
    } catch (Exception d) {
      System.err.println("Error ao salvar :  "+d.getMessage());
    }


  });

   nameStatusField.setText("");

 }

}
