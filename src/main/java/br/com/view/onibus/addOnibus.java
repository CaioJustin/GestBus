package br.com.view.onibus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
public class addOnibus extends JFrame{
    
  JTextField placaField;
   JTextField modeloField;
    JTextField anoField;
     JTextField capacidadeField;
       JTextField statusIdField;
        JTextField corIdField;
         JTextField garagemIdField;

   JPanel form;
        public addOnibus(){
        super("GestBus :: Adicionar Onibus ");
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

 public void Carg(){
   JLabel NC = new JLabel("Adicione o Onibus",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    
   placaField = new JTextField();
   modeloField = new JTextField();
   anoField = new JTextField();
   capacidadeField = new JTextField();
   statusIdField = new JTextField();
   corIdField = new JTextField();
   garagemIdField = new JTextField();

  ArrayList<JLabel> labels = new ArrayList<>();
   JLabel placa = new JLabel("Placa",JLabel.CENTER);
   JLabel modelo = new JLabel("modelo",JLabel.CENTER);
   JLabel ano = new JLabel("ano",JLabel.CENTER);
   JLabel capacidade = new JLabel("capacidade",JLabel.CENTER);
   JLabel status = new JLabel("status",JLabel.CENTER);
   JLabel cor = new JLabel("cor",JLabel.CENTER);
   JLabel garagem = new JLabel("garagem",JLabel.CENTER);
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
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));


   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);

    dadospes.add(placa);
    dadospes.add(placaField);

     dadospes.add(modelo);
    dadospes.add(modeloField);
    
     dadospes.add(ano);
    dadospes.add(anoField);

     dadospes.add(capacidade);
    dadospes.add(capacidadeField);

     dadospes.add(status);
    dadospes.add(statusIdField);

     dadospes.add(cor);
    dadospes.add(corIdField);

     dadospes.add(garagem);
    dadospes.add(garagemIdField);


   dadospes.add(BEnviar);
   form.add(dadospes);
 }
}
