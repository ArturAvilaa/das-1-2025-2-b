# Aula 5 (11/08/2025) - SOLID

## Princípio de Inversão de Dependências: 

Em vez de o código depender diretamente de coisas concretas (como classes específicas), ele deve depender de algo mais genérico (como interfaces). 
Assim, fica mais fácil trocar ou mudar a implementação sem quebrar tudo. Isso deixa o sistema mais flexível e fácil de manter.

## Princípio Prefira Composição a Herança

Recomenda usar objetos dentro de outros (composição) em vez de criar subclasses (herança) quando possível.
A herança cria forte acoplamento e expõe detalhes internos, tornando mudanças mais difíceis.
Na composição, a relação é mais flexível e pode ser alterada até em tempo de execução.
Além disso, evita herdar comportamentos desnecessários ou incorretos.
Em resumo: Heranca deve ser usada majoritariamente em casos que necessita-se que duas classe herdadas de uma classe **Pai** jamais se convertam uma com a outra

## Princípio de Demeter (menor conhecimento)

Conhecido tambem como principio de menor conhecimento

Todo metodo escrito em um objeto deve invocar apenas as seguintes coisas:
- sua própria classe
- objetos passados como parâmetro
- objetos criados por ele mesmo
- variaveis da classe do metodo

## Open/Closed Principle (Princípio de Aberto/Fechado)

Trata-se de um principio que Bertrand Meyer ainda na década de 80 defendia, que diz que uma classe deve estar fechada para modificacoes e abertas para extensoes.

Em resumo, o principio tem como objetivo a construção de classes flexíveis e extensíveis, capazes de se adaptarem a diversos cenários de uso, sem modificações no seu código fonte.
