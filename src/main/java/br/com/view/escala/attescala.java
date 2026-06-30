package br.com.view.escala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    setSize(400,400);
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
 JButton BLimpar;

 public void Carg(){

   //CRIANDO O TEXTO AUXILIAR
   JLabel text_auxiliar= new JLabel("Atualizar Escala : ",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));

    //Criando (id) label e input
    JLabel IDCargoLabel = new JLabel("ID da Escala : ",JLabel.CENTER);
    IDCargoLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
  IDcarField = new JTextField();
  IDcarField.setPreferredSize(new Dimension(200,30));
  JPanel PainelID = new JPanel();
   PainelID.setLayout(new FlowLayout(FlowLayout.CENTER));
  PainelID.add(IDCargoLabel);
  PainelID.add(IDcarField);

    //Criando (horario Inicio) label e input
   JLabel HIL = new JLabel("Horario de Inicio : ",JLabel.CENTER);
   HIL.setFont(new Font("Segoe UI",Font.BOLD,20));
    InputHorarioInicio = new JTextField();
    InputHorarioInicio.setPreferredSize(new Dimension(200,30));
    JPanel PainelHI =new JPanel();
    PainelHI.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelHI.add(HIL);
    PainelHI.add(InputHorarioInicio);

    //Criando (horario Fim) label e input
   JLabel HFL = new JLabel("Horario Final : ",JLabel.CENTER);
   HFL.setFont(new Font("Segoe UI",Font.BOLD,20));
    InputHorarioFim = new JTextField();
    InputHorarioFim.setPreferredSize(new Dimension(200,30));
   JPanel PainelHF = new JPanel();
   PainelHF.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelHF.add(HFL);
   PainelHF.add(InputHorarioFim);

    //Definindo botao de adicionar e Limpar 
    BEnviar = new JButton("Enviar");
    BLimpar = new JButton("Limpar");
   
    BEnviar.setBackground(Color.green);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

    BLimpar.setBackground(Color.BLUE);
    BLimpar.setForeground(Color.WHITE);
    BLimpar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JPanel PanelButton = new JPanel();
    PanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
    PanelButton.add(BEnviar);
    PanelButton.add(BLimpar);

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   //Adicionando os items 
   form= new JPanel();
   dadospes.add(text_auxiliar);
   dadospes.add(PainelID);
   dadospes.add(PainelHI);
   dadospes.add(PainelHF);
   dadospes.add(PanelButton);
   form.add(dadospes);

      escalaDao escD=new escalaDao();

      //AdicionandoFunção de Enviar no botao BEnviar 
    BEnviar.addActionListener(e ->{
      
      String HF = InputHorarioFim.getText().trim();
      String HI = InputHorarioInicio.getText().trim();
      int IDescala = Integer.parseInt(IDcarField.getText().trim());
      escala esc = new escala(IDescala,HI,HF);
      if(HF.isEmpty() || HI.isEmpty() || IDcarField== null){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          escD.Atualizar(esc);
          JOptionPane.showMessageDialog(null,"Atualizado com Sucesso !!");
      }

    });

    //Adicionando Função De limpar no botao BLimpar
      BLimpar.addActionListener(e ->{
        IDcarField.setText("");
      InputHorarioFim.setText("");
      InputHorarioInicio.setText("");
    });


 }


}
