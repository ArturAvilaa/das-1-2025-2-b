# Aula 09/10 - Circuit Breaker  
## Definições das Características Arquiteturais  

### Padrão do Disjuntor  

O **padrão Circuit Breaker** é utilizado para lidar com falhas em comunicações entre sistemas distribuídos.  
Quando um serviço remoto apresenta instabilidade ou falha, o disjuntor bloqueia temporariamente novas tentativas, evitando sobrecarga e permitindo a recuperação do sistema.  

Esse padrão aumenta a **resiliência** e a **estabilidade** das aplicações distribuídas.

---

## Contexto e Problema  

Em sistemas distribuídos, chamadas a serviços externos podem falhar devido a:
- Sobrecarga de recursos;  
- Conexões lentas ou indisponíveis;  
- Falhas transitórias ou persistentes.  

Falhas contínuas consomem recursos e podem gerar **falhas em cascata**.  
O objetivo do Circuit Breaker é interromper temporariamente novas tentativas até que o sistema tenha **condições reais de recuperação**.

---

## Solução  

O **Circuit Breaker** funciona como um proxy que controla as chamadas a serviços externos.  
Com base no histórico de falhas e sucessos, ele define se a operação será executada ou bloqueada.  

O funcionamento é baseado em três estados:

| Estado | Descrição |
|--------|------------|
| **Fechado** | Todas as solicitações são permitidas. Se o número de falhas ultrapassar o limite definido, o estado muda para **Aberto**. |
| **Aberto** | As chamadas são bloqueadas temporariamente. Após um período de espera, o disjuntor passa para o estado **Meio-Aberto**. |
| **Meio-Aberto** | Permite um número limitado de chamadas de teste. Se forem bem-sucedidas, o estado volta a **Fechado**; se falharem, retorna a **Aberto**. |

---

## Comparação com o Padrão Retry  

- **Retry:** tenta novamente a operação após falhas, com base em intervalos configurados.  
- **Circuit Breaker:** impede tentativas enquanto a probabilidade de sucesso é baixa.  

Os dois padrões podem ser combinados, desde que o Retry respeite o estado do disjuntor.

---

## Funcionamento dos Contadores  

- **Falhas (estado Fechado):** o contador é reiniciado periodicamente para evitar acionamentos indevidos.  
- **Sucessos (estado Meio-Aberto):** um número definido de chamadas bem-sucedidas reativa o disjuntor.  

Essa lógica garante a recuperação gradual do sistema e evita sobrecargas prematuras.

---

## Benefícios  

- Evita falhas em cascata.  
- Mantém a estabilidade e o desempenho.  
- Reduz o tempo de resposta durante falhas.  
- Preserva recursos do sistema.  

---

## Considerações de Implementação  

**Tratamento de Exceções:**  
O sistema deve tratar exceções retornadas quando o disjuntor está aberto, podendo usar cache ou mensagens alternativas.  

**Tipos de Falhas:**  
O disjuntor pode diferenciar falhas críticas (ex.: timeouts) de falhas transitórias, reagindo de forma adequada a cada caso.  

**Monitoramento:**  
Deve haver métricas para acompanhar taxas de falhas, tempos de resposta e estado atual do disjuntor.  

**Recuperação:**  
O tempo de bloqueio deve equilibrar estabilidade e agilidade. Um tempo muito curto causa oscilações; um tempo longo atrasa a retomada.  

**Testes e Ajustes:**  
Chamadas de teste controladas podem ser usadas para verificar a recuperação do serviço antes de liberar o tráfego normal.  

**Administração Manual:**  
O disjuntor pode ser configurado para permitir ativação ou desativação manual em situações críticas.  

---

## Quando Utilizar  

**Recomendado quando:**  
- Há dependências externas com instabilidade.  
- O sistema precisa se manter disponível durante falhas.  
- Deseja-se evitar sobrecarga e falhas em cascata.  

**Evite quando:**  
- O sistema é local e estável.  
- Há sobrecarga desnecessária causada pelo controle.  
- Mecanismos de retry já são suficientes.  

---

## Padrão no Contexto do Azure Well-Architected Framework  

