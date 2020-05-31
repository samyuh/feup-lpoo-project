# LPOO_70 - Frostbite Penguin Madness

O nosso jogo é inspirado no jogo `Gelo Fino` que existia no jogo *Club Penguin*. O jogador deve controlar o personagem de jogo através de inúmeros labirintos, passando pelo número máximo de quadrados antes de o completar. Além disso, ao longo do mapa vão surgindo moedas coletaveis que permitem ao jogador obter uma pontuação mais elevada, assim como diversos obstáculos!

- **Universidade**: [FEUP](https://sigarra.up.pt/feup/pt/web_page.Inicial)
- **Curso**: [MIEIC](https://sigarra.up.pt/feup/pt/cur_geral.cur_view?pv_curso_id=742&pv_ano_lectivo=2019)
- **Unidade Curricular**: [LPOO](https://sigarra.up.pt/feup/pt/UCURR_GERAL.FICHA_UC_VIEW?pv_ocorrencia_id=420000) (Laboratório de Programação Orientada por Objetos)
- **Elementos do Grupo**:    
    - Diogo Samuel Fernandes, up201806250@fe.up.pt
    - Hugo Guimarães, up201806490@fe.up.pt

# Indíce

1. [Funcionalidades do jogo](#funcionalidades)
    - [Funcionalidades Implementadas](#funcionalidades-implementadas)
    - [Funcionalidades Planeada](#funcionalidades-planeadas)
3. [Padrão Arquitetural do Código](#padrao-arquitetural-do-codigo)
4. [Design Patterns](#design)
    - [Level Builder](#level-builder)
    - [State](#state)
    - [Command](#state)
    - [Interact Strategy](#pufflebox-movement-strategy)
    - [Melting Strategy](#melting-strategy)
    - [Menu Factory](#menu-factory)
    - [Classe de dados privado](#private-class-data-on-levelmodel)
5. [Code Smells e Refactoring](#code-smells-e-refactoring)
    - [Data Class](#data-class)
    - [Large Class](#large-class)
6. [Unit Tests](#unit-tests)

# Funcionalidades do jogo
## Funcionalidades Implementadas

#### Menu

O nosso menu principal de jogo possui 3 opções distintas sendo elas:

- **Start** - Permite ao jogador começar um novo jogo.
- **Instructions** - Abre um menu em que o jogador pode observar todos os elementos do jogo.
- **Exit** - Faz com que a janela de jogo feche.

O jogador pode navegar entre as opções presentes no menu utilizando as teclas *ArrowUp* e *ArrowDown*. Para selecionar uma opção, o jogador terá de carregar na tecla *ArrowRight*. Além disso, quando o jogador se encontra no menu, o mesmo pode carregar na tecla *q* para fechar a janela de jogo.
  
#### Jogo

O jogador controla o Puffle utilizando as teclas direcionais. Além disso, o mesmo pode reiniciar o nível carregando na tecla *r* e passar para o nível seguinte pressionando a tecla *n*.
Caso o jogador queira terminar o jogo, o mesmo pode carregar na tecla *q*.

Na parte superior do jogo, o jogador pode ainda ver em que nível é que se encontra, assim como o número de blocos que é possível derreter. Já na parte inferior, é possível ver a pontuação total do jogador.

##### Elements
Representam todos os obstáculos possíveis, encantrando-se espalhados pelos vários niveis. Todos ocupam uma só casa, têm a sua respetiva imagem, cor e uma determinada interação que os distingue entre eles.

Os elementos podem ser divididos em dois tipos diferentes, sendo estes:

- ##### Movable
    São os elementos que possuem algum tipo de movimento.
    - **Box** - Caixa que pode ser empurrada até colidir com um obstáculo. Não pode ser atravessada pelo jogador.
    - **Puffle** - Personagem principal, que é controlada pelo jogador.

- ##### Imovable
    Elementos que não possuem movimento.
    - **Coin** - Incrementa os pontos do jogador por 10.
    - **DoubleIce** - Bloco de gelo mais resistente que que derrete ao interagir com o Puffle, tornando-se gelo normal.
    - **Ice** - Bloco de gelo que derrete ao interagir com o Puffle .transformando-se em Water. O Puffle só pode passar por cada bloco de gelo uma única vez por este mesmo motivo.
    -  **Water** - É criada sempre que o Puffle derrete gelo, não podendo ser atravessada.
    -  **Wall** - Não pode ser atravessada. Delimitam os limites do nível, mantendo o Puffle numa região fechada.
    - **EmptyBlock** - Posição final onde a Box deve ficar, de modo a que o jogador obtenha o número máximo de pontos. Por esse mesmo motivo, movimentar-se por cima destas peças não aumenta a pontuação do jogador.
    - **Finish** - Local onde o jogador deve chegar para completar o nível.
    - **Lock** - Não pode ser atravessada enquanto o jogador não coletar a Key.
    - **Key** - Abre o Lock.
    - **InvisibleWall** - É idêntico a uma parede, mas pode ser atravessado, permitindo desbloquear o nível secreto.
    - **Secret** - Objeto com igual comportamento parecido à Destination. No entanto, este desbloqueia o nível secreto.
    - **Teleport** - Está sempre associado a outro Teleport. Teletransporta o Puffle ou a Box entre a posição dos dois Teleports, sendo o seu uso bloqueado após a sua utilização por parte do Puffle.
    
#### Screenshots

| Menu                           | Instruções                         | Fim de Jogo                  |
| ------------------------------ | -----------------------------------| -----------------------------|
| ![](./images/screenshots/gameMainMenu.png) | ![](./images/screenshots/gameInstructions.png) | ![](./images/screenshots/gameFinish.png) |

| Nível 1                       | Nível 19 (Passagem secreta oculta) |  Nível 19 (Passagem secreta descoberta) |
| ----------------------------- | ---------------------------------- | --------------------------------------- |
|  ![](./images/screenshots/gameLevel1.png) | ![](./images/screenshots/gameLevel19.png) | ![](./images/screenshots//gameLevel19Secret.png) |

#### Gameplay

## Funcionalidades Planeadas

- [x] Menu Principal
    - [x] Começar um novo jogo
    - [x] Instruções do jogo
    - [ ] Escolha de nível
    - [x] Sair do jogo

- [x] Movimento
    - [x] Sempre que o Puffle se movimenta, a sua posição anterior é alterada conforme o tipo de bloco
    - [x] As posições que Puffle torna inacessível ao movimentar são transformadas em água
    - [x] Quando o jogador não se pode movimentar, isto é, quando rodeado por peças de água e por paredes, perde o jogo

- [ ] Menu Pausa
    - [x] Recomeçar o nível
    - [x] Terminar o jogo
    - [ ] Retornar ao menu principal

- [x] Pontuação
    - [x] Sempre que o jogador se movimenta para um bloco normal, a sua pontuação incrementa um ponto
    - [x] Existem moedas espalhadas em determinados niveís
    - [x] Capturar uma moeda aumenta a pontuação do jogador em dez pontos

- [x] Mecânicas de jogo
    - [x] Quadrados onde o jogador pode passar por cima duas vezes.
    - [x] Mecanismo chave-fechadura. Só é possível atravessar a fechadura caso se tenha obtido a chave.
    - [x] Quadrados verdes que correspondem a uma zona de teletransporte. Quando o jogador passa por cima do mesmo vai ser teletransportado para outro quadrado verde do mesmo nível. Depois de ser utilizado, o teletransporte fica desativado.
    - [x] Existência de peças de jogo que são empurradas pelo jogador até colidirem com uma parede. Estas peças podem utilizar os quadrados de teletransporte.
    - [x] Passagens secretas que levem o jogador para zonas bónus com muitos sacos de moedas.

- [x] Menu de fim de jogo
    - [x] O jogo acaba assim que o jogador completar todos os niveis ou perder. É apresentado a pontuação total.
    - [x] Recomeçar o jogo
    - [x] Retornar ao Menu Principal

# Padrão Arquitetural do Código

Para a realização deste projeto, decidimos separar e estruturar o nosso código utilizando o MVC. Este modelo foi apresentado durante as aulas e consiste em separar o código em três *packages* diferentes sendo estes:

- O ***Model***, que representa toda a informação presente no jogo
- O ***View***, que é responsável pela visualização do jogo e por enviar a informação recebida do utilizador, como por exemplo, teclas pressionadas no teclado para o *Controller*.
- O ***Controller***, que processa a informação recebida pelo *View* e envia comandos ao *Model* para atualizar o seu estado.

![MVC](./images/mvc.png)

Este padrão arquitetural permite uma maior modularidade ao código, facilitando a implementação de novas funcionalidades.

> Fonte: [Architectural Patterns](https://web.fe.up.pt/~arestivo/presentation/patterns/#56)

# Design Patterns

### Level Builder
#### Contexto do Problema
Era necessário encontrar uma forma de criar os níveis predefinidos que, sua criação, iriam inicializar diferentes objetos, dependendo do nível, evitando a existência de um construtor enorme responsável por decidir quais objetos a ser criados.

#### Padrão
Para resolver este problema, utilizamos uma adaptação do *Design Pattern* ***Builder***, usando como base o mecanismo de utilização de métodos *Build* para decidir se, em cada nível, iriamos precisar de criar um determinado *Element*.

#### Implementação
Ao implementar este *Design Pattern*, apercebemo-nos que a maneira mais simples de construir um nível seria a criação de uma classe única *LevelBuilder*, que iria ser capaz de ler um ficheiro `.txt` e descodificar os simbolos *ASCII*, que estaria associado a um elemento.

O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/BuilderUML.png)

##### Ficheiros
- [LevelController](../src/main/java/org/g70/controller/level/LevelController.java)
- [LevelBuilder](../src/main/java/org/g70/controller/level/LevelBuilder.java)
- [Resources](../src/main/resources/levelDesign) (This folder contains 19 different levels)

#### Consequências
- Facilita criação de novos níveis.
- Facilita alteraçao dos ficheiros atuais.
- Facilita a adição de novos *Elements*, sendo apenas necessário atribuir um novo símbolo ASCII (*Open-Closed Principle*).

> Fonte: [Design Patterns - Builder](https://refactoring.guru/design-patterns/builder)


###  State
#### Contexto do Problema
Como planeávamos ter um programa que fosse possuir diversos estados de jogo, os quais teriam comportamentos distintos, decidimos que era necessário arranjar um padrão para organizar o código da melhor maneira possível, que permitisse troca entre estados.

Inicialmente, tinhamos apenas criado um simples menu principal capaz de iniciar ou terminar o jogo, que possuia apenas vários *Ifs* para executar a opção escolhida pelo utilizador, pelo que nos apercebemos que a contínua adição de funcionalidades aos menus iria causar o *Code Smell* *If Statements*

#### Padrão
Para resolver este problema, decidimos implementar o *Design Pattern* *State*. Este padrão iria possibilitar a criação de vários estados de jogo, que seriam alterados através de comandos, utilizando o *Design Pattern* *Command*.

#### Implementação
O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/Menu-State-CommandUML.png)

#### Ficheiros
- [Main Controller](..src/main/java/org/g70/controller/MainController.java)
- [State](../src/main/java/org/g70/controller/state/State.java)
- [StateGame](../src/main/java/org/g70/controller/state/StateGame.java)
- [StateGameOver](../src/main/java/org/g70/controller/state/StateGameOver.java)
- [StateHelp](..src/main/java/org/g70/controller/state/StateHelp.java)
- [StateMainMenu](../src/main/java/org/g70/controller/state/StateMainMenu.java)
- [MenuController](../src/main/java/org/g70/controller/menu/MenuController.java)
- [Option](../src/main/java/org/g70/controller/menu/option/Option.java)
- [OptionExit](../src/main/java/org/g70/controller/menu/option/OptionExit.java)
- [OptionHelp](../src/main/java/org/g70/controller/menu/option/OptionHelp.java)
- [OtionMainMenu](../src/main/java/org/g70/controller/menu/option/OptionMainMenu.java)
- [OptionNewGame](../src/main/java/org/g70/controller/menu/option/OptionNewGame.java)
- [MenuFactory](../src/main/java/org/g70/model/menu/MenuFactory.java)
- [MenuOption](../src/main/java/org/g70/model/drawable/menu/MenuOption.java)

#### Consequências
- Maior modularidade ao código, facilitando não só a alteração dos estados de jogo, mas também a sua adição (*Open-Closed Principle*).
- Facilita a adição e alteração de *Options* (*Open-Closed Principle*).
- Possibilita a criação de *Options* que afetem o estado de jogo.
- Evita o uso de *If Statements* nos *States* e *Options*.


> Fonte: [Design Patterns - State](https://web.fe.up.pt/~arestivo/presentation/patterns/#35), [Design Patterns - Command](https://web.fe.up.pt/~arestivo/presentation/patterns/#20)

### Command
#### Contexto do Problema
#### Padrão
#### Implementação
#### Ficheiros
#### Consequências

### Puffle/Box Movement Strategy
#### Problema
Sempre que o utilizador pressiona uma tecla para mover a posição do Puffle, vão ser verificadas todas as interações com os diversos Elementos, como por exemplo, se o mesmo passa por cima de uma moeda, se colide com um parede ou outro tipo de bloco especial. A contínua adição de interações entre o objeto e o *Puffle* causou um *Code Smell*, devido ao elevado número de *If Statements* associados a cada interação. Para aleḿ disso, acabamos por adicionar um novo Elemento *Box*, que teria a sua própria interação com cada objeto, o que intensificou o *Code Smell* mencionado.

#### Padrão
Para resolver este problema decidimos utilizar o *Design Pattern* *Strategy* que permite encapsular dinamicamente as diferentes interações de cada *Element* com o *Puffle* e a *Box* em diferentes classes, alterando a interação quando necessário.

#### Implementação

O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/CommandUML.png)

##### Ficheiros
- [Interact](../src/main/java/org/g70/controller/level/interact/Interact.java)
- [InteractBox](../src/main/java/org/g70/controller/level/interact/InteractBox.java)
- [InteractCoin](../src/main/java/org/g70/controller/level/interact/InteractCoin.java)
- [InteractDestination](../src/main/java/org/g70/controller/level/interact/InteractDestination.java)
- [InteractEmptyBlock](../src/main/java/org/g70/controller/level/interact/InteractEmptyBlock.java)
- [InteractIce](../src/main/java/org/g70/controller/level/interact/InteractIce.java)
- [InteractInvisibleWall](../src/main/java/org/g70/controller/level/interact/InteractInvisibleWall.java)
- [InteractKey](../src/main/java/org/g70/controller/level/interact/InteractKey.java)
- [InteractSecret](../src/main/java/org/g70/controller/level/interact/InteractSecret.java)
- [InteractStop](../src/main/java/org/g70/controller/level/interact/InteractStop.java)
- [InteractTeleport](../src/main/java/org/g70/controller/level/interact/InteractTeleport.java)
- [InteractToughIce](../src/main/java/org/g70/controller/level/interact/InteractToughIce.java)
- [LevelController](../src/main/java/org/g70/controller/level/LevelController.java)
- [LevelFacade](../src/main/java/org/g70/controller/level/LevelFacade.java)
- [LevelModel](../src/main/java/org/g70/model/level/LevelModel.java)
- [ElementModel](../src/main/java/org/g70/model/drawable/element/ElementModel.java)

#### Consequências
- Fácil e rápida implementação do comportamento de novos Elementos (*Open-Closed Principle*).
- Evita longos *If Statements* associados ao comportamento de cada Elemento
- Permite evitar código repetido, dado que vários Elementos podem ter a mesma interação (ex: Wall e Water)

> Fonte: [Design Patterns - Strategy](https://web.fe.up.pt/~arestivo/presentation/patterns/#30)

### Melting Strategy

#### Problema
Ao mover o *Puffle* era necessário não só vericar as interações associadas ao bloco para qual o *Puffle* se tenta mover, mas também ao bloco sobre o qual se situa. Inicialmente, para implementarmos este funcionalidade, colocamos vários *if Statements* no método `movePuffle()`, originando os *Code Smells* *Long Method* e *Switch Statements*.

#### Padrão
Para resolvermos este problema, decidimos utilizar o *Design Pattern Strategy*.
Este padrão permite-nos definir uma familia de algoritmos separados em diferentes classes, alterando facilmente o algoritmo que um determinado objeto usa

#### Implementação

O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/MeltStrategyUML.png)

##### Ficheiros
- [LevelFacade](../src/main/java/org/g70/controller/level/LevelFacade.java)
- [MeltStrategy](../src/main/java/org/g70/controller/level/strategy/MeltStrategy.java)
- [StrategyDoubleIce](../src/main/java/org/g70/controller/level/strategy/StrategyDoubleIce.java)
- [StrategyIce](../src/main/java/org/g70/controller/level/strategy/StrategyIce.java)
- [StrategyNothing](../src/main/java/org/g70/controller/level/strategy/StrategyNothing.java)

#### Consequências
- Evita um código desorganizado repleto de *if statements* confusos.
- Torna mais fácil alternar a estratégia a ser utilizada.
- O controlador deixa de verificar se existe um objeto com uma interação debaixo dele (na mesma posiçao), que maioritariamente nem iria existir, evitando erros e verificações associadas a *null pointers*.
- Facilita a adição de novos comportamentos do Puffle ao sair de uma posição (*Open-Closed Principle*).

> Fonte: [Design Patterns - Strategy](https://web.fe.up.pt/~arestivo/presentation/patterns/#30)


### Menu Factory
#### Problema
Os menus possuiam bastantes métodos repetidos, pelo que estávamos a tentar organizar as classes de modo a evitar o *Code Smell* *Duplicate Code*,  

#### Padrão
Este problema foi resolvido utilizando o *Design Pattern* *Factory Method*. Criamos a classe *Menu Factory*, que possui um *ArrayList* de *Options* e *TextBoxes*. posteriormente, criamos vários menus que extendem a clases *MenuFactory*, e cada um adiciona a cada *ArrayList* os objetos que deseja

#### Implementação

O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/FactoryMethodUML.png)


##### Ficheiros

- [Drawable](../src/main/java/org/g70/model/drawable/Drawable.java)
- [MenuOption](../src/main/java/org/g70/model/drawable/menu/MenuOption.java)
- [GameOverModel](../src/main/java/org/g70/model/menu/GameOverModel.java)
- [HelpModel](../src/main/java/org/g70/model/menu/HelpModel.java)
- [MainMenuModel](../src/main/java/org/g70/model/menu/MainMenuModel.java)
- [MenuFactory](../src/main/java/org/g70/model/menu/MenuFactory.java)

#### Consequências

- Fácil criação de novos Menus.
- Fácil de adicionar/remover funcionalidades(*Options*) a cada Menu (*Open-Closed Principle*)

> Fonte: [Design Patterns - Factory Method](https://web.fe.up.pt/~arestivo/presentation/patterns/#10)

### Private Class Data on LevelModel

#### Problema
O nosso programa continha um enorme quantidade de objetos, que eram utilizados quer no *levelModel*, quer no *levelFacade*, causando o *Code Smells* *Data Clumps*.

#### Padrão
Para resolver este problema, decidimos utilizar o *Design Pattern* *Private Class Data*, que consiste na criação de uma
*Data Class* contendo todos os objetos que se deseja encapsular.

#### Implementação
O diagrama seguinte demonstra como implementamos o *Design Pattern*

![](images/PrivateClassData.png)

#### Consequências

- Corrige o *Code Smell* *Data Clumps*, organizando os elementos associados ao nível num só objeto, simplificando todas as classes que necessitem de ter acesso aos *Elements*.
- Origina o *Code Smell* *Data Class*, que acaba por ser inerente ao padrão de arquitetura usado: *MVC* (Mais informação sobre este *Code Smell* no capítulo seguinte).
- Facilita a adição de *Elements* ao nível, pelo que basta adicionar mais um atributo ao levelModel.

> Fonte : [Design Patterns - Private Class Data](https://sourcemaking.com/design_patterns/private_class_data)


# Code Smells e Refactoring

### Data Class

As classes que se encontram no [*Package Model*](../src/main/java/org/g70/model) são apenas constituídas por atributos, funções *getter* e *setter*.  

Embora se possa resolver este problema colocando alguma *lógica do jogo* nas nossas *Data Classes* utilizando, por exemplo, o *Move Method*, estaríamos a violar o padrão arquitetural escolhido, o ***MVC***. Sendo assim, podemos afirmar que este *Code Smell* é inerente ao estilo arquitetural utilizado no desenvolvimento do nosso projeto, pelo que não temos planos futuros para o corrigir.

> Fonte: [Data Class](https://refactoring.guru/smells/data-class), [Move Method](https://refactoring.guru/move-method)



### Large Class
Embora a classe *LevelFacade* tenha pouco mais do que 100 linhas de código, possui um grande número de métodos, sendo responsável pela interações entre todos os elementos.

Uma maneira de corrigir este problema seria o uso do *Refactor* *Extract Class*, através da criação de uma classe para encapsular todos os métodos associados á manipulação de um objeto.

Ex: Os métodos:
- `updateBoxMovement()`
- `moveBox(Position position)`
- `resetBoxInteraction()`
- `boxLoop()`
- `executeBoxMovement()`

poderiam ser extraidos para uma nova classe, e o mesmo seria feito para cada Elemento.

> Fonte: [Large Class](https://web.fe.up.pt/~arestivo/presentation/refactoring/#11), [Extract Class](https://web.fe.up.pt/~arestivo/presentation/refactoring/#31)

# Unit Tests

A realização de unit tests permitiu-nos descobrir alguns erros que tinhamos no nosso código e que, muito provavelmente, de outra maneira não os iriamos descobrir.

A utilização de mutation tests, além de verificar se estavamos a testar de forma correta os diversas métodos e classes, permitiu-nos descobrir duas linhas de código que eram redundantes. Tinhamos uma mutation que removia um set. No entanto, esse set era redundante uma vez que estava sempre a ser executado anteriormente, pelo que não tinha qualquer efeito no código.

Ao longo do desenvolvimento destes mesmos testes fomos descobrindo que os mesmos não servem apenas para corrigir erros no código, mas também ajudam a promover um melhor design do mesmo.

![testCoverage](./images/testCoverage.png)

Os resultados dos testes encontram-se na seguinte [pasta](./test) e estão hospedados na seguinte [página]().

# Auto-Avaliação

Decidimos que ambos os colaboradores contribuiram de igual forma para o desenvolvimento do trabalho!!

Divisão percentual:
- Diogo Samuel Fernandes : 50%
- Hugo Guimarães : 50%
