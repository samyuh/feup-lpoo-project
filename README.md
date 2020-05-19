# FrostBite Penguin Madness

O nosso jogo é inspirado num mini-jogo existente no *Club Penguin*, chamado de `Gelo Fino`. O jogador deve controlar um `Puffle`através de inúmeros labirintos, passando pelo maior número de blocos de gelo antes de o completar. Ao longo do jogo vão surgindo moedas coletáveis, blocos de gelo duplo, teletransporte e até passagens secretas, que permitem ao jogador obter uma maior pontuação!

- **Universidade**: [FEUP](https://sigarra.up.pt/feup/pt/web_page.Inicial)
- **Curso**: [MIEIC](https://sigarra.up.pt/feup/pt/cur_geral.cur_view?pv_curso_id=742&pv_ano_lectivo=2019)
- **Unidade Curricular**: [LPOO](https://sigarra.up.pt/feup/pt/UCURR_GERAL.FICHA_UC_VIEW?pv_ocorrencia_id=420000) (Laboratório de Programação Orientada por Objetos)
- **Elementos do Grupo**:    
    - Diogo Samuel Fernandes, up201806250@fe.up.pt
    - Hugo Guimarães, up201806490@fe.up.pt

## Instalação

Para jogar este jogo é necessário correr o projeto utilizando o `Gradlew`, usando o comando
```shell
./gradlew run   # se estiver a ser utilizado Linux
./gradlew.bat run # se estiver a ser utilizado Windows
```

## Pacotes Utilizados

- Lanterna

## Funcionalidades

- [x] Menu Principal
    - [x] Começar um novo jogo
    - [x] Escolha de nível
    - [x] Sair do jogo

- [x] Movimento
    - [x] Sempre que o jogador se movimentar, a sua posição anterior fica inacessível
    - [x] As posições inacessíveis são transformadas em água
    - [x] Quando o jogador não se pode movimentar, isto é, quando rodeado por peças de água e por paredes, perde o jogo

- [ ] Menu Pausa
    - [ ] Recomeçar o nível
    - [ ] Retornar ao menu principal

- [x] Pontuação
    - [x] Sempre que o jogador percorre um novo quadrado, a sua pontuação incrementa um ponto
    - [x] Existem moedas espalhadas em determinados niveís
    - [x] Capturar uma moeda aumenta a pontuação do jogador em dez pontos

- [x] Mecânicas de jogo
    - [x] Quadrados onde o jogador pode passar por cima duas vezes.
    - [x] Quadrados verdes que correspondem a uma zona de teletransporte. Quando o jogador passa por cima do mesmo vai ser teletransportado para outro quadrado verde do mesmo nível.
    - [x] Existência de peças de jogo que são empurradas pelo jogador até colidirem com uma parede
    - [ ] Passagens secretas que levem o jogador para zonas bónus com muitos sacos de moedas.

- [x] Menu de fim de jogo
    - [ ] O jogo acaba assim que o jogador completar todos os niveis ou perder. É apresentado a pontuação total.
    - [x] Retornar ao Menu Principal


