INSERT INTO usuario (nome,idade,cpf,sexo,email,site,profissao)
VALUES ('Astolfo Braga', 30, '111.11.111-11', 'M', 'astolfo@email.com', 'astolfobraga.com.br', 'Professor');

INSERT INTO usuario (nome,idade,cpf,sexo,email,site,profissao)
VALUES ('Yuri Gagari da Silva', 35, '222.22.222-22', 'M', 'gagarin@email.com', 'nasa.com.br', 'Astronauta');

INSERT INTO usuario (nome,idade,cpf,sexo,email,site,profissao)
VALUES ('Cristiane Torlon', 27, '111.11.111-11', 'F', 'cristiane@email.com', 'cristianetorlon.com.br', 'Advogada');

INSERT INTO Local (nome_local,estado, telefone, pais, cidade)
VALUES ('Secretaria Regional IV', 'Ceará', '30322343', 'Brasil', 'Fortaleza');

INSERT INTO Selective (codigo, periodo_inicial, periodo_final)
VALUES(1,'2018-04-08','2018-04-08');

INSERT INTO Selective (codigo, periodo_inicial, periodo_final)
VALUES(2,'2018-03-18','2018-03-20');

INSERT INTO selective_local (selective_codigo,local_codigo)
VALUES(1,1);

INSERT INTO selective_local (selective_codigo,local_codigo)
VALUES(2,1);

INSERT INTO selective_usuario (selective_codigo,usuario_codigo)
VALUES(1,1);

INSERT INTO selective_usuario (selective_codigo,usuario_codigo)
VALUES(1,3);

INSERT INTO selective_usuario (selective_codigo,usuario_codigo)
VALUES(2,2);

INSERT INTO selective_usuario (selective_codigo,usuario_codigo)
VALUES(2,3);

