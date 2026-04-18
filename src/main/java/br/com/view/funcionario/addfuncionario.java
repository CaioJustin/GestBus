package br.com.view.funcionario;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import org.jdatepicker.JDatePicker;

public class addfuncionario extends JFrame {

    private JPanel display;
    private JPanel form;

    public addfuncionario(){
        super("GestBus :: Adicionar Funcionario");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jpanel();
       
    }

    private void jpanel(){
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0,1,10,10));
        add(painel);
        CreateForm();
        painel.add(form);
       
    }


  
    /*Funcionario deve ter nome,sobrenome,data de nascimento,cpf,cargo	 */

    private void CreateForm(){
        JPanel dadosPessoa =new JPanel();

        Font styleFont = new Font("Segoi UI",Font.BOLD,16);

        //Criando os texto
        JLabel nomeFuncionario = new JLabel("Nome do Funcionario");
        JLabel sobrenomeFuncionario = new JLabel("Sobrenome do Funcionario");
        JLabel datadenascFuncionario= new JLabel("Data de nascimento do funcionario");
        JLabel cpfFuncionario= new JLabel("Cpf do funcionario");
        JLabel cargoFuncionario =new JLabel("Cargo do Funcionaro");
         JLabel statusFuncionario =new JLabel("Status do Funcionaro");

        ArrayList<JLabel> texts = new ArrayList<>();
        texts.add(nomeFuncionario);
        texts.add(sobrenomeFuncionario);
        texts.add(datadenascFuncionario);
        texts.add(cpfFuncionario);
        texts.add(cargoFuncionario);
         texts.add(statusFuncionario);

        for (JLabel txt : texts) {
             txt.setFont(styleFont);
        }

        //Criando os Inputs
        JTextField nomeInputFuncionario = new JTextField();
        JTextField sobrenomeInputFuncionario = new JTextField();
        JTextField cpfInputFuncionario = new JTextField();
        JTextField cargoInputFuncionario = new JTextField();
         JTextField statusInputFuncionario = new JTextField();
        
        JDatePicker datepicker = new JDatePicker();


        JButton adicionar = new JButton("Adicionar Funcionario");
        adicionar.setFont(styleFont);
        adicionar.setBackground(Color.blue);
        adicionar.setForeground(Color.WHITE);

        dadosPessoa.setLayout(new GridLayout(0,1,10,10));
      
        dadosPessoa.add(nomeFuncionario);
        dadosPessoa.add(nomeInputFuncionario);

        dadosPessoa.add(sobrenomeFuncionario);
        dadosPessoa.add(sobrenomeInputFuncionario);

        dadosPessoa.add(datadenascFuncionario);
        dadosPessoa.add(datepicker);

         dadosPessoa.add(cpfFuncionario);
        dadosPessoa.add(cpfInputFuncionario);

         dadosPessoa.add(cargoFuncionario);
        dadosPessoa.add(cargoInputFuncionario);

         dadosPessoa.add(statusFuncionario);
        dadosPessoa.add(statusInputFuncionario);

        dadosPessoa.add(adicionar);

        form = new JPanel();
        form.add(dadosPessoa);
        
       
    }

}
