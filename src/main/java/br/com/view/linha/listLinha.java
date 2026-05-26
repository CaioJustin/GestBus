package br.com.view.linha;

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


import br.com.dao.linhaDao;
import br.com.model.linha;

public class listLinha extends JFrame{
  JPanel form;
            public listLinha(){
        super("GestBus :: Listar Linhas ");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        createRootPane();
    }


     public void createpainel(){
        JPanel PAI = new JPanel();
        add(PAI);
        BotoesPanel();
        PAI.add(form);
    }

    int idC;
    public void BotoesPanel(){
        JLabel Nometext = new JLabel("Id da escala que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.white);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        linhaDao linD = new linhaDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            linha c= linD.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nId: "+c.Getid()+
                                     "\nNome:"+c.getNome()+
                                     "\nOrigem: "+c.getOrigem()+
                                    "\nDestino: "+c.getDestino());
                                     
                                    
                                    
            }
        });    

    }

}
