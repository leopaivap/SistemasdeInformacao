/* Transação para atualização do saldo das 
ctonas do tipo Poupança em 10% */

SELECT * FROM conta;
BEGIN;
	UPDATE conta SET saldo = saldo * 1.10 
	WHERE tipo = "Poupança"; 
COMMIT;
SELECT * FROM conta;