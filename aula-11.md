# Aula 08/09 e 11/09 - Fundamentos da Arquitetura de Software - Análise de Trade-offs

## Referência Bibliográfica
[Livro: Fundamentos da arquitetura de software: uma abordagem de engenharia - Richards, Mark, Ford, Neal](https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/22[%3Bvnd.vst.idref%3Dcap2.xhtml]!/4)

## Análise de Trade-offs em Arquitetura de Software

### O que são Trade-offs?
Decisões arquiteturais que envolvem balanceamento entre aspectos conflitantes, onde a melhoria em uma característica geralmente implica na piora de outra.

### Trade-offs Comuns na Arquitetura

**Desempenho vs Custo**
- Maior performance geralmente requer mais recursos de infraestrutura
- Exemplo: Cache distribuído versus custo de servidores adicionais

**Escalabilidade vs Complexidade**
- Sistemas altamente escaláveis tendem a ser mais complexos
- Exemplo: Microsserviços versus monolito

**Segurança vs Usabilidade**
- Medidas de segurança rigorosas podem impactar a experiência do usuário
- Exemplo: Autenticação multifator versus simplicidade de acesso

**Velocidade de Desenvolvimento vs Qualidade**
- Desenvolvimento rápido pode comprometer a qualidade do código
- Exemplo: MVP versus sistema robusto

### Processo de Análise de Trade-offs

1. **Identificar Requisitos Conflitantes**
   - Listar objetivos que se contradizem
   - Priorizar com base no negócio

2. **Avaliar Impactos**
   - Técnico: desempenho, manutenibilidade
   - Negócio: custo, tempo de entrega
   - Operacional: complexidade, monitoramento

3. **Tomar Decisão Informada**
   - Documentar rationale por trás da escolha
   - Considerar consequências de longo prazo

### Exemplo Prático: Banco de Dados

**Opção A: SQL (Relacional)**
- Vantagens: Consistência de dados, ACID properties
- Desvantagens: Escalabilidade horizontal limitada

**Opção B: NoSQL (Não-relacional)**
- Vantagens: Alta escalabilidade, flexibilidade de schema
- Desvantagens: Consistência eventual

### Importância para o Arquiteto
- Desenvolver capacidade de analisar múltiplas perspectivas
- Tomar decisões balanceadas considerando contexto do negócio
- Comunicar trade-offs claramente para stakeholders