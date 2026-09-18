public class TrocaVizinhos {
    public static void trocaVizinhos(int[] array) {
        // o i é acrescentado 2 unidades de cada vez, para que, assim, apenas vizinhos pares sejam
        // trocados
        for (int i = 0; i < array.length - 1; i += 2) {
            // para sobreescrever um valor em java, precisa-se obrigatoriamente de uma variável auxiliar
            int aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] = aux;
        }
    }

    public static void main(String[] args) {
        trocaVizinhos(new int[0]);
    }
}
