package cliente;

public class Pet {
    final private String nome;
    private boolean limpo;

    public Pet(String nome) {
        this.nome = nome;
        this.limpo = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean getLimpo() {
        return limpo;
    }

    public void setLimpo(boolean clean) {
        this.limpo = clean;
    }

    
}
