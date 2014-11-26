/* 
Extraterrestre
==============

Dentre as outras funcionalidades propostas por você, deve ter armazenado o tipo de extraterrestre e qual seu poder. Deve também armazenar se o extraterrestre é agressivo, quantidade de olhos e sua fraqueza.

**Requisitos funcionais**

**Polimorfismo**

1.	Duas classes abstratas, sendo que uma classe abstrata herda da outra classe abstrata na hierarquia de classes. - ok
2.	Cada classe abstrata deve ter pelo menos um parâmetro, o construtor vazio e o construtor default. Deve ter também um método não virtual, que não pode ser set ou get. - ok
3.	Pelo menos três classes concretas na hierarquia de classes. - ok
4.	Usar coerção de tipo C++ e não C, ou seja usar o static_cast para fazer o máximo de reutilização de código. - ok
5.	Usar um vector de classes concretas, o dynamic_cast e o typeid como indicado aqui: https://basecamp.com/2595605/projects/7018448/messages/33080741 - ok
6.	Criar uma função no arquivo do main, que aceita um ponteiro da classe genérica e mostrar o seu uso para as classes concretas. - ok

**Importante:** Todos os Requisitos abaixo ainda devem ser feitos e serão avaliados

**Todos os atributos e funções membros devem estar relacionados a classe**
  
1.	Pelo menos 4 atributos. - ok
2.	Pelo menos 4 funções membros sem incluir get e set. - ok

**Requisitos de implementação**

3.	Todos os atributos devem ser inicializados. Fez validação de dados. - ok
4.	Três construtores, incluindo um construtor de cópia e construtor com parâmetros defaults. Verifica alocação dentro do construtor de cópia. - ok
5.	Deve ter um atributo string. - ok
6.	Um atributo static. Correta modelagem dos statics? - ok
7.	Um atributo const static. - ok
8.	Dois métodos constantes (não pode ser get). - ok
9.	Um array. - ok
10.	Uma função inline (não pode ser get ou set). - ok
11.	Método com passagem por referência usando ponteiro. - ok
12.	Método static – deve ser chamado no main. - ok
13.	Composição com a classe Data. Fez uso do objeto criado? - ok
14.	O que é const deve ser const.  - ok
15.	Alocação dinâmica de memória. A memória é desalocada? - ok
16.	friend Operator<<. - ok
17.	Operator=. - ok
18.	vector push_back. - ok

**Requisitos para as classes adicionais (pelo menos duas)**

1.	Operator =. - ok
2.	 Alocação dinâmica - se houver vazamento de memória a classe toda é desconsiderada. - ok
3.	Usar o destrutor. - ok
4.	Construtor de cópia. - ok
5.	Operator << friend. - ok
6.	Um const static. - ok

**Requisitos herança**

1.	Diagrama de classes (obrigatório salvar também o png do diagrama no gitHub). - ok
2.	Herança pública. - ok
3.	Construtor de cópia, e sobrecargas dos operadores de atribuição (=) e << (cout << base) para a classe base e derivada. - ok
4.	Usar Protected acessando diretamente os atributos na classe derivada. - ok
5.	Alocação dinâmica de memória na classe base e derivada. - ok
6.	Sobrescrita de método: chamar dentro do método da classe derivada o método correspondente da classe base usando ::. - ok
7.	No main: criar um ponteiro da classe base para alocar memória para a classe derivada e chamar os vários métodos implementados. - ok (não muito porque não chamei os vários métodos implementados no main)
*/

#ifndef EXTRATERRESTRE_H
#define EXTRATERRESTRE_H

#include <string>
#include <iostream>
#include "Personagem.h"

using namespace std;
using std::string;

/*
Pequeno remainder das classes que irei criar
Alien Name 1:  Chatzan - fogo
Alien Name 2:  Bomol - água
Alien Name 3:  Pwetael - musgo
*/

class Extraterrestre : public Personagem{
	// sobrecarga do operador <<
	friend ostream& operator << ( ostream& os, const Extraterrestre &alien );
	
protected:
	int olhos;
	string tipo;
	bool agressivo;
	string fraqueza;

public:
	// sobrecarga do operador =
	void operator = ( const Extraterrestre &alien );
	
	// sobrecarga do operador +
	Extraterrestre& operator + ( const Extraterrestre &alien );
	
	// construtor vazio
	Extraterrestre();
	
	// construtor default
	Extraterrestre(  const string nome, const string tipo = "-", const int olhos = 1, const string agressivo = "a", const string poder = "-", const int nivel = 5, const string fraqueza = "<fraqueza>" );
	
	// construtor apenas para adicionar o necessário
	Extraterrestre( const int nivel, const string poder1, const string poder2, const string poder3, const string poder4 );
	
	// construtor de cópia
	Extraterrestre( const Extraterrestre &copy );
	
	// destrutor
	virtual ~Extraterrestre();
	
	// gets	
	int getOlhos() const;
	string getTipo() const;
	bool getAgressivo() const;
	string getFraqueza() const;
	
	// sets		
	void setAgressivo( const string agressivo );
	void setTipo( const string tipo );
	void setOlhos( const int olhos );
	void setFraqueza( const string fraqueza );
	
	int ataque( const int i );
	virtual void roar() = 0;
};
#endif
