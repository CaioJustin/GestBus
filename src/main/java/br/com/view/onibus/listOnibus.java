package br.com.view.onibus;

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

import br.com.dao.onibusDao;
import br.com.model.onibus;

public class listOnibus extends JFrame{
     JPanel form;
        public listOnibus(){
        super("GestBus :: Listar Onibus ");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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
        JLabel Nometext = new JLabel("Digite a placa do onibus que deseja Procura! ",JLabel.CENTER);
        Nometext.setFont(new Font("Segou UI",Font.BOLD,20));
        JTextField campoDeTexto=new JTextField();
        JButton botao = new JButton("Pesquisa");
        botao.setBackground(Color.blue);
        botao.setForeground(Color.white);
        botao.setFont(new Font("Segoe UI",Font.BOLD,20));
        
        form =new JPanel(new GridLayout(0,1,10,10));
        form.add(Nometext);
        form.add(campoDeTexto);
        form.add(botao);

       
        onibusDao linD = new onibusDao();
        botao.addActionListener(e ->{
         idC=Integer.parseInt(campoDeTexto.getText().trim());

            onibus c= linD.ListarInformacao(idC);
          
            if(c !=null){
        JOptionPane.showMessageDialog(null,"\n====Escala==="+
                                     "\nPlaca: "+c.getPlaca()+
                                     "\nModelo:"+c.getModelo()+
                                     "\nAno de Fabricação: "+c.getAnoFabri()+
                                    "\nCapacidade: "+c.getCapacidade()+
                                     "\nData Criação"+c.getdataCriacao()+
                                     "\nStauts id :"+c.getSta()+
                                     "\nCor Id :"+c.getCor()+
                                     "\nGaragem Id"+c.getGaragem());
                                     
                                    
                                    
            }
        });    

    }


}
