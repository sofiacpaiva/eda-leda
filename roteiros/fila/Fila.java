package roteiros.fila;

public class Fila {
    int[] fila;
    int size;
    int tail;
    int head;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.tail = -1;
        this.head = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (head == -1 && this.tail == -1);
    }

    public boolean isFull() {
        return this.size == this.fila.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) {
            throw new IllegalStateException("a fila está cheia");
        }
        if (isEmpty()) {
            this.head = 0;
        }
        this.tail = (tail+1) % fila.length;
        fila[tail] = valor;
        this.size += 1;

    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("a fila está vazia");
        }
        int valor = this.fila[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }
        this.size -= 1;
        return valor;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("a fila está vazia");
        }
        return fila[head];      
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("a fila está vazia");
        }
        return fila[tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String saida = "";

        for (int i = 0; i < this.size; i++) {
            int arrayId = (this.head + i) % this.fila.length;

            saida += fila[arrayId];
            if (i != this.size-1) {
                saida += ", ";
            }
        }
        return saida;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
 
        for (int i = 0; i < this.size; i++) {
            int arrayId = (this.head + i) % this.fila.length;

            if (fila[arrayId] == valor) {
                return i;
            }
        }
        return -1;
        
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int lastIdx = -1;
        for (int i = 0; i < this.size; i++) {
            int arrayId = (this.head + i) % this.fila.length;

            if (fila[arrayId] == valor) {
                lastIdx = i;
            }
        }
        return lastIdx;
        
    }
    
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return ((tail - head + fila.length) % fila.length) + 1;
    }
}
