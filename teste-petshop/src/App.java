import java.util.Scanner;

import equipamento.MaquinaBanho;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MaquinaBanho mb = new MaquinaBanho();
        int opcao;
        do {
            System.out.println("===Escolha uma das opções:===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer água");
            System.out.println("3 - Abastecer shampoo");
            System.out.println("4 - Verificar água");
            System.out.println("5 - Verificar shampoo");
            System.out.println("6 - Verificar se a máquina está limpa");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - retirar pet da máquina");
            System.out.println("9 - limpar máquina");
            System.out.println("0 - sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> mb.darBanho();
                case 2 -> mb.adicionarAgua();
                case 3 -> mb.adicionarShampoo();
                case 4 -> mb.getQuantidadeAgua();
                case 5 -> mb.getQuantidadeShampoo();
                case 6 -> mb.isLimpo();
                case 7 -> mb.colocarPet();
                case 8 -> mb.retirarPet();
                case 9 -> mb.limparMaquina();
                case 0 -> System.out.println("Encerrando utilização da máquina");
                default -> System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcao != 0);
        sc.close();
    }
}
