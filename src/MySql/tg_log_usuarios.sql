use helpr;

CREATE TABLE log_usuarios(
idLogUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    idUsuarios INTEGER NOT NULL,
    oldNome VARCHAR(150) NOT NULL,
    newNome VARCHAR(150) NOT NULL,
    oldPerfil VARCHAR(255) NOT NULL,
    newPerfil VARCHAR(255) NOT NULL,
    dtype VARCHAR(31) NOT NULL,
    dataAlteracao DATE NOT NULL
);
SELECT * FROM USUARIOS;


DELIMITER $$
CREATE TRIGGER tg_log_usuarios
BEFORE UPDATE ON USUARIOS
FOR EACH ROW

BEGIN
INSERT INTO log_usuarios VALUES(NULL,OLD.id,OLD.nome,NEW.nome,OLD.perfil,NEW.perfil,OLD.dtype, CURRENT_DATE());
END$$
 
UPDATE usuarios 
SET nome = "CAMILO"  
WHERE id = 1 ;

SELECT * FROM log_usuarios;



