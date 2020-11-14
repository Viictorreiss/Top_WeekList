CREATE DATABASE db_recomendacoes;

USE db_recomendacoes;

CREATE TABLE tb_usuario(
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
login VARCHAR(200),
Senha VARCHAR(20)
);

CREATE TABLE tb_musica(
idMusica INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
nota DECIMAL(2,2) DEFAULT 0
);

CREATE TABLE tb_genero(
idGenero INT PRIMARY KEY AUTO_INCREMENT,
tipo VARCHAR(50)
);

CREATE TABLE tb_colecao(
idColecao INT PRIMARY KEY AUTO_INCREMENT,
idMusica INT,
idGenero INT,
FOREIGN KEY (idMusica) REFERENCES tb_musica(idMusica),
FOREIGN KEY (idGenero) REFERENCES tb_genero(idGenero)
);

CREATE TABLE tb_generofavorito(
idGeneroFavorito INT PRIMARY KEY AUTO_INCREMENT,
idUsuario INT,
idGenero INT,
registro DATE,
FOREIGN KEY (idUsuario) REFERENCES tb_usuario(idUsuario),
FOREIGN KEY (idGenero) REFERENCES tb_genero(idGenero)
);

CREATE TABLE tb_avaliacao(
idAvaliacao INT PRIMARY KEY AUTO_INCREMENT,
idUsuario INT,
idMusica INT,
FOREIGN KEY (idUsuario) REFERENCES tb_usuario(idUsuario),
FOREIGN KEY (idMusica) REFERENCES tb_musica(idMusica)
);

SELECT * FROM tb_usuario;