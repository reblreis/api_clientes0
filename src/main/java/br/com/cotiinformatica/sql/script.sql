create table cliente(
	idcliente		serial			primary key,
	nome			varchar(150)	not null,
	cpf				varchar(11)		not null,
	email			varchar(50)		not null,
	telefone		varchar(14)		not null,
	observacoes		varchar(500)	not null
);