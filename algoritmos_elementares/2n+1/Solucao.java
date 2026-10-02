/* import java.util.Scanner;
public class Solucao {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        System.out.println(geraSequencia(numero));
    }

    public static int geraSequencia(int n) {
        if (n == 1) {
            return 1;
        }
        if (n/2 == 0) {
            int novo = n/2;
            System.out.println(novo);
            geraSequencia(novo);
        } else {
            int novo = n*3 + 1;
            System.out.println(novo);
            geraSequencia(novo);
        }
    }
}
 */