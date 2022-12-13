USE bkp_helpr;

USE helpr;

SELECT * FROM helpr.usuarios;

CREATE TABLE bkp_helpr.usuarioBackup(
	dtype VARCHAR(31),
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11),
    email VARCHAR(120),
    nome VARCHAR(150),
    perfil VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(25),
    foto VARCHAR(255),
    id_cargo int
);

SELECT * FROM helpr.usuarios;

SELECT * FROM bkp_helpr.usuarioBackup;

INSERT INTO helpr.usuarios (dtype, cpf, email, nome, perfil, senha, telefone, foto, id_cargo) VALUES 
("cliente", "14107070085", "guilherme@gmail.com", "Guilherme Marques", "CHEFE", "12345567", "05002012007", NULL, 2);

DELETE FROM helpr.usuarios WHERE id = 11;

DELIMITER //

CREATE TRIGGER usuariosBackup
BEFORE DELETE ON usuarios
FOR EACH ROW
BEGIN
	INSERT INTO bkp_helpr.usuarioBackup VALUES (OLD.dtype, OLD.id, OLD.cpf, OLD.email, OLD.nome, OLD.perfil, OLD.senha, OLD.telefone, OLD.foto, OLD.id_cargo);
END//