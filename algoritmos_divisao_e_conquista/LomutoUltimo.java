package algoritmos_divisao_e_conquista;

import java.util.Arrays;
import java.util.Scanner;

public class LomutoUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }

        int fim = valores.length-1;
        quickSort(valores, 0, fim);
        
        sc.close();
    }

    public static int particionamento(int[] v, int ini, int fim) {
        int pivot = v[fim];
        int i = ini;

        for (int j = i; j < fim; j++) {
            if (v[j] <= pivot) {
                swap(v, i, j);
                i++;          
            }
        }
        swap(v, i, fim);
        System.out.println(Arrays.toString(v));
        return i;

    }
    public static void quickSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int idxPivot = particionamento(v, ini, fim);
            quickSort(v, ini, idxPivot-1);
            quickSort(v, idxPivot+1, fim);

        }
    } 

    
    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}