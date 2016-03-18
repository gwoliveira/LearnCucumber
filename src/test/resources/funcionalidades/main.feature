#language: pt
Funcionalidade: criar sistema backend
  Através de uma tela simples o desenvolvedor consiga criar um novo “Modelo” e inserir dados (instâncias do “Modelo”) para serem consumidos pela app mobile.
  
  Um caso de uso de exemplo seria:
  Desenvolvedor cria um novo “Modelo” com o nome “Products"
  Desenvolvedor configura os atributos do modelo: name:string, description:text,
  price:decimal, category:string
  A partir desse cadastro um recurso REST para gerenciamento desse modelo com os 
  seguintes métodos devem estar disponíveis:
  GET /products - Lista todos os produtos
  GET /products/{id} - Busca um produto por id
  POST /products - Cria um novo produto
  PUT /products/{id} - Edita um produto
  DELETE /products/{id} - Deleta um produto

  Cenario: inclusão de um novo modelo
    Dado que estou na tela de incluir modelos
    E preencho o campo Modelo com "Products"
    E preencho o campo Field com "name" do tipo "String" e requerido "true"
    E clico em novo campo
    E preencho o campo Field com "description" do tipo "String" e requerido "true"
    E clico em novo campo
    E preencho o campo Field com "price" do tipo "Double" e requerido "true"
    E clico em novo campo
    E preencho o campo Field com "category" do tipo "String" e requerido "false"
    Quando clico salvar
    Então o modelo "Products" é salvo

  Cenario: inclusão de um novo produto
    Dado que estou na tela de incluir modelos
    E clico no modelo "Products"
