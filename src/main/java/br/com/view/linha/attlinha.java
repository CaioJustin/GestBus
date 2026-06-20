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

 public void Carg(){
   
   JLabel NC = new JLabel("Atualizar Linha",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));

   ArrayList<JLabel> na = new ArrayList<>();
   JLabel Destino = new JLabel("Destino",JLabel.CENTER);
   JLabel Origem = new JLabel("Origem",JLabel.CENTER);
   JLabel Nome = new JLabel("Nome",JLabel.CENTER);
   JLabel ids = new JLabel("iD",JLabel.CENTER);
   na.add(Destino);
   na.add(Origem);
   na.add(Nome);
   na.add(ids);

   for (JLabel j : na) {
        j.setFont(new Font("Segoe UI",Font.BOLD,20));
   }


    destinoField = new JTextField();
    origemField= new JTextField();
    nomeField= new JTextField();
    IdInputlinha= new JTextField();

    JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();


   dadospes.add(NC);

   dadospes.add(ids);
    dadospes.add(IdInputlinha);

   dadospes.add(Nome);
    dadospes.add(nomeField);

     dadospes.add(Origem);
    dadospes.add(origemField);

     dadospes.add(Destino);
    dadospes.add(destinoField);


   dadospes.add(BEnviar);
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



 }
}
