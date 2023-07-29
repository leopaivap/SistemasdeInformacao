#aumentar em 5 reais o saldo dos clientes de MG

SELECT * from cliente;

UPDATE cliente SET rg = "MG 999.999-99"  WHERE idCliente = 1;

SELECT * FROM contavinculada;
SELECT * FROM conta;

#subconsulta 01
UPDATE conta SET saldo = saldo + 5 WHERE idConta IN 
(SELECT CONTA_idConta FROM contavinculada WHERE CLIENTE_idCliente IN (SELECT idCliente FROM cliente WHERE RG LIKE "MG%" ));



#excluir as contas vinculadas aos clientes sem rg
SELECT * from cliente WHERE rg IS NULL;

DELETE FROM contavinculada WHERE CLIENTE_idCliente IN (SELECT idCliente from cliente WHERE rg IS NULL);