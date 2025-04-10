package candidatura;

import java.util.Locale;
import java.util.Scanner;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("informe a quantidade de candidatos: ");
        int quantidadeCandidatos = scanner.nextInt();

        for (int x = 0; x < quantidadeCandidatos; x++) {
        System.out.println("Digite o valor do salário pretendido: ");
        double salarioPretendido = scanner.nextDouble();

        String retorno = analisarCandidato(salarioPretendido);
        System.out.println(retorno);
        }

        scanner.close();
    }

    public static String analisarCandidato(double salarioCandidato){
        double salarioBase = 2000.0;
        String resultado;
        if (salarioBase > salarioCandidato) {
            resultado = "Ligar para o candidato";           
        } else if (salarioBase == salarioCandidato) {
            resultado = "Ligar para o candidato com contra proposta";
        } else {
            resultado = "Aguardando resultado dos demais candidatos";
        }
        return resultado;
    }
}
