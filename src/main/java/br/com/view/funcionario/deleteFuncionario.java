package br.com.view.funcionario;

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

import br.com.dao.funcionarioDao;


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
JButton excluir;
    public void CreatInput(){
         JLabel text_auxiliar= new JLabel("Deletar Funcionario",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
        form =new JPanel();
        
        JLabel text =new JLabel("Informe o ID do funcionário a ser excluído.");
        text.setFont(new Font("Segoi Ui",Font.BOLD,16));

        JTextField Input = new JTextField();

         excluir =new JButton("Excluir Funcionario");
        excluir.setFont(new Font("Segoe UI",Font.BOLD,20));
        excluir.setBackground(Color.BLUE);
        excluir.setForeground(Color.white);
        
        JPanel pnDel =new JPanel();
        pnDel.setLayout(new GridLayout(0,1,10,10));

        

        pnDel.add(text_auxiliar);
        pnDel.add(text);
        pnDel.add(Input);
        pnDel.add(excluir);
        form.add(pnDel);


          funcionarioDao funfDao =new funcionarioDao();
    excluir.addActionListener(e ->{
      int F_id = Integer.parseInt(Input.getText().trim());
      if(F_id !=0){
          funfDao.Deletar(F_id);
          JOptionPane.showMessageDialog(null,"Funcionario Deletado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });



    }

}
