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
6. [Outros comentários](#outros-comentarios)

# Funcionalidades

- [ ] Menu Principal

- [x] Movimento
  - [x] Sempre que o jogador se movimenta, a sua posição anterior fica inacessível
  - [x] As posições inacessíveis são transformadas em água
  - [x] Quando o jogador não se pode movimentor, isto é fica rodeado por peças de água e por paredes, perde o jogo
  - [x] Quanto maior for o número de quadrados que o jogador percorre, maior será a sua pontuação

- [x] Existem moedas espalhadas em determinados niveís.
  - [x] Capturar uma moeda aumenta a pontuação do jogador em dez pontos
  - [ ] Podem existir passagem secretas que levem para zonas com muitos sacos de moedas.

- [x] A partir de um certo nivel existem certos quadrados onde o jogador pode passar por cima duas vezes.

- [ ] Os quadrados verdes correspondem a uma zona de teletransporte. Quando o jogador passa por cima do mesmo vai ser teletransportado para outro quadrado verde do mesmo nível.

- [ ] Menu de fim de jogo
    - [ ] O jogo acaba assim que o jogador completar todos os niveis. É apresentado a pontuação total.

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
Como o nosso jogo necessita de ter um main menu, um jogo e um menu de final de jogo decidimos implementar o *Design Pattern* State para controlar esta situação.

#### Padrão
Por este motivo decidimos implementar o *Design Pattern* State para resolver a situação.

#### Implementação
##### Diagrama UML
![State](images/StateUML.png)

##### Ficheiros
[Main Controller](../src/main/java/Controller/MainController.java)
[State](../src/main/java/Controller/State/State.java)
[StateGame](../src/main/java/Controller/State/StateGame.java)
[StateGameOver](../src/main/java/Controller/State/StateGameOver.java)

#### Consequências
A aplicação deste Design Pattern irá permitir no decorrer do projeto a criação e mais Menus, como por exemplo Menu Inicial, Menu de instruções, entre outros no decorrer do projeto!

> Fonte: [Design Patterns - State](https://web.fe.up.pt/~arestivo/presentation/patterns/#35)

## Command
#### Problema
Cada vez que o jogador pressiona uma tecla para mover a sua posição, vão ser verificadas as colisões com todas as paredes, entre outros fatores como por exemplo, se o mesmo passa por cima de uma moeda ou outro tipo de bloco especial. Deste modo, este elevado número de interações entre o jogador e os diversos objetos presentes em cada nível irá causar um Code Smell em que vão existir um elevado número de if's clause

#### Padrão
Para resolver este problema, decidimos utilizar o *Design Pattern* Command para 

A utilização deste padrão permite encapsular as diferentes interações de cada *Element* com o jogador em diferente classes.

#### Implementação
Ainda não está implementado. Iremos começar a implementar este *Design Pattern* na branch Command.

#### Consequências
Com a implementação deste Design Pattern no nosso trabalho, a implementação de futuros objetos que interajam com a persongem principal do jogo será mais simples

> Fonte: [Design Patterns - Command](https://web.fe.up.pt/~arestivo/presentation/patterns/#20)

# Code Smells e Refactoring

### Data Class

As classes que se encontram no [*Package Model*](../src/main/java/Model) são apenas constituídas por atributos, funções *Getter* e *Setter*.  

Embora se possa resolver este problema adicionando a *lógica do programa* a *Data Class* utilizando o *Move Method*, estaríamos a violar o modelo **MVC**. Deste modo, podemos afirmar que este code smell é inerente ao estilo arquitetural que estamos a a utilizar no desenvolvimento do nosso projeto, pelo que não temos planos futuros para o corrigir.

> Fonte: [Data Class](https://refactoring.guru/smells/data-class), [Move Method](https://refactoring.guru/move-method)

### Dead Code e Speculative Generality

Na classe [Level Model](../src/main/java/Model/Level/LevelModel.java), existem *Getters* e *Setters* que não estamos a utilizar, quer por serem funções que utilizamos anteriormente, quer por serem funções que poderemos utilizar no futuro, pois estamos perante uma entrega intermédia do projeto e ainda há muito código por desenvolver que poderá usufruir da manipulação dos atributos do modelo.  

Este code smell é problemático, porque estamos a adicionar linhas de código redundantes cujo único propósito atual é complicar o código.  

Este problema pode ser facilmente resolvido eliminando-o. Contudo, decidimos não o fazer uma vez que estas linha de código podem vir a ser úteis.

> Fonte : [Dead Code](https://refactoring.guru/smells/dead-code), [*Speculative Generality*](https://refactoring.guru/smells/speculative-generality)


### Message Chains, Switch Statements e Large Class

A classe [Level Controller](../src/main/java/Controller/Level/LevelController.java) incorre no *Code Smell Message Chain*. Este ocorre quando existem linhas de código com acesso a métodos de um objeto do objeto da classe.

Por exemplo: 
```java
public void moveHero(Position position) {
    if (!checkCollisions(position)) {
        if(!levelModel.removeWhite(levelModel.getHero().getPosition()))
            levelModel.getFilled().add(new Water(levelModel.getHero().getPosition()));
        levelModel.getHero().setPosition(position);

        if (levelModel.removeCoin(position)) levelModel.addPoints(10);
        else levelModel.addPoints(1);

        if(levelModel.getKey() != null && levelModel.getKey().getPosition().equals(position)){
            levelModel.setKey(null);
            levelModel.setLock(null);
        }
    }
}
```

Este método é problemático, uma vez que dificulta a leitura do código. 

Além disso, o grande número de if statements existentes no código é em si um *Code Smell* e que neste caso pode ser resolvido utilizando o *Design Pattern Command* como já foi referido acima. 

- **Extract Method** - Criar novos métodos que executem a manipulação dos atributos do objeto em causa, melhorando a legibilade do código. Neste caso em vez de `getHero().getPosition()` podiamos utilizar `getHeroPosition()`. No entanto esta solução pode originar um outro *Code Smell* denominado como *Large Class*.

- **Extract Class** - Criar uma nova classe responsável por executar parte do código da classe atual, ou seja, criar vários controladores que façam a gestão de diferentes partes do LevelModel. Combinando este *Refactor* com o anterior, será possível eliminar *Code Smells* associados a Large Class.

> Fonte: [Message Chains](https://refactoring.guru/smells/message-chains), [*Couplers*](https://refactoring.guru/refactoring/smells/couplers), [*Extract Method*](https://refactoring.guru/extract-method), [*Extract Class*](https://refactoring.guru/extract-class)

# Unit Tests

Atualmente os nossos teste cobrem cerca de 72% do código total. É possível observar a percentagem de testes em cada classe de cada um dos packages principais na seguinte imagem.

![MoveHero](images/testCoverage.png)

Foi utilizado o package *Mockito* para testar corretamente o código criando os *stubs* adequados.

# Outros Comentários

....


