package br.com.view.cor;
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


import br.com.dao.corDao;

public class deleteCor extends JFrame{

JTextField carField;
   JPanel form;
     public deleteCor(){
        super("GestBuss :: Deletar Cor");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        criarPanel();
     }

         public void criarPanel(){
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Corex();
   painel.add(form);
   
 }


JButton BEnviar;
 public void Corex(){
   JLabel text_auxiliar= new JLabel("Deletar Cor",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
   JLabel NC = new JLabel("Id da Cor",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    carField = new JTextField();
     BEnviar = new JButton("Deletar");
    BEnviar.setBackground(Color.RED);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(NC);
   dadospes.add(carField);
   dadospes.add(BEnviar);
   form.add(dadospes);


      corDao CD =new corDao();
    BEnviar.addActionListener(e ->{
      int CN = Integer.parseInt(carField.getText().trim());
      if(CN !=0){
          CD.Deletar(CN);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });

   }


}
