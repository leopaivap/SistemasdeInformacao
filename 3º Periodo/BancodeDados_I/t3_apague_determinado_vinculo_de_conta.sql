/* Transação que apague determinado vínculo de conta e respectiva conta*/ 

SELECT * FROM contavinculada;
SELECT * FROM conta;
BEGIN;
	DELETE FROM contavinculada WHERE CONTA_idCONTA = 3;
	DELETE FROM conta WHERE idCONTA = 3;
COMMIT;
SELECT * FROM contavinculada;
SELECT * FROM conta;