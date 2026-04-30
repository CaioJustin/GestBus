package br.com.model;

public class viagem {
    
  
    
    private String descricao;
    private String data_partida;
    private String data_chegara;
    private int Escala_id;
    private int Linha_id;
   

    public viagem(String des,String datap ,String dataC,int escal,int linha){
        this.descricao=des;
        this.data_partida=datap;
        this.data_chegara=dataC;
        this.Escala_id=escal;
        this.Linha_id=linha;
        
    }

    public String getDesc(){
        return this.descricao;
    }

    
    public void setNome(String desc){
        this.descricao= desc;
    }

    public String getDataPar(){
        return this.data_partida;
    }   

    
    public void setDataPar(String dataP){
        this.data_partida=dataP;
    }

    public String getDataChe(){
        return this.data_chegara;
    }

    
    public void setDataChe(String dataC){
        this.data_chegara= dataC;
    }

    public int getLinha(){
        return this.Linha_id;
    }

    
    public void setLinha(int l){
        this.Linha_id= l;
    }

  
    public int getEscala(){
        return this.Escala_id;
    }   

    
    public void setEscala(int Esc){
        this.Escala_id= Esc;
    }


    

}
