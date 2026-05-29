package br.com.view.status;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import br.com.dao.statusDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class deletestatus extends JFrame {
 JTextField corField;
   JPanel form;
    public deletestatus(){
        super("GestBus :: Deletar Status");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        criarPanel();
    }
     public void criarPanel(){
   JPanel painel = new  JPanel();
   painel.setLayout(new GridLayout(0,1,10,10));
   add(painel);
   Carg();
   painel.add(form);
   
 }
JButton BDeletar;
 public void Carg(){
   JLabel NC = new JLabel("Excluir Status",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    corField = new JTextField();
     BDeletar = new JButton("Deletar");
    BDeletar.setBackground(Color.RED);
    BDeletar.setForeground(Color.WHITE);
    BDeletar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);
   dadospes.add(corField);
   dadospes.add(BDeletar);
   form.add(dadospes);


         statusDao statsD =new statusDao();
    BDeletar.addActionListener(e ->{
      int CN = Integer.parseInt(BDeletar.getText().trim());
      if(CN !=0){
          statsD.Deletar(CN);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }else{
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }

    });


 }
}
