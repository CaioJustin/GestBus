package br.com.view.funcionario;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class deleteFuncionario extends JFrame{
    
    JPanel form;
    JPanel pMsg;
    JLabel msgT;

    public deleteFuncionario(){
        super("Gestbus :: Deletar Funcionario");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jpanel();
    }

    public void jpanel(){
        JPanel painel = new JPanel();
        add(painel);
        CreatInput();
        painel.add(form);
        
    }

    public void CreatInput(){

        form =new JPanel();
        
        JLabel text =new JLabel("Informe o ID do funcionário a ser excluído.");
        text.setFont(new Font("Segoi Ui",Font.BOLD,16));

        JTextField Input = new JTextField();

        JButton excluir =new JButton("Excluir Funcionario");
        excluir.setFont(new Font("Segoe UI",Font.BOLD,20));
        excluir.setBackground(Color.BLUE);
        excluir.setForeground(Color.white);
        
        JPanel pnDel =new JPanel();
        pnDel.setLayout(new GridLayout(0,1,10,10));

        


        pnDel.add(text);
        pnDel.add(Input);
        pnDel.add(excluir);
        form.add(pnDel);
    }

}
