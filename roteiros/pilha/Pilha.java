package roteiros.pilha;
import java.util.Arrays;
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
            throw new StackOverflowError("a pilha está vazia");

        return p[tail--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) 
            throw new StackOverflowError("a pilha está vazia");

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
        
    //TODO: ARRUMAR ESSE BAGULHO AQUI EM RELACAO AO TAIL DA PILHA DA CLASSE

    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        return -1;
    }

    public int size() {
        return tail+1;
    }

    public int lastIndexOf(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }


}
