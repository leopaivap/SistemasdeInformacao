#relatorio consolidado para mostrar todas as vendas para determinado cliente

SELECT v.codVenda, date_format(v.dataHora, "%d/%m/%Y %H:%i:%s") AS dataHora, c.nome, c.cpf, v.tipoVenda
FROM venda AS v INNER JOIN cliente AS c
ON v.CLIENTE_codCliente = c.codCliente ORDER BY v.codVenda;

