package br.com.model;

public class escala {
        private int id;
        private String horario_inicio;
        private String horario_fim;
        private String dataC;


    public escala(String hf,String hi){
        this.horario_fim=hf;
        this.horario_inicio=hi;

    }

     public escala(int id,String hf,String hi,String data){
        this.id=id;
        this.horario_fim=hf;
        this.horario_inicio=hi;
        this.dataC=data;

    }

    public escala(int id,String hi,String hf){
        this.id=id;
        this.horario_inicio=hi;
        this.horario_fim=hf;    
    }

    public String getHorarioInicio(){
        return this.horario_inicio;
    }

    public void setHorarioInicio(String hi){
        this.horario_inicio= hi;

    }

     public String getHorarioFim(){
        return this.horario_fim;
    }

    public void setHorarioFim(String hf){
        this.horario_fim= hf;

    }

     public int Getid(){
        return this.id;
    }

    public void Setid(int d){
        this.id= d;
    }

    public String GetData(){
        return this.dataC;
    }

    public void SetData(String c){
        this.dataC=c;
    }
}
