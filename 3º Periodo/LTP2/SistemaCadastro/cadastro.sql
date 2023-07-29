/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

DROP DATABASE IF EXISTS `cadastro`;
CREATE DATABASE IF NOT EXISTS `cadastro` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cadastro`;

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `uf` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` (`codigo`, `nome`, `uf`) VALUES
	(3, 'São Paulo', 'SP'),
	(4, 'Poços de Caldas', 'MG'),
	(5, 'Passos', 'MG'),
	(7, 'Alterosa', 'MG'),
	(18, 'Alfenas', 'SP'),
	(26, 'Machado', 'MG'),
	(29, 'Alfenas', 'MG'),
	(30, 'dddd', 'MG'),
	(32, 'Machado', 'AL'),
	(34, 'teste', 'RS'),
	(35, 'Machado', 'MG'),
	(38, 'nova', 'PB'),
	(39, 'sdsds', 'PR'),
	(40, 'Machado', 'MG'),
	(41, 'Machado', 'MG'),
	(42, 'a', 'a'),
	(43, 'Machado ffff', 'MG'),
	(46, NULL, NULL);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `nomeCliente`) VALUES
	(1, 'Tulio Dias'),
	(2, 'Felipe Miguel');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `nascimento` date NOT NULL DEFAULT '1111-11-11',
  `cidade` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_funcionario_cidade` (`cidade`),
  CONSTRAINT `FK_funcionario_cidade` FOREIGN KEY (`cidade`) REFERENCES `cidade` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`codigo`, `nome`, `salario`, `nascimento`, `cidade`) VALUES
	(23, 'Tulio Dias', 1000, '2019-09-09', 18),
	(24, 'Daniela Augusta', 900, '2010-09-09', 18),
	(25, 'Paola Guimarães Dias', 15000, '2018-01-04', 26),
	(26, 'Paola', 12, '2019-10-22', 5),
	(27, 'Paola Guimarães', 12, '2018-04-10', 7),
	(28, 'teste', 10, '1976-10-10', 3),
	(29, 'tulio', 3, '4447-09-13', 4),
	(30, 'teste', 30, '1987-10-31', 5),
	(31, 'fff', 30, '1111-11-11', 4),
	(32, 'fff', 33, '1111-11-11', 3),
	(33, 'Tulio', 4000, '1976-10-31', 3),
	(34, 'rere', 3, '2000-12-12', 4),
	(35, 'teste100', 200, '1976-10-31', 7),
	(36, 'tete', 10, '1988-10-21', 4),
	(37, 'teste', 10, '1000-10-21', 4),
	(38, 'tulio', 100, '1976-10-10', 4),
	(39, 'tew', 33, '1111-11-11', 7),
	(40, '33', 22, '1111-11-11', 3),
	(41, 'teste', 10, '1976-10-31', 4),
	(42, 'Novo', 10, '1977-10-31', 3),
	(44, 'tulio', 111, '1111-11-11', 3),
	(45, 'f', 1, '1111-11-11', 3),
	(46, 'teste', 1, '1111-11-11', 3),
	(47, 'eee', 1, '1111-11-11', 4),
	(48, 'teste', 1, '1111-11-11', 3),
	(49, 'João', 12, '2020-11-11', 35),
	(50, 'Tulio', 111, '1111-11-11', 18),
	(51, 'ddd', 0, '1111-11-11', 4),
	(54, '222', 0, '1111-11-11', 7),
	(55, 'Tulio', 12, '2021-10-31', 5),
	(56, 'Tulio', 2000, '1976-10-31', 7),
	(57, 'Tulio', 88, '2333-12-12', 26),
	(58, 'teste', 10, '1976-10-31', 3),
	(59, 'tulio', 11, '1111-11-11', 18);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

DROP TABLE IF EXISTS `itensvenda`;
CREATE TABLE IF NOT EXISTS `itensvenda` (
  `iditensvenda` int(11) NOT NULL AUTO_INCREMENT,
  `idvenda` int(11) DEFAULT NULL,
  `idproduto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`iditensvenda`),
  KEY `FK_itensvenda_venda` (`idvenda`),
  KEY `FK_itensvenda_produto` (`idproduto`),
  CONSTRAINT `FK_itensvenda_produto` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_itensvenda_venda` FOREIGN KEY (`idvenda`) REFERENCES `venda` (`idvenda`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
INSERT INTO `itensvenda` (`iditensvenda`, `idvenda`, `idproduto`, `quantidade`, `valor`) VALUES
	(1, 1, 1, 10, 2),
	(2, 1, 3, 5, 1),
	(3, 2, 3, 2, 2),
	(4, 9, 3, 1, 50),
	(5, 9, 2, 1, 12),
	(6, 9, 1, 100, 10),
	(7, 10, 1, 1, 10),
	(8, 11, 1, 1, 10),
	(9, 12, 3, 3, 3),
	(10, 13, 1, 1, 10),
	(11, 14, 2, 1, 12),
	(12, 15, 1, 1, 10),
	(13, 15, 3, 1, 50),
	(14, 16, 1, 1, 10),
	(15, 18, 1, 1, 10),
	(16, 20, 2, 1, 12),
	(17, 20, 3, 1, 50),
	(18, 22, 2, 1, 12),
	(19, 22, 3, 10, 50),
	(20, 24, 2, 1, 12),
	(21, 25, 2, 1, 12),
	(23, 27, 2, 1, 12),
	(27, 28, 1, 1, 10),
	(30, 32, 1, 1, 10),
	(32, 33, 2, 1, 12),
	(33, 33, 2, 1, 12),
	(34, 33, 2, 1, 12),
	(36, 33, 2, 1, 12),
	(38, 33, 2, 1, 12),
	(40, 33, 2, 1, 12),
	(46, 37, 1, 1, 10),
	(49, 40, 1, 1, 10),
	(50, 41, 1, 1, 10),
	(51, 41, 1, 1, 10),
	(52, 42, 1, 1, 10),
	(53, 43, 1, 1, 10),
	(54, 45, 3, 1, 50),
	(55, 46, 1, 1, 10),
	(58, 48, 1, 1, 10),
	(61, 51, 1, 1, 10),
	(77, 56, 1, 10, 10),
	(79, 56, 3, 10, 50),
	(80, 57, 3, 10, 50),
	(81, 57, 3, 10, 50),
	(82, 58, 1, 10, 10),
	(84, 58, 3, 10, 50),
	(85, 59, 1, 10, 10),
	(86, 59, 2, 10, 12),
	(87, 60, 1, 1, 10),
	(89, 60, 3, 1, 50);
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`idproduto`, `descricao`, `valor`) VALUES
	(1, 'Arroz', 10),
	(2, 'Feijão', 12),
	(3, 'Azeite', 50);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idusuario`, `nome`, `email`, `senha`) VALUES
	(34, 'Tulio', 'tulio', '*23AE809DDACAF96AF0FD78ED04B6A265E05AA257'),
	(37, 'Maria', 'maria', '*23AE809DDACAF96AF0FD78ED04B6A265E05AA257');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  `idcliente` int(11) DEFAULT NULL,
  `dataVenda` date DEFAULT NULL,
  PRIMARY KEY (`idvenda`),
  KEY `FK_venda_cliente` (`idcliente`),
  CONSTRAINT `FK_venda_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` (`idvenda`, `idcliente`, `dataVenda`) VALUES
	(1, 2, '2022-11-10'),
	(2, 1, '2022-11-10'),
	(3, 1, '2022-11-17'),
	(4, 2, '2022-11-17'),
	(5, 2, '2022-11-17'),
	(6, 1, '2022-11-17'),
	(7, 1, '2022-11-17'),
	(8, 1, '2022-11-17'),
	(9, 1, '2022-11-17'),
	(10, 1, '2022-11-18'),
	(11, 2, '2022-11-18'),
	(12, 1, '2022-11-18'),
	(13, 1, '2022-11-18'),
	(14, 1, '2022-11-18'),
	(15, 1, '2022-11-18'),
	(16, 1, '2022-11-24'),
	(17, 1, '2022-11-24'),
	(18, 1, '2022-11-24'),
	(19, 1, '2022-11-24'),
	(20, 1, '2022-11-24'),
	(21, 1, '2022-11-24'),
	(22, 1, '2022-11-24'),
	(23, 1, '2022-11-24'),
	(24, 1, '2022-11-24'),
	(25, 1, '2022-11-24'),
	(26, 1, '2022-11-24'),
	(27, 1, '2022-11-24'),
	(28, 1, '2022-11-24'),
	(30, 1, '2022-11-24'),
	(32, 1, '2022-11-24'),
	(33, 1, '2022-11-24'),
	(37, 1, '2022-11-25'),
	(38, 1, '2022-11-25'),
	(40, 2, '2022-11-25'),
	(41, 1, '2022-11-29'),
	(42, 1, '2022-11-29'),
	(43, 1, '2022-11-29'),
	(44, 1, '2022-11-29'),
	(45, 1, '2022-11-29'),
	(46, 1, '2022-11-29'),
	(47, 1, '2022-11-29'),
	(48, 1, '2022-11-29'),
	(49, 1, '2022-11-29'),
	(50, 1, '2022-11-29'),
	(51, 1, '2022-11-29'),
	(52, 2, '2022-12-01'),
	(56, 1, '2022-12-01'),
	(57, 1, '2022-12-01'),
	(58, 2, '2023-04-23'),
	(59, 2, '2023-04-24'),
	(60, 2, '2023-06-14');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

DROP TRIGGER IF EXISTS `Tr_usuario`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `Tr_usuario` BEFORE INSERT ON `usuario` FOR EACH ROW BEGIN
set NEW.senha = PASSWORD(NEW.senha);

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
