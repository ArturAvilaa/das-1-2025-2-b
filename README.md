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
# Aula 04 - SOLID

O **SOLID** é um conjunto de cinco princípios de programação orientada a objetos que visam criar sistemas mais compreensíveis, flexíveis e de fácil manutenção.

1. **S – Single Responsibility Principle (SRP)**  
   *Princípio da Responsabilidade Única*:  
   - Cada classe deve ter **apenas uma responsabilidade** ou razão para mudar.  
   - Facilita manutenção e entendimento do código.

2. **O – Open/Closed Principle (OCP)**  
   - Classes devem estar **abertas para extensão** e **fechadas para modificação**.  
   - Novos comportamentos devem ser adicionados sem alterar código existente.

3. **L – Liskov Substitution Principle (LSP)**  
   - Objetos de uma subclasse devem poder substituir objetos da superclasse **sem quebrar o comportamento esperado**.  
   - Mantém a integridade da herança.

4. **I – Interface Segregation Principle (ISP)**  
   *Princípio da Segregação da Interface*:  
   - Interfaces específicas, menores e coesas são melhores que uma interface única e genérica.  
   - Evita obrigar classes a implementar métodos que não utilizam.

5. **D – Dependency Inversion Principle (DIP)**  
   - Módulos de alto nível não devem depender de módulos de baixo nível, ambos devem depender de abstrações.  
   - As abstrações não devem depender de detalhes, e sim o contrário.

---

## Livro recomendado
- **Título:** *Código Limpo* (*Clean Code*)  
- **Autor:** Robert C. Martin (*Uncle Bob*)  
- Aborda práticas para escrever código mais legível, limpo e sustentável.
- design paterns
- estudar sobre erik gamma
- 
---

## Boas práticas
- **Regras de negócio e lógica de aplicação** devem estar localizadas na **camada `Service`**.  
  Isso separa responsabilidades e mantém o código organizado.

---

## Herança e Interfaces
- **Seta da herança**: Representa a relação entre uma classe derivada (filha) e sua classe base (mãe).  
- **Variáveis e Interfaces**:  
  - É comum declarar variáveis utilizando o tipo **interface** e instanciá-las com uma **classe concreta**.  
    ```java
    List<String> nomes = new ArrayList<>();
    ```
  - Isso facilita a troca da implementação sem alterar o restante do código.

---

✏ **Resumo**: Aplicar o SOLID e seguir práticas recomendadas como separar lógica de negócio na `Service` e usar abstrações garante um código mais limpo, sustentável e fácil de manter.

