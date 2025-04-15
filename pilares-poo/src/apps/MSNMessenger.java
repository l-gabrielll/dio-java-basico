package apps;
public class MSNMessenger extends ServicoMensagemInstantania{
    @Override
    public void enviarMensagem() {
        validarConexaoInternet();
        System.out.println("Enviando mensagem pelo MSN");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo MSN");
    }
}
