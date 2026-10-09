package algoritmos_contagem;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }

        radixSort(valores);
        
        sc.close();
    }
    
    public static void radixSort(int[] v) {
        int maxNum = achaMax(v);
        int qtdeDigitos = ("" + maxNum).length();

        for (int nDig = 2; nDig <= qtdeDigitos; nDig+= 2) {
            sort(v, nDig);
            System.out.println(Arrays.toString(v));
        }
    }

    private static int achaMax(int[] v) {
        int maior = v[0];
        for (int i = 0; i < v.length; i++) {
            if (v[i] > maior) {
                maior = v[i];
            }
        }
        return maior;
    }

    private static void sort(int[] v, int n) {
        int[] C = new int[100]; //freq

        for (int i = 0; i < v.length; i++) {
            int index = v[i] % Math.powExact(10, n);
            index = index / Math.powExact(10, n-2);
            C[index]++;
        }

        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        
        int[] B = new int[v.length];
        for (int i = v.length-1; i >= 0; i--) {
            int index = v[i] % Math.powExact(10, n);
            index = index / Math.powExact(10, n-2);
            B[C[index]-1] = v[i];
            C[index]--;

        }

        for (int i = 0; i < B.length; i++) {
            v[i] = B[i];
        }


    }
}
