import java.util.Scanner;

import cliente.Pet;
import equipamento.MaquinaBanho;

public class App {

    private final static Scanner sc = new Scanner(System.in);
    private final static MaquinaBanho maquinaBanho = new MaquinaBanho();
    public static void main(String[] args) throws Exception {
        int opcao = -1;

        do {
            System.out.println("===Escolha uma das opções:===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer água");
            System.out.println("3 - Abastecer shampoo");
            System.out.println("4 - Verificar água");
            System.out.println("5 - Verificar shampoo");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - retirar pet da máquina");
            System.out.println("9 - limpar máquina");
            System.out.println("0 - sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> maquinaBanho.darBanho();
                case 2 -> adicionarAgua();
                case 3 -> adicionarShampoo();
                case 4 -> verificarÁgua();
                case 5 -> verificarShampoo();
                case 6 -> verificarSeTemPetNaMaquina();
                case 7 -> setPetMaquina();
                case 8 -> maquinaBanho.retirarPet();
                case 9 -> maquinaBanho.limpar();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (true);
    }

    private static void adicionarAgua() {
        System.out.println("Tentando colocar água na máquina");
        maquinaBanho.adicionarAgua();
        System.out.println("A máquina está no momento com " + maquinaBanho.getAgua() + " Litro(s) de água");
    }

    private static void adicionarShampoo() {
        System.out.println("Tentando colocar shampoo na máquina");
        maquinaBanho.adicionarShampoo();
        System.out.println("A máquina está no momento com " + maquinaBanho.getShampoo() + " Litro(s) de shampoo");
    } 

    private static void verificarÁgua() {
        int quantidade = maquinaBanho.getAgua();
        System.out.println("A máquina está no momento com " + quantidade + " Litro(s) de água");
    }

    private static void verificarShampoo() {
        int quantidade = maquinaBanho.getShampoo();
        System.out.println("A máquina está no momento com " + quantidade + " Litro(s) de shampoo");
    }

    private static void verificarSeTemPetNaMaquina() {
        boolean temPet = maquinaBanho.temPet();
        System.out.println(temPet ? "Tem pet na máquina" : "Não tem pet na máquina");
    }

    public static void setPetMaquina () {
        String nome = "";
        while (nome == null || nome.isEmpty()) {
            System.out.println("Informe o nome do pet");
            sc.nextLine();
            nome = sc.nextLine();
        }
        Pet pet = new Pet(nome);
        maquinaBanho.setPet(pet);
    }

}
