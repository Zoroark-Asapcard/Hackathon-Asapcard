
# Hackathon Asapcard
## Grupo Zoroark
![Logo](https://i.imgur.com/M5zI5FD.png)

## Desafios:
- Nível 1: Integração entre camadas
  O Desafio consistiu em criar uma aplicação capaz de receber um input de um arquivo .csv e gerar um output no formato JSON, persistindo esses dados em um banco de dados relacional. Construímos a aplicação em maven com o framework Spring boot e o SGDB MYSQL para persistir os dados.
  
  ![diagrama](https://i.imgur.com/FeXkJf8.png)


- Nível 2: Evolução do negócio
  Esse desafio se baseou em validar os dados persistido a partir de um segundo arquivo .csv, conciliando os dados e criando a funcionalidade de status para validar os dados das transações.
- Nível 3: Aplicação 24/7
  O nível 3 exigiu modificações na aplicação para que ela execute 24/7, observando alterações no direrótio de input, validado e persistí-lo no banco de dados.
- Nível 4: Criação de Container
  No nível 4 o desafio foi executar todas as aplicações criadas com Docker usando rabbitmq com o docker compose.
  
## Autores

- [@alineconchetta] (https://github.com/AlineConchetta)
- [perfil linkedin] (https://www.linkedin.com/in/aline-conchetta/))
- [@gercidio] (https://www.github.com/gercidio)
- [perfil linkedin] (https://www.linkedin.com/in/gercidiovaleriano/)
- [@kendal-katherine] (https://github.com/Kendal-Katherine)
- [perfil linkedin] (https://www.linkedin.com/in/Kendal-Katherine-correia/)
- [@marylin-fullstack] (https://github.com/Marilyn-FullStack)
- [perfil linkedin] (https://www.linkedin.com/in/mlls/))
- [@wallysonchristian] (https://github.com/WallyssonChristian)
- [perfil linkedin] (https://www.linkedin.com/in/wallysson-araujo/)

## Documentação

[Documentação](https://github.com/Zoroark-Asapcard/Documentacao)

## Stack utilizada

**Back-end:** 
- Java Springboot
- SGDB MYSql
- RabbitMQ
- Docker

  
## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/Zoroark-Asapcard/Hackathon-Asapcard.git
```

Entre no diretório do projeto

```bash
  cd Hackathon-Asapcard
```

Executar com docker compose

```bash
- certifique-se de ter o Docker instalado;
- abra o dashboard do Docker para ter acesso a porta do rabbitmq;
- abra o prompt na pasta dockerfile e execute:

docker-compose up

-abra a porta do rabbitmq http://localhost:15672 e faça o login

user: guest
password: guest
```

Inicie a aplicação spring boot

## Feedback

Se você tiver algum feedback, por favor nos deixe saber por meio de comentários, issues ou pull requests.


