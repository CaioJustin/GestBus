package br.com.model;

public class escala {

        private String horario_inicio;
        private String horario_fim;


    public escala(String hf,String hi){
        this.horario_fim=hf;
        this.horario_inicio=hi;

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


}
