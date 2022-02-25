# Estudos API 
    	
> Para os estudos de API Java, foi criado um sistema de controle de empréstimos de livros para leitores cadastrados no sistema de uma biblioteca.

### Ferramentas usadas no desenvolvimento do projeto
- Documentação: Swagger 3.0.0 e Postman
- Segurança: Spring Security (para testes em Swagger), Spring Validation, JWT (para testes em Postman)
- Banco de dados: H2, Dependência FlyWay para versionamento 
- Extra: Preenchimento automático de endereço com a API externa viacep (https://viacep.com.br/), cálculo de datas de entrega e empréstio de livros através do tipo LocalDate e operadores. 


### Entidades do Sistema
#####  Livro
- Id (Long)
- Nome (String)
- Descricao (String)

#####  Leitor
- Id (Long)
- Nome (String)
- Cep (String de 8 caracteres)
- Data de cadastro (Date)
-Data de expiracao do cadastro (Date)

##### Emprestimo
- Id (Long)
- Leitor (Leitor)
- Livro (livro)
- Data de emprestimo (Date)
-Data de devolucao (Date)

#### Entidade usada para mapeamento do endereço completo; essa classe não é salva em banco de dados, apenas é apresentada através de consulta para o usuário. 


##### Endereco
- cep (String de 8 caracteres)
- logradouro (String)
-  complemento (String)
- bairro (String)
- localidade (String)
-  uf (String)


#### Entidades utilizadas para a realização da segurança do sistema. Não possuem cruds pois são usadas apenas para acesso. 

##### Perfil
- Id (Long)
- Nome (String)

##### Usuario
- Id (Long)
- Email (String)
- Senha (String) - Encriptada pela ferramenta BCryptEncoder do próprio Spring. 
-Perfil (Perfil)

### Senha para acesso
> email: admin@gft.com 
> senha: 1234






