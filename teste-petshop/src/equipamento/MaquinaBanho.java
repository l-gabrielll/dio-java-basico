package equipamento;

import java.util.Scanner;

import cliente.Pet;

public class MaquinaBanho {
    Scanner sc = new Scanner(System.in);
    private final int maxAgua = 30;
    private final int maxShampoo = 10;
    private int quantidadeAgua = 0;
    private int quantidadeShampoo = 0;
    private boolean limpa = true;
    private Pet pet;

    public void darBanho() {
        if (this.pet == null) {
            System.out.println("Coloque um pet na máquina de banho");
            return;
        }
        if (quantidadeAgua <  10 || quantidadeShampoo < 2) {
            System.out.println("Reabasteça a máquina!");
            System.out.println("Para realizar o banho é necessário utilizar 10L de água e 2L de shampoo");
            System.out.println("Quantidade atual: Água " + quantidadeAgua + "L | Shampoo " + quantidadeShampoo + "L");
            return;
        }

        System.out.println("Dando banho no " + pet.getNome());
        quantidadeAgua -= 10;
        quantidadeShampoo -= 2;
        pet.setLimpo(true);
        System.out.println("O Banho do " + pet.getNome() + " foi finalizado");
    }

    public void adicionarAgua(){
        if(quantidadeAgua + 2 <= maxAgua) {
            System.out.println("Adicionando 2L de água");
            quantidadeAgua += 2;
            System.out.println("Quantidade de água após adição: " + quantidadeAgua + "L");
            return;
        }

        System.out.println("A quantidade de água já está no máximo");
    }

    public void adicionarShampoo(){
        if(quantidadeShampoo + 2 <= maxShampoo) {
            System.out.println("Adicionando 2L de água");
            quantidadeShampoo += 2;
            System.out.println("Quantidade de água após adição: " + quantidadeShampoo + "L");
            return;
        }

        System.out.println("A quantidade de shampoo já está no máximo");
    }

    public void getQuantidadeAgua() {
        System.out.println("A quantidade de água é: " + quantidadeAgua + "L");
    }

    public void getQuantidadeShampoo() {
        System.out.println("A quantidade de shampoo é: " + quantidadeShampoo + "L");
    }
    
    public void isLimpo() {
        if (!limpa) {
            System.out.println("A máquina está suja");
            return;
        }
        System.out.println("A máquina está limpa");
    }

    public void colocarPet() {
        String nome = "";
        if (!limpa) {
            System.out.println("A máquina está suja, para colocar um novo pet é necessário realizar a limpeza");
            return;
        }
        if (this.pet != null) {
            System.out.println("Já tem um pet na máquina");
            return;
        }
        
        // TODO: Verificar o que acontece se tirar a segunda verificação do while "nome.isEmpty"
        while (nome == null || nome.isEmpty()) {
            System.out.println("Informe o nome do pet");
            nome = sc.nextLine();
        }
        pet = new Pet(nome);
        System.out.println(pet.getNome() + " está na máquina");
    }

    public void retirarPet() {
        if (pet == null) {
            System.out.println("Não tem pet na máquina");
            return;
        }
        if (pet.isLimpo() == false) {
            limpa = false;
        }
        System.out.println(pet.getNome() + " foi retirado da máquina");
        pet = null;
    }

    public void limparMaquina() {
        if (limpa) {
            System.out.println("Não é necessário realizar uma limpeza. A máquina já está limpa");
            return;
        }

        if (quantidadeAgua <  3 || quantidadeShampoo < 1) {
            System.out.println("Reabasteça a máquina!");
            System.out.println("Para realizar a limpeza da máquina é necessário utilizar 3L de água e 1L de shampoo");
            System.out.println("Quantidade atual: Água " + quantidadeAgua + "L | Shampoo " + quantidadeShampoo + "L");
            return;
        }
        quantidadeAgua -= 3;
        quantidadeShampoo -= 1;
        limpa = true;
        System.out.println("A máquina já está limpa");
    }
}
