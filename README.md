# RaccoonPerson

RaccoonPerson é uma aplicação de gerenciamento de tarefas e informações pessoais desenvolvida em Java. O objetivo do projeto é praticar conceitos de estrutura de dados e CRUD em uma API RESTful, além de fornecer uma maneira centralizada de gerenciar tarefas, finanças pessoais, progresso em jogos e mais.

A aplicação integra diferentes funcionalidades para organizar a vida do usuário, como gerenciamento de tarefas, histórico de alterações, categorização, notificações, e agora, inclui um sistema de carteira e um login para transitar entre as funcionalidades do *Task Manager* e *Wallet*.

## Funcionalidades

- **CRUD de Tarefas**: Criação, leitura, atualização e exclusão de tarefas.
- **Histórico de Alterações**: Armazena uma pilha de versões anteriores das tarefas, permitindo desfazer a última alteração.
- **Notificações**: Gera notificações para cada criação, atualização ou remoção de tarefas.
- **Categorização de Tarefas**: Permite organizar as tarefas em categorias específicas.
- **Estrutura de Dados**: Utiliza `List`, `Stack`, `Queue` e `Map` para armazenamento e gerenciamento de tarefas.
- **Carteira**: Funcionalidade para adicionar, visualizar e realizar transferências entre contas bancárias dentro da carteira do usuário.
- **Login e Transição para a Wallet**: Sistema de login que permite aos usuários acessar suas contas e interagir com a funcionalidade de carteira diretamente dentro da aplicação.

## Estrutura de Dados

O projeto utiliza diversas estruturas de dados para organizar e gerenciar as informações:

- **List** (`ArrayList`) para armazenar as tarefas principais.
- **Stack** para manter um histórico das alterações nas tarefas.
- **Queue** (`LinkedList`) para gerenciar uma fila de notificações.
- **Map** (`HashMap`) para categorização de tarefas.
- **Map** adicional para gerenciar as carteiras dos usuários e suas contas bancárias.

## Visão Futura

RaccoonPerson é uma aplicação em constante evolução. A próxima fase do desenvolvimento incluirá a integração com outros módulos de gestão pessoal, como progresso em jogos e uma biblioteca de jogos concluídos. A ideia é oferecer uma plataforma centralizada para controlar várias áreas da vida do usuário, mantendo todas as informações acessíveis em um único lugar.

---
**Desenvolvedor**: Joshua Dias
