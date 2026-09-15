
public class soma {
    public int[] two_sum(int[] v, int target) {
        int[] array = new int[2];
        for (int i = 0; i < v.length; i++) {
            for (int j = i+1; j < v.length; j++) {
                if ((v[i] + v[j]) == target) {
                    array[0] = v[i];
                    array[1] = v[j];
                }
            }
        }
        return array;
    }
    
}
