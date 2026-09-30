public class CountingSort implements Sorting {

    @Override
    public void sort(int[] elements) {

    }

    //* O Counting Sort simples é um algoritmo de ordenação
    // n+k, em que o n é o tamanho do array a ser ordenado e 
    // o k é o maior valor do array. Esse algoritmo não é
    // in-place e é estável.*/

    public static int[] countingSimples(int[] A, int k) {
        //* Um array auxiliar C é criado com k elementos.
        // Ou seja, se o maior elemento de um array de 4 
        // posições for 12, por exemplo, o array C auxiliar
        // terá 12 posições. */
        boolean[] C = new boolean[k];
        
        //* É feita uma passada pelo array A, o qual conduzirá
        // o array C da seguinte forma: a posição de C (que 
        // será determinada pelo valor do elemento do array A-1)
        // é preenchida com true. */
        for (int i = 0; i < A.length; i++) {
            C[A[i]-1] = true;
        }

        //* É criado um novo array B com a mesma quantidade de 
        // posições que o array A. */
        int[] B = new int[A.length];
        //* Para que não ocorra erro de índice caso k seja 
        // diferente de n, é criada uma variável j iniciada em 0. */
        int j = 0;

        //* O array C é percorrido. Para cada true encontrado,
        // o valor no novo array B é o índice daquele true + 1. */
        for (int i = 0; i < C.length; i++) {
            if (C[i] == true) {
                B[j] = i+1;
                j++;
            }
        }
        return B;
    }

    public static int[] countingComRepeticao(int[] A, int k) {
        int[] C = new int[k];
        // frequencia
        for (int i = 0; i < A.length; i++) {
            C[A[i]-1]++;
        }

        // acumulativa
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }

        int[] B = new int[A.length];

        for (int i = A.length-1; i >= 0; i--) {
            B[C[A[i]-1]-1] = A[i];
            C[A[i]-1] --;
        }

        return B;

    }


    
}
