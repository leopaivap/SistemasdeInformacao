-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.20-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para lojapesca
DROP DATABASE IF EXISTS `lojapesca`;
CREATE DATABASE IF NOT EXISTS `lojapesca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lojapesca`;

-- Copiando estrutura para tabela lojapesca.auditoria
DROP TABLE IF EXISTS `auditoria`;
CREATE TABLE IF NOT EXISTS `auditoria` (
  `codAuditoria` int(11) NOT NULL AUTO_INCREMENT,
  `acao` varchar(400) DEFAULT NULL,
  `tabela` varchar(400) DEFAULT NULL,
  `dataHora` datetime DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codAuditoria`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='Registra as principais alterações neste BD.';

-- Copiando dados para a tabela lojapesca.auditoria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
INSERT INTO `auditoria` (`codAuditoria`, `acao`, `tabela`, `dataHora`, `usuario`) VALUES
	(12, 'Cliente Inserido: ACPF:10', 'cliente', '2023-05-02 10:08:41', 'root@localhost'),
	(13, 'Cliente Inserido: outroCPF:123', 'cliente', '2023-05-02 10:09:07', 'root@localhost'),
	(14, 'Cliente Alterado: outroNovo CPF: 120.120.120-50', 'cliente', '2023-05-02 10:16:35', 'root@localhost'),
	(15, 'Cliente Removido: ACPF: 10', 'cliente', '2023-05-02 10:19:23', 'root@localhost'),
	(16, 'Cliente Removido: outro CPF: 120.120.120-50', 'cliente', '2023-05-02 10:20:37', 'root@localhost');
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;

-- Copiando estrutura para tabela lojapesca.categoria
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `codCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(200) NOT NULL,
  PRIMARY KEY (`codCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.categoria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`codCategoria`, `Tipo`) VALUES
	(9, 'molinete'),
	(10, 'vara de pesca'),
	(11, 'anzois'),
	(12, 'barcos'),
	(13, 'iscas');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Copiando estrutura para tabela lojapesca.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `uf` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(25) NOT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.cliente: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`codCliente`, `nomeCliente`, `email`, `cpf`, `cidade`, `bairro`, `uf`, `cep`, `endereco`, `telefone`) VALUES
	(1, 'jaulis', 'jaulis@gmail.com', '123.456.789.55', 'machadao', 'centro', 'MinasGerais', '37750.000', 'rua agripino de lai, nº27', '+55 (35)95555-4565'),
	(2, 'leosin o cliente', 'leosinemail@email.com', '5418.1.4.1', 'rio de janeiro', 'ipanema', 'rj', '165145151', 'rua dos tcholas', '5947'),
	(6, 'salas', 'salas@emai.com', '123.002.001-50', 'machado city', 'jardim', 'Minas Gerais', '37750-000', 'rua salmao', '10');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para procedure lojapesca.consultaLogin
DROP PROCEDURE IF EXISTS `consultaLogin`;
DELIMITER //
CREATE PROCEDURE `consultaLogin`(usuario varchar(100), senha varchar(100))
BEGIN
Select * from usuarios where usuarios.nome = usuario and usuarios.senha = senha;
END//
DELIMITER ;

-- Copiando estrutura para tabela lojapesca.fornecedor
DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `codFornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cnpj` varchar(45) NOT NULL,
  PRIMARY KEY (`codFornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.fornecedor: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`codFornecedor`, `nome`, `cnpj`) VALUES
	(1, 'jaulis_varas', '60.746.948/0001-12'),
	(3, 'junior iscas', '04.143.526/0001-81'),
	(4, 'atacadao da pesca', '23.883.646/0001-60'),
	(5, 'eco pesca', '44.471.772/0001-87'),
	(6, 'premium varas', '40.933.227/0001-04'),
	(7, 'joao iscas', '00000');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;

-- Copiando estrutura para tabela lojapesca.funcionario
DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `codFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `dataAdimissao` date NOT NULL,
  `dataDemissao` date DEFAULT NULL,
  `cpf` varchar(45) NOT NULL,
  `ctps` varchar(45) NOT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.funcionario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`codFuncionario`, `nome`, `salario`, `dataAdimissao`, `dataDemissao`, `cpf`, `ctps`) VALUES
	(1, 'leosin', 15000.00, '0000-00-00', '0000-00-00', '478.456.123.55', '1234567'),
	(2, 'jaulis', 15611.45, '2022-03-30', '0000-00-00', '123.456.789.00', '1234567'),
	(3, 'outro teste', 15000.00, '2022-10-10', '0000-00-00', '126.126.126-50', '45615641');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para procedure lojapesca.insere_usuario
DROP PROCEDURE IF EXISTS `insere_usuario`;
DELIMITER //
CREATE PROCEDURE `insere_usuario`(usuario varchar(100), senha varchar(100))
BEGIN
 insert into usuarios values(null, usuario, senha);
END//
DELIMITER ;

-- Copiando estrutura para tabela lojapesca.itemvenda
DROP TABLE IF EXISTS `itemvenda`;
CREATE TABLE IF NOT EXISTS `itemvenda` (
  `Produtos_codProdutos` int(11) NOT NULL,
  `Venda_codVenda` int(11) NOT NULL,
  `qtdVenda` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Produtos_codProdutos`,`Venda_codVenda`),
  KEY `fk_Produtos_has_Venda_Venda1_idx` (`Venda_codVenda`),
  KEY `fk_Produtos_has_Venda_Produtos1_idx` (`Produtos_codProdutos`),
  CONSTRAINT `fk_Produtos_has_Venda_Produtos1` FOREIGN KEY (`Produtos_codProdutos`) REFERENCES `produto` (`codProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_has_Venda_Venda1` FOREIGN KEY (`Venda_codVenda`) REFERENCES `venda` (`codVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.itemvenda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `itemvenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemvenda` ENABLE KEYS */;

-- Copiando estrutura para procedure lojapesca.lista_categorias
DROP PROCEDURE IF EXISTS `lista_categorias`;
DELIMITER //
CREATE PROCEDURE `lista_categorias`()
BEGIN
	select * from categoria;
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.lista_fornecedores
DROP PROCEDURE IF EXISTS `lista_fornecedores`;
DELIMITER //
CREATE PROCEDURE `lista_fornecedores`()
BEGIN
	select codFornecedor, nome from fornecedor;
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.lista_marcas
DROP PROCEDURE IF EXISTS `lista_marcas`;
DELIMITER //
CREATE PROCEDURE `lista_marcas`()
BEGIN
	select * from marca;
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.lista_produto
DROP PROCEDURE IF EXISTS `lista_produto`;
DELIMITER //
CREATE PROCEDURE `lista_produto`()
BEGIN
	select codProduto, nomeProduto from produto;
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.lista_produtos
DROP PROCEDURE IF EXISTS `lista_produtos`;
DELIMITER //
CREATE PROCEDURE `lista_produtos`()
BEGIN
	select codProduto as "Codigo", nomeProduto as "Produto", qntdEstoque as "Quantidade no Estoque", precoCusto as "Preco de Custo", precoVenda as "Preco de Venda", date_format(dataInsercao, "%d/%m/%Y") as "Data de Insercao", obsProduto as "Observacoes", categoria.Tipo as "Categoria", marca.nomeMarca as "Marca", fornecedor.nome as "Fornecedor" from produto
	inner join categoria on Categoria_codCategoria = categoria.codCategoria
	inner join marca on Marca_codMarca = marca.codMarca
	inner join fornecedor on Fornecedor_codFornecedor = fornecedor.codFornecedor;
END//
DELIMITER ;

-- Copiando estrutura para tabela lojapesca.marca
DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `codMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMarca` varchar(200) NOT NULL,
  PRIMARY KEY (`codMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.marca: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`codMarca`, `nomeMarca`) VALUES
	(4, 'speed'),
	(5, 'adiddas'),
	(6, 'Saigon\r\nsaigon'),
	(7, 'Mazaffero'),
	(8, 'food');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Copiando estrutura para procedure lojapesca.proc_deleteProduto
DROP PROCEDURE IF EXISTS `proc_deleteProduto`;
DELIMITER //
CREATE PROCEDURE `proc_deleteProduto`(codProdutoR int)
BEGIN
	delete from produto where codProduto = codProdutoR;
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.proc_insereCategoria
DROP PROCEDURE IF EXISTS `proc_insereCategoria`;
DELIMITER //
CREATE PROCEDURE `proc_insereCategoria`(in novaCat varchar(100))
BEGIN
	insert into categoria(tipo) values( novaCat);
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.proc_insereCliente
DROP PROCEDURE IF EXISTS `proc_insereCliente`;
DELIMITER //
CREATE PROCEDURE `proc_insereCliente`(in nomeCliente varchar(100), in email varchar(100),in cpf varchar(20),in cidade varchar(100),in bairro varchar(45),in uf varchar(45),in cep varchar(45) ,in endereco varchar(100),in telefone varchar(25))
BEGIN
	insert into cliente values(null,nomeCliente, email, cpf, cidade, bairro, uf, cep, endereco, telefone);
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.proc_insereFornecedor
DROP PROCEDURE IF EXISTS `proc_insereFornecedor`;
DELIMITER //
CREATE PROCEDURE `proc_insereFornecedor`(in novoFornecedor varchar(100), in CNPJ varchar(45))
BEGIN
		insert into Fornecedor values(null, novoFornecedor,CNPJ);
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.proc_insereMarca
DROP PROCEDURE IF EXISTS `proc_insereMarca`;
DELIMITER //
CREATE PROCEDURE `proc_insereMarca`(in novaMarca varchar(100))
BEGIN
	insert into marca(nomeMarca) values(novaMarca);
END//
DELIMITER ;

-- Copiando estrutura para procedure lojapesca.proc_insereProduto
DROP PROCEDURE IF EXISTS `proc_insereProduto`;
DELIMITER //
CREATE PROCEDURE `proc_insereProduto`(in nome varchar(100), in qntdEstoque int, in precoCusto decimal(10,2), in precoVenda decimal(10,2), in dataInsercao Date, in obsProduto varchar(255), in Categoria_codCategoria int, in Marca_codMarca int, in Fornecedor_codFornecedor int)
BEGIN
 insert into produto values(null, nome, qntdEstoque, precoCusto, precoVenda, dataInsercao, obsProduto, Categoria_codCategoria, Marca_codMarca, Fornecedor_codFornecedor);
END//
DELIMITER ;

-- Copiando estrutura para tabela lojapesca.produto
DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `codProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(100) NOT NULL,
  `qntdEstoque` int(11) NOT NULL,
  `precoCusto` decimal(10,2) NOT NULL,
  `precoVenda` decimal(10,2) NOT NULL,
  `dataInsercao` date DEFAULT NULL,
  `obsProduto` varchar(255) DEFAULT NULL,
  `Categoria_codCategoria` int(11) NOT NULL,
  `Marca_codMarca` int(11) NOT NULL,
  `Fornecedor_codFornecedor` int(11) NOT NULL,
  PRIMARY KEY (`codProduto`,`Categoria_codCategoria`,`Marca_codMarca`,`Fornecedor_codFornecedor`),
  KEY `fk_Produtos_Marca_idx` (`Marca_codMarca`),
  KEY `fk_Produtos_Categoria1_idx` (`Categoria_codCategoria`),
  KEY `fk_Produto_Fornecedor1_idx` (`Fornecedor_codFornecedor`),
  CONSTRAINT `fk_Produto_Fornecedor1` FOREIGN KEY (`Fornecedor_codFornecedor`) REFERENCES `fornecedor` (`codFornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Categoria1` FOREIGN KEY (`Categoria_codCategoria`) REFERENCES `categoria` (`codCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_Marca` FOREIGN KEY (`Marca_codMarca`) REFERENCES `marca` (`codMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.produto: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`codProduto`, `nomeProduto`, `qntdEstoque`, `precoCusto`, `precoVenda`, `dataInsercao`, `obsProduto`, `Categoria_codCategoria`, `Marca_codMarca`, `Fornecedor_codFornecedor`) VALUES
	(12, 'Vara de alta tensao', 5, 250.00, 400.00, '2022-01-15', 'vara oceanica', 10, 4, 1),
	(13, 'Vara de bambu', 10, 50.00, 90.00, '2022-05-21', 'Varas curtas (em torno de 1m a 1,5m) e de ação média-rápida', 10, 6, 5),
	(14, 'Vara Surfcasting', 6, 200.00, 340.00, '2022-03-12', 'Surfcasting: pesca de praia,', 10, 7, 6),
	(15, 'Molinete Ultra leve', 15, 30.00, 50.00, '2022-06-17', 'molinetes menores que utilizam linhas entre 0,15mm e 0,23mm', 9, 5, 3),
	(16, 'Molinete Médio', 22, 40.00, 70.00, '2022-08-26', 'molinetes de médio porte que utilizam linhas entre 0,30mm a 0,40mm.', 9, 5, 4),
	(17, 'Molinete de fibra de carbono', 5, 200.00, 300.00, '2022-06-22', 'Molinete altamente resistente ', 9, 4, 6),
	(18, 'Maruseigo', 40, 20.00, 35.00, '2022-01-10', 'Esse tipo de anzol também pode ser utilizado na confecção dos jig heads', 11, 4, 4),
	(19, 'Chinu', 30, 5.00, 8.00, '2022-01-16', 'apresenta haste menor e curvatura maior. Por isso, é indicado para fisgar peixes que tenham boca menor.', 9, 4, 1),
	(20, 'Garateia', 5, 10.00, 20.00, '2022-05-14', 'O anzol é chamado assim quando há três ganchos em uma mesma haste.', 11, 7, 4),
	(21, 'Barco Semi-chatos', 4, 360.00, 500.00, '2022-11-10', 'eles são ideais para serem usados em águas mais calmas que possuem pequenas ondas, como em algumas represas e rios.', 12, 5, 3),
	(22, 'Caiaque nemisus', 3, 680.00, 1000.00, '2022-07-14', 'Exigem muita destreza para fazer a pilotagem e manipular os equipamentos ao mesmo tempo, porém, podem proporcionar um contato ímpar com a natureza e com a pescaria', 12, 5, 6),
	(23, 'Barco AquaLeve', 5, 500.00, 700.00, '2022-08-28', ' leves e ideais para ambientes menos turbulentos, como lagos e represas.', 9, 4, 1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Copiando estrutura para procedure lojapesca.update_produto
DROP PROCEDURE IF EXISTS `update_produto`;
DELIMITER //
CREATE PROCEDURE `update_produto`(codProdutos int, nomeProduto varchar(50) ,qntdEstoque int, precoCusto decimal(10,2), precoVenda decimal(10,2), dataInsercao date,  obsProduto varchar(255), Categoria_codCategoria int, Marca_codMarca int, Fornecedor_codFornecedor int)
BEGIN
 update produto set 
 `nomeProduto` = nomeProduto,
 `qntdEstoque` = qntdEstoque,
 `precoCusto` = precoCusto,
 `precoVenda` = precoVenda,
 `dataInsercao` = dataInsercao,
 `obsProduto` = obsProduto,
 `Categoria_codCategoria` = Categoria_codCategoria,
 `Marca_codMarca` = Marca_codMarca,
 `Fornecedor_codFornecedor` = Fornecedor_codFornecedor
 where `codProdutos` = codProduto;
END//
DELIMITER ;

-- Copiando estrutura para tabela lojapesca.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `codUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`codUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.usuarios: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`codUsuario`, `nome`, `senha`) VALUES
	(3, 'adm', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
	(10, 'joao luis', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
	(11, 'jaulis', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
	(12, 'joaoluis', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
	(13, 'leonardo', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Copiando estrutura para tabela lojapesca.venda
DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `codVenda` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` enum('À vista','Cartão Débito','Cartão Crédito','PIX') NOT NULL,
  `comissao` decimal(5,2) NOT NULL,
  `desconto` decimal(5,2) DEFAULT NULL,
  `dataHoraVenda` datetime NOT NULL,
  `Cliente_codCliente` int(11) NOT NULL,
  `Funcionario_codFuncionario` int(11) NOT NULL,
  PRIMARY KEY (`codVenda`,`Cliente_codCliente`,`Funcionario_codFuncionario`),
  KEY `fk_Venda_Cliente1_idx` (`Cliente_codCliente`),
  KEY `fk_Venda_Funcionario1_idx` (`Funcionario_codFuncionario`),
  CONSTRAINT `fk_Venda_Cliente1` FOREIGN KEY (`Cliente_codCliente`) REFERENCES `cliente` (`codCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Funcionario1` FOREIGN KEY (`Funcionario_codFuncionario`) REFERENCES `funcionario` (`codFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela lojapesca.venda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` (`codVenda`, `tipo`, `comissao`, `desconto`, `dataHoraVenda`, `Cliente_codCliente`, `Funcionario_codFuncionario`) VALUES
	(1, 'À vista', 15.00, 10.00, '2022-11-10 11:52:10', 1, 1);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

-- Copiando estrutura para trigger lojapesca.tri_LogDeleteCliente
DROP TRIGGER IF EXISTS `tri_LogDeleteCliente`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tri_LogDeleteCliente` AFTER DELETE ON `cliente` FOR EACH ROW BEGIN
	SET @mensagem = CONCAT("Cliente Removido: ", old.nomeCliente, " - CPF: ", old.cpf);
	
	INSERT INTO auditoria
	VALUES(NULL, @mensagem, "cliente", NOW(), USER());

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Copiando estrutura para trigger lojapesca.tri_LogInsereCliente
DROP TRIGGER IF EXISTS `tri_LogInsereCliente`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tri_LogInsereCliente` AFTER INSERT ON `cliente` FOR EACH ROW BEGIN
	SET @mensagem = CONCAT("Cliente Inserido: ", NEW.nomeCliente, " - CPF:", NEW.cpf);
	
	INSERT INTO auditoria
	VALUES(NULL, @mensagem, "cliente",NOW(), USER());
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Copiando estrutura para trigger lojapesca.tri_LogUpdateCliente
DROP TRIGGER IF EXISTS `tri_LogUpdateCliente`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tri_LogUpdateCliente` AFTER UPDATE ON `cliente` FOR EACH ROW BEGIN
	if(OLD.cpf != NEW.cpf)
		THEN SET @mensagem = CONCAT("Cliente Alterado: ", NEW.nomeCliente, " - Novo CPF: ", NEW.cpf);
	 	INSERT INTO auditoria
		VALUES(NULL, @mensagem, "cliente", NOW(), USER());
	END if;
	
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
