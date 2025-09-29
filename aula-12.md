# Aula 15/09 e 18/09 - Implementação do Publisher e Subscriber (Tópico)

## Conceito do Padrão Publisher-Subscriber

O padrão Publisher-Subscriber (Pub/Sub) é um padrão de mensageria assíncrona que permite a comunicação desacoplada entre componentes de software. Neste modelo, os publicadores (publishers) enviam mensagens para tópicos específicos, sem conhecer quais consumidores irão recebê-las. Os assinantes (subscribers) expressam interesse em determinados tópicos e recebem apenas as mensagens relevantes para suas assinaturas.

## Componentes Fundamentais

### Publisher (Publicador)
- Componente responsável por produzir e enviar mensagens
- Não possui conhecimento direto sobre os subscribers
- Publica mensagens em tópicos específicos
- Pode ser múltiplos publishers para o mesmo tópico

### Subscriber (Assinante)
- Componente que consome mensagens de tópicos específicos
- Registra seu interesse em um ou mais tópicos
- Processa mensagens recebidas de forma assíncrona
- Pode ser múltiplos subscribers para o mesmo tópico

### Message Broker (Intermediário de Mensagens)
- Gerencia o registro de tópicos e assinaturas
- Distribui mensagens para os subscribers apropriados
- Garante o desacoplamento completo entre publishers e subscribers
- Pode implementar políticas de entrega e persistência

### Tópico
- Canal de comunicação logicamente categorizado
- Funciona como um filtro para distribuição de mensagens
- Permite que múltiplos subscribers escutem o mesmo tópico
- Organiza mensagens por categorias ou tipos de evento

## Vantagens do Padrão Pub/Sub

### Desacoplamento Completo
- Publishers e subscribers não possuem referências diretas entre si
- Alterações em um componente não afetam os outros
- Flexibilidade para adicionar ou remover componentes dinamicamente

### Escalabilidade Horizontal
- Múltiplos subscribers podem processar mensagens do mesmo tópico
- Distribuição natural de carga de processamento
- Fácil expansão do sistema com novos consumidores

### Flexibilidade e Extensibilidade
- Diferentes subscribers podem processar a mesma mensagem de formas distintas
- Assinaturas podem ser modificadas em tempo de execução
- Novos tipos de processamento podem ser adicionados sem modificar publishers

### Tolerância a Falhas
- Falha em um subscriber não afeta outros subscribers
- Message broker pode implementar retentativas de entrega
- Sistema continua funcionando mesmo com componentes indisponíveis

## Implementação Detalhada em Java

### Estrutura Base das Interfaces

```java
public interface Subscriber {
    void receiveMessage(String topic, String message);
    String getSubscriberId();
}

public interface TopicManager {
    void subscribe(String topic, Subscriber subscriber);
    void unsubscribe(String topic, Subscriber subscriber);
    void publish(String topic, String message);
    List<String> getTopics();
    List<Subscriber> getSubscribers(String topic);
}