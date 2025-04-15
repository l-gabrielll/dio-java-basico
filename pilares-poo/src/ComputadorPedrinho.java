import java.util.Scanner;

import apps.FacebookMessenger;
import apps.MSNMessenger;
import apps.ServicoMensagemInstantania;
import apps.Telegram;

public class ComputadorPedrinho {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ServicoMensagemInstantania smi = null;

        String appEscolhido;
        do {
            System.out.println("Escolha o aplicativo a ser utilizado sendo:\n" + //
                        "fcb = Facebook\n" +
                        "msn = MSN\n" +
                        "tlg = Telegram");
            appEscolhido = sc.nextLine().toUpperCase();
        }
        while (!appEscolhido.equals("MSN") && !appEscolhido.equals("TLG") && !appEscolhido.equals("FCB"));

        if (appEscolhido.equals("MSN")) {
            smi = new MSNMessenger();
        } else if (appEscolhido.equals("FCB")) {
            smi = new FacebookMessenger();
        } else if (appEscolhido.equals("TLG")) {
            smi = new Telegram();
        }

        smi.enviarMensagem();
        smi.receberMensagem();

        sc.close();
    }
}
