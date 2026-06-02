# Exercícios de Classes e Encapsulamento - Santander Bootcamp 2026 ☕

Oi! Esse aqui é o meu projeto para a aula de **Classes e Encapsulamento** da trilha de **AI Java Back-end** do **Bootcamp Santander 2026**.

A ideia dessa parte do curso era colocar a mão na massa e praticar Orientação a Objetos (OO), focando em criar classes bem estruturadas, controlar os estados dos objetos e usar o encapsulamento para proteger os dados. Como sempre, fui um pouco além pra treinar bem as lógicas! 😅

## O que tem no código?

Nesse projeto, eu implementei três sistemas diferentes, baseados nos desafios propostos:

1. **Conta Bancária (Bank Account)** 🏦:
   - Gerencia saldo, saques, depósitos e pagamento de boletos.
   - O grande desafio foi o **cheque especial**, que é calculado na criação da conta com base no primeiro depósito.
   - Tem lógica embutida para cobrar taxa de 20% caso o cheque especial seja utilizado.

2. **Controle de Carro (Car)** 🚗:
   - Simula um carro real! Ele começa desligado, em ponto morto e a 0 km/h.
   - Controle de 6 marchas, onde a velocidade está atrelada à marcha atual (não dá pra acelerar muito na 1ª marcha, por exemplo).
   - Validações para não pular marcha e só permitir virar esquerda/direita em velocidades seguras (1 a 40 km/h).

3. **Máquina de Banho de Petshop (Pet Bath Machine)** 🐶:
   - Uma máquina automática de banho. Controla o nível de água (max 30L) e shampoo (max 10L).
   - O banho consome água e shampoo. Se o pet sair no meio do processo, a máquina fica suja e precisa ser limpa (gastando mais insumos) antes do próximo.
   - Controle rígido: apenas um pet por vez!

## Onde eu me empolguei um pouco mais?

Como a ideia era focar em **Encapsulamento**, eu fiz questão de proteger os atributos e expor apenas os métodos que fazem sentido para quem está "usando" as classes:
- **Proteção de estado**: Não tem como alterar a velocidade do carro magicamente; tem que usar o acelerador ou freio e estar na marcha certa.
- **Validações rígidas**: Tratamento para não sacar dinheiro que não tem (além do cheque especial), não ultrapassar limites de água/shampoo e não quebrar as regras de negócio.
- **Organização**: Separei os modelos (`entities`) da lógica de execução (`application`), mantendo o código bem limpo e fácil de ler.

---
Bora codar! Qualquer dica sobre design patterns, Clean Architecture ou melhorias no código é super bem-vinda! 🚀
