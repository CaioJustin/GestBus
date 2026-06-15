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
 public  addCargo(){
    super("GestBus :: Adicionar Cargo");
    setSize(400,250);
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
   JLabel Text_auxiliar = new JLabel("Adicionar Cargo",JLabel.CENTER);
   Text_auxiliar.setFont(new Font("Segoe UI",Font.BOLD,30));
   JLabel NC = new JLabel("Nome do Cargo",JLabel.CENTER);
   NC.setFont(new Font("Segoe UI",Font.BOLD,20));
    carField = new JTextField();
     BEnviar = new JButton("Enviar");
    BEnviar.setBackground(Color.blue);
    BEnviar.setForeground(Color.WHITE);
    BEnviar.setFont(new Font("Segoe UI",Font.BOLD,20));

   JPanel dadospes = new  JPanel(new GridLayout(0,1,10,10));

   form= new JPanel();
   dadospes.add(Text_auxiliar);
   dadospes.add(NC);
   dadospes.add(carField);
   dadospes.add(BEnviar);
   form.add(dadospes);

      cargoDao cD=new cargoDao();
    BEnviar.addActionListener(e ->{
      String CN = carField.getText().trim();
      cargo car = new cargo(CN);
      if(CN.isEmpty()){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          cD.Salvar(car);
          JOptionPane.showMessageDialog(null,"Adicionado com Sucesso !!");
      }

    });



 }








}
