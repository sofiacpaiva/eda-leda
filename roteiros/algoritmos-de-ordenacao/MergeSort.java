//* O MergeSort é um algoritmo de ordenação que se baseia no processo de 
// divisão e conquista. Do ponto de vista da análise assintótica, o desempenho
// desse algoritmo é n*log(n), independente da situação, para todos os casos. 
// Isso dá uma garantia que, idependente da disposição dos dados em um
// array, a ordenação sempre será eficiente.*/ 

//* O MergeSort se baseia no merge, uma rotina que se repete diversas vezes
// no processo até que o array seja completamente ordenado. */

public class MergeSort {
    
    public static void main(String[] args) {
        
    }

    //* O merge com dois arrays funciona da seguinte forma: recebemos
    // dois arrays, já previamente ordenados, e comparamos cada elemento 
    // um a um. Após cada comparação, o elemento é colocado num array resultante,
    // cujo tamanho é a soma da quantidade de posições dos dois arrays a serem
    // comparados. */
    public static int[] mergeComDoisArrays(int[] a, int[] b) {
        // array resultante v
        int[] v = new int[a.length + b.length];
        // indicador de posição do array a
        int i = 0;
        // indicador de posição do array b
        int j = 0;
        // indicador de posição do array v
        int k = 0;

        //* enquanto ambos os ponteiros não atingem o final de seus respectivos
        // arrays, o laço continua. é comparado o elemento do array a com o elemento
        // do array b. caso o elemento de a seja menor, é feito seu append no array v, e 
        // i e k são acrescentados. No entanto, caso o contrário, é feito o append do
        //  elemento do array b no array v, e b e k são acrescentados.
        // */
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                v[k] = a[i];
                i++;
            }
            else {
                v[k] = b[j];
                j++;
            }
            k++;
        }

        //* Caso os arrays sejam de tamanhos diferentes, se o array a ainda 
        // possui elementos a serem comparados e como não há com quem comparar,
        // apenas é feito o append do restante de seus elementos no array v. */
        while (i < a.length) {
            v[k++] = a[i++];
        }
        //* Da mesma forma, caso sobrem elementos no array b, eles são apenas 
        // adicionados no array v. */
        while (j < b.length) {
            v[k++] = b[j++];
        }
        return v;
    }


    //* O Merge com um array que ambas as metades estão ordenadas funciona de 
    // forma bastante semelhante a um Merge com dois arrays ordenados. A diferença
    // é que, ao invés de ambos os ponteiros começarem com 0, eles são calculados
    // a partir do tamanho do próprio array. */
    public static void mergeComUmArrayMetade(int[] a, int ini, int fim) {
        //* Aqui, estou estabelecendo que o início é um parâmetro da função,
        // porque não sabemos se a ordenação começará, necessariamente, em 0.
        // Da mesma forma, o fim não precisa ser necessariamente o length do array. */
        int i = ini; 
        int meio = (ini + fim)/2;
        //* A separação virtual do array cujas ambas as metades já estão ordenadas
        // é o meio. */
        int j = meio;
        int k = ini;

        //* Um novo array é criado do tamanho do array a ser ordenado. */
        int[] v = new int[a.length];

        //** O mesmo processo do Merge com dois arrays é iniciado. São comparados,
        // um a um, os elementos de cada metade do array e adicionados ao array v,
        // da mesma forma que os ponteiros são acrescentados de forma diferente dependendo
        // da comparação.  */ 
        while (i < meio && j < fim) {
            if (a[i] <= a[j]) {
                v[k++] = a[i++];
            }
            else {
                v[k++] = a[j++];
            }
        }
        while (i < meio) {
            v[k++] = a[i++];
        }
        while (j < fim) {
            v[k++] = a[j++];
        }

        //** Como a ordenação pode começar apenas em um pedaço do array, se a função
        // retornar o array auxiliar, ele pode 'apagar' algumas posições. Por exemplo,
        // se eu quero começar a ordenar um array a partir da segunda posição e devolver
        // o array que me ajudará nisso, você não concorda que os elementos que não foram 
        // inclusos na ordenação serão ignorados? Para resolver isso, fazemos 
        // um append dos números ordenados de volta para o array original.*/
        
        for (int p = ini; p < fim; p++) {
            a[p] = v[p];
        }
    
    }

    //* O Merge utilizado no MergeSort possui uma característica diferente: ele deve ser 
    // capaz de criar um array auxiliar, do tamanho da quantidade de elementos a serem 
    // ordenados.*/
    public void merge(int[] v, int left, int right) {

        //* distância entre o começo e o final do pedaço do array que 
        // queremos copiar */
        int rightHelper = right-left;
        //* como um array começa do índice 0, o tamanho total dele precisa
        // ser rightHelper+1 */
        int[] helper = new int[rightHelper+1];
        //* O i é o contaodr de passos, já que o array v não necessariamente
        // começa em 0. */
        for (int i = 0; i < helper.length; i++) {
            helper[i] = v[left+i];
        }

        //* Dividimos virtualmente o array para a ordenação. */
        int middleHelper = rightHelper/2;

        int i = 0;
        int j = middleHelper+1;
        int k = left;

        //* O mesmo processo de comparação dos demais Merge's se inicia. */
        while (i <= middleHelper && j <= rightHelper) {
            if (helper[i] <= helper[j]) {
                v[k++] = helper[i++];
            }
            else {
                v[k++] = helper[j++];
            }
        }
        while ( i < middleHelper) {
            v[k++] = helper[i++];
        }

    }
    
    //* O MergeSort utiliza do Merge diversas vezes até a ordenação total, como
    // dito anteriormente.  */
    public void mergeSort(int[] v, int left, int right) {
        //* Caso o tamanho virtual do array seja 1, não será mais necessária
        // a repartição. */
        if (left >= right) {
            return;
        }
        else {
            int middle = (left+right)/2;
            mergeSort(v, left, middle); // T(n/2) 
            mergeSort(v, middle+1, right); // T(n/2)

            merge(v, left, right); // O(n)
        }
    }


}

