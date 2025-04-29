import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarContaCorrente(Cliente cliente) {
        ContaCorrente conta = new ContaCorrente(cliente);
        contas.add(conta);
    }

    public void adicionarContaPoupanca(Cliente cliente) {
        ContaPoupanca conta = new ContaPoupanca(cliente);
        contas.add(conta);
    }

    public Conta buscarContaPornumero(int numero){
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> buscarContaPorCpf(String cpf) {
        if(!ValidadorCPF.validarCpf(cpf)) {
        System.out.println("CPF inválido! O CPF deve conter 11 números.");
        return new ArrayList<>();
        }

        List<Conta> contasCliente = new ArrayList<>();
        for(Conta conta : contas) {
                if (conta.getCliente().cpf().equals(cpf)) {
                    contasCliente.add(conta);
                } 
            }
        if (ValidadorCPF.validarCpf(cpf) && contasCliente.isEmpty()) {
            System.out.println("Nenhuma conta encontrada com o CPF: " + cpf);
            return new ArrayList<>();
        }   
        return  contasCliente;
    }

    public String getNome() {
        return nome;
    }
}
