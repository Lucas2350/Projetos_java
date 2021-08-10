-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.14 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5137
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para cecijava
CREATE DATABASE IF NOT EXISTS `cecijava` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cecijava`;

-- Copiando estrutura para tabela cecijava.aluno
CREATE TABLE IF NOT EXISTS `aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `dataNasc` varchar(50) NOT NULL,
  `doencas` varchar(50) NOT NULL,
  `alergias` varchar(50) NOT NULL,
  `dataAdmissao` varchar(50) NOT NULL,
  `turma` varchar(50) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `desenvolvimento` varchar(128) NOT NULL,
  PRIMARY KEY (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela cecijava.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(50) NOT NULL,
  `numero` varchar(15) NOT NULL,
  `complemento` varchar(25) NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `cep` varchar(25) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `estado` varchar(25) NOT NULL,
  `idAlunofk` int(11) NOT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `idAlunofk` (`idAlunofk`),
  CONSTRAINT `idAlunofk` FOREIGN KEY (`idAlunofk`) REFERENCES `aluno` (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
