delimiter $
CREATE TRIGGER tri_alteraDataAberturaConta
AFTER UPDATE 
ON cliente
FOR EACH ROW
BEGIN
	IF(OLD.cpf <>NEW.cpf) then
		UPDATE contavinculada SET dataAbertura = CURRENT_DATE()
		WHERE CLIENTE_idCliente = OLD.idCliente;
	END if;
END$
delimiter ;