| Pilar | Objetivo |
|--------|-----------|
| **Confiabilidade (RE)** | Evita sobrecarga em serviços com falha, mantendo o sistema disponível. |
| **Eficiência de Desempenho (PE)** | Impede tentativas desnecessárias, otimizando o uso de recursos. |

---

## Exemplo Prático  

**Cenário:**  
Em uma aplicação que utiliza o **Azure Cosmos DB**, durante picos de acesso o serviço retorna erros *HTTP 429 (Too Many Requests)*.  

**Solução:**  
1. O sistema monitora falhas e ativa o disjuntor após o limite configurado.  
2. Durante o período aberto, as requisições são bloqueadas e o cache é utilizado.  
3. Após o tempo de espera, o disjuntor entra em modo de teste (*Meio-Aberto*).  
4. Havendo sucesso nas chamadas, o disjuntor volta ao estado normal.  

**Resultado:**  
O sistema mantém disponibilidade e evita sobrecarga, garantindo recuperação controlada.  


# Aula 13/10 – Padrão CQRS

## Definição
O **CQRS (Command Query Responsibility Segregation)** separa operações de **leitura** e **gravação** em modelos diferentes.  
Isso melhora desempenho, escalabilidade e segurança em sistemas complexos.


## Problema
Arquiteturas tradicionais usam um único modelo para CRUD.  
Com o crescimento do sistema, isso causa:
- Dificuldade de otimização;
- Bloqueios concorrentes;
- Consultas lentas;
- Riscos de segurança.


## Solução
Separar o sistema em:
- **Comandos:** alteram o estado (escrita);
- **Consultas:** apenas leem dados.

Cada modelo é otimizado para seu propósito e pode evoluir de forma independente.

---

## Modelos
1. **Mesma base de dados:** modelos de leitura e escrita usam o mesmo banco.  
2. **Bancos separados:** bancos distintos para leitura e gravação, exigindo sincronização via eventos.

---

## Benefícios
- Maior desempenho e escalabilidade;  
- Menos complexidade nas consultas;  
- Separação clara de responsabilidades;  
- Maior segurança e controle de acesso.

---

## Desvantagens
- Implementação mais complexa;  
- Risco de inconsistência entre modelos;  
- Maior esforço de sincronização.

---

## Quando Usar
- Sistemas com alta concorrência;  
- Domínios complexos;  
- Necessidade de escalabilidade e performance.

---

## Quando Evitar
- Aplicações simples ou CRUD básico;  
- Cenários sem alto volume de leitura ou gravação.

---

## CQRS + Event Sourcing
Combinar ambos permite histórico completo de alterações e reconstrução de estados, mas aumenta a complexidade e a consistência passa a ser eventual.



# Aula 16/10 – Retry Pattern

## Definição
O **Retry Pattern** é um padrão de resiliência que define uma estratégia para **tentar novamente** uma operação que falhou temporariamente, antes de reportar erro ao sistema.  
Ele é útil para lidar com **falhas transitórias** em conexões de rede, bancos de dados ou serviços externos.

---

## Problema
Em sistemas distribuídos, falhas ocasionais são comuns devido a:
- Picos de carga no servidor;
- Conexões instáveis;
- Timeouts momentâneos.  

Tratar essas falhas como permanentes pode reduzir a disponibilidade do sistema.

---

## Solução
O padrão **Retry** executa novamente a operação falha após um intervalo de tempo pré-definido.  
Pode incluir:
- **Número máximo de tentativas**;
- **Intervalo fixo ou exponencial** entre as tentativas;
- **Cancelamento** após tempo limite.

O objetivo é dar tempo para que a falha transitória se resolva naturalmente.

---

## Estratégias de Retry
| Tipo | Descrição |
|------|------------|
| **Intervalo fixo** | Reexecuta a operação após um tempo constante. |
| **Exponencial Backoff** | Aumenta o intervalo a cada nova tentativa. |
| **Com jitter** | Adiciona variação aleatória ao intervalo para evitar sobrecarga simultânea. |

---

