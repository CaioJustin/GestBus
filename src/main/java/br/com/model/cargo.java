package br.com.model;

public class cargo {
    
    private String nome ;
    private int id;

    public cargo(String n){ 
        this.nome=n;
    }

    public cargo(int id,String nome){
        this.id=id;
        this.nome=nome;
    }

    public String GetNome(){
        return this.nome;
    }

    public void SetNome(String name){
        this.nome= name;
    }

    
    public int Getid(){
        return this.id;
    }

    public void Setid(int d){
        this.id= d;
    }

}
