package br.com.dio.model;

public enum StatusEnum {

    NAO_INICIADO("não iniciado"),
    INCOMPLETO("incompleto"),
    COMPLETO("completo");

    private String descricao;

    StatusEnum(final String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}