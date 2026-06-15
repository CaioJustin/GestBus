package br.com.view.funcionario;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.jdatepicker.JDatePicker;

import br.com.dao.funcionarioDao;
import br.com.model.funcionario;

public class attfuncionario extends JFrame{
    
    
    private JPanel form;
    JButton BEnviar;

    public attfuncionario(){
        super("GestBus :: Atualizar Funcionario");
        setSize(400,800);
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


  JButton adicionar;
    /*Funcionario deve ter nome,sobrenome,data de nascimento,cpf,cargo	 */

    private void CreateForm(){
     

        JPanel dadosPessoa =new JPanel();

         JLabel NC = new JLabel("Atualizar Funcionario",JLabel.CENTER);
        NC.setFont(new Font("Segoe UI",Font.BOLD,20));

        Font styleFont = new Font("Segoi UI",Font.BOLD,16);

        //Criando os texto
        JLabel nomeFuncionario = new JLabel("Nome do Funcionario");
        JLabel IdFuncionario = new JLabel("ID do Funcionario");
        JLabel sobrenomeFuncionario = new JLabel("Sobrenome do Funcionario");
        JLabel datadenascFuncionario= new JLabel("Data de nascimento do funcionario");
        JLabel cpfFuncionario= new JLabel("Cpf do funcionario");
        JLabel cargoFuncionario =new JLabel("Cargo do Funcionaro");
         JLabel statusFuncionario =new JLabel("Status do Funcionaro");
         JLabel EscalaFuncionario =new JLabel("Escala do Funcionaro");

        ArrayList<JLabel> texts = new ArrayList<>();
        texts.add(nomeFuncionario);
        texts.add(sobrenomeFuncionario);
        texts.add(datadenascFuncionario);
        texts.add(cpfFuncionario);
        texts.add(cargoFuncionario);
         texts.add(statusFuncionario);
         texts.add(EscalaFuncionario);
         texts.add(IdFuncionario);

        for (JLabel txt : texts) {
             txt.setFont(styleFont);
        }

        //Criando os Inputs
        JTextField IdInputFuncionario = new JTextField();
        JTextField nomeInputFuncionario = new JTextField();
        JTextField sobrenomeInputFuncionario = new JTextField();
        JTextField cpfInputFuncionario = new JTextField();
        JTextField cargoInputFuncionario = new JTextField();
         JTextField statusInputFuncionario = new JTextField();
         JTextField escalaInputFuncionario = new JTextField();
        
        JDatePicker datepicker = new JDatePicker();


         adicionar = new JButton("Alterar Funcionario");
        adicionar.setFont(styleFont);
        adicionar.setBackground(Color.blue);
        adicionar.setForeground(Color.WHITE);

        dadosPessoa.setLayout(new GridLayout(0,1,10,10));

        dadosPessoa.add(NC);
      
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

         dadosPessoa.add(EscalaFuncionario);
        dadosPessoa.add(escalaInputFuncionario);

        dadosPessoa.add(adicionar);

        form = new JPanel();
        form.add(dadosPessoa);
        

           funcionarioDao FuncDao=new funcionarioDao();
         adicionar.addActionListener(e ->{
      int idF = Integer.parseInt(IdInputFuncionario.getText().trim());
      String nom = nomeInputFuncionario.getText().trim();
      String sob = sobrenomeInputFuncionario.getText().trim();
      String cpfs = cpfInputFuncionario.getText().trim();
      int EscId = Integer.parseInt(cargoInputFuncionario.getText().trim());
      int StsId = Integer.parseInt(statusInputFuncionario.getText().trim());
      int CarId =Integer.parseInt(escalaInputFuncionario.getText().trim());

          java.util.Date dataNascimento = (java.util.Date) datepicker.getModel().getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataString = sdf.format(dataNascimento);

      funcionario funf = new funcionario(idF,nom,sob,cpfs,StsId,CarId,EscId,dataString);
      if((nom.isEmpty())||(sob.isEmpty())||(cpfs.isEmpty())||(EscId==0)||(StsId==0)||(CarId==0)){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          FuncDao.Salvar(funf);
          JOptionPane.showMessageDialog(null,"Funcionario Adicionado com Sucesso !!");
      }

    });
       
    }

}
