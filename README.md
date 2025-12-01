
# Sistema de gerencimento-Clinica veterinaria
Este é um projeto de uma aplicação para gerenciar uma clínica veterinária, desenvolvida em Java. A aplicação atende tanto os funcionários quanto os proprietários de animais, proporcionando um atendimento mais eficiente e organizado. O sistema  permite o cadastro de animais, agendamento de consultas e gestão de dados.

## Funcionalidades
- Agenda
- Registro de serviços
- Gerenciamento de Consultas
- Gerenciamento de Pacientes
- Gerenciamento de Profissionais

## Modelo do Banco de Dados
O banco de dados da clínica veterinária foi estruturado para organizar clientes, animais, veterinários, atendimentos e tratamentos.

- **Cliente** – Armazena dados do tutor.
- **Animal** – Representa o paciente, sempre vinculado a um cliente.
- **Veterinário** – Profissional responsável pelos atendimentos.
- **Atendimento** – Registra consultas, incluindo data, tipo e observações.
- **Tratamento** – Procedimentos realizados no atendimento (vacinas, exames, cirurgias).

###  Relacionamentos (1:N)
- **Cliente → Animais**
- **Animal → Atendimentos**
- **Veterinário → Atendimentos**
- **Atendimento → Tratamentos**
  
 

## Tecnologias Utilizadas
-java
-Banco de dados: Apenas demonstrativo com png 


## Instalação

1- Clone o repositorio: https://github.com/clarrinha/Clinicavet

2- Abra o projeto na IDE ja instalada no seu sistema

3- execute o projeto


## Diagrama de classes:
![Diagrama de classes](out/diagrama_classes.png)

## Diagrama de casos de uso:
![Diagrama de casos de uso](out/diagrama_vt.png)


## Autora

- Maria Clara Nascimento Silva (https://github.com/clarrinha)
