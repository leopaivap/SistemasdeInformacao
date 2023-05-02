#Trigger para inserir na tabela auditoria um registro informando a adição de um novo cliente
delimiter $
CREATE TRIGGER tri_LogInsereCliente
AFTER Insert
ON cliente
FOR EACH ROW
BEGIN
	SET @mensagem = CONCAT("Cliente Inserido: ", new.nomeCliente, " - CPF:", new.cpf);
	
	INSERT INTO auditoria
	VALUES(NULL, @mensagem, "cliente",NOW(), USER());
END$
delimiter ;
