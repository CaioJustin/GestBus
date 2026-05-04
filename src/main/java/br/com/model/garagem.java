package br.com.model;

public class garagem {
    
    private String nome;
    private String cidade;
    private String rua;
    private String bairro;
    private String cep;
    private int vagas;

    public garagem(String n,String c,String r,String b,String cep,int vaga){
            this.nome=n;
            this.cidade=c;
            this.rua=r;
            this.bairro=b;
            this.cep=cep;
            this.vagas=vaga;
        
    }

    public String getNome(){
        return this.nome;
    }

    
    public void setNome(String n){
        this.nome= n;
    }

    public String getCidade(){
        return this.cidade;
    }   

    
    public void setCidade(String c){
        this.cidade= c;
    }

    public String getRua(){
        return this.rua;
    }

    
    public void setRua(String r){
        this.rua= r;
    }

    public String getBairro(){
        return this.bairro;
    }

    
    public void setBairro(String b){
        this.bairro= b;
    }

    public String getCep(){
        return this.cep;
    }   

    
    public void setCep(String ce){
        this.cep= ce;
    }


    public int getVagas(){
        return this.vagas;
    }

      public void setVagas(int s ){
        this.vagas=s;
    }

}
