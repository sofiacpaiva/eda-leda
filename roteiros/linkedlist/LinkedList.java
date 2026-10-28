package roteiros.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    // head e tail são nodes, não inteiros
    private Node head;
    private Node tail;
    private int size;
    
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return (this.head == null);
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size += 1;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);
        
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size += 1;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node newNode = new Node(valor);

        if (index == 0) {
            addFirst(valor);
        }
        else if (index == size) {
            addLast(valor);
        } else {
            Node aux = head;
            // o aux será o elemento prévio à posicao que iremos adicionar
            for (int i = 0; i < index-1; i++) {
                aux = aux.next;
            }
            newNode.next = aux.next;
            newNode.prev = aux;
            aux.next.prev = newNode;
            aux.next = newNode;

            size += 1;
        }
    }

    public int getFirst() {
        return head.value;
    }

    public int getLast() {
        return tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
         if (index < 0 || index >= size) { //ERRO: USEI > AO INVES DE >=
            throw new IndexOutOfBoundsException();
         }

         Node aux = head;
         for (int i = 0; i < index; i++) { // ERRO: AVANÇAVA UMA CASA A MAIS COM <= INDEX
            aux = aux.next;
         }
         return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    // lembrar sempre dos casos de linked lists com apenas um elemento

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        int value = head.value;

        if (head == tail) {
            this.head = null;
            this.tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size -= 1;
        
        return value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        int value = tail.value;

        if (head == tail) {
            this.head = null;
            this.tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size -= 1;
        
        return value;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size-1) {
            return removeLast();
        }

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        size -= 1;
        return aux.value;     

    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        Node aux = head;

        for (int i = 0; i < size; i++) {
            if (aux.value == value) {
                if (i == 0) {
                    removeFirst();
                } else if (i == size-1) {
                    removeLast();
                } else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size -= 1;
                }
                return true;
            }
            aux = aux.next; //continua o laço
        }

        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = head;
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (aux.value == value) {
                return idx;
            }
            aux = aux.next;
            idx += 1;
        }
        return -1;
    }

    public boolean contain(int v) {
        Node aux = head;
        for (int i = 0; i < size; i++) {
            if (aux.value == v) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = tail;
        for (int i = size-1; i >= 0; i--) {
            if (aux.value == valor) {
                return i;
            }
            aux = aux.prev;
        }
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return size;
    }

    // move o elemento que está na posição index para a cabeça da lista.
    // a busca pelo elemento é O(n), mas a movimentação em si deve ser O(1),
    // ou seja, feita só manipulando referências.

    //* casos a se pensar: 
    // 1. mover o elemento que já é o head
    // 2. mover o último elemento
    // 3. esquecimento do aux.prev = null */

    public void moveToHead(int index) {

        if (index == 0) { 
            return;
        }

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        // removendo o nó dali
        if (aux == tail) {   // verificando se é o último elemento para atualizar o tail
            tail = aux.prev;
            tail.next = null;
        } else {
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
        }

        // realocando para o começo
        aux.next = head;
        aux.prev = null; //o novo head obriatoriamente tem prev = null
        head.prev = aux;
        head = aux;

    }

    // dado que a lista já está em ordem crescente, insere v no lugar certo
    // para que a lista continue ordenada depois da inserção. se já houver
    // elementos iguais a v na lista, insira v depois deles.
    public void insereOrdenado(int v) {

        if (isEmpty() || v >= tail.value) {
            addLast(v);
            return;
        }
        if (v < head.value) {
            addFirst(v);
            return;
        }

        Node aux = tail;
        while (aux != null && aux.value > v) {
            aux = aux.prev;   
        }

        Node newNode = new Node(v);
        newNode.next = aux.next;
        newNode.prev = aux;
        aux.next.prev = newNode;
        aux.next = newNode;

        size += 1;
    }

    // troca n1 e n2 de posição na lista. não é permitido trocar os valores
    // guardados nos nós, só manipular as referências (prev/next). esse
    // algoritmo deve ser O(1), já que os nós a trocar são recebidos como
    // parâmetro (ou seja, não é permitido percorrer a lista para achá-los).
    public void swap(Node n1, Node n2) {
    }

    // inverte a lista: tail passa a ser head, o elemento anterior ao tail
    // passa a ser o segundo da lista e assim por diante, até chegar em
    // head, que passa a ser o último elemento (tail). não é permitido usar
    // nenhuma estrutura auxiliar.
    public void inverte() {
    }

    // retorna uma string representando a lista no sentido inverso, do tail
    // para o head, usando os ponteiros prev (e não next). serve para provar
    // que a implementação é de fato duplamente encadeada.
    public String toStringReverso() {
        return null;
    }

    // remove todas as ocorrências de valor na lista (diferente de
    // removeByValue, que remove só a primeira ocorrência). retorna quantas
    // remoções foram feitas.
    public int removeAll(int valor) {
        return -1;
    }

    // retorna um array com os elementos da lista, na mesma ordem em que
    // aparecem (do head para o tail).
    public int[] toArray() {
        return null;
    }

    // retorna o valor do elemento do meio da lista, usando dois ponteiros
    // (um avança uma posição por vez, o outro avança duas) em uma única
    // passada pela lista. se a lista tiver tamanho par, retorne o segundo
    // dos dois elementos centrais.
    public int meio() {
        return -1;
    }

    // retorna true se a lista for um palíndromo, isto é, se lê-la do head
    // para o tail dá a mesma sequência de valores que lê-la do tail para o
    // head. aproveite o fato de a lista ser duplamente encadeada para
    // resolver isso em O(n) tempo e O(1) espaço extra, sem array ou pilha
    // auxiliar.
    public boolean isPalindromo() {
        return false;
    }

    // retorna o nó na posição index. existe só para permitir que os testes
    // de swap peguem referências reais de nós da lista (fora da classe não
    // há outro jeito de obter um Node).
    public Node getNode(int index) {
        return null;
    }

    // remove a última ocorrência do elemento cujo valor foi passado como
    // parâmetro (diferente de removeByValue, que remove a primeira).
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeLastOccurrence(int valor) {
        return false;
    }

    // remove da lista, em efeito colateral (sem criar uma lista nova), todo
    // elemento cujo valor seja menor ou igual a valor. ao final, a lista só
    // deve ter elementos estritamente maiores que valor.
    public void filter(int valor) {
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}
