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
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));


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
    


    for (JLabel n : names) {
        n.setFont(new Font("Segoi UI",Font.BOLD,20));
    }


    nomeField = new JTextField();
    cidadeField = new JTextField();
    ruaField = new JTextField();
    bairroField = new JTextField();
    cepField = new JTextField();
    vagasField = new JTextField();
    

    

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));


   JButton BEnviar = new JButton("Enviar");
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



       garagemDao garaDao=new garagemDao();
    BEnviar.addActionListener(e ->{
      String n = nomeField.getText().trim();
      String c = cidadeField.getText().trim();
      String r = ruaField.getText().trim();
      String b = bairroField.getText().trim();
      String ceps = cepField.getText().trim();
      int vags =Integer.parseInt(vagasField.getText().trim());
      
      garagem ga = new garagem(n,c,r,b,ceps,vags);
      if((n.isEmpty())||(c.isEmpty())||(r.isEmpty())||(b.isEmpty())||(ceps.isEmpty())|| (vags==0)){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          garaDao.Salvar(ga);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }

    });








 }

}
