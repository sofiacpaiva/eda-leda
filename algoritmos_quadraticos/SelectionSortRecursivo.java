package algoritmos_quadraticos;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        selectionRecursivo(valores, 0);
        sc.close();
    }

    public static void selectionRecursivo(int[] v, int idx) {
        if (idx >= v.length-1) {
            return;
        }
        int idxMenor = achaMenor(v, idx);
        
        swap(v, idxMenor, idx);
        System.out.println(Arrays.toString(v));
        
        selectionRecursivo(v, idx + 1);
    }

    private static int achaMenor(int[] v, int idx) {
        int idxMenor = idx;
        for (int j = idx; j < v.length; j++) {
            if (v[j] < v[idxMenor]) {
                idxMenor = j;
            }
        }
        return idxMenor;
    }

    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
