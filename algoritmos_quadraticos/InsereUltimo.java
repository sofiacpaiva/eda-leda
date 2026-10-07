package algoritmos_quadraticos;


import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        insereUltimo(valores);
        System.out.println(Arrays.toString(valores));
        
    }

    public static void insereUltimo(int[] v) {
        for (int i = v.length-1; i > 0; i--) {
            if (v[i-1] > v[i]) {
                swap(v, i, i-1); 
            }
        }

    }
    
    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
