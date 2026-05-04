package br.com.view.cargo;

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

import br.com.dao.cargoDao;
import br.com.model.cargo;

public class addCargo extends JFrame{
    
   JTextField carField;
   JPanel form;
   JButton BEnviar;
 public  addCargo(){
    super("GestBus :: Adicionar Cargo");
    setSize(400,200);
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
   JLabel NC = new JLabel("Nome do Cargo",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    carField = new JTextField();
     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(NC);
   dadospes.add(carField);
   dadospes.add(BEnviar);
   form.add(dadospes);



   cargoDao CargoDao = new cargoDao();

   BEnviar.addActionListener(e ->{
      String cargoNome =carField.getText();
      cargo cargs= new cargo(cargoNome);
       
   if(cargoNome.isEmpty()){
    JOptionPane.showMessageDialog(null,"Input vazio");
   }else{
    
     try {
      CargoDao.Salvar(cargs);
       JOptionPane.showMessageDialog(null,"Adicionado Com Sucesso!!");  
       carField.setText("");
    } catch (Exception d) {
      System.out.println("Cargo adicionado com sucesso : "+d.getMessage());
    }
    
   }

      carField.setText("");

   });


 }


}
