# Atividade
## Objetivo
Exercitar práticas de orientação a objetos, tais como, utilização de herança, classes e métodos abstratos e interfaces. 
Assim como trabalhar com tratamento de exceções em java.

## Exceções a serem criadas
Todas as exceções devem ser criadas no pacote <code>local.exception</code>, com os nomes
exatamente conforme indicados a seguir
### PersonagemException 
Deverá ser uma exceção não verificada. 
### NomePersonagemException
Deverá ser uma especialização de PersonagemException
### VidaException
Deverá ser uma exceção verificada

## Validações Personagem
### Nome
Deve possuir entre 11 e 30 caracteres (considerando o sufixo). Caso o requisito não seja cumprido, deverá ser lançada uma "NomePersonagemException"
com a mensagem  "Nome inválido". 

### Vida Atual
Caso a <code>vidaAtual</code> seja menor ou igual a 0, deverá lançar uma "VidaException", com 
a mensagem "O Personagem está morto". 

### Esquiva e resistencia
Devem respeitar um valor entre 0 e 99, inclusive estes valores. Para qualquer valor diferente,
deverá ser lançada uma "PersonagemException" com a mensagem "Dado de entrada inválido".

## Atenção! Crie os Getters e Setters que forem necessário para cumprir com os requisitos indicados

## Interface
Dentro de um pacote <code>local.template</code>, crie uma interface <code>PersonagemDAO</code>, que deverá conter as 
seguintes assinaturas:
``` java
boolean salvar();
List<Personagem> buscarTodos();
//Em caso de não encontrar, deverá retornar null
Personagem buscar(Personagem in);
```
A interface deverá ser implementada pela classe <code>Personagem</code>, e deverá executar as ações em arquivo.
