package roteiros.pilha;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Pilha {
    private int[] p;
    private int tail;

    public Pilha(int capacidade) {
        this.p = new int[capacidade];
        this.tail = -1;
    }

    public boolean isEmpty() {
        if (tail == -1) 
            return true;
        return false;
    }

    public boolean isFull() {
        if (tail == p.length-1) 
            return true;
        return false;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull())
            throw new StackOverflowError("a pilha está cheia");
        tail++;
        p[tail] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty()) 
            throw new NoSuchElementException("a pilha está vazia");

        return p[tail--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) 
            throw new NoSuchElementException("a pilha está vazia");

        return p[tail];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        int[] saida = new int[size()];

        if (isEmpty()) 
            return "";

        Pilha aux = new Pilha(size());

        while (!isEmpty()) {
            aux.push(this.pop());    
        }

        int i = 0;
        while (!aux.isEmpty()) {
            int e = aux.pop();
            saida[i++] = e;
            push(e);
        }

        return Arrays.toString(saida);
        

    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        if (isEmpty()) {
            throw new NoSuchElementException("a pilha está vazia");
        }

        Pilha aux = new Pilha(size());

        int idx = 0;
        boolean isFound = false;

        while (!isEmpty()) {
            int e = this.pop();
            aux.push(e);
        }

        while(!aux.isEmpty()) {
            int e = aux.pop();
            push(e);
            if (e == valor) {
                isFound = true;
                }
            if (!isFound) {
                idx+=1;
            }
        }
    
        if (isFound) {
            return idx;
        }
        return -1;
    }

    public int size() {
        return tail+1;
    }

    public int lastIndexOf(int i) {
        if (isEmpty()) {
            throw new NoSuchElementException("a pilha está vazia");
        }

        Pilha aux = new Pilha(size());

        int idx = size()-1;
        boolean isFound = false;

        while (!isEmpty()) {
            int e = this.pop();
            aux.push(e);
            if (e == i) {
                isFound = true;
            }
            if (!isFound) {
                idx -= 1;
            }
        }

        while(!aux.isEmpty()) {
            push(aux.pop());
        }

        if (isFound) {
            return idx;
        }

        return -1;
    }


}
