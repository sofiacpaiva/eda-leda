import java.util.Scanner;
public class Solucao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        String[] pedacos = linha.split(" ");
        int numeros[] = new int[pedacos.length];

        for (int i = 0; i < pedacos.length; i++) {
            numeros[i] = Integer.parseInt(pedacos[i]);
        }

        System.out.println(verificaDuplicados(numeros));
    }

    public static boolean verificaDuplicados(int[] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = i+1; j < v.length; j++) {
                if (v[i] == v[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}