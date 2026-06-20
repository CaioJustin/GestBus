package br.com.model;

public class linha {
    
    
    private int id;
    private String nome;
    private String origem;
    private String destino;
    
    public linha(String n,String o ,String d){
        this.nome=n;
        this.origem=o;
        this.destino=d;
    }

     public linha(int id,String n,String o ,String d){
        this.id=id;
        this.nome=n;
        this.origem=o;
        this.destino=d;
    }


    
 public String getNome(){
        return this.nome;
    }

    
    public void setNome(String nom){
        this.nome= nom;
    }

    public String getOrigem(){
        return this.origem;
    }

    
    public void setOrigem(String o){
        this.origem= o;
    }

    public String getDestino(){
        return this.destino;
    }

    
    public void setDestino(String d){
        this.destino= d;
    }

    public int Getid(){
        return this.id;
    }

    public void Setid(int d){
        this.id= d;
    }
    

    
}
