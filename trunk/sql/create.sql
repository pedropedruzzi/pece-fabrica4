alter table Curso drop constraint FK3E7107C4C9B3B82
alter table Disciplina drop constraint FK8C4D778CF701E9BE
alter table Inscricao drop constraint FK5D1905051F3B0AA7
alter table Inscricao drop constraint FK5D190505C760BB05
alter table Matricula drop constraint FKB5B91D5EC760BB05
alter table Matricula drop constraint FKB5B91D5EF701E9BE
alter table Nota drop constraint FK25240EBE5D6CD5
alter table Turma drop constraint FK4D69F45DAA620E2
drop table Curso
drop table Disciplina
drop table Inscricao
drop table Matricula
drop table Nota
drop table Pessoa
drop table Turma
drop table Usuario
drop sequence hibernate_sequence
create table Curso (codCurso varchar(255) not null, cargaHoraria int4 not null, nome varchar(255), coordenador_idUsuario int8, primary key (codCurso))
create table Disciplina (codDisciplina varchar(255) not null, cargaHoraria int2 not null, descricao varchar(255), materialApoio varchar(255), nome varchar(255), curso_codCurso varchar(255), primary key (codDisciplina))
create table Inscricao (id int8 not null, presencas int2 not null, turma_codTurma varchar(255), aluno_idUsuario int8, primary key (id))
create table Matricula (numeroMatricula int4 not null, curso_codCurso varchar(255), aluno_idUsuario int8, primary key (numeroMatricula))
create table Nota (nome varchar(255) not null, nota int2 not null, inscricao_id int8, primary key (nome))
create table Pessoa (pessoa_id int8 not null, endereco varchar(255), nascimento timestamp, nome varchar(255), telefone int8 not null, primary key (pessoa_id))
create table Turma (codTurma varchar(255) not null, dataRegistro timestamp, disciplina_codDisciplina varchar(255), primary key (codTurma))
create table Usuario (DTYPE varchar(31) not null, idUsuario int8 not null, celular int8 not null, cep varchar(255), cidade varchar(255), cpf int8 not null, cursosComplementares varchar(255), dataExpRg timestamp, dataNascimento timestamp, email varchar(255), enderecoRes varchar(255), formacaoAcademica varchar(255), historicoProfissional varchar(255), localNascimento varchar(255), login varchar(255), nome varchar(255), nomeMae varchar(255), rg int8 not null, senha varchar(255), telefone int8 not null, uf varchar(255), carteiraTrabalho varchar(255), primary key (idUsuario))
alter table Curso add constraint FK3E7107C4C9B3B82 foreign key (coordenador_idUsuario) references Usuario
alter table Disciplina add constraint FK8C4D778CF701E9BE foreign key (curso_codCurso) references Curso
alter table Inscricao add constraint FK5D1905051F3B0AA7 foreign key (turma_codTurma) references Turma
alter table Inscricao add constraint FK5D190505C760BB05 foreign key (aluno_idUsuario) references Usuario
alter table Matricula add constraint FKB5B91D5EC760BB05 foreign key (aluno_idUsuario) references Usuario
alter table Matricula add constraint FKB5B91D5EF701E9BE foreign key (curso_codCurso) references Curso
alter table Nota add constraint FK25240EBE5D6CD5 foreign key (inscricao_id) references Inscricao
alter table Turma add constraint FK4D69F45DAA620E2 foreign key (disciplina_codDisciplina) references Disciplina
create sequence hibernate_sequence
