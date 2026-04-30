package br.com.model;

public class onibus {
    
    private int placa;
    private String modelo;
    private String anoDeFabrica;
    private int capacidade;
    private int Status_id;
    private int Cor_id;
    private int Garagem_id;

    public onibus(int p ,String m,String a ,int capa,int Sta,int cor,int gara){
        this.placa=p;
        this.modelo=m;
        this.anoDeFabrica=a;
        this.capacidade=capa;
        this.Status_id=Sta;
        this.Cor_id=cor;
        this.Garagem_id=gara;
    }



    public int getPlaca(){
        return this.placa;
    }

    
    public void setPlaca(int p ){
        this.placa= p;
    }

    public String getModelo(){
        return this.modelo;
    }   

    
    public void setModelo(String m){
        this.modelo= m;
    }

    public String getAnoFabri(){
        return this.anoDeFabrica;
    }

    
    public void setAnoFabricado(String a){
        this.anoDeFabrica= a;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    
    public void setCapacidade(int cap){
        this.capacidade= cap;
    }

    public int getSta(){
        return this.Status_id;
    }   

    
    public void setSta(int sta){
        this.Status_id= sta;
    }


      public int getCor(){
        return this.Cor_id;
    }   

    
    public void setCor(int color){
        this.Cor_id= color;
    }


      public int getGaragem(){
        return this.Garagem_id;
    }   

    
    public void setGaragem(int gar){
        this.Garagem_id= gar;
    }


}
