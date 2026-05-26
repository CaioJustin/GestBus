package br.com.model;

public class cor {
    private int id;
      private String nome ;

    public cor(String n){
        this.nome=n;

    }

    public cor(int id,String nome){
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
