package br.com.view.onibus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.onibusDao;
import br.com.model.onibus;

public class attonibus extends JFrame {
   
  JTextField placaField;
   JTextField modeloField;
    JTextField anoField;
     JTextField capacidadeField;
       JTextField statusIdField;
        JTextField corIdField;
         JTextField garagemIdField;

   JPanel form;
        public attonibus(){
        super("GestBus :: Atualizar Onibus ");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        criarPanel();
    }
 public void criarPanel(){
   JLabel text_auxiliar= new JLabel("Atualizar Cor",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Carg();
   painel.add(form);
   
 }

 public void Carg(){
   JLabel NC = new JLabel("Atualizar o Onibus",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));

   
  JLabel placa = new JLabel("Placa",JLabel.CENTER);
   placaField = new JTextField();
  JPanel Painelplaca = new JPanel();
   placaField.setPreferredSize(new Dimension(200,30));
    Painelplaca.setLayout(new FlowLayout(FlowLayout.CENTER));
    Painelplaca.add(placa);
    Painelplaca.add(placaField);

  
    JLabel modelo = new JLabel("modelo",JLabel.CENTER);
   modeloField = new JTextField();
   modeloField.setPreferredSize(new Dimension(200,30));
  JPanel Painelmodelo = new JPanel();
    Painelmodelo.setLayout(new FlowLayout(FlowLayout.CENTER));
    Painelmodelo.add(modelo);
    Painelmodelo.add(modeloField);

   JLabel ano = new JLabel("ano",JLabel.CENTER);
   anoField = new JTextField();
   anoField.setPreferredSize(new Dimension(200,30));
  JPanel Painelano = new JPanel();
    Painelano.setLayout(new FlowLayout(FlowLayout.CENTER));
    Painelano.add(ano);
    Painelano.add(anoField);

   JLabel capacidade = new JLabel("capacidade",JLabel.CENTER);
   capacidadeField = new JTextField();
   capacidadeField.setPreferredSize(new Dimension(200,30));
  JPanel Painelcapacidade = new JPanel();
    Painelcapacidade.setLayout(new FlowLayout(FlowLayout.CENTER));
    Painelcapacidade.add(capacidade);
    Painelcapacidade.add(capacidadeField);

      JLabel status = new JLabel("status",JLabel.CENTER);
   statusIdField = new JTextField();
   statusIdField.setPreferredSize(new Dimension(200,30));
  JPanel PainelstatusId = new JPanel();
    PainelstatusId.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelstatusId.add(status);
    PainelstatusId.add(statusIdField);

   corIdField = new JTextField();
   JLabel cor = new JLabel("cor",JLabel.CENTER);
   corIdField.setPreferredSize(new Dimension(200,30));
  JPanel PainelcorId = new JPanel();
    PainelcorId.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelcorId.add(cor);
    PainelcorId.add(corIdField);

    garagemIdField = new JTextField();
   garagemIdField.setPreferredSize(new Dimension(200,30));
   JLabel garagem = new JLabel("garagem",JLabel.CENTER);
    JPanel PainelgaragemId = new JPanel();
    PainelgaragemId.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelgaragemId.add(garagem);
    PainelgaragemId.add(garagemIdField);

   
   
   
   


  ArrayList<JLabel> labels = new ArrayList<>();
    labels.add(placa);
    labels.add(modelo);
    labels.add(ano);
    labels.add(capacidade);
    labels.add(status);
    labels.add(cor);
    labels.add(garagem);
   

    for (JLabel l : labels) {
        l.setFont(new Font("Segoi UI",Font.BOLD,20));
    }


    JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.green);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

     JButton BLimpar = new JButton("Limpar");
    BLimpar.setBackground(Color.blue);
    BLimpar.setForeground(Color.WHITE);
    BLimpar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JPanel PainelBotao = new JPanel();
    PainelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelBotao.add(BEnviar);
    PainelBotao.add(BLimpar);

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);



 dadospes.add(Painelplaca);
    dadospes.add(Painelmodelo);
    dadospes.add(Painelano);
    dadospes.add(Painelcapacidade);
    dadospes.add(PainelstatusId);
    dadospes.add(PainelcorId);
    dadospes.add(PainelgaragemId);
   dadospes.add(PainelBotao);
   form.add(dadospes);


   onibusDao lindao=new onibusDao();
    BEnviar.addActionListener(e ->{
      int PF = Integer.parseInt(placaField.getText().trim());
      String mF= modeloField.getText().trim();
      String aF = anoField.getText().trim();
      int cap = Integer.parseInt(capacidadeField.getText().trim());
      int SIF = Integer.parseInt(statusIdField.getText().trim());
      int CIF = Integer.parseInt(corIdField.getText().trim());
      int GIF = Integer.parseInt(garagemIdField.getText().trim());

 

      
      onibus lin = new onibus(PF,mF,aF,cap,SIF,CIF,GIF); 
      lindao.Atualizar(lin);
      JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      

    });

     BLimpar.addActionListener(e ->{
           placaField.setText("");
      modeloField.setText("");
      anoField.setText("");
      capacidadeField.setText("");
      statusIdField.setText("");
      corIdField.setText("");
      garagemIdField.setText("");
    });

 }
}
