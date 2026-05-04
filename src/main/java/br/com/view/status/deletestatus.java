package br.com.view.status;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.dao.statusDao;
import br.com.model.status;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
public class deletestatus extends JFrame {
 JTextField corField;
   JPanel form;
   JButton BDeletar;
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

   statusDao StatusDao= new statusDao();

  BDeletar.addActionListener(e ->{
    int id_Deleter = Integer.parseInt(corField.getText().trim());
  
    if (id_Deleter !=0) {
      StatusDao.Deletar(id_Deleter);
      JOptionPane.showMessageDialog(null,"Status Deletado com Sucesso!!");
    }else{
      JOptionPane.showMessageDialog(null,"Error no Input vazio ou e texto ");
    }

  });

 }


}
