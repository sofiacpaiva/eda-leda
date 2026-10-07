
public class BuscaBinaria {
    
    public static int buscaBinaria(int[] v, int ini, int fim, int n) {
        if (ini > fim){
            return -1;
        }
        int meio = (ini+fim)/2;

        if (n == v[meio]) {
            return meio;
        }
        if (n < v[meio]) {
            return buscaBinaria(v, ini, meio-1, n);
        }
        else {
            return buscaBinaria(v, meio+1, fim, n);
        }

    }
}
