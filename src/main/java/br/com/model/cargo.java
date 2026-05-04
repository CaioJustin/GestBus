package br.com.model;

public class cargo {
    
    private String nome ;

    public cargo(String n){
        this.nome=n;
    }

    public String GetNome(){
        return this.nome;
    }

    public void SetNome(String name){
        this.nome= name;
    }

}
