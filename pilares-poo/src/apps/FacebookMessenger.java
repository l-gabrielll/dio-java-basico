package apps;
public class FacebookMessenger extends ServicoMensagemInstantania{
    @Override
    public void enviarMensagem() {
        validarConexaoInternet();
        System.out.println("Enviando mensagem pelo Facebook");
    }
    @Override
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo Facebook");
    }
}
