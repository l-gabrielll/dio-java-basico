public class ExemploBreakContinue {
    public static void main(String[] args) {
        int numeros[] = {1,3,5,7,8,9};
        for(int x = 0; x < numeros.length; x ++){
            if(numeros[x]%2==0)
            break;

            System.out.println(numeros[x]);
        }
    }
}