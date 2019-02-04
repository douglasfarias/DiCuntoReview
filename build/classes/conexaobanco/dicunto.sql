-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Dez-2017 às 14:45
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dicunto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(30) NOT NULL,
  `DESCRICAO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`ID`, `NOME`, `DESCRICAO`) VALUES
(2, 'coco', 'delicia'),
(3, 'nicoll', 'asd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `ENDERECO` varchar(30) NOT NULL,
  `BAIRRO` varchar(30) NOT NULL,
  `NUMERO` int(5) NOT NULL,
  `CIDADE` varchar(30) NOT NULL,
  `CEP` int(9) NOT NULL,
  `ESTADO` varchar(2) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `DATA_NASCIMENTO` varchar(10) DEFAULT NULL,
  `CELULAR` int(11) DEFAULT NULL,
  `TELEFONE` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`ID`, `NOME`, `ENDERECO`, `BAIRRO`, `NUMERO`, `CIDADE`, `CEP`, `ESTADO`, `EMAIL`, `CPF`, `DATA_NASCIMENTO`, `CELULAR`, `TELEFONE`) VALUES
(1, 'Alef', 'Alef', 'Alef', 2, 'Alef', 2541589, 'AF', 'Alef', '45789621455', '666666', 580021444, 55447780);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `ENDERECO` varchar(30) NOT NULL,
  `BAIRRO` varchar(30) NOT NULL,
  `NUMERO` int(5) NOT NULL,
  `CIDADE` varchar(30) NOT NULL,
  `CEP` int(9) NOT NULL,
  `ESTADO` varchar(30) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  `DATA_CADASTRO` varchar(10) NOT NULL,
  `CELULAR` int(9) DEFAULT NULL,
  `TELEFONE` int(8) NOT NULL,
  `TELEFONE2` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`ID`, `NOME`, `ENDERECO`, `BAIRRO`, `NUMERO`, `CIDADE`, `CEP`, `ESTADO`, `EMAIL`, `CNPJ`, `DATA_CADASTRO`, `CELULAR`, `TELEFONE`, `TELEFONE2`) VALUES
(1, 'Dougras', 'Dougras', 'Dougras', 185, 'Dougras', 14587905, 'DG', 'Dougras', '54187498566324', '666666', 4444444, 66666, 8888888);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `CARGO` varchar(20) NOT NULL,
  `SETOR` varchar(20) NOT NULL,
  `ENDERECO` varchar(30) NOT NULL,
  `BAIRRO` varchar(30) NOT NULL,
  `NUMERO` int(5) NOT NULL,
  `CIDADE` varchar(30) NOT NULL,
  `CEP` int(9) NOT NULL,
  `ESTADO` varchar(30) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `DATA_ADMISSAO` varchar(10) NOT NULL,
  `DATA_NASCIMENTO` varchar(10) NOT NULL,
  `CELULAR` varchar(20) DEFAULT NULL,
  `TELEFONE` varchar(20) NOT NULL,
  `TELEFONE2` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `ID` int(6) NOT NULL,
  `ID_FUNCIONARIO` int(4) DEFAULT NULL,
  `ID_CLIENTE` int(4) DEFAULT NULL,
  `PRODUTO` varchar(30) NOT NULL,
  `QUANTIDADE` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `ID` int(4) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `ID_FORNECEDOR` int(4) DEFAULT NULL,
  `ID_CATEGORIA` int(4) DEFAULT NULL,
  `QUANTIDADE` varchar(20) NOT NULL,
  `DESCRICAO` varchar(50) NOT NULL,
  `PRECO` varchar(10) NOT NULL,
  `PESO` float(7,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`ID`, `NOME`, `ID_FORNECEDOR`, `ID_CATEGORIA`, `QUANTIDADE`, `DESCRICAO`, `PRECO`, `PESO`) VALUES
(1, 'asd', NULL, NULL, '12', 'asd', 'R$ 12', NULL),
(2, 'bolo de chocolate', NULL, NULL, '10', 'bolo', 'R$ 50', NULL),
(3, 'torta', NULL, NULL, '10', 'bolo', 'R$ 50,00', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PED_FUN_FK` (`ID_FUNCIONARIO`),
  ADD KEY `PED_CLI_FK` (`ID_CLIENTE`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `PRO_FOR_FK` (`ID_FORNECEDOR`),
  ADD KEY `PRO_CAT_FK` (`ID_CATEGORIA`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `PED_CLI_FK` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`),
  ADD CONSTRAINT `PED_FUN_FK` FOREIGN KEY (`ID_FUNCIONARIO`) REFERENCES `funcionario` (`ID`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `PRO_CAT_FK` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID`),
  ADD CONSTRAINT `PRO_FOR_FK` FOREIGN KEY (`ID_FORNECEDOR`) REFERENCES `fornecedor` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
