package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.StatusEnum.COMPLETO;
import static br.com.dio.model.StatusEnum.INCOMPLETO;
import static br.com.dio.model.StatusEnum.NAO_INICIADO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Quadro {

    private final List<List<Espaco>> espacos;

    public Quadro(final List<List<Espaco>> espacos) {
        this.espacos = espacos;
    }

    public List<List<Espaco>> getEspacos() {
        return espacos;
    }

    public StatusEnum getStatus(){
        if (espacos.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixa() && nonNull(s.getValorAtual()))){
            return NAO_INICIADO;
        }

        return espacos.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getValorAtual())) ? INCOMPLETO : COMPLETO;
    }

    public boolean hasErrors(){
        if(getStatus() == NAO_INICIADO){
            return false;
        }

        return espacos.stream().flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getValorAtual()) && !s.getValorAtual().equals(s.getValorEsperado()));
    }

    public boolean alterarValor(final int coluna, final int linha, final int valor){
        var espaco = espacos.get(coluna).get(linha);
        if (espaco.isFixa()){
            return false;
        }

        espaco.setValorAtual(valor);
        return true;
    }

    public boolean limparValor(final int coluna, final int linha){
        var espaco = espacos.get(coluna).get(linha);
        if (espaco.isFixa()){
            return false;
        }

        espaco.espacoLivre();
        return true;
    }

    public void reiniciar(){
        espacos.forEach(c -> c.forEach(Espaco::espacoLivre));
    }

    public boolean jogoFinalizado(){
        return !hasErrors() && getStatus().equals(COMPLETO);
    }

}