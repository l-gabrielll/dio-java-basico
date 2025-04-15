package apps;
public abstract class ServicoMensagemInstantania {
    public abstract void enviarMensagem();
    public abstract void receberMensagem();

    protected void validarConexaoInternet() {
        System.out.println("Validando se está conectado a internet");
    }
}
