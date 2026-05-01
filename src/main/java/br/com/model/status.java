package br.com.model;

public class status {
    
     private String nome ;

    public status(String n){
        this.nome=n;
    }

    public String GetNome(){
        return this.nome;
    }

    public void SetNome(String name){
        this.nome= name;
    }

}
