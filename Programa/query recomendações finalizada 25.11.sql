SELECT * FROM db_recomendacoes.tb_usuario;

/*A recomendação ela tem que pegar da tabela geral de músicas, 
quais musicas que tem médias mais altas (nome, média), e que tem a ver com o genero que ele curte e a música que ele não avaliou */

Lista de generos
SELECT r.idGenero, r.registro, g.tipo
FROM tb_generofavorito AS r
LEFT JOIN tb_genero AS g ON g.idGenero = r.idGenero
WHERE r.idUsuario = ? 

Novo genero favorito
INSERT INTO tb_generofavorito (idUsuario, idGenero, registro) VALUES (?, (SELECT idGenero FROM tb_genero WHERE tipo = ?), ?) 
/* o select nos values sao para caso possuamos apenas o nome do genero caso ja tenha na tela o id pode ser usado direto */

Apagar generos Favoritos 
DELETE FROM tb_generofavorito WHERE idUsuario = ? AND idGenero = ?

-------------------------------------------------------
Select m.nome, avg (a.nota) AS nota
from tb_generofavorito AS f
LEFT JOIN tb_colecao AS c ON f.idGenero = c.idGenero
LEFT JOIN tb_musica AS m ON c.idMusica = m.idMusica
LEFT JOIN tb_avaliacao AS a ON a.idMusica = m.idMusica
where f.idUsuario = 1 AND m.idMusica not in (select idMusica from tb_avaliacao where idUsuario = 1)
Group by m.nome 
order by nota DESC
limit 3;


Recomendações 
SELECT m.Nome, m.idMusica, c.idMusica, m.idMusica, f.idGenero, c.idGenero, a.idUsuario, f.idUsuario
FROM tb_musica AS m 
LEFT JOIN tb_colecao AS c ON c.idMusica = m.idMusica 
LEFT JOIN tb_generofavorito AS f ON f.idGenero = c.idGenero
LEFT JOIN tb_avaliacao AS a ON a.idUsuario = f.idUsuario
WHERE f.idUsuario <> a.idUsuario

----------------------------------------------------------

Avaliar 
/* o select é o mesmo recomendações */
UPDATE tb_recomendacoes SET nota = (((SELECT nota FROM tb_avaliacao WHERE idMusica = ? )+? )/2 )