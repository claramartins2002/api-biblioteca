create table tb_livro(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
descricao VARCHAR(255) NOT NULL);

create table tb_leitor(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
cep VARCHAR(8) NOT NULL,
cadastro varchar(30) not null,
expiracao varchar(30) not null);

create table tb_emprestimo(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
leitor_id BIGINT not null,
livro_id BIGINT not null,
emprestimo varchar(30) not null,
devolucao varchar(30) not null,
constraint fk_leitor foreign key (leitor_id) references tb_leitor(id),
constraint fk_livro foreign key (livro_id) references tb_livro(id) );

create table perfil (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL
);

create table usuario (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
perfil_id BIGINT,
constraint fk_perfil FOREIGN KEY (perfil_id) references perfil(id));
