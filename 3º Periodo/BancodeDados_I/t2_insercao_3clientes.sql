/* Transação para confirmar a inserção de 3 cleintes */

SELECT * FROM cliente;
BEGIN;
	INSERT INTO cliente VALUES(NULL, "Fernando Telles", "444", "444", "2023-04-11","(35)995958859");
	INSERT INTO cliente VALUES(NULL, "Alessandra Silva", "434", "334", "2023-11-12","(35)9934343459");
	INSERT INTO cliente VALUES(NULL, "Gustavo Pererira", "33", "22", "2021-02-10","(19)9456456");
COMMIT;
SELECT * FROM cliente;