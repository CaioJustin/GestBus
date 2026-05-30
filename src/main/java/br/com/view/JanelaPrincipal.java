package br.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.LineBorder;


import br.com.view.cargo.addCargo;
import br.com.view.cargo.attCargo;
import br.com.view.cargo.deleteCargo;
import br.com.view.cargo.listCargo;
import br.com.view.cor.addCor;
import br.com.view.cor.attcor;
import br.com.view.cor.deleteCor;
import br.com.view.cor.listCor;
import br.com.view.escala.addescala;
import br.com.view.escala.attescala;
import br.com.view.escala.deleteEscala;
import br.com.view.escala.listEscala;
import br.com.view.funcionario.addfuncionario;
import br.com.view.funcionario.attfuncionario;
import br.com.view.funcionario.deleteFuncionario;
import br.com.view.funcionario.listFuncionario;
import br.com.view.garagem.addGaragem;
import br.com.view.garagem.attgaragem;
import br.com.view.garagem.deleteGaragem;
import br.com.view.garagem.listGaragem;
import br.com.view.linha.addLinha;
import br.com.view.linha.attlinha;
import br.com.view.linha.deleteLinha;
import br.com.view.linha.listLinha;
import br.com.view.onibus.addOnibus;
import br.com.view.onibus.attonibus;
import br.com.view.onibus.deleteOnibus;
import br.com.view.onibus.listOnibus;
import br.com.view.status.addStatus;
import br.com.view.status.attstatus;
import br.com.view.status.deletestatus;
import br.com.view.status.listStatus;
import br.com.view.viagem.addViagem;
import br.com.view.viagem.attviagem;
import br.com.view.viagem.deletaViagem;
import br.com.view.viagem.listViagem;

public class JanelaPrincipal extends JFrame {

    private JPanel  centerpanel;

    public JanelaPrincipal() {

        super("GestBus :: Janela Principal");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando o painel no JFRAME
        CriarPanel();
        CriarCenterPanel();
       

        //Adicionando efito no botoes
        Baction();
        
    }

