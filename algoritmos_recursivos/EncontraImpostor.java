
public class EncontraImpostor {
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
