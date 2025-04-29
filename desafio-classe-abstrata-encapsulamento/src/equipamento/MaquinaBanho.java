package equipamento;

import cliente.Pet;

public class MaquinaBanho {

    private boolean limpo = true;
    private int agua = 30;
    private int shampoo = 10;
    private Pet pet;


    public void darBanho() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        this.agua -= 10;
        this.shampoo -= 2;
        pet.setLimpo(true);
        System.out.println("O pet " + pet.getNome() + " está limpo.");
    }

    public void adicionarAgua(){
        if (agua == 30) {
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }
        agua += 2;
    }

    public void adicionarShampoo(){
        if (shampoo == 10) {
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }
        shampoo += 2;
    }

    public int getAgua() {
        return agua;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean temPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.limpo) {
            System.out.println("A máquina está suja, para colocar um novo pet é necessário realizar a limpeza");
            return;
        }
        if (temPet()) {
            System.out.println("O pet " + this.pet.getNome() + " Está na máquina.");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getNome() + " foi colocado na máquina");
    }

    public void retirarPet(){
        this.limpo = this.pet.getLimpo();

        System.out.println("O pet " + this.pet.getNome() + " foi retirado da máquina");
        this.pet = null;
    }

    public void limpar() {
        this.agua -= 10;
        this.shampoo -= 2;
        this.limpo = true;
        System.out.println("A máquina está limpa");
    }
}