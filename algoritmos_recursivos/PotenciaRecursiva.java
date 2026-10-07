
public class PotenciaRecursiva {
    
    public static int potenciaRecursiva(int i, int j) {
        if (j == 0) {
            return 1;
        }
        return i * potenciaRecursiva(i, j-1);
    }
}
