USE helpr;
CREATE TABLE log_chamado(
	idLogChamado INTEGER PRIMARY KEY AUTO_INCREMENT,
    idChamado INTEGER NOT NULL,
    oldStatusChamados VARCHAR(255) NOT NULL,
    newStatusChamados VARCHAR(255) NOT NULL,
    oldTitulo VARCHAR(120) NOT NULL,
    newTitulo VARCHAR(120) NOT NULL,
    oldIdFuncionario INTEGER ,
    newIdFuncionario INTEGER ,
    oldIdCliente INTEGER NOT NULL,
    newIdCliente INTEGER NOT NULL,
    dataAlteracao DATE NOT NULL
);
SELECT * FROM chamado;
DELIMITER $$

CREATE TRIGGER tg_log_chamado1
BEFORE UPDATE ON chamado
FOR EACH ROW
	BEGIN
		INSERT INTO log_chamado VALUES(NULL,OLD.id_chamado,OLD.status, NEW.status,OLD.titulo,NEW.titulo,OLD.id_funcionario, NEW.id_funcionario, OLD.id_cliente, NEW.id_cliente,CURRENT_DATE());
	END$$


UPDATE chamado
SET titulo = "Camilo  "
WHERE id_chamado = 2;

SELECT * from log_chamado;

