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



public class listCor extends JFrame{
JPanel form;
    public listCor(){
        super("GestBus :: Listar Cores");
         setSize(500,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        createpanel();
    }


    public void createpanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1,10,10));
        add(panel); 
        BotoesPanel();
        panel.add(form);
      
    }
 int idC;
    public void BotoesPanel(){
         JLabel text_auxiliar= new JLabel("Mostar Cor",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
        JLabel Nometext = new JLabel("Id do Cor que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(text_auxiliar);
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        corDao codao = new corDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            cor c= codao.ListarInformacao(idC);
          
            if(c !=null){
                  System.out.println(c.Getid());
        System.out.println(c.GetNome());
        JOptionPane.showMessageDialog(null,"\n====Cor==="+"\nId: "+c.Getid()+"\nNome:"+c.GetNome());
            }
        });    

    }

    


}