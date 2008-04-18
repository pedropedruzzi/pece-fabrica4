alter table Curso drop constraint FK3E7107C75E60240
alter table Disciplina drop constraint FK8C4D778CB16D7AF5
alter table Inscricao drop constraint FK5D190505A4AE495
alter table Inscricao drop constraint FK5D19050597F61A55
alter table Matricula drop constraint FKB5B91D5EB16D7AF5
alter table Matricula drop constraint FKB5B91D5EA4AE495
alter table Turma drop constraint FK4D69F45F84D7095
alter table Turma drop constraint FK4D69F45F00885F
alter table Usuario drop constraint FK5B4D8B0EF059C889
alter table Usuario drop constraint FK5B4D8B0E53AD378B
alter table Usuario_CursoComplementar drop constraint FKB55058821CE76B72
alter table Usuario_CursoComplementar drop constraint FKB550588251B08C02
alter table Usuario_FormacaoAcademica drop constraint FKFF5B54F568280DBD
alter table Usuario_FormacaoAcademica drop constraint FKFF5B54F51CE76B72
drop table Curso
drop table CursoComplementar
drop table Disciplina
drop table FormacaoAcademica
drop table HistoricoProfissional
drop table Inscricao
drop table Matricula
drop table PesquisaPECE
drop table Turma
drop table Usuario
drop table Usuario_CursoComplementar
drop table Usuario_FormacaoAcademica
drop sequence hibernate_sequence
create table Curso (id int8 not null, cargaHoraria int2 not null, codCurso varchar(255) not null unique, descricao varchar(255), nome varchar(255) not null unique, coordenador_id int8 not null, primary key (id))
create table CursoComplementar (id int8 not null, descricao varchar(255), duracao int2 not null, periodo varchar(255), primary key (id))
create table Disciplina (id int8 not null, cargaHoraria int2 not null, codDisciplina varchar(255) not null unique, descricao varchar(255), materialApoio varchar(255), nome varchar(255) not null, curso_id int8 not null, primary key (id))
create table FormacaoAcademica (id int8 not null, anoFormacao timestamp, escola varchar(255), formacao varchar(255), primary key (id))
create table HistoricoProfissional (id int8 not null, atividadesAnteriores varchar(255), cargo varchar(255), email varchar(255), empresaAtual varchar(255), endBairro varchar(255), endCEP varchar(255), endCidade varchar(255), endComercial varchar(255), endComplemento varchar(255), endUF varchar(255), ramoAtividade varchar(255), telefone varchar(255), primary key (id))
create table Inscricao (id int8 not null, nota int2 not null, notaTF int2 not null, presencas int2 not null, aluno_id int8 not null, turma_id int8 not null, primary key (id), unique (turma_id, aluno_id))
create table Matricula (id int8 not null, data timestamp, status int4, aluno_id int8 not null, curso_id int8 not null, primary key (id), unique (aluno_id, curso_id))
create table PesquisaPECE (id int8 not null, anuncioJornal bool not null, anuncioRevista bool not null, descricaoOutros varchar(255), indicacaoAlunoPECE bool not null, indicacaoEmpresa bool not null, indicacaoExAlunoPECE bool not null, indicacaoProfessorPECE bool not null, internetSitePesquisa bool not null, malaDiretaEmail bool not null, malaDiretaFolheto bool not null, outros bool not null, primary key (id))
create table Turma (id int8 not null, dataRegistro timestamp, disciplina_id int8 not null, professor_id int8, primary key (id))
create table Usuario (DTYPE varchar(31) not null, id int8 not null, bairroEndereco varchar(255), celular int8 not null, cep varchar(255), cidade varchar(255), complementoEndereco varchar(255), cpf int8 unique, dataExpRg timestamp, dataNascimento timestamp, email varchar(255) not null unique, localNascimento varchar(255), login varchar(255) not null unique, nome varchar(255) not null, nomeMae varchar(255), numeroEndereco varchar(255), rg int8 unique, ruaEndereco varchar(255), senha varchar(255) not null, sexo char(1) not null, telefone int8 not null, uf varchar(255), motivacao varchar(255), qualificacao varchar(255), carteiraTrabalho varchar(255) unique, pesquisaPece_id int8, historicoProfissional_id int8, primary key (id))
create table Usuario_CursoComplementar (Usuario_id int8 not null, cursosComplementares_id int8 not null, unique (cursosComplementares_id))
create table Usuario_FormacaoAcademica (Usuario_id int8 not null, formacao_id int8 not null, unique (formacao_id))
alter table Curso add constraint FK3E7107C75E60240 foreign key (coordenador_id) references Usuario
alter table Disciplina add constraint FK8C4D778CB16D7AF5 foreign key (curso_id) references Curso
alter table Inscricao add constraint FK5D190505A4AE495 foreign key (aluno_id) references Usuario
alter table Inscricao add constraint FK5D19050597F61A55 foreign key (turma_id) references Turma
alter table Matricula add constraint FKB5B91D5EB16D7AF5 foreign key (curso_id) references Curso
alter table Matricula add constraint FKB5B91D5EA4AE495 foreign key (aluno_id) references Usuario
alter table Turma add constraint FK4D69F45F84D7095 foreign key (professor_id) references Usuario
alter table Turma add constraint FK4D69F45F00885F foreign key (disciplina_id) references Disciplina
alter table Usuario add constraint FK5B4D8B0EF059C889 foreign key (pesquisaPece_id) references PesquisaPECE
alter table Usuario add constraint FK5B4D8B0E53AD378B foreign key (historicoProfissional_id) references HistoricoProfissional
alter table Usuario_CursoComplementar add constraint FKB55058821CE76B72 foreign key (Usuario_id) references Usuario
alter table Usuario_CursoComplementar add constraint FKB550588251B08C02 foreign key (cursosComplementares_id) references CursoComplementar
alter table Usuario_FormacaoAcademica add constraint FKFF5B54F568280DBD foreign key (formacao_id) references FormacaoAcademica
alter table Usuario_FormacaoAcademica add constraint FKFF5B54F51CE76B72 foreign key (Usuario_id) references Usuario
create sequence hibernate_sequence
