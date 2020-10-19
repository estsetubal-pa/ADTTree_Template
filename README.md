ADT Tree Template
===

Este repositório consiste num projeto **IntelliJ** 
de suporte à lecionação dos tipos abstratos de dados na linguagem Java,
no contexto da unidade curricular de *Programação Avançada* - ESTSetúbal.

Os exercícios solicitados são os seguintes:

## ADT Tree | Exercícios de implementação

1. Faça *clone* deste projeto base **ADTTree_Template** (projeto **IntelliJ**) do *GitHub*:

2. Forneça o código dos métodos por implementar, i.e., os que estão a  lançar NotImplementedException ;
	Nota: Em relação ao método size, sugere-se que reveja a  implementação realizada pra a BST

3. Compile e teste o programa fornecido.

4. Considere o algoritmo Breath-first para percorrer a árvore em largura,    por níveis.
```java 
   BFS(Tree)
   Coloque a raiz da árvore na fila
   Enquanto a fila não está vazia faça:
   	   seja n o primeiro nó da fila
   	   processe n
   	   para todo o f nó filho de n 
         		coloque f na fila
   ```
   Implemente na classe TreeLinked o método Breath-first que devolve uma Colecao Iteravel com os elementos da árvore ordenado segundo o algoritmo Breath-first.
