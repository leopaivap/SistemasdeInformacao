delimiter $
CREATE TRIGGER tri_insereClientePoupanca 
AFTER INSERT
ON cliente
FOR EACH ROW
BEGIN
	INSERT INTO conta VALUES(NULL, "Poupança", 0.01, "abc");
	
	SELECT idConta INTO @idNovaConta 
	FROM conta ORDER BY idConta DESC LIMIT 1;
	
	SELECT idCliente INTO @idNovoCliente
	FROM cliente ORDER BY idCliente DESC LIMIT 1;
	
	INSERT INTO contavinculada VALUES(@idNovoCliente, @idNovaConta, CURRENT_DATE());
END$
delimiter ;
