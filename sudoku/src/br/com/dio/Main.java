package br.com.dio;

import br.com.dio.model.Quadro;
import br.com.dio.model.Espaco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static br.com.dio.util.ModeloQuadro.MODELO_QUADRO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Quadro quadro;

    private final static int LIMITE_QUADRO = 9;

    public static void main(String[] args) {
        final var posicoes = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var opcao = -1;
        while (true){
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> iniciarJogo(posicoes);
                case 2 -> numeroEntrada();
                case 3 -> removerNumero();
                case 4 -> mostrarJogoAtual();
                case 5 -> mostrarStatusJogo();
                case 6 -> limparJogo();
                case 7 -> finalizarJogo();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    private static void iniciarJogo(final Map<String, String> posicao) {
        if (nonNull(quadro)){
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Espaco>> espacos = new ArrayList<>();
        for (int i = 0; i < LIMITE_QUADRO; i++) {
            espacos.add(new ArrayList<>());
            for (int j = 0; j < LIMITE_QUADRO; j++) {
                var configPosicao = posicao.get("%s,%s".formatted(i, j));
                var valorEsperado = Integer.parseInt(configPosicao.split(",")[0]);
                var fixa = Boolean.parseBoolean(configPosicao.split(",")[1]);
                var espacoAtual = new Espaco(valorEsperado, fixa);
                espacos.get(i).add(espacoAtual);
            }
        }

        quadro = new Quadro(espacos);
        System.out.println("O jogo está pronto para começar");
    }


    private static void numeroEntrada() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Informe a coluna que em que o número será inserido");
        var coluna = executarAteObterUmNumeroValido(0, 8);
        System.out.println("Informe a linha que em que o número será inserido");
        var linha = executarAteObterUmNumeroValido(0, 8);
        System.out.printf("Informe o número que vai entrar na posição [%s,%s]\n", coluna, linha);
        var valor = executarAteObterUmNumeroValido(1, 9);
        if (!quadro.alterarValor(coluna, linha, valor)){
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", coluna, linha);
        }
    }

    private static void removerNumero() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Informe a coluna que em que o número será inserido");
        var coluna = executarAteObterUmNumeroValido(0, 8);
        System.out.println("Informe a linha que em que o número será inserido");
        var linha = executarAteObterUmNumeroValido(0, 8);
        if (!quadro.limparValor(coluna, linha)){
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", coluna, linha);
        }
    }

    private static void mostrarJogoAtual() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < LIMITE_QUADRO; i++) {
            for (var coluna: quadro.getEspacos()){
                args[argPos ++] = " " + ((isNull(coluna.get(i).getValorAtual())) ? " " : coluna.get(i).getValorAtual());
            }
        }
        System.out.println("Seu jogo se encontra da seguinte forma");
        System.out.printf((MODELO_QUADRO) + "\n", args);
    }

    private static void mostrarStatusJogo() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.printf("O jogo atualmente se encontra no status %s\n", quadro.getStatus().getDescricao());
        if(quadro.hasErrors()){
            System.out.println("O jogo contém erros");
        } else {
            System.out.println("O jogo não contém erros");
        }
    }

    private static void limparJogo() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso?");
        var confirmar = scanner.next();
        while (!confirmar.equalsIgnoreCase("sim") && !confirmar.equalsIgnoreCase("não")){
            System.out.println("Informe 'sim' ou 'não'");
            confirmar = scanner.next();
        }

        if(confirmar.equalsIgnoreCase("sim")){
            quadro.reiniciar();
        }
    }

    private static void finalizarJogo() {
        if (isNull(quadro)){
            System.out.println("O jogo ainda não foi iniciado iniciado");
            return;
        }

        if (quadro.jogoFinalizado()){
            System.out.println("Parabéns você concluiu o jogo");
            mostrarJogoAtual();
            quadro = null;
        } else if (quadro.hasErrors()) {
            System.out.println("Seu jogo conté, erros, verifique seu board e ajuste-o");
        } else {
            System.out.println("Você ainda precisa preenhcer algum espaço");
        }
    }


    private static int executarAteObterUmNumeroValido(final int min, final int max){
        var atual = scanner.nextInt();
        while (atual < min || atual > max){
            System.out.printf("Informe um número entre %s e %s\n", min, max);
            atual = scanner.nextInt();
        }
        return atual;
    }

}