#Trigger para inserir na tabela auditoria um registro quando algum cpf for trocado
delimiter $
CREATE TRIGGER tri_LogUpdateCliente
AFTER update
ON cliente
FOR EACH ROW
BEGIN
	if(OLD.cpf != NEW.cpf)
		THEN SET @mensagem = CONCAT("Cliente Alterado: ", NEW.nomeCliente, " - Novo CPF: ", NEW.cpf);
	 	INSERT INTO auditoria
		VALUES(NULL, @mensagem, "cliente", NOW(), USER());
	END if;
	
END$
delimiter ;
