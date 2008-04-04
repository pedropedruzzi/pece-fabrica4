alter table Curso drop constraint FK3E7107C75E60240
alter table Disciplina drop constraint FK8C4D778CB16D7AF5
alter table Inscricao drop constraint FK5D190505A4AE495
alter table Inscricao drop constraint FK5D19050597F61A55
alter table Matricula drop constraint FKB5B91D5EB16D7AF5
alter table Matricula drop constraint FKB5B91D5EA4AE495
alter table Turma drop constraint FK4D69F45F00885F
drop table Curso
drop table Disciplina
drop table Inscricao
drop table Matricula
drop table Pessoa
drop table Turma
drop table Usuario
drop sequence hibernate_sequence
create table Curso (id int8 not null, cargaHoraria int2 not null, codCurso varchar(255) not null unique, descricao varchar(255), nome varchar(255) not null unique, coordenador_id int8 not null, primary key (id))
create table Disciplina (id int8 not null, cargaHoraria int2 not null, codDisciplina varchar(255) not null unique, descricao varchar(255), materialApoio varchar(255), nome varchar(255) not null, curso_id int8 not null, primary key (id))
create table Inscricao (id int8 not null, nota int2 not null, notaTF int2 not null, presencas int2 not null, aluno_id int8 not null, turma_id int8 not null, primary key (id), unique (turma_id, aluno_id))
create table Matricula (id int8 not null, data timestamp, numero int4 not null, status int4, aluno_id int8 not null, curso_id int8 not null, primary key (id), unique (aluno_id, curso_id), unique (numero))
create table Pessoa (pessoa_id int8 not null, endereco varchar(255), nascimento timestamp, nome varchar(255), telefone int8 not null, primary key (pessoa_id))
create table Turma (id int8 not null, codigo int4 not null, dataRegistro timestamp, disciplina_id int8 not null, primary key (id), unique (codigo, disciplina_id))
create table Usuario (DTYPE varchar(31) not null, id int8 not null, celular int8 not null, cep varchar(255), cidade varchar(255), cpf int8 unique, cursosComplementares varchar(255), dataExpRg timestamp, dataNascimento timestamp, email varchar(255) not null unique, enderecoRes varchar(255), historicoProfissional varchar(255), localNascimento varchar(255), login varchar(255) not null unique, nome varchar(255) not null, nomeMae varchar(255), rg int8 unique, senha varchar(255) not null, telefone int8 not null, uf varchar(255), carteiraTrabalho varchar(255) unique, primary key (id))
alter table Curso add constraint FK3E7107C75E60240 foreign key (coordenador_id) references Usuario
alter table Disciplina add constraint FK8C4D778CB16D7AF5 foreign key (curso_id) references Curso
alter table Inscricao add constraint FK5D190505A4AE495 foreign key (aluno_id) references Usuario
alter table Inscricao add constraint FK5D19050597F61A55 foreign key (turma_id) references Turma
alter table Matricula add constraint FKB5B91D5EB16D7AF5 foreign key (curso_id) references Curso
alter table Matricula add constraint FKB5B91D5EA4AE495 foreign key (aluno_id) references Usuario
alter table Turma add constraint FK4D69F45F00885F foreign key (disciplina_id) references Disciplina
create sequence hibernate_sequence
