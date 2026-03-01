package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class JanelaPrincipal extends JFrame {
    
    public JanelaPrincipal(){
        
        super("Janela Principal");
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        //Adicionando o painel no JFRAME
       CriarPanel();
    }

    

    private void CriarPanel(){
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(painel,BorderLayout.WEST);
        painel.setBackground(Color.red);
    }


}
