/* Transação para colocar os nomes dos clientes em letras MAIUSCULAS desde que 
possuam telefone cadastrado */

SELECT * FROM cliente;
BEGIN;
	UPDATE cliente SET nome = UPPER(nome) WHERE telefone IS NOT NULL;
COMMIT;
SELECT * FROM cliente;