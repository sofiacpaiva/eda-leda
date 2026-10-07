package algoritmos_quadraticos;

import java.util.Arrays;
import java.util.Scanner;

public class InserePrimeiro {

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        inserePrimeiro(valores);
        System.out.println(Arrays.toString(valores));
        
        sc.close();
    }
    public static void inserePrimeiro(int[] v) {
        for (int i = 0; i < v.length-1; i++) {
            if (v[i] > v[i+1]) {
                swap(v, i, i+1);
            } else {
                break;
            }
        }
    }
    
    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
    
}
