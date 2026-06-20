package br.com.view.garagem;

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

import br.com.dao.garagemDao;
import br.com.model.garagem;

public class listGaragem extends JFrame{
        JPanel form;

    public listGaragem(){
        super("GestBust :: Listar Garagem");
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
         JLabel text_auxiliar= new JLabel("Atualizar Cor",JLabel.CENTER);
  text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
        JLabel Nometext = new JLabel("Id da escala que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.white);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(text_auxiliar);
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        garagemDao garad = new garagemDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            garagem c= garad.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nId: "+c.Getid()+
                                     "\nNome:"+c.getNome()+
                                     "\nCidade: "+c.getCidade()+
                                    "\nRua: "+c.getRua()+
                                     "\nBairro "+c.getBairro()+
                                    "\nCep  : "+c.getCep()+
                                    "\nVagas : "+c.getVagas());
            }
        });    

    }


}
