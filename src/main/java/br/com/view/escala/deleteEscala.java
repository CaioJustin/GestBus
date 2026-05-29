package br.com.view.escala;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


import br.com.dao.escalaDao;

public class deleteEscala extends JFrame{
JTextField carField;
   JPanel form;
        public deleteEscala(){
        super("GestBus :: Deletar Escala ");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        criarPanel();
    }


        public void criarPanel(){
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Carg();
   painel.add(form);
   
 }


 JButton BEnviar;
 public void Carg(){
   JLabel Vi = new JLabel("Id da Escala",JLabel.CENTER);
     Vi.setFont(new Font("Segoe UI",Font.BOLD,20));
   JLabel NC = new JLabel("Id da escala",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    carField = new JTextField();
     BEnviar = new JButton("Deletar");
    BEnviar.setBackground(Color.RED);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(Vi);
   dadospes.add(NC);
   dadospes.add(carField);
   dadospes.add(BEnviar);
   form.add(dadospes);


  
      escalaDao escd =new escalaDao();
    BEnviar.addActionListener(e ->{
      int CN = Integer.parseInt(carField.getText().trim());
      if(CN !=0){
          escd.Deletar(CN);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });


   }

}
