package br.com.view.viagem;

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


import br.com.dao.viagemDao;
import br.com.model.viagem;

public class listViagem extends JFrame {
     JPanel form;
        public listViagem(){
        super("GestBus :: Lista Viagem ");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }


       public void createpainel(){
        JPanel PAI = new JPanel();
        add(PAI);
        BotoesPanel();
        PAI.add(form);
    }

    int idC;
    public void BotoesPanel(){
        JLabel Nometext = new JLabel("Digite a placa do onibus que deseja Procura! ",JLabel.CENTER);
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

       
        viagemDao linD = new viagemDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            viagem c= linD.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Viagem==="+
                                     "\nId da viagem: "+c.Getid()+
                                     "\nDescrição:"+c.getDesc()+
                                    "\n Data Partida"+c.getDataPar()+
                                     "\n Data Chegada"+c.getDataChe()+
                                     "\n Escala id"+c.getEscala()+
                                     "\n Linha id"+c.getLinha());
                                     
                                    
                                    
            }
        });    

    }
    
}
