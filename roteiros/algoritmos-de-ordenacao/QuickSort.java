public class QuickSort   {

    public int particionamento(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini;
    
        for (int j = ini+1; j < fim; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
        }
        swap(v, ini, i);

        return i;
    }

    private void swap(int[] v, int i, int j) {
       int temp = v[i];
       v[i] = v[j];
       v[j] = temp;
    }

    public void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int idxPivot = particionamento(v, left, right);
            quickSort(v, left, idxPivot-1);
            quickSort(v, idxPivot+1, right);

        }
    }

}

