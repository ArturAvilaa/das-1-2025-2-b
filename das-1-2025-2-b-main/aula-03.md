## Aula 3 (04/08/2025) - Coesão, Acoplamento e SOLID

### Coesão

Trata-se de um codigo minimo para eu fazer uma tarefa bem feita. Toda classe deve implementar uma única funcionalidade ou serviço e todos os metodos e atributos de uma classe devem estar voltados para a implementação do mesmo serviço.

#### Coesão tem as seguintes vantagens:

- Facilita a implementação de uma classe, bem como o seu entendimento e manutenção.
- Facilita a alocação de um único responsável por manter uma classe.
- Facilita o reúso e teste de uma classe, pois é mais simples reusar e testar uma classe coesa do que uma classe com várias responsabilidades.

#### Separação de interesses: é uma propriedade desejável parecida com a coesão, ela defende que uma classe deve implementar apenas um interesse.

### Acoplamento

Acoplamento é o grau de dependência entre classes e pode ser aceitável ou ruim. É aceitável quando ocorre por meio de interfaces estáveis e uso de métodos públicos. Já o acoplamento ruim surge quando há dependência de implementações instáveis, como arquivos compartilhados ou variáveis globais. Existe o acoplamento estrutural (explícito no código) e o evolutivo (efeito de mudanças se propagarem). Minimizar o acoplamento e maximizar a coesão melhora a manutenção e a estabilidade do sistema.

### SOLID

É programar orientado a objetos 

Trata-se de um acrônimo:

**S**ingle Resposability Principle | Responsabilidade Única   |
**O**pen/Closed Principle          | Aberto/Fechado           |
**L**iskov Substitution Principle  | Substituição de Liskov   |
**I**nterface Segregation Principle| Segregação de Interfaces |
**D**ependency Inversion Principle | Inversão de Dependências |
