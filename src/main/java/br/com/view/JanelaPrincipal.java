package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        add(painel,BorderLayout.WEST);
        painel.setBackground(Color.BLUE);
        CriandoBotoes(painel);
    }

    private void CriandoBotoes(JPanel painel){
        JButton BFuncionario= new JButton("Funcionario");
        JButton BLinhas =new JButton("Linhas");
        JButton BOnibus= new JButton("Onibus");
        JButton BCor =new JButton("Status");
        JButton BCargo=new JButton("Cargo");
        JButton BEscala =new JButton("Escala");
        JButton BGaragem=new JButton("Garagem");
        JButton BViagem =new JButton("Viagem");
        JButton BSair=new JButton("Sair");

        //Modificando Botões 

      
        BFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
        BFuncionario.setContentAreaFilled(false);
        BFuncionario.setOpaque(false);
        BFuncionario.setFont(new Font("Arial",Font.BOLD,20));
        BFuncionario.setForeground(Color.WHITE);

        BLinhas.setHorizontalAlignment(SwingConstants.CENTER);
        BLinhas.setContentAreaFilled(false);
        BLinhas.setOpaque(false);
        BLinhas.setFont(new Font("Arial",Font.BOLD,20));
        BLinhas.setForeground(Color.WHITE);

        BOnibus.setHorizontalAlignment(SwingConstants.CENTER);
        BOnibus.setContentAreaFilled(false);
        BOnibus.setOpaque(false);
        BOnibus.setFont(new Font("Arial",Font.BOLD,20));
        BOnibus.setForeground(Color.WHITE);

        BCargo.setHorizontalAlignment(SwingConstants.CENTER);
        BCargo.setContentAreaFilled(false);
        BCargo.setOpaque(false);
        BCargo.setFont(new Font("Arial",Font.BOLD,20));
        BCargo.setForeground(Color.WHITE);

        BCor.setHorizontalAlignment(SwingConstants.CENTER);
        BCor.setContentAreaFilled(false);
        BCor.setOpaque(false);
        BCor.setFont(new Font("Arial",Font.BOLD,20));
        BCor.setForeground(Color.WHITE);

        BEscala.setHorizontalAlignment(SwingConstants.CENTER);
        BEscala.setContentAreaFilled(false);
        BEscala.setOpaque(false);
        BEscala.setFont(new Font("Arial",Font.BOLD,20));
        BEscala.setForeground(Color.WHITE);

        BGaragem.setHorizontalAlignment(SwingConstants.CENTER);
        BGaragem.setContentAreaFilled(false);
        BGaragem.setOpaque(false);
        BGaragem.setFont(new Font("Arial",Font.BOLD,20));
        BGaragem.setForeground(Color.WHITE);

        BViagem.setHorizontalAlignment(SwingConstants.CENTER);
        BViagem.setContentAreaFilled(false);
        BViagem.setOpaque(false);
        BViagem.setFont(new Font("Arial",Font.BOLD,20));
        BViagem.setForeground(Color.WHITE);

        BSair.setHorizontalAlignment(SwingConstants.CENTER);
        BSair.setContentAreaFilled(false);
        BSair.setOpaque(false);
        BSair.setFont(new Font("Arial",Font.BOLD,20));
        BSair.setForeground(Color.WHITE);


        //Adicionanado Botão
        painel.add(BFuncionario);
        painel.add(BLinhas);   
        painel.add(BOnibus);   
        painel.add(BCor);   
        painel.add(BCargo); 
        painel.add(BEscala);      
        painel.add(BGaragem);    
        painel.add(BViagem);      
        painel.add(BSair);
       

        


        
    }

}
