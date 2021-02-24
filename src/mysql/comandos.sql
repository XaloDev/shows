create table bandas (
	id	BIGINT  UNSIGNED NOT NULL AUTO_INCREMENT,
	nome	VARCHAR(255),
	genero	VARCHAR(255),
	primary key	(id)
);

create table shows (
    id BIGINT  UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    dataShow date,
    bandas VARCHAR(255),
    localShow VARCHAR(255),
    primary key (id)
);

create table locais (
    id BIGINT  UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    capacidade INT,
    endereco VARCHAR(255),
    primary key (id)
);

create table eventos (
    show_id INT UNSIGNED NOT NULL,
    banda_id INT UNSIGNED NOT NULL,
    local VARCHAR(255),
    primary key (show_id, banda_id)
);

DELETE FROM shows;

DELETE FROM locais;
DELETE FROM bandas;


