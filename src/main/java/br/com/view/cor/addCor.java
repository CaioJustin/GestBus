package br.com.view.cor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.corDao;
import br.com.model.cor;

public class addCor extends JFrame{
    

     JTextField corField;
   JPanel form;
    JButton BEnviar;

    public addCor(){
        super("GestBus :: Adicionar Cor");
        setSize(400,300);
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
   JLabel NC = new JLabel("Nome da Cor",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    corField = new JTextField();
     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);
   dadospes.add(corField);
   dadospes.add(BEnviar);
   form.add(dadospes);

   
  
   corDao CorDao = new corDao();

  BEnviar.addActionListener(e ->{
     String corText= corField.getText();
      cor cors = new cor(corText);

    if(corText.isEmpty()){
      CorDao.Salvar(cors);
      JOptionPane.showMessageDialog(null,"O Input esta Vazio !!");
    }else{

      CorDao.Salvar(cors);
      JOptionPane.showMessageDialog(null,"O adicionada com Sucesso !!");
    }
    
  });



 }

}
