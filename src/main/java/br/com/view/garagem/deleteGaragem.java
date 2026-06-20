package br.com.view.garagem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


import br.com.dao.garagemDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class deleteGaragem extends JFrame{
     JTextField corField;
   JPanel form;
    public deleteGaragem(){
        super("GestBust :: Deletar Garagem");
        setSize(400,300);
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
   JLabel text_auxiliar= new JLabel("Deletar Garagem",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
   JLabel NC = new JLabel("Id da Garagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    corField = new JTextField();
    JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(NC);
   dadospes.add(corField);
   dadospes.add(BEnviar);
   form.add(dadospes);



     garagemDao garaD =new garagemDao();
    BEnviar.addActionListener(e ->{
      int GD = Integer.parseInt(corField.getText().trim());
      if(GD !=0){
          garaD.Deletar(GD);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });








 }
}
