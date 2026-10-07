public class QuickSort implements Sorting {

    @Override
    public void sort (int[] elements) {


    }

    public int particionamento(int[] v, int left, int right) {
        int pivot = v[left];
        int i = left;
    
        for (int j = left+1; j < right; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
        }
        swap(v, left, i);

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

