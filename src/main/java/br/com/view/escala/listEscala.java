package br.com.view.escala;

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

import br.com.dao.escalaDao;

import br.com.model.escala;

public class listEscala extends JFrame{
JPanel form;
        public listEscala(){
        super("GestBus :: Listar Escala ");
        setSize(400,250);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
         JLabel text_auxiliar= new JLabel("Mostra Escala",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
        JLabel Nometext = new JLabel("Id da escala que deseja Procura! ",JLabel.CENTER);
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

       
        escalaDao escdao = new escalaDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            escala c= escdao.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nId: "+c.Getid()+
                                     "\nHorario Inicio:"+c.getHorarioInicio()+
                                     "\nHorario Final: "+c.getHorarioFim()+
                                    "\nData de Criação da escala : "+c.GetData());
            }
        });    

    }

    







    
}
