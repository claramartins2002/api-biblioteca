
insert into perfil (id, nome) values (1, 'admin');
insert into perfil (id, nome) values (2, 'usuario');
insert into usuario (email, senha, perfil_id) values ('usuario@gft.com', '$2a$12$K6rWR9EChRv1G/6FdhM/aunrbNYHmpTWHYOm8kj8gst4iRgBMKjKG', 2);
insert into usuario (email, senha, perfil_id) values ('admin@gft.com', '$2a$12$K6rWR9EChRv1G/6FdhM/aunrbNYHmpTWHYOm8kj8gst4iRgBMKjKG', 1);


insert into tb_leitor (nome, cep, cadastro, expiracao) values ('Clara dos Santos Martins', '38300026', '2021-12-12', '2022-12-12');
insert into tb_livro(nome, descricao) values ( 'Senhor dos anéis', 'O Senhor dos Anéis é uma trilogia cinematográfica dirigida por Peter Jackson com base na obra-prima homónima de J. R. R. Tolkien.');
insert into tb_emprestimo(livro_id, leitor_id, emprestimo, devolucao) values (1, 1, '2021-12-12', '2021-12-22');