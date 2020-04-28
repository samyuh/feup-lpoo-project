# REPORT - Grupo 70

O nosso jogo é inspirado no jogo `Gelo Fino` que existia no jogo *Club Penguin*. O jogador deve controlar o personagem de jogo através de inúmeros labirintos, passando pelo número máximo de quadrados antes de o completar. Além disso, ao longo do mapa vão surgindo moedas coletaveis que permitem ao jogador obter uma pontuação mais elevada assim como diversos obstáculos!

# Indice

1. [Introdução](#introdução)
2. [Funcionalidades](#funcionalidades)
3. [Estrutura Geral](#estrutura-geral)
    - [Arquitetura do Código](#padrão-arquitetural-do-código)
4. [Design Patterns](#design-patterns)
    - [Strategy](#strategy)
5. [Code Smells e Refactoring]

#  Introdução

O nosso jogo é inspirado no jogo `Gelo Fino` que existia no jogo *Club Penguin*. O jogador deve controlar o personagem de jogo através de inúmeros labirintos, passando pelo número máximo de quadrados antes de o completar. Além disso, ao longo do mapa vão surgindo moedas coletaveis que permitem ao jogador obter uma pontuação mais elevada assim como diversos obstáculos!

# Funcionalidades

# Estrutura Geral
## Padrão Arquitetural do Código

Para a realização deste projeto, decidimos separar o nosso projeto em três pacotes sendo eles:

- Model
- View
- Controller

### Model

O **Model** contém todos o dados do jogo.

### View

O pacote **View** é responsável por toda a interação **Utilizador-Máquina**, ou seja, inicializa o Lanterna e atua como a GUI, sendo responsável pelo desenho e envia as ações do utilizador para o **Controller**.

### Controller

O **Controller** é responsável pelo mecanismo do jogo, sendo este 

Ou seja, o controlador utiliza os dados existentes no **Model** e altera-os garantindo o cumprimento das regras do jogo. Estes dados depois de processados são desenhos no ecrã pelo **View**.

# Design Patterns
### Strategy

##### Problema:

Este Método é também capaz de resolver o problema anterior, porém, de uma maneira diferente. Ou seja, divide os tipos de níveis em várias classes derivadas de um nível, sendo cada uma responsável pela execução do percurso da sua forma

##### Exemplo:

Mecanismo chave fechadura: Existência de uma classe **LevelCoin** e outra **LevelKey**. O nosso código seria responsável de chamar um controlador de nivel adequado ao nivel atual. Se Só houvesse coins, chamaríamos o LevelCoin, que não iria verificar as colisões com chave fechadura, gelo branco, etc. Á medida que a complexidade dos níveis iria aumentado, alterávamos o controlador de nivel a utilizar.