## Boas Práticas
- Definir **limite máximo de tentativas** para evitar sobrecarga.  
- Registrar logs de falhas e tentativas.  
- Usar **cancelamento** (timeout global) para impedir loops infinitos.  
- Avaliar se a operação é **idempotente** (não causa efeitos duplicados).  
- Integrar com outros padrões, como **Circuit Breaker**, para evitar novas tentativas em sistemas instáveis.

---

## Benefícios
- Aumenta a **resiliência** do sistema.  
- Melhora a **disponibilidade** durante falhas temporárias.  
- Reduz a necessidade de intervenção manual.

---

## Desvantagens
- Pode **aumentar a latência** da resposta.  
- Tentativas excessivas podem **sobrecargar serviços**.  
- Nem toda falha deve ser reexecutada (ex: erros de validação).

---

## Quando Usar
- Falhas transitórias em comunicações de rede.  
- Integrações com APIs externas.  
- Serviços que se recuperam rapidamente de sobrecarga.

---

## Quando Evitar
- Erros permanentes ou de lógica.  
- Operações críticas não idempotentes.  
- Sistemas com baixa tolerância a atrasos.

---

## Conclusão
O **Retry Pattern** é essencial para sistemas distribuídos e baseados em rede, garantindo que falhas temporárias não afetem a estabilidade geral.  
Quando bem configurado, ele reduz indisponibilidades e melhora a experiência do usuário sem comprometer recursos.



# Aula 20/10 -  Arquitetura em Camadas 

## Conceito
A **arquitetura em camadas** organiza o sistema em níveis horizontais, cada um com funções específicas (apresentação, negócio, persistência e banco de dados). É amplamente usada por ser simples, familiar e de baixo custo. Surge naturalmente conforme a estrutura das equipes (lei de Conway).


## Estrutura Padrão
- **Camada de Apresentação**: interface com o usuário.
- **Camada de Negócio**: regras e lógica da aplicação.
- **Camada de Persistência**: comunicação com o banco de dados.
- **Camada de Banco de Dados**: armazenamento e recuperação de dados.

![alt text](image-5.png)

![alt text](image-6.png)

## Conceitos-Chave

### Separação de Responsabilidades
Cada camada cuida apenas da sua função, facilitando manutenção e especialização técnica, mas reduzindo a **agilidade**.

### Camadas Fechadas vs Abertas
- **Fechadas**: cada camada acessa apenas a imediatamente abaixo — favorece isolamento e baixo acoplamento.  
- **Abertas**: permitem pular camadas — melhor desempenho, mas aumentam o acoplamento.

### Camadas de Isolamento
Alterações em uma camada não afetam as outras. Isso permite trocar tecnologias (ex.: trocar JSF por React) sem grandes impactos.


![alt text](image-7.png)

## Adição de Novas Camadas
Pode-se inserir novas camadas, como **Serviços**, para organizar funcionalidades compartilhadas e controlar acessos entre camadas.

---

## Antipadrão Sinkhole
Ocorre quando as camadas apenas repassam dados sem aplicar lógica de negócio, gerando desperdício de processamento.  
É aceitável se for **menos de 20%** das requisições.

---

## Quando Usar
- Aplicações **pequenas ou simples**.  
- Projetos com **baixo orçamento** ou **prazo curto**.  
- Quando ainda não há definição clara de outro estilo arquitetural.

Evitar para sistemas grandes, que exigem **alta escalabilidade, agilidade e modularidade**.

---

## Pontos Fortes
- Simplicidade e baixo custo.  
- Facilidade de desenvolvimento.  
- Boa confiabilidade inicial.

## Pontos Fracos
- Baixa testabilidade e agilidade.  
- Dificuldade de manutenção e implantação.  
- Escalabilidade e desempenho limitados.  
- Fraca tolerância a falhas.

---

## Avaliação Geral

![alt text](image-8.png)

## Conclusão
A **arquitetura em camadas** é ideal para **projetos iniciais ou pequenos sistemas corporativos**, mas perde eficiência e flexibilidade à medida que cresce. É um bom ponto de partida, porém deve evoluir para estilos mais modulares em sistemas de maior porte.
