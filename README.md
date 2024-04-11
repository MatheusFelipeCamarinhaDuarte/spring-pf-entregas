# 🚚 🤓👍🏾Entregas Benezinho 

CP I - **Java Advanced** aplicado em 18/03/2024.


| ![](documentacao/fiap.jpg)               | **Java Advanced** |
|------------------------------------------|-------------------|
| **ALUNO:**                               | **TURMA:** 2TDSPF |
| **PROFESSOR:** Benefrancis do Nascimento | 18/03/2024        |
| **CP I**                      | ****              |

# Sumário


[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como Entregar ](#_Entrega)

[Correção da Prova ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso


A Holding Benezinho está interessada em investir na criação de um aplicativo de entregas no Brasil em 2024. Este investimento pode oferecer diversas vantagens para o empresário, especialmente considerando o contexto econômico e social do país.  
 

Com o objetivo de fazer este negócio dar certo, idealizamos o desenvolvimento de um Sistema de Gestão de Enregas o qual poderão ser tranportados passageiros e produtos.

Criaremos, nesta aula, um Produto Mínimo Viável (PMV) de uma API Rest para este sistema.

Nossa equipe de analistas desenvolveu o Diagrama de Classes abaixo, e a sua missão aqui é realizar o Mapeamento Objeto Relacional das classes de Entidade. Usaremos a JPA e o Hibernate como ferramentas de Mapeamento Objeto Relacional.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Repositorios :

   1. EnderecoRepository
   2. ViagemRepository
   3. ProdutoRepository
   4. PessoaRepository
   5. PassageiroRepository

5. A criação dos Seguintes Resources:

   1. **PessoaResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/pessoa" - **GET**, **POST**
      2. "logalhost/pessoa/{id}" - **GET**

   2. **ProdutoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/produto" - **GET**, **POST**
      2. "logalhost/produto/{id}" - **GET**

   3. **EnderecoResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/endereco" - **GET**, **POST**
      2. "logalhost/endereco/cep/{cep}" - **GET**
      3. "logalhost/endereco/pessoa/{idPessoa}" - **GET**

   4. **PassageiroResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/passageiro" - **GET**, **POST**
      2. "logalhost/passageiro/{id}" - **GET**

   5. **ViagemResource** com as seguintes ROTAS e VERBOS:
      1. "localhost/viagem" - **GET**, **POST**
      2. "logalhost/viagem/{id}" - **GET**     


<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?


**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/spring-pf-entregas](https://github.com/Benefrancis/spring-pf-entregas)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma da dupla que fará esta atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

## 1. **(0,5 Ponto)** A perfeita configuração da aplicação

    1. **(0,5 Ponto)** acessar o arquivo **application.yml** e incluir as configurações para **persistencia** para que seja possível conectar-se ao banco de dados Oracle da FIAP com o seu usuário e senha (manter o seu usuário e senha ativo é sua responsabilidade). Não utilize o usuário e senha de outro aluno. Caso tenha problema para autenticar, comunique o professor.

## 2. **(4 Pontos)** No pacote entity, criar as seguintes classes e adicionar corretamente as anotações JPA

    1. **(2 Pontos)** Criar a classe **Viagem**.
    
    2. **(0,5 Ponto)** Criar a classe **Produto**.
    
    3. **(0,5 Ponto)** Criar a classe **Endereco**.
    
    4. **(0,5 Ponto)** Criar a classe **Passageiro**.
    
    5. **(0,5 Ponto)** Criar a classe **Pessoa**.



## 3. **(6 Ponto)**  A perfeita criação dos Seguintes Resources no pacote resource


    1. **(1 Ponto)** **PessoaResource** com as seguintes ROTAS e VERBOS:
       1. "localhost/pessoa" - **GET**,
       2. "localhost/pessoa" - **POST**
       3. "logalhost/pessoa/{id}" - **GET**
    
    2. **(1 Ponto)** **ProdutoResource** com as seguintes ROTAS e VERBOS:
       1. "localhost/produto" - **GET**,
       2. "localhost/produto" - **POST**
       3. "logalhost/produto/{id}" - **GET**
    
    3. **(1,5 Ponto)** **EnderecoResource** com as seguintes ROTAS e VERBOS:
       1. "localhost/endereco" - **GET**,
       2. "localhost/endereco" - **POST**
       3. "logalhost/endereco/cep/{cep}" - **GET**
       4. "logalhost/endereco/pessoa/{idPessoa}" - **GET**
    
    4. **(1 Ponto)** **PassageiroResource** com as seguintes ROTAS e VERBOS:
       1. "localhost/passageiro" - **GET**,
       2. "localhost/passageiro" - **POST**
       3. "logalhost/passageiro/{id}" - **GET**
    
    5. **(1,5 Ponto)** **ViagemResource** com as seguintes ROTAS e VERBOS:
       1. "localhost/viagem" - **GET**,
       2. "localhost/viagem" - **POST**
       3. "logalhost/viagem/{id}" - **GET**

## 4. **(2 Ponto)** A perfeita criação dos Seguintes Repositories :

    1. **(0,25 Ponto)** ProdutoRepository
    2. **(0,25 Ponto)** PassageiroRepository
    3. **(0,25 Ponto)** PessoaRepository
    4. **(1 Ponto)** EnderecoRepository
    5. **(0,25 Ponto)** ViagemRepository


<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes

![diagrama-classes-entregas.png](documentacao%2Fdiagramas%2Fdiagrama-classes-entregas.png)


<a id="_Entrega"></a>

# Como Entregar

**A entrega deverá ser feita pelo Teams**, porém não se esqueça de fazer o **commit** e **push** do projeto no github.

Você poderá fazer o download do zip do seu reposítório github e postar no teams.

<a id="_Correcao"></a>

# Correção da Prova

Nos próximos dias, a correção da prova será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/spring-pf-entregas && cd spring-pf-entregas && git checkout correcao
```

A atividade é em **DUPLA**, não se esqueça de colocar o nome dos integrantes no arquivo contido em documentacao/equipe.txt. Em caso de fraude de qualquer tipo, todos os envolvidos receberão nota ZERO.



Boa avaliação.
