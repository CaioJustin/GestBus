package br.com.view.cargo;

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

import br.com.dao.cargoDao;

import br.com.model.cargo;



public class listCargo extends JFrame {
    JPanel form;
    public  listCargo(){
        super("GestBus :: Lista de Cargo");
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
        JLabel Nometext = new JLabel("Id da cor que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        cargoDao cdao = new cargoDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            cargo c= cdao.ListarInformacao(idC);
          

            if(c !=null){
                  System.out.println(c.Getid());
        System.out.println(c.GetNome());
        JOptionPane.showMessageDialog(null,"\n====Cargo==="+"\nId: "+c.Getid()+"\nNome:"+c.GetNome());
            }
        });    

    }

    
    
}
