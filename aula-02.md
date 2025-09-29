# 31/07/2025 - Arquitetura de Código
*Baseada no livro "Engenharia de Software Moderna"*

## Contexto do Livro
O livro "Engenharia de Software Moderna" aborda práticas contemporâneas de desenvolvimento, enfatizando a importância de fundamentos sólidos em arquitetura de código para construir sistemas sustentáveis e escaláveis.

## Abstração
Estratégia fundamental para reduzir a complexidade de software através da representação simplificada de elementos do mundo real em código. Permite focar nos aspectos essenciais ignorando detalhes irrelevantes.

**Hierarquia de Abstrações:**
- **Entidade**: Representação de elementos do domínio real com identidade única
- **Repositório**: Abstração de operações de persistência e acesso a dados
- **Serviço**: Abstração da lógica de negócios e orquestração
- **Controlador**: Abstração de endpoints e interface com clientes externos

## Complexidade em Software
Dificuldade inerente em compreender, modificar e manter um sistema devido a múltiplos fatores: quantidade de elementos, interdependências, falta de clareza estrutural e acoplamento excessivo. Pode ser classificada em:

- **Complexidade Acidental**: Resultante de más decisões de design
- **Complexidade Essencial**: Inerente ao problema sendo resolvido

## Boas Práticas em Desenvolvimento Orientado a Objetos

- **Padrões de Nomenclatura**: Seguir convenções estabelecidas pela linguagem (camelCase, PascalCase, snake_case)
- **Uso de Frameworks**: Aproveitar estruturas consolidadas para padronização e produtividade
- **Estruturas de Dados Adequadas**: Selecionar coleções e tipos apropriados para cada contexto
- **Princípios SOLID**: Aplicar diretrizes para design orientado a objetos coeso

## Estradas Pavimentadas
Conceito que defende a utilização de soluções já validadas pela indústria, baseado na premissa de que reinventar a roda é custoso e arriscado.

**Vantagens:**
- Economia de tempo e recursos financeiros
- Redução de riscos através de soluções testadas
- Acesso a conhecimentos e melhores práticas consolidadas
- Foco em diferenciais competitivos ao invés de problemas já resolvidos

## Ocultamento de Informação
Princípio implementado através do encapsulamento que protege os detalhes internos de implementação, expondo apenas interfaces bem definidas.

**Benefícios:**
- **Desenvolvimento Paralelo**: Equipes podem trabalhar independentemente em módulos encapsulados
- **Flexibilidade a Mudanças**: Implementações internas podem evoluir sem impactar consumidores
- **Facilidade de Entendimento**: Redução da carga cognitiva através de interfaces simplificadas
- **Manutenibilidade**: Isolamento de mudanças e prevenção de efeitos colaterais

## Getters e Setters
Mecanismos que implementam o encapsulamento controlando o acesso aos atributos internos de uma classe. Permitem:

- Validação de dados na entrada
- Controle de estado interno consistente
- Flexibilidade para alterar implementação sem quebrar contratos
- Adição de lógica auxiliar (logging, notificações)