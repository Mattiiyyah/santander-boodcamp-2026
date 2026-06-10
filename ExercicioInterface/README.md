# Exercícios de Interfaces e Lambdas - Santander Bootcamp 2026 ☕

Oi! Esse aqui é o meu projeto para a aula de **Interfaces e Expressões Lambda** da trilha de **AI Java Back-end** do **Bootcamp Santander 2026**.

A ideia dessa parte do curso era praticar o uso de **Interfaces** para definir contratos, além de possivelmente aplicar expressões lambda. Coloquei a mão na massa para resolver alguns desafios clássicos de abstração e polimorfismo! 😅

## O que tem no código?

Nesse projeto, eu implementei três sistemas diferentes, baseados nos desafios propostos:

1. **Mensagens de Marketing (Marketing Messages)** 📱:
   - Um sistema para disparar mensagens por diferentes canais.
   - Implementação de serviços para **SMS, E-mail, Redes Sociais e WhatsApp**.
   - Todos implementam o mesmo contrato (interface), recebendo a mensagem como parâmetro.

2. **Cálculo de Tributos de Produtos (Product Taxes)** 💰:
   - Uma forma de calcular impostos baseados na categoria do produto.
   - Categorias: **Alimentação (1%), Saúde e bem-estar (1.5%), Vestuário (2.5%) e Cultura (4%)**.
   - Cada tipo de produto sabe calcular o próprio imposto usando o método da interface.

3. **Área de Figuras Geométricas (Geometric Shapes)** 📐:
   - Cálculo de área padronizado para diferentes formas.
   - **Quadrado** (baseado nos lados), **Retângulo** (base e altura) e **Círculo** (raio).
   - Todos respondem ao mesmo método que devolve o valor da área.

---