package tst_eda.tabela_hash;
import tst_eda.tabela_hash.util.*;
import java.util.*;

public class TabelaHash {

    private Aluno[] tabela;
    private Set<Integer> chaves;
    private Set<Aluno> valores;
    private int size;
    private double fatorDeCarga;
    public static final int CAPACIDADE_DEFAULT = 20;
    public static final double FATOR_DE_CARGA = 0.75;
    private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");


    /**
     * Cria uma nova tabela com a capacidade default 20.
     */
    public TabelaHash() {
        this(CAPACIDADE_DEFAULT, FATOR_DE_CARGA);
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
    public TabelaHash(int capacidade, double fatorDeCarga) {
        this.tabela = new Aluno[capacidade];
        this.chaves = new HashSet<Integer>();
        this.valores = new HashSet<Aluno>();
        this.fatorDeCarga = fatorDeCarga;
        this.size = 0;
    }
    
    /**
     * Calcula o hash de uma determinada chave. A função de hash é simples
     * e usa o método da divisão.
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    private int hash(Integer chave) {
        return chave % tabela.length;
    } 

    private int hashMultiplicacao(Integer chave) {
        return (int) ((((hash(chave)*0.617648934)%1)) * tabela.length);
    }

    public Set<Integer> getKeys() {
        return this.chaves;
    }

    public Set<Aluno> getValue() {
        return this.valores;
    }

    public Aluno get(Integer chave) {
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length) {
            hash = (hash(chave)+sondagem) % tabela.length;

            if (tabela[hash] == null) {
                return null;
            }

            if (tabela[hash].getMatricula() == chave) {
                return tabela[hash];
            }
            sondagem +=1;
        }
        return null;
    }

    public void put(Integer chave, Aluno valor) {

        if (size/tabela.length >= fatorDeCarga || size == tabela.length) {
            Aluno[] novaTabela = new Aluno[tabela.length*2];
            reiniciaTabela();

            for (Aluno aluno : tabela) {
                if (aluno != null) {
                    put(novaTabela, aluno.getMatricula(), aluno);                
                }
            }

            put(novaTabela, chave, valor);
            this.tabela = novaTabela;
        } else {
            this.put(this.tabela, chave, valor);
        }
    }

    public Aluno remove(int chave) {
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length) {
            hash = (hash(chave)+sondagem) % tabela.length;

            if (tabela[hash] != null && tabela[hash].getMatricula().equals(chave)) {
                Aluno aluno = tabela[hash];
                tabela[hash] = APAGADO;
                chaves.remove(chave);
                valores.remove(aluno);
                
                return aluno;
            }
            sondagem += 1;
        }
        return null;   
    }

    public int size() {
        return size;
    }

    private void reiniciaTabela() {
        this.size = 0;
        this.chaves = new HashSet<Integer>();
        this.valores = new HashSet<Aluno>();
    }

    private void put(Aluno[] tabela, Integer chave, Aluno valor) {
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length) {
            hash = (hash(chave)+sondagem) % tabela.length;
            Aluno tmpAluno = tabela[hash];

            if (tmpAluno == null || tmpAluno.getMatricula().equals(chave) || tmpAluno.equals(APAGADO)) {
                tabela[hash] = valor;
                this.chaves.add(chave);
                this.valores.add(valor);
                this.size += 1;
                return;
            }

            sondagem += 1;
        }
    }


    
}
