package br.com.view.viagem;

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
import java.util.ArrayList;
public class addViagem  extends JFrame{
     
  JTextField descricaoField;
  JTextField dataPartidaField;
  JTextField dataChegadaField;
  JTextField EscalaIdField;
  JTextField LinhaIdField;


   JPanel form;
    public addViagem(){
        super("GestBus :: Adicionar Viagem");
        setSize(400,600);
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
   JLabel NC = new JLabel("Adicionar Viagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));
    
   JLabel descricao = new JLabel("Descrição",JLabel.CENTER);
   descricaoField = new JTextField();
   descricaoField.setPreferredSize(new Dimension(200,30));
   JPanel PainelDescicao = new JPanel();
   PainelDescicao.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelDescicao.add(descricao);
   PainelDescicao.add(descricaoField);

   JLabel dataPartida = new JLabel("Data Partida",JLabel.CENTER);
   dataPartidaField = new JTextField();
   dataPartidaField.setPreferredSize(new Dimension(200,30));
   JPanel PainelDataPartida = new JPanel();
   PainelDataPartida.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelDataPartida.add(dataPartida);
    PainelDataPartida.add(dataPartidaField);

   JLabel dataChegada = new JLabel("Data Chegada",JLabel.CENTER);
     dataChegadaField = new JTextField();
     dataChegadaField.setPreferredSize(new Dimension(200,30));
     JPanel PainelDataChegada = new JPanel();
     PainelDataChegada.setLayout(new FlowLayout(FlowLayout.CENTER));
     PainelDataChegada.add(dataChegada);
     PainelDataChegada.add(dataChegadaField);

   JLabel EscalaId = new JLabel("Escala Id",JLabel.CENTER);
    EscalaIdField = new JTextField();
    EscalaIdField.setPreferredSize(new Dimension(200,30));
    JPanel PainelEscalaId = new JPanel();
 PainelEscalaId.setLayout(new FlowLayout(FlowLayout.CENTER));
     PainelEscalaId.add(EscalaId);
     PainelEscalaId.add(EscalaIdField);

   JLabel LinhaId = new JLabel("Linha Id",JLabel.CENTER);
   LinhaIdField = new JTextField();
   LinhaIdField.setPreferredSize(new Dimension(200,30));
   JPanel PainelLinhaId = new JPanel();
    PainelLinhaId.setLayout(new FlowLayout(FlowLayout.CENTER));
     PainelLinhaId.add(LinhaId);
     PainelLinhaId.add(LinhaIdField);
 

  

   ArrayList<JLabel> labels = new ArrayList<>();
   labels.add(descricao);
   labels.add(dataPartida);
   labels.add(dataChegada);
   labels.add(EscalaId);
   labels.add(LinhaId);

   for (JLabel la : labels) {
       la.setFont(new Font("Segoi UI",Font.BOLD,20));
   }


   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));


    BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.GREEN);
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

   form= new JPanel();
   dadospes.add(NC);
   dadospes.add(PainelDescicao);
   dadospes.add(PainelDataPartida);
   dadospes.add(PainelDataChegada);
   dadospes.add(PainelEscalaId);
   dadospes.add(PainelLinhaId);
   dadospes.add(PainelBotao);
   form.add(dadospes);

    viagemDao vidao = new viagemDao();
   BEnviar.addActionListener(e->{
    String desc=descricaoField.getText();
    String  par=dataPartidaField.getText().trim();
    String che=dataChegadaField.getText().trim();
    int escalid=Integer.parseInt(EscalaIdField.getText().trim());
    int Lid =Integer.parseInt(LinhaIdField.getText().trim());

     viagem via = new viagem(desc, par, che, escalid, Lid);

      try {
      vidao.Salvar(via);; 
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

   });

   
 }
}
