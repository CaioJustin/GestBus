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

public class attescala extends JFrame{
    
    //Criando os campos de input da escala
   JTextField IDcarField;
    JTextField InputHorarioInicio;
   JTextField InputHorarioFim;

   JPanel form;
   //Metodo Construtor
 public  attescala(){
    super("GestBus :: Atualizar Escala");
    setSize(400,200);
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
 JButton BEnviar;
 public void Carg(){
   JLabel text_auxiliar= new JLabel("Atualizar Escala",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
    //Criando id label e input
    JLabel IDCargoLabel = new JLabel("Id da Escala",JLabel.CENTER);
   IDCargoLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
IDcarField = new JTextField();
    //Criando horario Inicio label e input
   JLabel HIL = new JLabel("Horario de Inicio",JLabel.CENTER);
   HIL.setFont(new Font("Segoe UI",Font.BOLD,20));
    InputHorarioInicio = new JTextField();
    //Criando horario Fim label e input
   JLabel HFL = new JLabel("Horario Final",JLabel.CENTER);
   HFL.setFont(new Font("Segoe UI",Font.BOLD,20));
    InputHorarioFim = new JTextField();
  

    //Definindo botao
     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(IDCargoLabel);
   dadospes.add(IDcarField);
    dadospes.add(HIL);
   dadospes.add(InputHorarioInicio);
    dadospes.add(HFL);
   dadospes.add(InputHorarioFim);
   dadospes.add(BEnviar);
   form.add(dadospes);

      escalaDao escD=new escalaDao();
    BEnviar.addActionListener(e ->{
      
      String HF = InputHorarioFim.getText().trim();
      String HI = InputHorarioInicio.getText().trim();
      int IDescala = Integer.parseInt(IDcarField.getText().trim());
      escala car = new escala(IDescala,HI,HF);
      if(HF.isEmpty() || HI.isEmpty()){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          escD.Atualizar(car);
          JOptionPane.showMessageDialog(null,"Atualizado com Sucesso !!");
      }

    });



 }


}
