package br.com.view.viagem;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.viagemDao;
import br.com.model.viagem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


public class attviagem extends JFrame{
    

  JTextField descricaoField;
  JTextField dataPartidaField;
  JTextField dataChegadaField;
  JTextField EscalaIdField;
  JTextField LinhaIdField;
  JTextField viagemIdField;


   JPanel form;
    public attviagem(){
        super("GestBus :: Atualizar Viagem");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
JButton BEnviar;
JButton BLimpar;
 public void Carg(){
   JLabel NC = new JLabel("Atualizar Viagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));
    
   descricaoField = new JTextField();
   JLabel descricao = new JLabel("Descrição",JLabel.CENTER);
   descricaoField.setPreferredSize(new Dimension(200,30));
   JPanel PainelDescricao= new JPanel();
   PainelDescricao.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelDescricao.add(descricao);
   PainelDescricao.add(descricaoField);
   
   dataPartidaField = new JTextField();
   JLabel dataPartida = new JLabel("Data Partida",JLabel.CENTER);
   dataPartidaField.setPreferredSize(new Dimension(200,30));
  JPanel PaineldataPartida= new JPanel();
  PaineldataPartida.setLayout(new FlowLayout(FlowLayout.CENTER));
   PaineldataPartida.add(dataPartida);
   PaineldataPartida.add(dataPartidaField);

   dataChegadaField = new JTextField();
   JLabel dataChegada = new JLabel("Data Chegada",JLabel.CENTER);
   dataChegadaField.setPreferredSize(new Dimension(200,30));
  JPanel PaineldataChegada= new JPanel();
   PaineldataChegada.setLayout(new FlowLayout(FlowLayout.CENTER));
   PaineldataChegada.add(dataChegada);
   PaineldataChegada.add(dataChegadaField);

   EscalaIdField = new JTextField();
   JLabel EscalaId = new JLabel("Escala Id",JLabel.CENTER);
   EscalaIdField.setPreferredSize(new Dimension(200,30));
  JPanel PainelViaEscalaId= new JPanel();
    PainelViaEscalaId.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelViaEscalaId.add(EscalaId);
   PainelViaEscalaId.add(EscalaIdField);

   LinhaIdField = new JTextField();
   JLabel LinhaId = new JLabel("Linha Id",JLabel.CENTER);
   LinhaIdField.setPreferredSize(new Dimension(200,30));
  JPanel PainelLinhaId= new JPanel();
  PainelLinhaId.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelLinhaId.add(LinhaId);
   PainelLinhaId.add(LinhaIdField);

   viagemIdField = new JTextField();
   JLabel viagemId = new JLabel("Viagem Id",JLabel.CENTER);
   viagemIdField.setPreferredSize(new Dimension(200,30));
   JPanel PainelviagemId= new JPanel();
   PainelviagemId.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelviagemId.add(viagemId);
   PainelviagemId .add(viagemIdField);
   
   ArrayList<JLabel> labels = new ArrayList<>();
   labels.add(descricao);
   labels.add(dataPartida);
   labels.add(dataChegada);
   labels.add(EscalaId);
   labels.add(LinhaId);
   labels.add(viagemId);
   for (JLabel la : labels) {
       la.setFont(new Font("Segoi UI",Font.BOLD,20));
   }


   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));


    BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.GREEN);
    BEnviar.setForeground(Color.black);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

    BLimpar = new JButton("Limpar");
    BLimpar.setBackground(Color.blue);
    BLimpar.setForeground(Color.WHITE);
    BLimpar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JPanel PainelBotao = new JPanel();
    PainelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelBotao.add(BEnviar);
    PainelBotao.add(BLimpar);


   form= new JPanel();
   dadospes.add(NC);

   
   dadospes.add(PainelviagemId);
   dadospes.add(PainelDescricao);
   dadospes.add(PaineldataPartida); 
   dadospes.add(PaineldataChegada);
   dadospes.add(PainelViaEscalaId);
   dadospes.add(PainelLinhaId);
   dadospes.add(PainelBotao);
   form.add(dadospes);

    // inicializando objeto  viagemDao
    viagemDao vidao = new viagemDao();
  
    BEnviar.addActionListener(e->{
    String desc=descricaoField.getText();
    String  par=dataPartidaField.getText().trim();
    String che=dataChegadaField.getText().trim();
    int escalid=Integer.parseInt(EscalaIdField.getText().trim());
    int Lid =Integer.parseInt(LinhaIdField.getText().trim());
   int idv=Integer.parseInt(viagemIdField.getText().trim());
     viagem via = new viagem(idv,desc, par, che, escalid, Lid);

      try {
      vidao.Atualizar(via); 
      System.err.println("Salvo com Sucesso no banco de dados!! ");
    } catch (Exception d) {
      System.err.println("Error ao salvar :  "+d.getMessage());
    }

   });

   BLimpar.addActionListener(e ->{
    descricaoField.setText("");
    dataPartidaField.setText("");
    dataChegadaField.setText("");
    EscalaIdField.setText("");
    LinhaIdField.setText("");
   viagemIdField.setText("");
   });

   
 }



}
