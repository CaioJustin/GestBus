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
 public void Carg(){
   JLabel NC = new JLabel("Atualizar Viagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));
    
   descricaoField = new JTextField();
   dataPartidaField = new JTextField();
   dataChegadaField = new JTextField();
   EscalaIdField = new JTextField();
   LinhaIdField = new JTextField();

   ArrayList<JLabel> labels = new ArrayList<>();
   JLabel descricao = new JLabel("Descrição",JLabel.CENTER);
   JLabel dataPartida = new JLabel("Data Partida",JLabel.CENTER);
   JLabel dataChegada = new JLabel("Data Chegada",JLabel.CENTER);
   JLabel EscalaId = new JLabel("Escala Id",JLabel.CENTER);
   JLabel LinhaId = new JLabel("Linha Id",JLabel.CENTER);
   JLabel viagemId = new JLabel("Linha Id",JLabel.CENTER);
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
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   form= new JPanel();
   dadospes.add(NC);

   dadospes.add(viagemId);
   dadospes.add(viagemIdField);
   
   dadospes.add(descricao);
   dadospes.add(descricaoField);

    dadospes.add(dataPartida);
   dadospes.add(dataPartidaField);

    dadospes.add(dataChegada);
   dadospes.add(dataChegadaField);

    dadospes.add(EscalaId);
   dadospes.add(EscalaIdField);

    dadospes.add(LinhaId);
   dadospes.add(LinhaIdField);



   dadospes.add(BEnviar);
   form.add(dadospes);

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


   
 }



}
