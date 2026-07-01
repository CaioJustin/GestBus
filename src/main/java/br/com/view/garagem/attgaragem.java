package br.com.view.garagem;

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

import br.com.dao.garagemDao;
import br.com.model.garagem;

public class attgaragem  extends JFrame{
      JTextField nomeField;
        JTextField cidadeField;
         JTextField ruaField;
          JTextField bairroField;
           JTextField cepField;
            JTextField vagasField;
               JTextField IdInputGaragem;
     JPanel form;

    public attgaragem(){
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
  
   JLabel NC = new JLabel("Atualizar Garagem",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,30));


       
    

     JLabel nome =new JLabel("Nome",JLabel.CENTER);
    nomeField = new JTextField();
    nomeField.setPreferredSize(new Dimension(200,30));
    JPanel PainelNome = new JPanel();
    PainelNome.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelNome.add(nome);
    PainelNome.add(nomeField);  

     JLabel cidade =new JLabel("Cidade",JLabel.CENTER);
    cidadeField = new JTextField();
    cidadeField.setPreferredSize(new Dimension(200,30));
    JPanel PainelCidade = new JPanel();
    PainelCidade.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelCidade.add(cidade);
    PainelCidade.add(cidadeField);

    JLabel rua =new JLabel("Rua",JLabel.CENTER);
    ruaField = new JTextField();
    ruaField.setPreferredSize(new Dimension(200,30));
    JPanel PainelRua = new JPanel();
    PainelRua.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelRua.add(rua);
    PainelRua.add(ruaField);
    
     JLabel bairro =new JLabel("Bairro",JLabel.CENTER);
    bairroField = new JTextField();
    bairroField.setPreferredSize(new Dimension(200,30));
    JPanel PainelBairro = new JPanel();
    PainelBairro.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelBairro.add(bairro);
    PainelBairro.add(bairroField);

    JLabel cep =new JLabel("Cep",JLabel.CENTER);
    cepField = new JTextField();
    cepField.setPreferredSize(new Dimension(200,30));
    JPanel PainelCep = new JPanel();
    PainelCep.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelCep.add(cep);
    PainelCep.add(cepField);

    
    JLabel vagas =new JLabel("Vagas : ",JLabel.CENTER);
    vagasField = new JTextField(); 
    vagasField.setPreferredSize(new Dimension(200,30));
    JPanel PainelVagas = new JPanel();
    PainelVagas.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelVagas.add(vagas);
    PainelVagas.add(vagasField);
  

     JLabel id =new JLabel("Id",JLabel.CENTER);
     IdInputGaragem = new JTextField();
     IdInputGaragem.setPreferredSize(new Dimension(200,30));
     JPanel PainelGaragem= new JPanel();
     PainelGaragem.setLayout(new FlowLayout(FlowLayout.CENTER));
     PainelGaragem.add(id);
     PainelGaragem.add(IdInputGaragem);

    ArrayList<JLabel> names = new ArrayList<>();
    names.add(nome);
    names.add(cidade);
    names.add(rua);
    names.add(bairro);
    names.add(cep);
    names.add(vagas);
    names.add(id);
    for (JLabel n : names) {
        n.setFont(new Font("Segoi UI",Font.BOLD,20));
    }


 

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));


   JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.green);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JButton BLimpar = new JButton("Limpar");
    BLimpar.setBackground(Color.blue);
    BLimpar.setForeground(Color.white);
    BLimpar.setFont(new Font("Segoe UI",Font.BOLD,20));

    JPanel PainelBotao= new JPanel();
    PainelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
    PainelBotao.add(BEnviar);
    PainelBotao.add(BLimpar);

   form= new JPanel();
   dadospes.add(NC);

     
  dadospes.add(PainelGaragem);
  dadospes.add(PainelNome);
  dadospes.add(PainelCidade);
  dadospes.add(PainelRua);
  dadospes.add(PainelBairro);
  dadospes.add(PainelCep);
  dadospes.add(PainelVagas);
   dadospes.add(PainelBotao);
   form.add(dadospes);



       garagemDao garaDao=new garagemDao();
    BEnviar.addActionListener(e ->{
      String n = nomeField.getText().trim();
      String c = cidadeField.getText().trim();
      String r = ruaField.getText().trim();
      String b = bairroField.getText().trim();
      String ceps = cepField.getText().trim();
      int vags =Integer.parseInt(vagasField.getText().trim());
      int i = Integer.parseInt(IdInputGaragem.getText().trim());
      
      garagem ga = new garagem(i,n,c,r,b,ceps,vags);
      if((n.isEmpty())||(c.isEmpty())||(r.isEmpty())||(b.isEmpty())||(ceps.isEmpty())|| (vags==0)){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          garaDao.Atualizar(ga);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }

    });








 }

}
