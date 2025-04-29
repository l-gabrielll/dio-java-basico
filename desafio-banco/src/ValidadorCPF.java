public class ValidadorCPF {
    public static boolean validarCpf(String cpf) {
        if (cpf.length() == 11 && cpf.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
}
