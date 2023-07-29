SELECT * FROM contavinculada HAVING CLIENTE_idCliente IN (SELECT IdCLIENTE FROM CLIENTE WHERE FLOOR(DATEDIFF(CURDATE(), dataNascimento) /365 > 45));
SELECT * FROM conta;
SELECT SUM(saldo) FROM conta;


#soma dos saldos agrupados pela média
SELECT tipo, SUM(saldo) AS somaSaldo FROM conta GROUP BY tipo HAVING somaSaldo > (SELECT AVG(saldo) FROM conta);


#seleciona todos os fornecedores que comecam com a letra J
SELECT *
FROM produto
WHERE fornecedor_codFornecedor IN (
SELECT codFornecedor
FROM fornecedor
WHERE nome LIKE 'j%'
);


#AUMENTAR EM 5 REAIS O SALDO DOS CLIENTES DE MINAS GERAIS
SELECT * FROM CLIENTE;
SELECT * FROM contavinculada;
SELECT * FROM conta;

UPDATE conta SET saldo = saldo + 5
WHERE idConta IN
(SELECT CONTA_idConta FROM contavinculada WHERE Cliente_idCliente
IN (SELECT idCLIENTE FROM cliente WHERE RG LIKE "MG%")); #SELECIONA PELO ID CLIENTE DA TABELA CLIENTE ONDE O RG COMEÇA COM "MG%"


#Subconsulta para identificar as varas com preço de Venda superior a média do
#preço de Venda de todas as varas;
#Código SQL:
SELECT
AVG(precoVenda)
FROM produto
WHERE Categoria_codCategoria = 10;
SELECT nomeProduto, precoVenda, Categoria_codCategoria
FROM produto
WHERE Categoria_codCategoria = 10
AND
precoVenda >= (SELECT AVG(precoVenda) FROM produto) ;


#Subconsulta que define o valor total do estoque de produtos que nao sao
#barcos
#Código SQL:
SELECT
nomeProduto,qntdEstoque,precoVenda,Categoria_codCategoria
FROM produto
WHERE Categoria_codCategoria = 12
ORDER BY precoVenda DESC;

SELECT SUM(qntdEstoque * precoVenda) AS "Valor Total do Estoque"
FROM produto
WHERE Categoria_codCategoria NOT IN (
SELECT codCategoria FROM categoria WHERE codCategoria = 12
);