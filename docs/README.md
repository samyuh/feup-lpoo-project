# REPORT - Grupo 70


O nosso jogo é inspirado no jogo `Gelo Fino` que existia no jogo *Club Penguin*. O jogador deve controlar o personagem de jogo através de inúmeros labirintos, passando pelo número máximo de quadrados antes de o completar. Além disso, ao longo do mapa vão surgindo moedas coletaveis que permitem ao jogador obter uma pontuação mais elevada assim como diversos obstáculos!

- **Universidade**: [FEUP](https://sigarra.up.pt/feup/pt/web_page.Inicial)
- **Curso**: [MIEIC](https://sigarra.up.pt/feup/pt/cur_geral.cur_view?pv_curso_id=742&pv_ano_lectivo=2019)
- **Unidade Curricular**: [LPOO](https://sigarra.up.pt/feup/pt/UCURR_GERAL.FICHA_UC_VIEW?pv_ocorrencia_id=420000) (Laboratório de Programação Orientada por Objetos)
- **Elementos do Grupo**:    
    - Diogo Samuel Fernandes, up201806250@fe.up.pt
    - Hugo Guimarães, up201806490@fe.up.pt

# Indíce

1. [Funcionalidades](#funcionalidades)
2. [Arquitetura do Código](#padrão-arquitetural-do-código)
3. [Design Patterns](#design-patterns)
    - [Strategy](#strategy)
4. [Code Smells e Refactoring](#code-smells-e-refactoring)
5. [Unit Tests](#unit-tests)

# Funcionalidades

- [ ] Menu Principal

- [x] Todas as peças que o jogador percorre ficam inacessíveis.
  - [x] O jogador não pode passar por cima de uma peça de água
  - [x] Se o jogador ficar rodeado por peças de água, este perde.
  - [x] Quanto maior for o número de peças de gelo que o jogador passe, maior é a sua pontuação


- [x] Existem sacos com moedas espalhados pelo nivel.
  - [x] Capturar um saco com moedas faz aumentar a pontuação do jogador
  - [ ] Podem existir passagem secretas que levem para zonas com muitos sacos de moedas.

- [x] A partir de um certo nivel começa a aparecer gelo mais resistente, isto é uma zona em que o jogador pode passar por cima duas vezes. 

- [ ] Quando o jogador passa por cima de um quadrado verde, o mesmo vai ser teletransportado para outro quadrado verde do mesmo nível.

- [ ] Menu de fim de jogo
    - [ ] O jogo acaba assim que o jogador completar todos os niveis. É apresentado a pontuação total.

# Padrão Arquitetural do Código

To structure this project we decided to implement the MVC (Model-View-Controller) architectural pattern. As the name implies this pattern divides the structure of the program in three interconnected parts:

Model: It holds the internal game information, rules and is independent of the user interface
View: Represents the visualization of the data that model contains.
Controller: Exists between the view and the model. It listens to events triggered by the view and executes the appropriate reaction to these events. In most cases, the reaction will change the model and its display under view.
The biggest advantage in the MVC architectural pattern is that it decouples these major components allowing for efficient code reuse and parallel development.

Para a realização deste projeto, decidimos separar e estruturar o nosso código utilizando o MVC. Este modelo foi apresentado durante as aulas e consiste em separar o código em três *packages* diferentes sendo estes:
- Model - Responsável por armazenar a informação do jogo, como a posição dos diversos elementos em cada nível.
- View - Responsável por toda a interação **Utilizador-Máquina**, ou seja, inicializa o Lanterna e atua como a GUI, sendo responsável pelo desenho e envia as ações do utilizador para o **Controller**.

- Controller - é responsável pelo mecanismo do jogo.
Ou seja, o controlador utiliza os dados existentes no **Model** e altera-os garantindo o cumprimento das regras do jogo. Estes dados depois de processados são desenhos no ecrã pelo **View**.

# Design Patterns

-- TO DO 
### Strategy

Problem in Context
The Pattern
Implementation
Consequences

##### Problema:

Este Método é também capaz de resolver o problema anterior, porém, de uma maneira diferente. Ou seja, divide os tipos de níveis em várias classes derivadas de um nível, sendo cada uma responsável pela execução do percurso da sua forma

##### Exemplo:

Mecanismo chave fechadura: Existência de uma classe **LevelCoin** e outra **LevelKey**. O nosso código seria responsável de chamar um controlador de nivel adequado ao nivel atual. Se Só houvesse coins, chamaríamos o LevelCoin, que não iria verificar as colisões com chave fechadura, gelo branco, etc. Á medida que a complexidade dos níveis iria aumentado, alterávamos o controlador de nivel a utilizar.

### Command

# Code Smells e Refactoring

### Data Class

# Unit Tests

