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

public class attCargo extends JFrame{
    
   JTextField carField;
   JTextField IDcarField;
   JPanel form;
 public  attCargo(){
    super("GestBus :: Atualizar Cargo");
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
 JButton BEnviar;
 public void Carg(){
  JLabel IDCargo = new JLabel("Id do Cargo",JLabel.CENTER);
   IDCargo.setFont(new Font("Segoe UI",Font.BOLD,20));
IDcarField = new JTextField();

   JLabel NC = new JLabel("Nome do Cargo",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    carField = new JTextField();
    
     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(IDCargo);
   dadospes.add(IDcarField);
   dadospes.add(NC);
   dadospes.add(carField);
   dadospes.add(BEnviar);
   form.add(dadospes);

      cargoDao cD=new cargoDao();
    BEnviar.addActionListener(e ->{
      String CN = carField.getText().trim();
      int Ci = Integer.parseInt(IDcarField.getText().trim());
      cargo car = new cargo(Ci,CN);
      if(CN.isEmpty()){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          cD.Atualizar(car);
          JOptionPane.showMessageDialog(null,"Atualizado com Sucesso !!");
      }

    });



 }








}
