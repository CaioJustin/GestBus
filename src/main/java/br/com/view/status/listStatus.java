package br.com.view.status;

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


import br.com.dao.statusDao;

import br.com.model.status;

public class listStatus extends JFrame{
    JPanel form;
    public listStatus(){
        super("GestBus :: Listar de Status");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        createpainel();
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

       
        statusDao linD = new statusDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            status c= linD.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nPlaca: "+c.Getid()+
                                     "\nModelo:"+c.GetNome());
                                     
                                    
                                    
            }
        });    

    }

}
