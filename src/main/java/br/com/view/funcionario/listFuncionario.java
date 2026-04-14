package br.com.view.funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class listFuncionario extends JFrame{
    

    public listFuncionario(){
        super("GestBust :: Listar Funcionario");
        setSize(700,700);
    }

    public void createpainel(){
        JPanel PAI = new JPanel();
        add(PAI);
    }

}
