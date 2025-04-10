package candidatura;

import java.util.Locale;
import java.util.Scanner;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        imprimirSelecionados();
        /*selecaoCandidatos();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("informe a quantidade de candidatos: ");
        int quantidadeCandidatos = scanner.nextInt();

        for (int x = 0; x < quantidadeCandidatos; x++) {
        System.out.println("Digite o valor do salário pretendido: ");
        double salarioPretendido = scanner.nextDouble();

        String retorno = analisarCandidato(salarioPretendido);
        System.out.println(retorno);
        }

        scanner.close();*/
    }

    public static void imprimirSelecionados() {
         String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

         System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

         for (String candidato : candidatos){
            System.out.println("A candidatura de " + candidato + " foi aprovada para a vaga.");
         }
    }

    public static void selecaoCandidatos(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            System.out.println(candidato + " digite o valor do salário pretendido: ");
            double salarioPretendido = scanner.nextDouble();

            System.out.println("O salário pretendido de " + candidato + " é de R$ " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println(candidato + " teve sua candidatura aprovada para a vaga.");
                candidatosSelecionados ++;
            }
            candidatoAtual ++;
        }
        scanner.close();
    }

    public static String analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        String resultado;
        if (salarioBase > salarioPretendido) {
            resultado = "Ligar para o candidato";           
        } else if (salarioBase == salarioPretendido) {
            resultado = "Ligar para o candidato com contra proposta";
        } else {
            resultado = "Aguardando resultado dos demais candidatos";
        }
        return resultado;
    }
}