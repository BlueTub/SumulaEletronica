use master
go
drop database sumula
----------Query Estrutura das Tabelas--------------
create database sumula
go
use sumula

create table jogador(
id int not null identity,
nome varchar(100) not null,
apelido varchar(100) not null,
primary key(id)
)

insert into jogador values ('Hury','camisa10'),('Pato','fominha'),('Ronaldo','topete')