package br.com.view.funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class deleteFuncionario extends JFrame{
    

    public deleteFuncionario(){
        super("Gestbus :: Deletar Funcionario");
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void jpanel(){
        JPanel painel = new JPanel();
        add(painel);
    }

    public void CreatInput(){
        
    }

}
