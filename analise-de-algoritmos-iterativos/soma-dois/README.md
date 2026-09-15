
# Two Sum (Soma de Dois)

Este repositório contém a implementação de um algoritmo que busca dois elementos dentro de um array cuja soma seja igual a um valor alvo (`target`). O algoritmo verifica todas as combinações possíveis de pares através de dois laços de repetição aninhados.

## Análise Assintótica

O algoritmo percorre o array utilizando uma estrutura em que o laço interno tem seu número de iterações reduzido a cada passo do laço externo, formando uma progressão aritmética. A análise abaixo considera o **pior caso**, em que nenhum par que atenda à condição é encontrado, fazendo com que os laços rodem até o final.

### 1. Tabela de Custos

Seja $n$ o tamanho do array `v`.

| Código | Custo | Repetições |
| --- | --- | --- |
| `int[] array = new int[2];` | $c_1$ | $1$ |
| `int i = 0;` | $c_2$ | $1$ |
| `i < v.length;` | $c_3$ | $n + 1$ |
| `i++;` | $c_4$ | $n$ |
| `int j = i+1;` | $c_5$ | $n$ |
| `j < v.length;` | $c_6$ | $\frac{n^2 + n}{2}$ |
| `j++;` | $c_7$ | $\frac{n^2 - n}{2}$ |
| `(v[i] + v[j]) == target;` | $c_8$ | $\frac{n^2 - n}{2}$ |
| `return array;` | $c_9$ | $1$ |


### 2. Montando a Equação

Somando os custos e repetições de cada linha:


$$f(n) = c_1 \cdot 1 + c_2 \cdot 1 + c_3(n + 1) + c_4(n) + c_5(n) + c_6\left(\frac{n^2 + n}{2}\right) + c_7\left(\frac{n^2 - n}{2}\right) + c_8\left(\frac{n^2 - n}{2}\right) + c_9 \cdot 1$$

Considerando que todas as constantes operacionais possuem o mesmo custo ($c_1 = c_2 = \dots = c_9 = c$):


$$f(n) = c + c + c(n + 1) + c(n) + c(n) + c\left(\frac{n^2 + n}{2}\right) + c\left(\frac{n^2 - n}{2}\right) + c\left(\frac{n^2 - n}{2}\right) + c$$

Agrupando os termos comuns:


$$f(n) = c \cdot \left(4 + 3n + \frac{n^2 + n + n^2 - n + n^2 - n}{2}\right)$$

$$f(n) = c \cdot \left(4 + 3n + \frac{3n^2 - n}{2}\right)$$

$$f(n) = c \cdot \left(\frac{8 + 6n + 3n^2 - n}{2}\right)$$

Assumindo $c = 1$ para simplificar a notação da prova formal:


$$f(n) = \frac{3n^2 + 5n + 8}{2}$$

### 3. Prova Formal ($\Theta$)

Para provar que $f(n) \in \Theta(n^2)$, aplicamos a definição do limite assintótico exato:


$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ pela nossa função quadrática e escolhendo as constantes $c_1 = 1$, $c_2 = 8$ e $n_0 = 1$ para fechar a inequação:


$$0 \le 1 \cdot n^2 \le \frac{3n^2 + 5n + 8}{2} \le 8 \cdot n^2, \forall n \ge 1$$

Testando para $n_0 = 1$:


$$0 \le 1 \cdot (1)^2 \le \frac{3(1)^2 + 5(1) + 8}{2} \le 8 \cdot (1)^2$$

$$0 \le 1 \le \frac{16}{2} \le 8$$

$$0 \le 1 \le 8 \le 8$$

Como a inequação é verdadeira para $n \ge 1$, fica demonstrado que a função de tempo de execução cresce de forma quadrática.

**O algoritmo pertence à classe $\Theta(n^2)$.**