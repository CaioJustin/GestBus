package br.com.view.funcionario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class listFuncionario extends JFrame{
    

    public listFuncionario(){
        super("GestBust :: Listar Funcionario");
        setSize(700,700);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void createpainel(){
        JPanel PAI = new JPanel();
        add(PAI);
    }

}
