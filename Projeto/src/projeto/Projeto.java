/*
Xbox
====

Dentre as outras funcionalidades propostas por você, deve ter armazenado o
código do modelo e sua capacidade de armazenamento. Deve também armazenar se o 
Kinect está ativo e as suas coordenadas espaciais (x, y e z).

**Importante:** Para item abaixo deve ser copiado trechos do código que cumprem 
o requisito e explicado, se não for aparente, o porquê o requisito é cumprido. 
Sejam bem explícitos. Deve ser indicado também o arquivo da classe em que está 
o trecho do código. Eu avaliarei o código do Github a partir desse documento 
para confirmá-lo e também para detectar possíveis erros. Quem não seguir o que 
está indicado aqui, não terá o projeto avaliado e perderá a atividade. 

**Requisitos de implementação**

**Todos os atributos e funções membros devem estar relacionados a classe**
  
1.	Pelo menos 4 atributos. - ok
2.	Pelo menos 4 funções membros sem incluir get e set. - ok

**Requisitos de implementação**

3.	Cinco classes: uma superclasse e duas subclasses, e duas classes 
        relacionadas ao projeto. - ok
4.	Sempre usar o super para o máximo de reaproveitamento de código. - ok
5.	Diagrama de classes (obrigatório salvar também o png do diagrama no 
        gitHub). - ok
6.	Todos os atributos devem ser inicializados. Fez validação de dados? - ok
7.	Dois construtores. - ok
8.	Um atributo static. - ok
9.	Um atributo const static. Correta modelagem dos statics?  - ok
10.	Um array. - ok
11.	Método static – deve ser chamado no main.
12.	Sobrescrita de método: chamar dentro do método da classe. Usar 
        o @override. - ok
13.	Usar Protected acessando diretamente os atributos na classe
        derivada. - ok
14.	Usar suas classes no main. - ok

**Opcionais que garantem pontos extras:**

1. Trabalhar com ENUM.
2. Trabalhar com pacotes.

 */
package projeto;

import projeto.Outros.Pessoa;
/*
 * @author Gio
 */

public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa( 1000 );
        pessoa.menu();
    }
    
}