    private void CriarPanel() {

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0,1,10,10));
        add(painel, BorderLayout.WEST);
        painel.setBackground(Color.decode("#0D2EFF"));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        CriandoBotoes(painel);
    }

   

    private void CriarCenterPanel() {

         centerpanel = new JPanel();
        centerpanel.setLayout(new BorderLayout());
        add(centerpanel, BorderLayout.CENTER);
       
    }

    private Map<String, JButton> LISTADBOTOES;

    private void CriandoBotoes(JPanel painel) {

        LISTADBOTOES = new HashMap<>();

        // Adicionanado os botoes na lista
        LISTADBOTOES.put("BFuncionario", new JButton("Funcionario"));
        LISTADBOTOES.put("BLinhas", new JButton("Linhas"));
        LISTADBOTOES.put("BOnibus", new JButton("Onibus"));
        LISTADBOTOES.put("BCor", new JButton("Cor"));
        LISTADBOTOES.put("BStatus", new JButton("Status"));
        LISTADBOTOES.put("BCargo", new JButton("Cargo"));
        LISTADBOTOES.put("BEscala", new JButton("Escala"));
        LISTADBOTOES.put("BGaragem", new JButton("Garagem"));
        LISTADBOTOES.put("BViagem", new JButton("Viagem"));
        LISTADBOTOES.put("BSair", new JButton("Sair"));

        for (JButton botao : LISTADBOTOES.values()) {
            botao.setHorizontalAlignment(SwingConstants.CENTER);
            botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
            botao.setForeground(Color.WHITE);
            botao.setBackground(new Color(25,25,112));

            painel.add(botao);
        
        }

    }

    //Criando o painel do centro
    
      private Map<String,JButton> OptionFunc;

    public void panelFuncionario() {

        OptionFunc = new HashMap<>();

        centerpanel.removeAll();

        JPanel PAINELFuncionario = new JPanel();
    
        
       OptionFunc.put("CreateFuncionario",new JButton("Adicionar Funcionario"));
       OptionFunc.put("DeleteFunc",new JButton("Deletar Funcionario"));
       OptionFunc.put("ReadFunc",new JButton("Listar Funcionario"));
       OptionFunc.put("AtualizarFunc",new JButton("Atualizar Funcionario")); 
       
       

        JPanel botaoPainel = new JPanel();
        botaoPainel.setPreferredSize(new Dimension(500,300));
        botaoPainel.setBackground(Color.decode("#0D2EFF"));
        botaoPainel.setLayout(new GridLayout(0,1,10,10));
        JLabel Func = new JLabel("Funcionario",JLabel.CENTER);
        botaoPainel.setBorder(new LineBorder(Color.black,2, true));
        Func.setFont(new Font("Segoe UI",Font.BOLD,20));
        Func.setForeground(Color.WHITE);
        //Adicionando Botoes dentro do painel
        botaoPainel.add(Func); 
      

        for(JButton botao:OptionFunc.values()){
            botao.setBackground(Color.decode("#000000"));
            botao.setForeground(Color.decode("#FFFFFF"));
            botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
            botaoPainel.add(botao);
            
           
            
        };
   
        

        PAINELFuncionario.add(botaoPainel);
        

        centerpanel.add(PAINELFuncionario,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionFuncionario();
    }

    private Map<String,JButton> optionStatus;
    public void panelStatus(){

        optionStatus =new HashMap<>();

        JPanel panelstatus =new JPanel();

        optionStatus.put("AdicionaStatus",new JButton("Adicionar novo Status"));
        optionStatus.put("DeletarStatus",new JButton("Deletar um Status"));
        optionStatus.put("ListarStatus",new JButton("Listar Status"));
optionStatus.put("AtualizarStatus",new JButton("Atualizar Status"));
        

        JPanel statusbutton = new JPanel();
        statusbutton.setPreferredSize(new Dimension(500,300));
        statusbutton.setBackground(Color.decode("#0D2EFF"));
        statusbutton.setLayout(new GridLayout(0,1,10,10));
        statusbutton.setBorder(new LineBorder(Color.black,2, true));
        
        
        JLabel textS =new JLabel("Status Menu",JLabel.CENTER);
        textS.setForeground(Color.WHITE);
        textS.setFont(new Font("Segoi UI",Font.BOLD,20));
        statusbutton.add(textS);

        for (JButton botao : optionStatus.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
            statusbutton.add(botao);
        }

        panelstatus.add(statusbutton);
        centerpanel.add(panelstatus,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionStatus();

    }

    private Map <String,JButton> optionCargo;
    public void panelCargo(){
        optionCargo=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelCargo = new JPanel();

        optionCargo.put("AdicionarCargo",new JButton("Adicionar Cargo"));
        optionCargo.put("ExcluirCargo",new JButton("Excluir Cargo"));
        optionCargo.put("ListarCargo",new JButton("Listar Cargo"));
        optionCargo.put("AtualizarCargo",new JButton("Atualizar Cargo"));

        JButton CargoButtonPanel= new JButton();
        CargoButtonPanel.setPreferredSize(new Dimension(500,300));
        CargoButtonPanel.setLayout(new GridLayout(0,1,10,10));
        CargoButtonPanel.setBackground(Color.decode("#0D2EFF"));
        CargoButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textCargo = new JLabel("Menu de Cargo",JLabel.CENTER);
        textCargo.setFont(new Font("Segoi UI",Font.BOLD,20));
        textCargo.setForeground(Color.white);
        CargoButtonPanel.add(textCargo);

        for (JButton botao : optionCargo.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                CargoButtonPanel.add(botao);
        }


        panelCargo.add(CargoButtonPanel);
        centerpanel.add(panelCargo,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionCargo();

    }

    private Map <String,JButton> optionOnibus;
    public void panelOnibus(){
        optionOnibus=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelOnibus = new JPanel();

        optionOnibus.put("AdicionarOnibus",new JButton("Adicionar Onibus"));
        optionOnibus.put("ExcluirOnibus",new JButton("Excluir Cor"));
        optionOnibus.put("ListarOnibus",new JButton("Listar Onibus"));
        optionOnibus.put("AtualizarOnibus",new JButton("Atualizar Onibus"));

        JButton OnibusButtonPanel= new JButton();
        OnibusButtonPanel.setPreferredSize(new Dimension(500,300));
        OnibusButtonPanel.setLayout(new GridLayout(0,1,10,10));
        OnibusButtonPanel.setBackground(Color.decode("#0D2EFF"));
        OnibusButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textOnibus = new JLabel("Menu de Onibus",JLabel.CENTER);
        textOnibus.setForeground(Color.white);
        textOnibus.setFont(new Font("Segoi UI",Font.BOLD,20));
        OnibusButtonPanel.add(textOnibus);


        for (JButton botao : optionOnibus.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                OnibusButtonPanel.add(botao);
        }


        panelOnibus.add(OnibusButtonPanel);
        centerpanel.add(panelOnibus,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionOnibus();

    }

    private Map <String,JButton> optionViagem;
    public void panelViagem(){
        optionViagem=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelViagem = new JPanel();

        optionViagem.put("AdicionarViagem",new JButton("Adicionar Viagem"));
        optionViagem.put("ExcluirViagem",new JButton("Excluir Viagem"));
        optionViagem.put("ListarViagem",new JButton("listar Viagem"));
        optionViagem.put("AtualizarViagem",new JButton("Atualizar Viagem"));

        JButton ViagemButtonPanel= new JButton();
        ViagemButtonPanel.setPreferredSize(new Dimension(500,300));
        ViagemButtonPanel.setLayout(new GridLayout(0,1,10,10));
        ViagemButtonPanel.setBackground(Color.decode("#0D2EFF"));
        ViagemButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textViagem = new JLabel("Menu de Viagem",JLabel.CENTER);
        textViagem.setFont(new Font("Segoi UI",Font.BOLD,20));
        textViagem.setForeground(Color.white);
        ViagemButtonPanel.add(textViagem);

        for (JButton botao : optionViagem.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                ViagemButtonPanel.add(botao);
        }


        panelViagem.add(ViagemButtonPanel);
        centerpanel.add(panelViagem,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionViagem();

    }

    private Map <String,JButton> optionGaragem;
    public void panelGaragem(){
        optionGaragem=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelGaragem = new JPanel();

        optionGaragem.put("AdicionarGarage",new JButton("Adicionar Garage"));
        optionGaragem.put("ExcluirGarage",new JButton("Excluir Garage"));
        optionGaragem.put("ListarGarage",new JButton("Listar Garage"));
        optionGaragem.put("AtualizarGarage",new JButton("Atualizar Garage"));

        JPanel GarageButtonPanel= new JPanel();
        GarageButtonPanel.setPreferredSize(new Dimension(500,300));
        GarageButtonPanel.setLayout(new GridLayout(0,1,10,10));
        GarageButtonPanel.setBackground(Color.decode("#0D2EFF"));
        GarageButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textGaragem = new JLabel("Menu de Cor",JLabel.CENTER);
        textGaragem.setFont(new Font("Segoi UI",Font.BOLD,20));
        textGaragem.setForeground(Color.white);
        GarageButtonPanel.add(textGaragem);

        for (JButton botao : optionGaragem.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                GarageButtonPanel.add(botao);
        }


        panelGaragem.add(GarageButtonPanel);
        centerpanel.add(panelGaragem,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionGaragem();

    }

    private Map <String,JButton> optionLinhas;
    public void panelLinhas(){
        optionLinhas=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelLinhas = new JPanel();

        optionLinhas.put("AdicionarLinhas",new JButton("Adicionar Linhas"));
        optionLinhas.put("ExcluirLinhas",new JButton("Excluir Linhas"));
        optionLinhas.put("ListarLinhas",new JButton("Linhas Linhas"));
        optionLinhas.put("AtualizarLinhas",new JButton("Atualizar Linhas"));

        JButton LinhasButtonPanel= new JButton();
        LinhasButtonPanel.setPreferredSize(new Dimension(500,300));
        LinhasButtonPanel.setLayout(new GridLayout(0,1,10,10));
        LinhasButtonPanel.setBackground(Color.decode("#0D2EFF"));
        LinhasButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textLinhas = new JLabel("Menu de Linhas",JLabel.CENTER);
        textLinhas.setForeground(Color.white);
        textLinhas.setFont(new Font("Segoi UI",Font.BOLD,20));
        LinhasButtonPanel.add(textLinhas);

        for (JButton botao : optionLinhas.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                LinhasButtonPanel.add(botao);
        }


        panelLinhas.add(LinhasButtonPanel);
        centerpanel.add(panelLinhas,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionLinha();
    }

    private Map <String,JButton> optionEscala;
    public void panelEscala(){
        optionEscala=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelEscala = new JPanel();

        optionEscala.put("AdicionarEscala",new JButton("Adicionar Escala"));
        optionEscala.put("ExcluirEscala",new JButton("Excluir Escala"));
        optionEscala.put("ListarEscala",new JButton("Listar Escala"));
        optionEscala.put("AtualizarEscala",new JButton("Atualizar Escala"));
        

        JButton EscalaButtonPanel= new JButton();
        EscalaButtonPanel.setPreferredSize(new Dimension(500,300));
        EscalaButtonPanel.setLayout(new GridLayout(0,1,10,10));
        EscalaButtonPanel.setBackground(Color.decode("#0D2EFF"));
        EscalaButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textEscala = new JLabel("Menu de Escala",JLabel.CENTER);
        textEscala.setFont(new Font("Segoi UI",Font.BOLD,20));
        textEscala.setForeground(Color.white);
        EscalaButtonPanel.add(textEscala);

        for (JButton botao : optionEscala.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                EscalaButtonPanel.add(botao);
        }


        panelEscala.add(EscalaButtonPanel);
        centerpanel.add(panelEscala,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionEscala();
    }

    private Map <String,JButton> optionCor;
    public void panelCor(){
        optionCor=new HashMap<>();

        centerpanel.removeAll();

        JPanel panelCor = new JPanel();

        optionCor.put("AdicionarCor",new JButton("Adicionar Cor"));
        optionCor.put("ExcluirCor",new JButton("Excluir Cor"));
        optionCor.put("ListarCor",new JButton("Listar Cor"));
        optionCor.put("AtualizarCor",new JButton("Atualizar Cor"));
        

        JPanel CorButtonPanel= new JPanel();
        CorButtonPanel.setPreferredSize(new Dimension(500,300));
        CorButtonPanel.setLayout(new GridLayout(0,1,10,10));
        CorButtonPanel.setBackground(Color.decode("#0D2EFF"));
        CorButtonPanel.setBorder(new LineBorder(Color.BLACK,2,true));

        JLabel textCor = new JLabel("Menu de Cor",JLabel.CENTER);
        textCor.setFont(new Font("Segoi UI",Font.BOLD,20));
        textCor.setForeground(Color.white);
        CorButtonPanel.add(textCor);

        for (JButton botao : optionCor.values()) {
                botao.setBackground(Color.decode("#000000"));
                botao.setForeground(Color.decode("#FFFFFF"));
                botao.setFont(new Font("Segoi UI",Font.BOLD,20));
                CorButtonPanel.add(botao);
        }


        panelCor.add(CorButtonPanel);
        centerpanel.add(panelCor,BorderLayout.CENTER);
        centerpanel.revalidate();
        centerpanel.repaint();
        BactionCor();
    }



    //Adiciona efeito nos botoes  no panel a esquerda
    public void Baction() {
       
      

        LISTADBOTOES.get("BFuncionario").addActionListener(e->{
            
            try {
                panelFuncionario();     
            } catch (Exception r) {
                System.out.println("error de :"+r.getMessage());
            }

        });

        LISTADBOTOES.get("BStatus").addActionListener(e ->{

            try{
                panelStatus();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BCargo").addActionListener(e ->{

            try{
                panelCargo();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BSair").addActionListener(e ->{

            try{
                System.exit(0);
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BEscala").addActionListener(e ->{

            try{
                panelEscala();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BOnibus").addActionListener(e ->{

            try{
                panelOnibus();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BViagem").addActionListener(e ->{

            try{
                panelViagem();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BCor").addActionListener(e ->{

            try{
                panelCor();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BLinhas").addActionListener(e ->{

            try{
                panelLinhas();
            }catch(Exception d ){
                System.out.println("Error : "+d.getMessage());
            }

        });

        LISTADBOTOES.get("BGaragem").addActionListener(e ->{
            try {
                panelGaragem();
            } catch (Exception u) {
                System.err.println("Error : "+u.getMessage());
            }
        });

    }


        // adiciona efeito nos botoes do jpanel no center
    public void BactionFuncionario(){

        OptionFunc.get("CreateFuncionario").addActionListener(e->{
            try {
                System.out.println("HALOHA");
                addfuncionario adicionarfunctionariowindow = new addfuncionario();
                adicionarfunctionariowindow.setVisible(true);
            } catch (Exception f) {
                System.err.println("Erro de : "+f.getMessage());
            }
        });

        OptionFunc.get("DeleteFunc").addActionListener(e ->{
            try {
                deleteFuncionario delfunc = new deleteFuncionario();
                delfunc.setVisible(true);
            } catch (Exception d) {
                System.err.print("Error de : "+d.getMessage());
                
            }
        });

        OptionFunc.get("ReadFunc").addActionListener(e ->{
            try {
                listFuncionario list = new listFuncionario();
                list.setVisible(true);
            } catch (Exception k) {
                System.err.println("Error de :"+k.getMessage());
                 
            }

        });

                 OptionFunc.get("AtualizarFunc").addActionListener(e ->{
            try {
                attfuncionario atualizarFuncionario= new attfuncionario();
                atualizarFuncionario.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });

    }


    public void BactionStatus(){


        optionStatus.get("AdicionaStatus").addActionListener(e ->{
            
            try {
                addStatus statusadd = new addStatus();
                statusadd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionStatus.get("DeletarStatus").addActionListener(e->{
            try {
                deletestatus delstatus = new deletestatus();
                delstatus.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionStatus.get("ListarStatus").addActionListener(e ->{
            try {
                listStatus liStatus  = new listStatus();
                liStatus.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

        
         optionStatus.get("AtualizarStatus").addActionListener(e ->{
            try {
                attstatus atualizarStatus= new attstatus();
                atualizarStatus.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });





        
       
    }

    public void BactionCor(){


        optionCor.get("AdicionarCor").addActionListener(e ->{
            
            try {
                addCor coradd = new addCor();
                coradd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionCor.get("ExcluirCor").addActionListener(e->{
            try {
                deleteCor delCor = new deleteCor();
                delCor.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionCor.get("ListarCor").addActionListener(e ->{
            try {
                listCor lisCor  = new listCor();
                lisCor.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

         optionCor.get("AtualizarCor").addActionListener(e ->{
            try {
                attcor atualizarCor= new attcor();
                atualizarCor.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });





        
       
    }


    public void BactionLinha(){


        optionLinhas.get("AdicionarLinhas").addActionListener(e ->{
            
            try {
                addLinha linhadd = new addLinha();
                linhadd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionLinhas.get("ExcluirLinhas").addActionListener(e->{
            try {
                deleteLinha deLinha = new deleteLinha();
                deLinha.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionLinhas.get("ListarLinhas").addActionListener(e ->{
            try {
                listLinha linhalist  = new listLinha();
                linhalist.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });


         optionLinhas.get("AtualizarLinhas").addActionListener(e ->{
            try {
                attlinha atualizarLinhas= new attlinha();
                atualizarLinhas.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });




        
       
    }


    public void BactionViagem(){


        optionViagem.get("AdicionarViagem").addActionListener(e ->{
            
            try {
                addViagem adViagem = new addViagem();
                adViagem.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionViagem.get("ExcluirViagem").addActionListener(e->{
            try {
                deletaViagem delviagem = new deletaViagem();
                delviagem.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionViagem.get("ListarViagem").addActionListener(e ->{
            try {
                listViagem listViagem  = new listViagem();
                listViagem.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

           optionViagem.get("AtualizarViagem").addActionListener(e ->{
            try {
                attviagem atualizarViagem= new attviagem();
                atualizarViagem.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });

    }


    public void BactionGaragem(){


        optionGaragem.get("AdicionarGarage").addActionListener(e ->{
            
            try {
                addGaragem garagemadd = new addGaragem();
                garagemadd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionGaragem.get("ExcluirGarage").addActionListener(e->{
            try {
                deleteGaragem delGaragem = new deleteGaragem();
                delGaragem.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionGaragem.get("ListarGarage").addActionListener(e ->{
            try {
                listGaragem garagemList  = new listGaragem();
                garagemList.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

          optionGaragem.get("AtualizarGarage").addActionListener(e ->{
            try {
                attgaragem atualizargaragem= new attgaragem();
                atualizargaragem.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });
    }


    public void BactionCargo(){


        optionCargo.get("AdicionarCargo").addActionListener(e ->{
            
            try {
                addCargo Cargoadd = new addCargo();
                Cargoadd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionCargo.get("ExcluirCargo").addActionListener(e->{
            try {
                deleteCargo cargodel = new deleteCargo();
                cargodel.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionCargo.get("ListarCargo").addActionListener(e ->{
            try {
                listCargo cargolist  = new listCargo();
                cargolist.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

        optionCargo.get("AtualizarCargo").addActionListener(e ->{
            try {
                attCargo atualizarCargo = new attCargo();
                atualizarCargo.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });





        
       
    }


    public void BactionEscala(){


        optionEscala.get("AdicionarEscala").addActionListener(e ->{
            
            try {
                 addescala addEscala  = new addescala();
                addEscala.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionEscala.get("ExcluirEscala").addActionListener(e->{
            try {
                deleteEscala delEscala = new deleteEscala();
                delEscala.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionEscala.get("ListarEscala").addActionListener(e ->{
            try {
                listEscala listescala  = new listEscala();
                listescala.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });

        optionEscala.get("AtualizarEscala").addActionListener(e ->{
            try {
                attescala atualizarEscala = new attescala();
                atualizarEscala.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });

       
    }


    
    public void BactionOnibus(){


        optionOnibus.get("AdicionarOnibus").addActionListener(e ->{
            
            try {
                 addOnibus onibusadd  = new addOnibus();
                onibusadd.setVisible(true);
            } catch (Exception a) {
                System.err.println("error de : "+a.getMessage());
            }

        });


        optionOnibus.get("ExcluirOnibus").addActionListener(e->{
            try {
                deleteOnibus delOnibus = new deleteOnibus();
                delOnibus.setVisible(true);
            } catch (Exception z) {
                System.err.println("Error : "+z.getMessage());
            }
        });


        optionOnibus.get("ListarOnibus").addActionListener(e ->{
            try {
                listOnibus Lonibus= new listOnibus();
                Lonibus.setVisible(true);
            } catch (Exception b) {
                System.out.println("Error  :"+b.getMessage());
            }
        });



          optionOnibus.get("AtualizarOnibus").addActionListener(e ->{
            try {
                attonibus atualizarOnibus = new attonibus();
                atualizarOnibus.setVisible(true);
            } catch (Exception m) {
                System.out.println("Error de : "+m.getMessage());
            }
        });



        
       
    }








        
       
    










}
