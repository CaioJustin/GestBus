package br.com.view.funcionario;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.jdatepicker.JDatePicker;

import br.com.dao.funcionarioDao;

import br.com.model.funcionario;


public class addfuncionario extends JFrame {

    
    private JPanel form;
    
   

    public addfuncionario(){
        super("GestBus :: Adicionar Funcionario");
        setSize(400,700);
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
    JButton BLimpa;
    /*Funcionario deve ter nome,sobrenome,data de nascimento,cpf,cargo	 */

    private void CreateForm(){
         

        JPanel dadosPessoa =new JPanel();

         JLabel NC = new JLabel("Adicionar Funcionario",JLabel.CENTER);
        NC.setFont(new Font("Segoe UI",Font.BOLD,20));

        Font styleFont = new Font("Segoi UI",Font.BOLD,16);

        //Criando os texto
        JLabel DadosPessoais = new JLabel("Dados Pessoais");
        DadosPessoais.setFont(new Font("Segoe UI",Font.BOLD,20));
        JPanel PainelPessoais= new JPanel();
        PainelPessoais.add(DadosPessoais);

        JLabel nomeFuncionario = new JLabel("Nome : ");
        JTextField nomeInputFuncionario = new JTextField();
        nomeInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelNome = new JPanel();
        PainelNome.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelNome.add(nomeFuncionario);
        PainelNome.add(nomeInputFuncionario);

        JLabel sobrenomeFuncionario = new JLabel("Sobrenome :");
        JTextField sobrenomeInputFuncionario = new JTextField();
        sobrenomeInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelSobrenome = new JPanel();
        PainelSobrenome.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelSobrenome.add(sobrenomeFuncionario);
        PainelSobrenome.add(sobrenomeInputFuncionario);
        
        JLabel datadenascFuncionario= new JLabel("Data :");
        JDatePicker datepicker = new JDatePicker();
        JPanel PainelData = new JPanel();
        PainelData.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelData.add(datadenascFuncionario);
        PainelData.add(datepicker);

        JLabel cpfFuncionario= new JLabel("Cpf : ");
        JTextField cpfInputFuncionario = new JTextField();
        cpfInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelCpf = new JPanel();
        PainelCpf.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelCpf.add(cpfFuncionario);
        PainelCpf.add(cpfInputFuncionario);

         JLabel DadosPessoaisTrabalho = new JLabel("Dados de Trabalho");
        DadosPessoaisTrabalho.setFont(new Font("Segoe UI",Font.BOLD,20));

        JPanel PainelDadosTrabalho= new JPanel();
        PainelDadosTrabalho.add(DadosPessoaisTrabalho);


        JLabel cargoFuncionario =new JLabel("Cargo :");
        JTextField cargoInputFuncionario = new JTextField();
        cargoInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelCargo = new JPanel();
        PainelCargo.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelCargo.add(cargoFuncionario);
        PainelCargo.add(cargoInputFuncionario);

        JLabel statusFuncionario =new JLabel("Status : ");
        JTextField statusInputFuncionario = new JTextField();
        statusInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelStatus = new JPanel();
        PainelStatus.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelStatus.add(statusFuncionario);
        PainelStatus.add(statusInputFuncionario);

        JLabel EscalaFuncionario =new JLabel("Escala : ");
        JTextField escalaInputFuncionario = new JTextField();
        escalaInputFuncionario.setPreferredSize(new Dimension(200,30));
        JPanel PainelEscala = new JPanel();
        PainelEscala.setLayout(new FlowLayout(FlowLayout.CENTER));
        PainelEscala.add(EscalaFuncionario);
        PainelEscala.add(escalaInputFuncionario);

        ArrayList<JLabel> texts = new ArrayList<>();
        texts.add(nomeFuncionario);
        texts.add(sobrenomeFuncionario);
        texts.add(datadenascFuncionario);
        texts.add(cpfFuncionario);
        texts.add(cargoFuncionario);
         texts.add(statusFuncionario);
         texts.add(EscalaFuncionario);

        for (JLabel txt : texts) {
             txt.setFont(styleFont);
        }

        /*Criando Botoes de Adicionar Limpar e JPanel*/
            /* Botao de Adicionar */
        adicionar = new JButton("Adicionar Funcionario");
        adicionar.setFont(styleFont);
        adicionar.setBackground(Color.green);
        adicionar.setForeground(Color.black);
        

            /* Botao de Limpar */
        BLimpa = new JButton("Limpar Campos");
        BLimpa.setFont(styleFont);
        BLimpa.setBackground(Color.blue);
        BLimpa.setForeground(Color.WHITE);

        /* JPANEL  aonde os dois botoes vão ficar*/
        JPanel PanelBotoes =new JPanel();
        PanelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelBotoes.add(adicionar);
        PanelBotoes.add(BLimpa);



        /* Juntando as Coisas */
        dadosPessoa.setLayout(new GridLayout(0,1,10,10));

        dadosPessoa.add(NC);
        dadosPessoa.add(DadosPessoais);
        dadosPessoa.add(PainelNome);
        dadosPessoa.add(PainelSobrenome);
        dadosPessoa.add(PainelData);
        dadosPessoa.add(PainelCpf);
        dadosPessoa.add(PainelDadosTrabalho);
        dadosPessoa.add(PainelCargo);
        dadosPessoa.add(PainelStatus);
        dadosPessoa.add(PainelEscala);
       

            /* Adicionando o jpanel que possui botao de adicionar e limpar */
        dadosPessoa.add(PanelBotoes);

        form = new JPanel();
        form.add(dadosPessoa);
        

           funcionarioDao FuncDao=new funcionarioDao();
       
    adicionar.addActionListener(e ->{
        String nom = nomeInputFuncionario.getText().trim();
      String sob = sobrenomeInputFuncionario.getText().trim();
      String cpfs = cpfInputFuncionario.getText().trim();
      int EscId = Integer.parseInt(escalaInputFuncionario.getText().trim());
      int StsId = Integer.parseInt(statusInputFuncionario.getText().trim());
      int CarId =Integer.parseInt(cargoInputFuncionario.getText().trim());

       // meche na data e coloca arruamar deposis
          
           java.util.Date dataNascimento = ((GregorianCalendar) datepicker.getModel().getValue()).getTime();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String dataString = sdf.format(dataNascimento);
      
      funcionario funf = new funcionario(nom,sob,cpfs,dataString,StsId,CarId,EscId);
      if((nom.isEmpty())||(sob.isEmpty())||(cpfs.isEmpty())||(EscId==0)||(StsId==0)||(CarId==0)){
        JOptionPane.showMessageDialog(null,"Erro no input  !!");
      }else{
          FuncDao.Salvar(funf);
          JOptionPane.showMessageDialog(null,"Funcionario Adicionado com Sucesso !!");
      }

    });
       

      BLimpa.addActionListener(e ->{

      
      nomeInputFuncionario.setText("");
      sobrenomeInputFuncionario.setText("");
      cpfInputFuncionario.setText("");
      escalaInputFuncionario.setText("");
      statusInputFuncionario.setText("");
      cargoInputFuncionario.setText("");
      


    });

    }

}
