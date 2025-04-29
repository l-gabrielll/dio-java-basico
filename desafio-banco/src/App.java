import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String cpf;
        Cliente cliente1 = new Cliente("João", "12345678912");
        Cliente cliente2 = new Cliente("Maria", "98765432198");
        Banco banco = new Banco("Tudo");
        banco.adicionarContaCorrente(cliente1);
        banco.adicionarContaPoupanca(cliente1);
        banco.adicionarContaPoupanca(cliente2);
        banco.getContas().get(0).imprimirExtrato();
        System.out.println("========================");
        banco.getContas().get(1).imprimirExtrato();
        System.out.println("========================");
        banco.getContas().get(2).imprimirExtrato();
        

        List<Conta> contasCliente;
        while (true) {
            System.out.println("Digite o CPF (Apenas números):");
            cpf = sc.nextLine();
            contasCliente = banco.buscarContaPorCpf(cpf);

            if (!contasCliente.isEmpty()) {
                System.out.println("========Contas encontradas========");
                for (int i = 0; i < contasCliente.size(); i++) {
                    System.out.println((i + 1) + " - Conta " + contasCliente.get(i).getNumero() + " | Tipo: "
                            + contasCliente.get(i).getClass().getSimpleName());
                }
                break;
            }
        }

        int opcao;
        do {
            System.out.println("Escolha o número da conta que deseja acessar: ");
            opcao = sc.nextInt();
            if (opcao < 1 || opcao > contasCliente.size()) {
                System.out.println("Opção inválida");
            }
        } while (opcao < 1 || opcao > contasCliente.size());

        double valor;
        int numeroDestinatario;
        Conta contaSelecionada = contasCliente.get(opcao - 1);
        do {
            System.out.println("Opção 1 para sacar");
            System.out.println("Opção 2 para depositar");
            System.out.println("Opção 3 para transferir");
            System.out.println("Opção 4 para ver o extrato");
            System.out.println("Opção 0 para encerrar");
            System.out.println("Escolha uma das opções acima:");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor a ser sacado:");
                    valor = sc.nextDouble();
                    contaSelecionada.sacar(valor);
                    break;
                case 2:
                    System.out.println("Informe o valor a ser depositado:");
                    valor = sc.nextDouble();
                    contaSelecionada.depositar(valor);
                    break;
                case 3:
                    System.out.println("Informe a número da conta do destinatário: ");
                    numeroDestinatario = sc.nextInt();
                    Conta contaDestinatario = banco.buscarContaPornumero(numeroDestinatario);
                    if (contaDestinatario == null) {
                        System.out.println("Nenhuma conta encontrada com o número: " + numeroDestinatario);
                    } else {
                        System.out.println("Informe o valor a ser transferido:");
                        valor = sc.nextDouble();
                        contaSelecionada.transferir(valor, contaDestinatario);
                    }
                    break;
                case 4: 
                    contaSelecionada.imprimirExtrato();
                    break;
                case 0:
                    contaSelecionada.imprimirExtrato();
                    System.out.println("Encerrando utilização da máquina");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcao != 0);
        sc.close();
    }
}
