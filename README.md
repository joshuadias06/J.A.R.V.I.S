# Task Manager

Uma aplicação de gerenciamento de tarefas desenvolvida em Java, com o objetivo de praticar conceitos de estrutura de dados e CRUD em uma API RESTful. O projeto implementa funcionalidades para criar, atualizar, visualizar e remover tarefas, além de histórico de alterações, notificações e categorização de tarefas.

## Funcionalidades

- **CRUD de Tarefas**: Criação, leitura, atualização e exclusão de tarefas.
- **Histórico de Alterações**: Armazena uma pilha de versões anteriores das tarefas, permitindo desfazer a última alteração.
- **Notificações**: Gera notificações para cada criação, atualização ou remoção de tarefas.
- **Categorização de Tarefas**: Permite organizar as tarefas em categorias específicas.
- **Estrutura de Dados**: Utiliza `List`, `Stack`, `Queue` e `Map` para armazenamento e gerenciamento de tarefas.

## Estrutura de Dados

O projeto utiliza diversas estruturas de dados para organizar e gerenciar as informações:

- **List** (`ArrayList`) para armazenar as tarefas principais.
- **Stack** para manter um histórico das alterações nas tarefas.
- **Queue** (`LinkedList`) para gerenciar uma fila de notificações.
- **Map** (`HashMap`) para categorização de tarefas.
