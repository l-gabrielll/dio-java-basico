//Importando classe para simular valor aleatório
import java.util.concurrent.ThreadLocalRandom;
public class ExemploWhile {
public static void main(String[] args) {
	double mesada = 50.0;
    double valorPago = 0;
        while(mesada>0) {
            Double valorDoce = valorAleatorio();
            if(valorDoce > mesada)
                valorDoce = mesada;

            System.out.println("Doce de R$" + String.format("%.2f", valorDoce) + " adicionado no carrinho");
            mesada = mesada - valorDoce;
            valorPago += valorDoce; 
        }
        System.out.println("Valor pago R$" + String.format("%.2f", valorPago));
        System.out.println("Mesada R$" + String.format("%.2f", mesada));
        System.out.println("Joãozinho gastou toda a sua mesada em doces");
   }

   //Método utilizado para gerar valores aletórios acima de 2 e abaixo de 8
   private static double valorAleatorio() {
	return ThreadLocalRandom.current().nextDouble(2, 8);
   }
}