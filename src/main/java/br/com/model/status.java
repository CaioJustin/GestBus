package br.com.model;

public class status {
     private int id;
     private String nome ;

     //Metodo Construtor
    public status(String n){
        this.nome=n;
    }
//Metodo Construtor
    public status(int id,String n){
        this.id=id;
        this.nome=n;
    }
//Metodo Construtor
    public status(int d ){
        this.id=d;
    }


    //Metodos get e set
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
