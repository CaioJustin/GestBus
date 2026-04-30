package br.com.model;

public class funcionario {
    

    
    
    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
     private int Status_id;
    private int Cargo_id;
    private int Escala_id;

    public funcionario(String n,String s ,String cpf,String datanasc,int sta,int car,int esc){
        this.nome=n;
        this.sobrenome=s;
        this.cpf=cpf;
        this.dataNascimento=datanasc;
        this.Status_id=sta;
        this.Cargo_id=car;
        this.Escala_id=esc;
    }



    public String getNome(){
        return this.nome;
    }

    
    public void setNome(String nom){
        this.nome= nom;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }   

    
    public void setModelo(String s){
        this.sobrenome=s;
    }

    public String getCpf(){
        return this.cpf;
    }

    
    public void setCpf(String cp){
        this.cpf= cp;
    }

    public String getDataNas(){
        return this.dataNascimento;
    }

    
    public void setDataNasc(String nas){
        this.dataNascimento= nas;
    }

    public int getSta(){
        return this.Status_id;
    }   

    
    public void setSta(int sta){
        this.Status_id= sta;
    }


      public int getCargo(){
        return this.Cargo_id;
    }   

    
    public void setCor(int carg){
        this.Cargo_id=carg;
    }


      public int getEscala(){
        return this.Escala_id;
    }   

    
    public void setEscala(int Esc){
        this.Escala_id= Esc;
    }


    
}
