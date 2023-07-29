/*Proposta criar um trigger que registre no LOG de Auditoria
a alteração do CPF de um cliente da Agência
*/

delimiter $
CREATE TRIGGER tri_LogFiscalizaCpf
AFTER UPDATE
ON cliente
FOR EACH ROW
BEGIN	
	SET @mensagem = CONCAT("CPF do cliente: ", NEW.nome, "foi alterado para ", NEW.cpf);
	
	INSERT INTO auditoria 
	VALUES(NULL, @mensagem, "cliente", NOW(), USER());
END$
delimiter ;

