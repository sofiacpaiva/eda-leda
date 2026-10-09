import java.util.Scanner;

public class EncontraImpostor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] valores = new int[entrada.length];
        
        for (int i = 0; i < entrada.length; i++) {
            valores[i] = Integer.parseInt(entrada[i]);
        }
        System.out.println(encontraImpostor(valores,0));
        
    }

    public static int encontraImpostor(int[] v, int idx) {
        if (idx == v.length-1) {
            return -1;
        }
        if (v[idx+1] < v[idx]) {
            return idx+1;
        }
        return encontraImpostor(v, idx+1);
    }    
}
