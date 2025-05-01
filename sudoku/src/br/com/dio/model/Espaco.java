package br.com.dio.model;

public class Espaco {

    private Integer valorAtual;
    private final int valorEsperado;
    private final boolean fixa;


    public Espaco(final int valorEsperado, final boolean fixa) {
        this.valorEsperado = valorEsperado;
        this.fixa = fixa;
        if (fixa){
            valorAtual = valorEsperado;
        }
    }

    public Integer getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(final Integer valorAtual) {
        if (fixa) return;
        this.valorAtual = valorAtual;
    }

    public void espacoLivre(){
        setValorAtual(null);
    }

    public int getValorEsperado() {
        return valorEsperado;
    }

    public boolean isFixa() {
        return fixa;
    }
}