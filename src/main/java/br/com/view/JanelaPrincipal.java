package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

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
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        add(painel, BorderLayout.WEST);
        painel.setBackground(Color.BLUE);
        CriandoBotoes(painel);
    }

   

    private void CriarCenterPanel() {

         centerpanel = new JPanel();
        centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.Y_AXIS));
        add(centerpanel, BorderLayout.CENTER);
        centerpanel.setBackground(Color.RED);
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
            botao.setContentAreaFilled(false);
            botao.setOpaque(false);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setForeground(Color.WHITE);
            painel.add(botao);
        
        }

    }

    

    public void panelFuncionario() {

        centerpanel.removeAll();

        JPanel PAINELFuncionario = new JPanel();

        JButton CreateFuncionario = new JButton("Adicionar Funcionario");
        JButton deleteFuncionario = new JButton("Excluir Funcionario");
        JButton ListaFuncionarios = new JButton("Lista Funcionario");

        JPanel botaoPainel = new JPanel();
        botaoPainel.add(CreateFuncionario);
        botaoPainel.add(deleteFuncionario);
        botaoPainel.add(ListaFuncionarios);

        PAINELFuncionario.add(botaoPainel);

        centerpanel.add(PAINELFuncionario,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
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

}
