# Aula 03 - Coesão e Acoplamento

**Data:** 04/08/2025  

## Assuntos abordados

- Conceito de Orientação a Objetos
- Métodos Getters e Setters
- Princípio da Coesão (5.4)
- Princípio do Acoplamento

## Anotações importantes

### Getters e Setters

- São métodos utilizados para acessar (`get`) e modificar (`set`) atributos privados de uma classe.
- Boa prática de encapsulamento, pois protege os dados internos do objeto e permite controle sobre alterações.

### Princípio da Coesão (5.4)

- Cada classe deve ter **uma única responsabilidade bem definida**.
- Classes coesas são mais simples de entender, reutilizar, testar e manter.
- A coesão facilita a implantação e evolução do sistema.

**Boas práticas:**
- Divida o sistema em partes distintas.
- Crie uma nova classe para cada responsabilidade.
- Evite que uma única classe concentre várias funções desconexas ("classe Frankenstein").
- Também evite uma separação exagerada que dificulte o entendimento do sistema.
- O ideal é alcançar um equilíbrio entre separação e centralização.

### Acoplamento

- Acoplamento é o grau de **dependência** entre duas classes.
- Representa a **força da conexão**: quanto mais acopladas, mais difícil é modificar uma sem impactar a outra.
- O acoplamento ocorre, por exemplo, quando uma classe possui como atributo outra classe (associação).

**Exemplo:**
- Se a classe A possui um atributo do tipo B, mudanças em B podem exigir mudanças em A e vice-versa.

**Princípio:**
- **Maximize a coesão e minimize o acoplamento.**
- Classes devem ser o mais independentes possível, facilitando a manutenção, testes e reutilização.

## Dúvidas a revisar

- Como identificar na prática quando o acoplamento está alto?
- Quais técnicas ajudam a reduzir o acoplamento sem comprometer a funcionalidade?
