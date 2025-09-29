# 04/08/2025 - Coesão, Acoplamento e SOLID

## Coesão
Princípio que define que uma classe deve conter apenas o código necessário para executar uma única responsabilidade de forma completa.

### Vantagens da Coesão
- Facilita implementação e entendimento da classe
- Simplifica manutenção e testes
- Permite reúso mais eficiente
- Facilita atribuição de responsabilidades na equipe

### Separação de Interesses
Princípio relacionado que defende que uma classe deve implementar apenas um interesse específico do domínio.

## Acoplamento
Grau de interdependência entre classes e componentes do sistema.

### Tipos de Acoplamento
**Aceitável:**
- Dependência via interfaces estáveis
- Uso de métodos públicos bem definidos

**Ruim:**
- Dependência de implementações instáveis
- Uso de variáveis globais ou arquivos compartilhados

### Classificações
- **Acoplamento Estrutural**: Dependências explícitas no código
- **Acoplamento Evolutivo**: Propagação de mudanças entre componentes

### Benefícios do Baixo Acoplamento
- Maior estabilidade do sistema
- Flexibilidade para modificações
- Melhor testabilidade dos componentes

## Princípios SOLID
Conjunto de cinco princípios para design de software orientado a objetos.

### S - Single Responsibility Principle
Uma classe deve ter apenas uma razão para mudar.

### O - Open/Closed Principle
Entidades devem ser abertas para extensão, mas fechadas para modificação.

### L - Liskov Substitution Principle
Classes derivadas devem ser substituíveis por suas classes base.

### I - Interface Segregation Principle
Múltiplas interfaces específicas são melhores que uma interface única.

### D - Dependency Inversion Principle
Dependa de abstrações, não de implementações concretas.