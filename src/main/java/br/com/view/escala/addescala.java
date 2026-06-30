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
  JButton BLimpar;
 public void Carg(){
  
  
  JLabel Vi = new JLabel("Adicionar Escala",JLabel.CENTER);
  Vi.setFont(new Font("Segoe UI",Font.BOLD,30));
  Vi.setFont(new Font("Segoe UI",Font.BOLD,20));
   
  
  JLabel HI = new JLabel("Horario Inicio",JLabel.CENTER);
  HI.setFont(new Font("Segoe UI",Font.BOLD,20));
  InputHorarioInicio = new JTextField();
  InputHorarioInicio.setPreferredSize(new Dimension(200,30));
  JPanel PainelHI=new JPanel();
  PainelHI.setLayout(new FlowLayout(FlowLayout.CENTER));
  PainelHI.add(HI);
  PainelHI.add(InputHorarioInicio);


    InputHorarioFim = new JTextField();
    InputHorarioFim.setPreferredSize(new Dimension(200,30));
    JLabel HF =new JLabel("Horario Fim",JLabel.CENTER);
    HF.setFont(new Font("Segoe UI",Font.BOLD,20));
    JPanel PainelHF = new JPanel();
    PainelHF.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelHF.add(HF);
    PainelHF.add(InputHorarioFim);


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





   form= new JPanel();
   
  dadospes.add(Vi);
  dadospes.add(PainelHI);
  dadospes.add(PainelHF);
  dadospes.add(PanelButton);
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

    BLimpar.addActionListener(e ->{
      InputHorarioFim.setText("");
      InputHorarioInicio.setText("");
    });

 }

}
