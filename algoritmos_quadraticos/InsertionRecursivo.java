package algoritmos_quadraticos;
import java.util.Scanner;
import java.util.Arrays;

public class InsertionRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        insertionRecursivo(valores, 1);
        
        sc.close();
    }

    public static void insertionRecursivo(int[] v, int idx) {
        if (idx >= v.length) {
            return;
        }
        int j = idx;
        while (j > 0 && v[j] < v[j-1]) {
            swap(v, j, j-1);
            j--;
        }
        System.out.println(Arrays.toString(v));
        insertionRecursivo(v, idx+1);
    }
    

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
