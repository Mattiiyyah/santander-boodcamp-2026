# Exercícios de Herança e Polimorfismo - Santander Bootcamp 2026 ☕

Oi! Esse aqui é o meu projeto para a aula de **Herança e Polimorfismo** da trilha de **AI Java Back-end** do **Bootcamp Santander 2026**.

A ideia dessa parte do curso era aplicar os conceitos de **Herança** para reaproveitar atributos/métodos comuns e **Polimorfismo** para alterar comportamentos de acordo com o tipo da classe. E claro, sempre gosto de ir além nas validações e regras de negócio! 😅

## O que tem no código?

Nesse projeto, resolvi três cenários diferentes para aplicar o que foi aprendido:

1. **Sistema de Ingressos de Cinema** 🎟️:
   - Classe base de Ingresso contendo valor, nome do filme e idioma (dublado/legendado).
   - Tipos derivados: **Meia Entrada** (que corta o valor pela metade) e **Ingresso Família** (que multiplica pelo valor e número de pessoas, aplicando 5% de desconto para grupos maiores que 3).

2. **Usuários de um Sistema** 👥:
   - Uma hierarquia de papéis com atributos compartilhados (Nome, Email, Senha e status de administrador).
   - **Gerente** (admin), **Vendedor** (não-admin, controla vendas) e **Atendente** (não-admin, gerencia valor em caixa).
   - Métodos específicos para cada cargo e também métodos compartilhados (como login, logoff e alteração de dados).

3. **Relógios pelo Mundo** ⌚:
   - Superclasse controlando o tempo (horas, minutos e segundos) e validações rígidas do relógio.
   - Implementação do **Relógio Brasileiro** (24h) e **Relógio Americano** (12h, não passando de 12 horas).
   - Um método polimórfico para sincronizar e transferir as horas entre relógios diferentes, ajustando os formatos.

## Onde eu me empolguei um pouco mais?

O foco principal foi **reaproveitamento de código** e organização da **Hierarquia de Classes**:
- **Menos repetição de código**: Tudo o que era comum entre as classes foi parar na classe pai, e as classes filhas ficaram só com o que as tornavam únicas (como regras específicas de cálculo de preço ou métodos exclusivos).
- **Sobrescrita Inteligente**: Apliquei a sobrescrita de métodos nos relógios e ingressos para que o comportamento mude automaticamente dependendo de qual objeto estamos instanciando.
- **Encapsulamento contínuo**: Continuei blindando as classes, protegendo atributos e garantindo que as regras de negócio fossem respeitadas nos `getters` e `setters`.

---