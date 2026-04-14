package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import br.com.view.funcionario.addfuncionario;
import br.com.view.funcionario.deleteFuncionario;
import br.com.view.funcionario.listFuncionario;

public class JanelaPrincipal extends JFrame {

    private JPanel  centerpanel;

    public JanelaPrincipal() {

        super("GestBus :: Janela Principal");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando o painel no JFRAME
        CriarPanel();
        CriarCenterPanel();
       

        //Adicionando efito no botoes
        Baction();
        
    }

    private void CriarPanel() {

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0,1,10,10));
        add(painel, BorderLayout.WEST);
        painel.setBackground(Color.decode("#0D2EFF"));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        CriandoBotoes(painel);
    }

   

    private void CriarCenterPanel() {

         centerpanel = new JPanel();
        centerpanel.setLayout(new BorderLayout());
        add(centerpanel, BorderLayout.CENTER);
       
    }

    private Map<String, JButton> LISTADBOTOES;

    private void CriandoBotoes(JPanel painel) {

        LISTADBOTOES = new HashMap<>();

        // Adicionanado os botoes na lista
        LISTADBOTOES.put("BFuncionario", new JButton("Funcionario"));
        LISTADBOTOES.put("BLinhas", new JButton("Linhas"));
        LISTADBOTOES.put("BOnibus", new JButton("Onibus"));
        LISTADBOTOES.put("BCor", new JButton("Status"));
        LISTADBOTOES.put("BCargo", new JButton("Cargo"));
        LISTADBOTOES.put("BEscala", new JButton("Escala"));
        LISTADBOTOES.put("BGaragem", new JButton("Garagem"));
        LISTADBOTOES.put("BViagem", new JButton("Viagem"));
        LISTADBOTOES.put("BSair", new JButton("Sair"));

        for (JButton botao : LISTADBOTOES.values()) {
            botao.setHorizontalAlignment(SwingConstants.CENTER);
            botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
            botao.setForeground(Color.WHITE);
            botao.setBackground(new Color(25,25,112));

            painel.add(botao);
        
        }

    }

    
      private Map<String,JButton> OptionFunc;
    public void panelFuncionario() {

        OptionFunc = new HashMap<>();

        centerpanel.removeAll();

        JPanel PAINELFuncionario = new JPanel();
    
        
       OptionFunc.put("CreateFuncionario",new JButton("Adicionar Funcionario"));
       OptionFunc.put("DeleteFunc",new JButton("Deletar Funcionario"));
       OptionFunc.put("ReadFunc",new JButton("Listar Funcionario"));
       

        JPanel botaoPainel = new JPanel();
        botaoPainel.setPreferredSize(new Dimension(500,300));
        botaoPainel.setBackground(Color.decode("#fcf9f9"));
        botaoPainel.setLayout(new GridLayout(0,1,10,10));
        JLabel Func = new JLabel("Funcionario");
        Func.setFont(new Font("Segoe UI",Font.BOLD,20));
        //Adicionando Botoes dentro do painel
        botaoPainel.add(Func); 

        for(JButton botao:OptionFunc.values()){
            botao.setBackground(Color.decode("#000000"));
            botao.setForeground(Color.decode("#FFFFFF"));
            botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
            botaoPainel.add(botao);
            
           
            
        };
   
        

        PAINELFuncionario.add(botaoPainel);
        

        centerpanel.add(PAINELFuncionario,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionFuncionario();
    }


    public void Baction() {
        // TODO - ADICIONA EFEITO NO BOTAO FUNCIONARIO
      

        LISTADBOTOES.get("BFuncionario").addActionListener(e->{
            
            try {
                panelFuncionario();     
            } catch (Exception r) {
                System.out.println("error de :"+r.getMessage());
            }

        });


    }


    public void BactionFuncionario(){

        OptionFunc.get("CreateFuncionario").addActionListener(e->{
            try {
                System.out.println("HALOHA");
                addfuncionario adicionarfunctionariowindow = new addfuncionario();
                adicionarfunctionariowindow.setVisible(true);
            } catch (Exception f) {
                System.err.println("Erro de : "+f.getMessage());
            }
        });

        OptionFunc.get("DeleteFunc").addActionListener(e ->{
            try {
                deleteFuncionario delfunc = new deleteFuncionario();
                delfunc.setVisible(true);
            } catch (Exception d) {
                System.err.print("Error de : "+d.getMessage());
                
            }
        });

        OptionFunc.get("ReadFunc").addActionListener(e ->{
            try {
                listFuncionario list = new listFuncionario();
                list.setVisible(true);
            } catch (Exception k) {
                System.err.println("Error de :"+k.getMessage());
                 
            }

        });




    }


}
