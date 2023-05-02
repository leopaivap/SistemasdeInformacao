#Trigger para inserir na tabela auditoria um registro quando algum cliente for apagado
delimiter $
CREATE TRIGGER tri_LogDeleteCliente
AFTER delete
ON cliente
FOR EACH ROW
BEGIN
	SET @mensagem = CONCAT("Cliente Removido: ", old.nomeCliente, " - CPF: ", old.cpf);
	
	INSERT INTO auditoria
	VALUES(NULL, @mensagem, "cliente", NOW(), USER());

END$
delimiter ;
