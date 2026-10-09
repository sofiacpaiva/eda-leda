package algoritmos_divisao_e_conquista;

public class LomutoMedianaTres {

    public static int particionamento(int[] v) {   
        int ini = 0;
        int fim = v.length - 1;
        
        int medianaIdx = indiceMedianaDeTres(v, ini, fim);
        swap(v, ini, medianaIdx);
        
        int pivot = v[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
        }
        
        swap(v, ini, i);
        return i;
    }

    private static int indiceMedianaDeTres(int[] v, int ini, int fim) {
        int meio = (ini + fim) / 2;
        
        if ((v[ini] >= v[meio] && v[ini] <= v[fim]) || (v[ini] <= v[meio] && v[ini] >= v[fim])) {
            return ini;
        } else if ((v[meio] >= v[ini] && v[meio] <= v[fim]) || (v[meio] <= v[ini] && v[meio] >= v[fim])) {
            return meio;
        } else {
            return fim;
        }
    }

    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
