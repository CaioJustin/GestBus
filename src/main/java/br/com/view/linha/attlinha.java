package br.com.view.linha;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import br.com.dao.linhaDao;
import br.com.model.linha;

public class attlinha extends JFrame{
    
  JTextField nomeField;
   JTextField origemField;
   JTextField destinoField;
  JTextField IdInputlinha;


   JPanel form;
        public attlinha(){
        super("GestBus :: Atualizar  Linha ");
        setSize(400,500);
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

 JButton BEnviar;
 JButton BLimpar;
 public void Carg(){
   
   JLabel NC = new JLabel("Atualizar Linha",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));

   JLabel Destino = new JLabel("Destino",JLabel.CENTER);
   destinoField = new JTextField();
   destinoField.setPreferredSize(new Dimension(200,30));
   JPanel PainelDs = new JPanel();
   PainelDs.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelDs.add(Destino);
   PainelDs.add(destinoField);

    JLabel Origem = new JLabel("Origem",JLabel.CENTER);
    origemField= new JTextField();
    origemField.setPreferredSize(new Dimension(200,30));
    JPanel PainelOrigem = new JPanel();
    PainelOrigem.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelOrigem.add(Origem);
    PainelOrigem.add(origemField);
   
    JLabel Nome = new JLabel("Nome",JLabel.CENTER);
    nomeField= new JTextField();
    nomeField.setPreferredSize(new Dimension(200,30));
    JPanel PainelNome = new JPanel();
    PainelNome.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelNome.add(Nome);
    PainelNome.add(nomeField);

   JLabel ids = new JLabel("iD",JLabel.CENTER); 
   IdInputlinha= new JTextField();
   IdInputlinha.setPreferredSize(new Dimension(200,30));
   JPanel PainelId = new JPanel();
   PainelId.setLayout(new FlowLayout(FlowLayout.CENTER));
   PainelId.add(ids);
   PainelId.add(IdInputlinha);

   
   ArrayList<JLabel> na = new ArrayList<>();
   na.add(Destino);
   na.add(Origem);
   na.add(Nome);
   na.add(ids);

   for (JLabel j : na) {
        j.setFont(new Font("Segoe UI",Font.BOLD,20));
   }



     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.green);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

    BLimpar = new JButton("Limpar");
    BLimpar.setBackground(Color.blue);
    BLimpar.setForeground(Color.white);
    BLimpar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JPanel Panelbotoes = new JPanel();
    Panelbotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
    Panelbotoes.add(BEnviar);
    Panelbotoes.add(BLimpar);

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();


   dadospes.add(NC);
    dadospes.add(PainelId);
    dadospes.add(PainelNome);
    dadospes.add(PainelOrigem);
    dadospes.add(PainelDs);
   dadospes.add(Panelbotoes);
   form.add(dadospes);

  linhaDao lindao=new linhaDao();
    BEnviar.addActionListener(e ->{
      String no = nomeField.getText().trim();
      String or= origemField.getText().trim();
      String ds = destinoField.getText().trim();
     int idl = Integer.parseInt(IdInputlinha.getText().trim());
      
      linha lin = new linha(idl,no,or,ds);
      if((no.isEmpty())||(or.isEmpty())||(ds.isEmpty())){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          lindao.Atualizar(lin);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }

    });

    BLimpar.addActionListener(e->{
      nomeField.setText("");
      origemField.setText("");
      destinoField.setText("");;
    });


 }
}
