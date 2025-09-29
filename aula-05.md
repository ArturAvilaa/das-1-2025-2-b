# 11/08/2025 - SOLID
*Baseada no livro "Código Limpo" e referências de Bertrand Meyer*

---

## Capítulo 1 - Princípio de Inversão de Dependências
Em vez de o código depender diretamente de implementações concretas (como classes específicas), ele deve depender de abstrações (como interfaces).  

**Benefícios:**
- Facilita substituição de implementações  
- Reduz acoplamento  
- Aumenta a flexibilidade e a manutenibilidade do sistema  

---

## Capítulo 2 - Princípio Prefira Composição a Herança
Este princípio recomenda priorizar o uso de **composição** em detrimento da **herança**.  

### Herança:
- Cria forte acoplamento entre classes  
- Expõe detalhes internos  
- Pode gerar herança de comportamentos indesejados ou incorretos  

### Composição:
- Permite flexibilidade, inclusive alteração em tempo de execução  
- Evita dependência excessiva entre classes  
- Reduz efeitos colaterais em mudanças  

**Resumo:**  
A herança deve ser usada somente quando duas classes **filhas** realmente compartilham uma relação clara com a classe **pai** e não fazem sentido sem essa hierarquia.  

---

## Capítulo 3 - Princípio de Demeter (Menor Conhecimento)
Também chamado de **Lei de Demeter** ou princípio do menor conhecimento.  

### Regras:
Um método deve invocar apenas:
- Métodos da sua **própria classe**  
- Métodos de objetos recebidos como **parâmetro**  
- Métodos de objetos **criados internamente**  
- Métodos de **atributos** da própria classe  

**Objetivo:**  
Evitar o acoplamento excessivo e a dependência em cadeias longas de chamadas.  

---

## Capítulo 4 - Open/Closed Principle (Aberto/Fechado)
Defendido por **Bertrand Meyer** na década de 80.  
Diz que **uma classe deve estar fechada para modificações, mas aberta para extensões.**  

### Exemplos de aplicação:
- Uso de **interfaces** para possibilitar múltiplas implementações  
- Aplicação de **padrões de projeto** como Strategy e Template Method  

**Resumo:**  
Esse princípio incentiva a construção de classes flexíveis e extensíveis, que se adaptam a diferentes cenários sem necessidade de alterar o código-fonte existente.  

---

## Conclusão da Aula
Nesta aula (11/08/2025) aprendemos:  
- O **princípio da inversão de dependências**, essencial para reduzir acoplamento  
- O motivo de **preferir composição a herança** em busca de maior flexibilidade  
- Como aplicar o **princípio de Demeter** para evitar cadeias de chamadas complexas  
- O fundamento do **princípio Aberto/Fechado**, que sustenta extensibilidade sem modificar código existente  

Esses conceitos reforçam os pilares de **SOLID**, garantindo código limpo, organizado e preparado para evoluir.  

