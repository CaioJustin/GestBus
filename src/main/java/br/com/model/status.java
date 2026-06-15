package br.com.model;

public class status {
     private int id;
     private String nome ;

    public status(String n){
        this.nome=n;
    }

    public status(int id,String n){
        this.id=id;
        this.nome=n;
    }

    public status(int d ){
        this.id=d;
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
