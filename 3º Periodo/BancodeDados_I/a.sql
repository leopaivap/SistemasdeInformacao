#mostrar id, nome e telefone dos clientes uqe possuem essa informacao(telefone)

SELECT idCliente, nome, telefone FROM cliente WHERE telefone IS NOT NULL;

CREATE VIEW agenda1 AS (SELECT idCliente, nome, telefone FROM cliente WHERE telefone IS NOT NULL);
RENAME TABLE agenda1 TO v_agenda1;

#mostrar nome dos clientes e data de nascimento no formato brasileiro
SELECT nome, date_FORMAT(dataNascimento, "%d/%m/%Y") AS dataNascimento FROM cliente;

CREATE VIEW v_nascimentoClientes AS (SELECT nome, date_FORMAT(dataNascimento, "%d/%m/%Y") AS dataNascimento FROM cliente);