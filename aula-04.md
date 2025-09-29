# 07/08/2025 - SOLID
*Baseada no livro "Código Limpo" e Padrões de Projeto*

---

## Contexto
O conceito de **SOLID** reúne cinco princípios fundamentais de design de software orientado a objetos.  
Esses princípios têm como objetivo principal facilitar a compreensão, o desenvolvimento e a manutenção de sistemas.  
Segui-los significa construir aplicações mais organizadas, escaláveis e com menor acoplamento.

---

## Princípios SOLID

### 1. Single Responsibility Principle (Princípio da Responsabilidade Única)
Cada classe ou módulo deve possuir apenas uma responsabilidade, evitando misturar funções que não pertencem à mesma lógica.  

**Exemplo prático:** Utilizar o padrão **MVC**, onde:  
- **Model** cuida dos dados,  
- **View** da interface,  
- **Controller** da lógica de interação.

---

### 2. Open/Closed Principle (Princípio do Aberto/Fechado)
As entidades de software devem estar abertas para extensão, mas fechadas para modificação.  
Isso significa que novas funcionalidades devem ser adicionadas sem alterar código já existente.

---

### 3. Liskov Substitution Principle (Princípio da Substituição de Liskov)
Objetos de subclasses devem poder substituir objetos da classe base sem afetar o funcionamento correto do programa.

---

### 4. Interface Segregation Principle (Princípio da Segregação de Interfaces)
Interfaces devem ser específicas e coesas.  
Evita-se a criação de interfaces “inchadas” que obrigam classes a implementar métodos desnecessários.  

---

### 5. Dependency Inversion Principle (Princípio da Inversão de Dependência)
Módulos de alto nível não devem depender de módulos de baixo nível, ambos devem depender de **abstrações**.  
A ideia é sempre depender de **interfaces** ao invés de implementações concretas.

---

## Conteúdo Abordado na Aula
- Responsabilidade Única  
- Segregação de Interfaces  
- Referência ao livro **Código Limpo**  
- Padrões de Projeto como apoio na aplicação dos princípios  

---

## Exemplo Prático em Java (Swing)

### Classe Janelinha
```java
package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janelinha extends JFrame {

    private JButton botaozinho;
    private Controlador controlador;

    public Janelinha() {
        setTitle("Janelinha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        controlador = new Controlador();

        botaozinho = new JButton(" Me Clica ");
        botaozinho.addActionListener(controlador);
        botaozinho.addMouseMotionListener(controlador);

        add(botaozinho);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Janelinha();
    }
}


### Classe Controlador

```java
package br.univille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

public class Controlador 
    implements ActionListener, 
        MouseMotionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "EU NAO ACREDITO");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Implementação vazia
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Moveu" + " x:" + e.getX() + " y:" + e.getY());
    }
}
```

---

## Conclusão

A aplicação prática dos princípios **SOLID** garante maior qualidade de código.
Nesta aula, destacamos:

* A importância da **responsabilidade única** e da **segregação de interfaces**
* Como o uso de **MVC** e de **interfaces** ajuda a aplicar esses conceitos
* O suporte de padrões de projeto para manter código limpo, organizado e extensível

**Referência:** Livro *Código Limpo* e Padrões de Projeto.

