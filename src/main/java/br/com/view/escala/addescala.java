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
import br.com.model.escala;

public class addescala extends JFrame{
   JTextField InputHorarioInicio;
   JTextField InputHorarioFim;
   JPanel form;

        public addescala(){
        super("GestBus :: Adicionar Escala ");
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
  JButton BEnviar ;
 public void Carg(){
  JLabel Vi = new JLabel("Adicionar Escala",JLabel.CENTER);
   JLabel HI = new JLabel("Horario Inicio",JLabel.CENTER);
   JLabel HF =new JLabel("Horario Fim",JLabel.CENTER);
   HI.setFont(new Font("Segoe UI",Font.BOLD,20));
   HF.setFont(new Font("Segoe UI",Font.BOLD,20));
  Vi.setFont(new Font("Segoe UI",Font.BOLD,20));
    InputHorarioInicio = new JTextField();
    InputHorarioFim = new JTextField();

     BEnviar = new JButton("Enviar");
   
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));





   form= new JPanel();
  dadospes.add(Vi);

   dadospes.add(HI);
   dadospes.add(InputHorarioInicio);

    dadospes.add(HF);
   dadospes.add(InputHorarioFim);

   dadospes.add(BEnviar);
   form.add(dadospes);


       escalaDao escdao=new escalaDao();
    BEnviar.addActionListener(e ->{
      String hi = InputHorarioInicio.getText().trim();
      String hf = InputHorarioFim.getText().trim();
      
      escala esc = new escala(hi,hf);
      if((hi.isEmpty())|| (hf.isEmpty())){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          escdao.Salvar(esc);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }

    });

 }

}
