package br.com.view.linha;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


import br.com.dao.linhaDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class deleteLinha extends JFrame{
         JTextField cargField;
   JPanel form;
    public deleteLinha(){
        super("GestBus :: Deletar Linha ");
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

 public void Carg(){
   JLabel text_auxiliar= new JLabel("Deletar Linha",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
   JLabel NC = new JLabel("Id da linha",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    cargField = new JTextField();
    JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(NC);
   dadospes.add(cargField);
   dadospes.add(BEnviar);
   form.add(dadospes);




    linhaDao garaD =new linhaDao();
    BEnviar.addActionListener(e ->{
      int GD = Integer.parseInt(cargField.getText().trim());
      if(GD !=0){
          garaD.Deletar(GD);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });





 }
}
