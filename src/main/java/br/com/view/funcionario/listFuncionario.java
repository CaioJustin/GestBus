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
import br.com.model.funcionario;

public class listFuncionario extends JFrame{
    
    JPanel form;
    public listFuncionario(){
        super("GestBust :: Listar Funcionario");
        setSize(700,700);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        createpainel();
    }

    public void createpainel(){
        JPanel PAI = new JPanel();
        add(PAI);
        BotoesPanel();
        PAI.add(form);
    }

    int idC;
    public void BotoesPanel(){
        JLabel Nometext = new JLabel("Id da escala que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        funcionarioDao funcd = new funcionarioDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            funcionario c= funcd.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nId: "+c.Getid()+
                                     "\nNome:"+c.getNome()+
                                     "\nSobrenome: "+c.getSobrenome()+
                                    "\nCPF: "+c.getCpf()+
                                     "\nData de Nascimeto"+c.getDataNas()+
                                    "\nCargo : "+c.getCargo()+
                                    "\nStatus : "+c.getSta()+
                                     "\nEscala: "+c.getEscala());
            }
        });    

    }

    
}
