/*Proposta de Trigger que  registre no LOG de auditoria
a inserção de uma conta com seus respectivos dados:
idConta, tipo e saldo
*/

delimiter $
CREATE TRIGGER tri_LogInsereConta 
AFTER INSERT 
ON conta
FOR EACH ROW
BEGIN
	SET @mensagem = CONCAT("Conta inserida: ", nome, " tipo: ", tipo, " saldo: R$", saldo);
	
	INSERT INTO auditoria 
	VALUES(NULL, @mensagem, "conta", NOW(), USER());
END$
delimiter ;
