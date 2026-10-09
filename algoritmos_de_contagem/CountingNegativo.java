package algoritmos_de_contagem;

public class CountingNegativo {
    public static void countingNegativo(int[] v) {
        int k = achaMaior(v) + Math.abs(achaMenor(v))+1;
        int[] C = new int[k];
        int menor = achaMenor(v);

        //frequencia
        for (int i = 0; i < v.length; i++) {
            C[v[i]-menor]++;
        }

        // acumulativa
        for (int j = 1; j < C.length; j++) {
            C[j] += C[j-1];
        }

        int[] B = new int[v.length];
        for (int i = v.length-1; i >= 0; i--) {
            B[C[v[i]-menor]-1] = v[i];
            C[v[i]-menor] --;
        }

        for (int i = 0; i < v.length; i++) {
            v[i] = B[i];
        }
    }

    private static int achaMenor(int[] v) {
        int menor = v[0];
        for (int i = 0; i < v.length; i++) {
            if (v[i] < menor) {
                menor = v[i];
            }
        }
        return menor;
    }

        private static int achaMaior(int[] v) {
        int maior = v[0];
        for (int i = 0; i < v.length; i++) {
            if (v[i] > maior) {
                maior = v[i];
            }
        }
        return maior;
    }
}
