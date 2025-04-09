import java.util.Locale;
import java.util.Scanner;

public class CalcularMediaTurma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        String alunos[] = {"Luã", "Luan", "hiroshi", "Calixto"};

        double media = calcularMediaTurma(alunos, scan);

        System.out.printf("A média da turma é %.1f", media);
    }

    public static double calcularMediaTurma(String alunos[], Scanner scanner) {
        double soma = 0;
        for(String aluno : alunos) {
            System.out.printf("Nota do aluno %s: ", aluno);
            double nota = scanner.nextDouble();
            
            soma += nota;
        }
        return soma / alunos.length;
    }
    
}
