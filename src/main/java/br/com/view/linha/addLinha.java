package br.com.view.linha;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.linhaDao;
import br.com.model.escala;
import br.com.model.linha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
public class addLinha extends JFrame{
 
  JTextField nomeField;
   JTextField origemField;
   JTextField destinoField;
JButton BEnviar;
   JPanel form;
        public addLinha(){
        super("GestBus :: Adicionar Linha ");
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
   JLabel NC = new JLabel("Adicionar Linha",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));

   ArrayList<JLabel> na = new ArrayList<>();
   JLabel Destino = new JLabel("Destino",JLabel.CENTER);
   JLabel Origem = new JLabel("Origem",JLabel.CENTER);
   JLabel Nome = new JLabel("Nome",JLabel.CENTER);
   na.add(Destino);
   na.add(Origem);
   na.add(Nome);

   for (JLabel j : na) {
        j.setFont(new Font("Segoe UI",Font.BOLD,20));
   }


    destinoField = new JTextField();
    origemField= new JTextField();
    nomeField= new JTextField();

     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();


   dadospes.add(NC);

   dadospes.add(Nome);
    dadospes.add(nomeField);

     dadospes.add(Origem);
    dadospes.add(origemField);

     dadospes.add(Destino);
    dadospes.add(destinoField);


   dadospes.add(BEnviar);
   form.add(dadospes);
  
   
    linhaDao linhaDAO= new linhaDao();

   BEnviar.addActionListener(e ->{
      String names = nomeField.getText().trim();
    String or = origemField.getText().trim();
    String df = destinoField.getText().trim();
    linha esc = new linha(names,or,df);
      if((names.isEmpty())||(or.isEmpty())||(df.isEmpty())){
          JOptionPane.showMessageDialog(null,"Algum Input vazio");
      }else{
        JOptionPane.showMessageDialog(null,"ESCALA ADICIONADA");
        linhaDAO.Salvar(esc);
      }


   });

 }
}
