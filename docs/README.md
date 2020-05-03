# REPORT - Grupo 70


O nosso jogo é inspirado no jogo `Gelo Fino` que existia no jogo *Club Penguin*. O jogador deve controlar o personagem de jogo através de inúmeros labirintos, passando pelo número máximo de quadrados antes de o completar. Além disso, ao longo do mapa vão surgindo moedas coletaveis que permitem ao jogador obter uma pontuação mais elevada, assim como diversos obstáculos!

- **Universidade**: [FEUP](https://sigarra.up.pt/feup/pt/web_page.Inicial)
- **Curso**: [MIEIC](https://sigarra.up.pt/feup/pt/cur_geral.cur_view?pv_curso_id=742&pv_ano_lectivo=2019)
- **Unidade Curricular**: [LPOO](https://sigarra.up.pt/feup/pt/UCURR_GERAL.FICHA_UC_VIEW?pv_ocorrencia_id=420000) (Laboratório de Programação Orientada por Objetos)
- **Elementos do Grupo**:    
    - Diogo Samuel Fernandes, up201806250@fe.up.pt
    - Hugo Guimarães, up201806490@fe.up.pt

# Indíce

1. [Funcionalidades](#funcionalidades)
1. [Funcionalidades](#funcionalidades)
2. [Arquitetura do Código](#padrão-arquitetural-do-código)
3. [Design Patterns](#design-patterns)
    - [State](#state)
    - [Command](#state)
4. [Code Smells e Refactoring](#code-smells-e-refactoring)
5. [Unit Tests](#unit-tests)

# Funcionalidades

- [ ] Menu Principal

- [x] Movimento
    - [x] Sempre que o jogador se movimenta, a sua posição anterior fica inacessível
    - [x] As posições inacessíveis são transformadas em água
    - [x] Quando o jogador não se pode movimentor, isto é fica rodeado por peças de água e por paredes, perde o jogo
    - [x] Quanto maior for o número de quadrados que o jogador percorre, maior será a sua pontuação

- [x] Pontuação
    - [x] Existem moedas espalhadas em determinados niveís.
    - [x] Capturar uma moeda aumenta a pontuação do jogador em dez pontos

- [ ] Mecânicas de jogo
    - [x] Quadrados onde o jogador pode passar por cima duas vezes.
    - [ ] Quadrados verdes que correspondem a uma zona de teletransporte. Quando o jogador passa por cima do mesmo vai ser teletransportado para outro quadrado verde do mesmo nível.
    - [ ] Passagem secretas que levem para zonas bónus com muitos sacos de moedas.

- [ ] Menu de fim de jogo
    - [ ] O jogo acaba assim que o jogador completar todos os niveis ou perder. É apresentado a pontuação total.

Com o decorrer do projeto poderão ser adicionadas mais funcionalidades

# Padrão Arquitetural do Código

Para a realização deste projeto, decidimos separar e estruturar o nosso código utilizando o MVC. Este modelo foi apresentado durante as aulas e consiste em separar o código em três *packages* diferentes sendo estes:

- O ***Model*** que representa toda a informação presente no jogo
- O ***View*** que é responsável pela visualização do jogo e por enviar a informação recebida do utilizador, como por exemplo teclas pressionadas no teclado, para o *Controller*.
- O ***Controller*** que processa a informação recebida pelo *View* e envia comandos *Model* atualizar o seu estado.

![MVC](images/mvc.png)

Este padrão arquitetural permite uma maior modularidade ao código, facilitando a implementação de novas funcionalidades.

> Fonte: [Architectural Patterns](https://web.fe.up.pt/~arestivo/presentation/patterns/#56)

# Design Patterns

## State

#### Contexto do Problema
Como o nosso jogo irá possuir diversos estados em que o programa irá ter comportamentos diferentes, de jogo decidimos que precisávamos de arranjar algum método de forma a conseguir ter o código organizado da melhor maneira possível. Já tínhamos feito algo parecido em LCOM, mas utilizando Switch Statements, que são um Code Smell. Deste modo,

#### Padrão
De forma a conseguir ter diversos estados diferentes no nosso projeto decidimos mplementar o *Design Pattern* State para resolver a situação.

#### Implementação
##### Diagrama UML
![State](images/StateUML.png)

##### Ficheiros
- [Main Controller](../src/main/java/Controller/MainController.java)
- [State](../src/main/java/Controller/State/State.java)
- [StateGame](../src/main/java/Controller/State/StateGame.java)
- [StateGameOver](../src/main/java/Controller/State/StateGameOver.java)

#### Consequências
A aplicação deste *Design Pattern* irá permitir um maior modularidade ao código fazendo com que seja de rápido e fácil de acrescentar e alterar novos estados ao jogo.

> Fonte: [Design Patterns - State](https://web.fe.up.pt/~arestivo/presentation/patterns/#35)

## Command
#### Problema
Sempre que o utilizador pressiona uma tecla para mover a posição do jogador, vão ser verificadas todas as interações com os diversos Elementos, como por exemplo, se o mesmo passa por cima de uma moeda, se colide com um parede ou outro tipo de bloco especial. A contínua adição de interações entre o objeto e o jogador causou um *Code Smell* devido ao elevado número de *If Statements* que podem ser resolvidos.

#### Padrão
Para resolver este problema decidimos utilizar o *Design Pattern Command* que permite encapsular as diferentes interações de cada *Element* com o jogador em diferente classes, evitando assim o *Code Smell*.

#### Implementação
Ainda não está implementado. Iremos começar a implementar este *Design Pattern* na branch Command.

#### Consequências
A implementação deste *Design Pattern* irá permitir uma fácil e rápida implementação de novos objetos que tenham algum tipo de interação com o jogador.

> Fonte: [Design Patterns - Command](https://web.fe.up.pt/~arestivo/presentation/patterns/#20)

# Code Smells e Refactoring

### Data Class

As classes que se encontram no [*Package Model*](../src/main/java/Model) são apenas constituídas por atributos, funções *getter* e *setter*.  

Embora se possa resolver este problema colocando alguma *lógica do jogo* nas nossas *Data Class* utilizando, por exemplo, o *Move Method*, estaríamos a violar o ***MVC***. Sendo assim, podemos afirmar que este *Code Smell* é inerente ao estilo arquitetural utilizado no desenvolvimento do nosso projeto, pelo que não temos planos futuros para o corrigir.

> Fonte: [Data Class](https://refactoring.guru/smells/data-class), [Move Method](https://refactoring.guru/move-method)

### Dead Code e Speculative Generality

Na classe [Level Model](../src/main/java/Model/Level/LevelModel.java), existem *getters* e *setters* que não são utilizados. Estas funções podem ter sido utilizadas anteriormente e por termos dado refactor ao código deixaram de ser utilizadas ou então são funções que podemos utilizar no futuramente. Uma vez que estamos perante uma entrega intermédia do projeto, ainda existe bastante código a ser desenvolvido que poderá usufruir da manipulação dos atributos do modelo.  

Este *Code Smell* pode vir a ser problemático, porque estamos a adicionar linhas de código redundantes cujo único propósito atual é complicar o código. Além disso, também pode deixar a classe com um tamanho considerável.

O problema pode ser facilmente resolvido eliminando o código inutilizado. Contudo, decidimos não o fazer uma vez que estas linha de código podem vir a ser úteis.

> Fonte : [Dead Code](https://refactoring.guru/smells/dead-code), [*Speculative Generality*](https://refactoring.guru/smells/speculative-generality)

### Message Chains, Switch Statements e Large Class

A classe [Level Controller](../src/main/java/Controller/Level/LevelController.java) possui um *Code Smell* conhecido como *Message Chain*. Este ocorre quando um objeto invoca um método, esse método invoca outro método, continuando este ciclo.

Por exemplo, o método `moveHero()` é problemático, uma vez que dificulta a leitura do código. 
```java
public void moveHero(Position position) {
    if (!checkCollisions(position)) {
        if(!levelModel.removeWhite(levelModel.getHero().getPosition()))
            levelModel.getFilled().add(new Water(levelModel.getHero().getPosition()));

        if (levelModel.removeCoin(position))
            levelModel.addPoints(11);
        else
            levelModel.addPoints(1);

        if(levelModel.getKey() != null && levelModel.getKey().getPosition().equals(position)){
            levelModel.setKey(null);
            levelModel.setLock(null);
        }
        levelModel.getHero().setPosition(position);
    }
}
```



Além disso, o grande número de *If Statements* existentes no código é em si um *Code Smell* e que neste caso pode ser resolvido utilizando o *Design Pattern Command* como já foi referido acima. 

Para resolver este problema podemos seguir os seguintes passos:

- **Extract Method** - Criar novos métodos que executem a manipulação dos atributos do objeto em causa, melhorando a legibilade do código. Neste caso em vez de `getHero().getPosition()` podiamos utilizar `getHeroPosition()`. No entanto esta solução pode originar um outro *Code Smell* denominado como *Large Class*.

- **Extract Class** - Criar uma nova classe responsável por executar parte do código da classe principal. Combinando este *Refactor* com o anterior, será possível eliminar o *Code Smell* associado a uma *Large Class*.

> Fonte: [Message Chains](https://refactoring.guru/smells/message-chains), [*Couplers*](https://refactoring.guru/refactoring/smells/couplers), [*Extract Method*](https://refactoring.guru/extract-method), [*Extract Class*](https://refactoring.guru/extract-class)

# Unit Tests

Os nossos teste cobrem cerca de 76% do código total. É possível observar a percentagem de testes em cada classe de cada um dos packages principais na seguinte imagem.

![MoveHero](images/testCoverage.png)

Para a criação de testes foram utilizados as frameworks ***JUnit*** e ***Mockito***.

Os resultados dos testes encontram-se na seguinte [pasta](./test).
