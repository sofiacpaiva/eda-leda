
public class EncontraPrimeiroNegativo {

    public static void encontraNegativo(int[] v, int idx) {

        if (idx == v.length) {
            System.out.print("-");
            return;
        }
        if (v[idx] < 0) {
            System.out.println(v[idx]);
            return;
        }
        encontraNegativo(v, idx+1);
    }
    
}
