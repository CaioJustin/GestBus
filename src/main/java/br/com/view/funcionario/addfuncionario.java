package br.com.view.funcionario;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Font;

public class addfuncionario extends JFrame {

    private JPanel display;

    public addfuncionario(){
        super("GestBus :: Adicionar Funcionario");
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jpanel();
    }

    private void jpanel(){
        JPanel painel = new JPanel();
        add(painel);
        Display(painel);
        painel.add(display);
    }


    private void Display(JPanel painel){
        display = new JPanel();
        painel.add(display);
        JLabel adicionar = new JLabel("Adicionar");
        Font StyleLetter = new Font("Arial",Font.BOLD,20);
        adicionar.setFont(StyleLetter);
        display.add(adicionar);

    }



    private void CreateForm(){
        JPanel dadosPessoa =new JPanel();
        JTextField dadospessoa = new JTextField("dados pessoal");

    }

}
