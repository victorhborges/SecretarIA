# 🤖 SecretarIA

Sistema de organização pessoal desenvolvido em **Java**, com interface gráfica utilizando **Java Swing**.

O SecretarIA nasceu como um projeto prático para desenvolver e aplicar conhecimentos de **Programação Orientada a Objetos, desenvolvimento de interfaces, organização de código e gerenciamento de dados**.

O projeto está em desenvolvimento contínuo e possui como objetivo evoluir de uma aplicação pessoal de organização para um sistema cada vez mais completo e estruturado.

---

## 📌 Sobre o projeto

O **SecretarIA** é uma aplicação de organização pessoal que reúne funcionalidades para auxiliar o usuário no gerenciamento de suas atividades.

A aplicação possui atualmente um sistema básico de autenticação e um módulo de tarefas, permitindo cadastrar, acompanhar e concluir atividades.

O projeto está sendo desenvolvido de forma incremental, com novas funcionalidades sendo adicionadas conforme os conhecimentos em Java são aprofundados.

---

## 🚀 Funcionalidades

### 🔐 Autenticação

* Login de usuário
* Cadastro de conta
* Alteração de senha
* Recuperação de senha
* Validação de login e senha

### ✅ Gerenciamento de tarefas

* Criação de tarefas
* Definição de prioridade

  * Baixa
  * Média
  * Alta
* Definição de prazo
* Validação de datas
* Impedimento de prazos anteriores à data atual
* Marcação de tarefas como concluídas
* Exclusão de tarefas
* Contador de tarefas
* Contador de tarefas concluídas
* Contador de tarefas pendentes

### 🖥️ Interface

* Interface gráfica desenvolvida com Java Swing
* Tela de login
* Tela de cadastro
* Tela de recuperação de senha
* Tela principal
* Menu lateral
* Tela de gerenciamento de tarefas

---

## 🛠️ Tecnologias utilizadas

* **Java**
* **Java Swing**
* **Programação Orientada a Objetos**
* **Git**
* **GitHub**
* **Visual Studio Code**

---

## 🧱 Estrutura do projeto

A aplicação está organizada em diferentes classes, buscando separar as responsabilidades do sistema.

```text
src/
│
├── GerenciadorTarefas.java
├── Tarefa.java
├── TarefaPainel.java
│
├── TelaLogin.java
├── TelaCadastrarConta.java
├── TelaRecuperarSenha.java
├── TelaPrincipal.java
└── TelaTarefas.java
```

### Principais classes

**`Tarefa`**

Representa uma tarefa do sistema, armazenando informações como:

* Texto
* Prioridade
* Prazo
* Status de conclusão

**`GerenciadorTarefas`**

Responsável pelo gerenciamento das tarefas, incluindo:

* Adição
* Remoção
* Validação
* Contagem
* Geração do resumo das tarefas

**`TarefaPainel`**

Responsável pela representação visual de uma tarefa na interface.

**`TelaLogin`**

Responsável pela autenticação do usuário.

**`TelaCadastrarConta`**

Permite o cadastro de uma nova conta.

**`TelaRecuperarSenha`**

Permite alterar a senha cadastrada.

**`TelaPrincipal`**

Funciona como a tela principal de navegação da aplicação.

**`TelaTarefas`**

Responsável pela interface e interação do usuário com o gerenciamento de tarefas.

---

## 🧠 Conceitos aplicados

Durante o desenvolvimento do SecretarIA estão sendo praticados conceitos importantes da linguagem Java, incluindo:

* Programação Orientada a Objetos
* Classes e objetos
* Atributos e métodos
* Encapsulamento
* Construtores
* Modificadores de acesso
* Métodos `static`
* Métodos de instância
* Listas e `ArrayList`
* Estruturas condicionais
* Laços de repetição
* Tratamento de exceções
* Manipulação de datas com `LocalDate`
* Interfaces gráficas com Swing
* Eventos e `ActionListener`
* Separação de responsabilidades
* Organização e refatoração de código

---

## 📅 Próximos passos

O SecretarIA ainda está em desenvolvimento. Entre as próximas melhorias planejadas estão:

* [ ] Persistência dos dados
* [ ] Banco de dados
* [ ] Armazenamento de usuários
* [ ] Armazenamento permanente das tarefas
* [ ] Edição de tarefas
* [ ] Filtros de tarefas
* [ ] Ordenação por prioridade e prazo
* [ ] Desenvolvimento do módulo de agenda
* [ ] Desenvolvimento das configurações
* [ ] Melhorias na interface gráfica
* [ ] Melhor organização da arquitetura do projeto
* [ ] Melhorias de segurança na autenticação
* [ ] Testes automatizados

---

## 📚 Objetivo do projeto

Mais do que desenvolver uma aplicação funcional, o SecretarIA está sendo utilizado como um projeto de aprendizado e evolução prática em desenvolvimento de software.

A ideia é aplicar conceitos aprendidos durante a formação em **Análise e Desenvolvimento de Sistemas**, transformando conhecimentos teóricos em funcionalidades reais.

O projeto também serve como laboratório para estudar novas tecnologias, boas práticas de programação, arquitetura e desenvolvimento de aplicações.

---

## 👨‍💻 Desenvolvedor

**Victor Hugo de Sousa Borges**

Estudante de **Análise e Desenvolvimento de Sistemas**, com foco em desenvolvimento de software e backend.

Atualmente estudando e desenvolvendo projetos utilizando principalmente **Java e C#/.NET**, com interesse em Programação Orientada a Objetos, APIs, bancos de dados e boas práticas de desenvolvimento.

---

## 📄 Status

🚧 **Em desenvolvimento**

O projeto está sendo construído e aprimorado continuamente. Novas funcionalidades e melhorias serão adicionadas conforme sua evolução.