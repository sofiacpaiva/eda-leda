package algoritmos_quadraticos;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortPasso {

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        selectionSort(valores);
        sc.close();
        
    }
    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int menor = encontraMenor(v, i);
            if (menor != i) { //se o número não for ele mesmo
                swap(v, i, menor); //indices
                System.out.println(Arrays.toString(v));
            }
        }

    }

    private static int encontraMenor(int[] v, int i) {
        int idxmenor = i;
        for (int j = i; j < v.length; j++) {
            if (v[j] <= v[idxmenor]) {
                idxmenor = j;
            }
        }
        return idxmenor;
    }

    private static void swap(int[]v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
