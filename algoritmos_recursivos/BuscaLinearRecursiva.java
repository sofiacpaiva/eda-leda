
public class BuscaLinearRecursiva {

    public void buscaLinearRecursiva(int[] v, int N, int idx) {
        if (idx == v.length) {
            System.out.println("-1");
            return;
        }
        if (v[idx] == N) {
            System.out.println(idx);
            return;
        }
        buscaLinearRecursiva(v, N, idx+1);

    }
    
}
