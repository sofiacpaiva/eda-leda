package roteiros.arraylist;

public class ArrayList {
    private int[] lista;
    private int size;
   
    public ArrayList(int sizeInicial) {
        this.lista = new int[sizeInicial];
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void addFirst(int valor) {
        asseguresize(this.size+1);
        this.shiftRight(0);
        this.lista[0] = valor;

        size += 1;

    }

    public void addLast(int valor) {
        asseguresize(this.size+1);
        this.lista[size] = valor;

        size += 1;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        asseguresize(this.size+1);
        this.shiftRight(index);
        this.lista[index] = valor;

        size += 1;
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novasize) {
       int[] novaLista = new int[novasize];
       for (int i = 0; i < this.lista.length; i++) {
            novaLista[i] = lista[i];
       }
       this.lista = novaLista;
    }

    public void asseguresize(int sizePretendida) {
       if (sizePretendida > this.lista.length) {
        resize(Math.max(lista.length*2, sizePretendida));
       }
    }

    public int getFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return lista[0];
    }

    public int getLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return lista[size-1];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return lista[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int elem = lista[0];
        shiftLeft(0);
        this.size -= 1;

        return elem;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        this.size -= 1;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        shiftLeft(index);
        this.size -= 1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (lista[i] == value) {
                remove(i);
                break; //interrompe na primeira ocorrência
            }
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (lista[i] == value) {
                return i;
            }
        }
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        for (int i = size-1; i >= 0; i--) {
            if (lista[i] == valor) {
                return i;
            }
        }
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        String saida = "";

        for (int i = 0; i < this.size; i++) {

            saida += lista[i];
            if (i != this.size-1) {
                saida += ", ";
            }
        }
        return saida;
    }
    
    public int size() {
        return this.size;
    }

    private void shiftRight(int idx) {
        for (int i = this.size; i > idx; i-- ) {
            this.lista[i] = this.lista[i-1];
        }
    }

    private void shiftLeft(int idx) {
        for (int i = idx; i < size-1; i++) {
            this.lista[i] = this.lista[i+1];
        }
    }
}
