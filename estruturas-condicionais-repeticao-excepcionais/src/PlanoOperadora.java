// Modo condicional switch/case
public class PlanoOperadora {
	public static void main(String[] args) {
		String plano = "T"; // M / T

		switch (plano) {
			case "T": {
				System.out.println("5Gb Youtube");
			}
			case "M": {
				System.out.println("Whats e Instagram grátis");
			}
			case "B": {
				System.out.println("100 minutos de ligação");
			}
		}
	}
}

/* 
 // Modo condicional convencional(Nesse caso o switch case é a melhor opção por conta que nele não é necessário ficar repetindo algumas linhas de código, como no if)

public class PlanoOperadora {
	public static void main(String[] args) {
		String plano = "M"; //M / T
		
		if(plano == "B") {
			System.out.println("100 minutos de ligação");
		}else if(plano == "M") {
			System.out.println("100 minutos de ligação");
			System.out.println("Whats e Intagram grátis");	
		}else if(plano == "T") {
			System.out.println("100 minutos de ligação");
			System.out.println("Whats e Intagram grátis");	
			System.out.println("5Gb Youtube");	
		}
			
		
	}
}
 */
