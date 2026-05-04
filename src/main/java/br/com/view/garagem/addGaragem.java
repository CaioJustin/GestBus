package br.com.view.garagem;


import java.awt.Color;
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

import br.com.dao.garagemDao;
import br.com.model.garagem;

public class addGaragem extends JFrame{
       JTextField nomeField;
        JTextField cidadeField;
         JTextField ruaField;
          JTextField bairroField;
           JTextField cepField;
            JTextField vagasField;
     JPanel form;
 JButton BEnviar;

    
         String Nome ;
     String Cidade;
     String Rua;
     String Bairro;
     String Cep;
     int Vagas;

    public addGaragem(){
        super("GstBus :: Garagem");
        setSize(400,800);
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

 public void Carg(){
   JLabel NC = new JLabel("Adicionar Garagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));


    ArrayList<JLabel> names = new ArrayList<>();
    JLabel nome =new JLabel("Nome",JLabel.CENTER);
    JLabel cidade =new JLabel("Cidade",JLabel.CENTER);
    JLabel rua =new JLabel("Rua",JLabel.CENTER);
    JLabel bairro =new JLabel("Bairro",JLabel.CENTER);
    JLabel cep =new JLabel("Cep",JLabel.CENTER);
    JLabel vagas =new JLabel("Vagas",JLabel.CENTER);

    names.add(nome);
    names.add(cidade);
    names.add(rua);
    names.add(bairro);
    names.add(cep);
    names.add(vagas);

     nomeField = new JTextField();
    cidadeField = new JTextField();
    ruaField = new JTextField();
    bairroField = new JTextField();
    cepField = new JTextField();
    vagasField = new JTextField();



    for (JLabel n : names) {
        n.setFont(new Font("Segoi UI",Font.BOLD,20));
    }


   

    

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));


    BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   form= new JPanel();
   dadospes.add(NC);

   dadospes.add(nome);
  dadospes.add(nomeField);

   dadospes.add(cidade);
  dadospes.add(cidadeField);

   dadospes.add(rua);
  dadospes.add(ruaField);

   dadospes.add(bairro);
  dadospes.add(bairroField);

   dadospes.add(cep);
  dadospes.add(cepField);

   dadospes.add(vagas);
  dadospes.add(vagasField);

   dadospes.add(BEnviar);
   form.add(dadospes);



   
     garagemDao GaragemDao = new garagemDao();

     BEnviar.addActionListener(e ->{

      Nome =nomeField.getText().trim();
      Cidade=cidadeField.getText().trim();
      Rua=ruaField.getText().trim();
      Bairro=bairroField.getText().trim();
      Cep=cepField.getText().trim();
      Vagas= Integer.parseInt(vagasField.getText().trim());
        garagem gam = new garagem(Nome,Cidade,Rua,Bairro,Cep,Vagas);
      
       try {
         GaragemDao.Salvar(gam);
         JOptionPane.showMessageDialog(null,"Informações da Garagem Adicionada");
       } catch (Exception d) {
        JOptionPane.showMessageDialog(null,"Error de : "+d.getMessage());
       }

     });

 }

}
