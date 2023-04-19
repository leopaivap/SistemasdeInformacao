/* Proposta: cria um trigger 
(tri_LogApagaContaVinculada)
que registre na Auditoria a exclusão
de uma conta vinculada
*/

delimiter $
CREATE TRIGGER tri_LogApagaContaVinculada
AFTER DELETE 
ON contavinculada
FOR EACH ROW 
BEGIN
	SELECT nome INTO @nomeCliente FROM cliente
	WHERE idCliente = OLD.CLIENTE_idCliente;
	
	SET @mensagem = CONCAT("Exclusão de conta do cliente: ", @nomeCliente);

	INSERT INTO auditoria 
	VALUES(NULL, @mensagem, "contavinculada", NOW(), USER());
END$
delimiter ;

