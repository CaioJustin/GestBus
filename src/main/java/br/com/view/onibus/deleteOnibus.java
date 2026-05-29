package br.com.view.onibus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.onibusDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class deleteOnibus extends JFrame{
 JTextField corField;
   JPanel form;
        public deleteOnibus(){
        super("GestBus :: Deletar Onibus ");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 public void criarPanel(){
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Carg();
   painel.add(form);
   
 }

 public void Carg(){
   JLabel NC = new JLabel("ID do Onibus ",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    corField = new JTextField();
    JButton BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);
   dadospes.add(corField);
   dadospes.add(BEnviar);
   form.add(dadospes);


 onibusDao garaD =new onibusDao();
    BEnviar.addActionListener(e ->{
      int GD = Integer.parseInt(corField.getText().trim());
      if(GD !=0){
          garaD.Deletar(GD);
          JOptionPane.showMessageDialog(null,"Deletado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });


 }
}
