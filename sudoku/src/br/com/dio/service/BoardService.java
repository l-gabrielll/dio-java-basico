package br.com.dio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.dio.model.Espaco;
import br.com.dio.model.Quadro;
import br.com.dio.model.StatusEnum;

public class BoardService {

    private final static int LIMITE_QUADRO = 9;

    private final Quadro quadro;

    public BoardService(final Map<String, String> configJogo) {
        this.quadro = new Quadro(initQuadro(configJogo));
    }

    public List<List<Espaco>> getEspacos() {
        return this.quadro.getEspacos();
    }

    public void reiniciar() {
        quadro.reiniciar();
    }

    public boolean hasErrors() {
        return quadro.hasErrors();
    }

    public StatusEnum getStatus() {
        return quadro.getStatus();
    }

    public boolean jogoFinalizado() {
        return quadro.jogoFinalizado();
    }

    private List<List<Espaco>> initQuadro(Map<String, String> configJogo) {
        List<List<Espaco>> espacos = new ArrayList<>();
        for (int i = 0; i < LIMITE_QUADRO; i++) {
            espacos.add(new ArrayList<>());
            for (int j = 0; j < LIMITE_QUADRO; j++) {
                var configPosicao = configJogo.get("%s,%s".formatted(i, j));
                var valorEsperado = Integer.parseInt(configPosicao.split(",")[0]);
                var fixa = Boolean.parseBoolean(configPosicao.split(",")[1]);
                var espacoAtual = new Espaco(valorEsperado, fixa);
                espacos.get(i).add(espacoAtual);
            }
        }

       return espacos;
    }

    
}
