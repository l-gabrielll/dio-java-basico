import java.util.Random;

public class ExemploDoWhile {
	public static void main(String[] args) {
		System.out.println("Discando...");

		do {
			// excutando repetidas vezes até alguém atender
			System.out.println("Telefone tocando");

		} while (tocando());

		System.out.println("Alô !!!");
	}

	/*Método que gera números aleatórios até 2 e cada número gerado simula que o telefone tocou uma vez. E o número 1 foi selecionado para simular que a pessoa atendeu a chamada. Então caso o número gerado seja o 1, a expressão de validação do while se tornará falsa e o telefone para de tocar*/
	private static boolean tocando() {
		boolean toque = new Random().nextInt(3) == 1;
		System.out.println("Atendeu? " + toque);
		// negando o ato de continuar tocando
		return !toque;
	}
}