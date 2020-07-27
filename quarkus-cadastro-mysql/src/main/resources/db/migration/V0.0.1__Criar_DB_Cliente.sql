# CRIAR UM BANCO DE DADOS
CREATE DATABASE DB_CADASTRO;
USE DB_CADASTRO;

#CRIAR AS TABELAS
CREATE TABLE TB_CLIENTE
(
    ID_CLIENTE INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    NM_CLIENTE VARCHAR(80) NOT NULL,
    NR_CPF_CLIENTE VARCHAR(11) NOT NULL,
    DT_NASC_CLIENTE DATE NOT NULL
);

CREATE TABLE TB_CLIENTE_CONTATO
(
    ID_CLIENTE_CONTATO INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    ID_CLIENTE INT NOT NULL REFERENCES TB_CLIENTE (ID_CLIENTE),
    TX_EMAIL VARCHAR(80) NOT NULL,
    NR_TELEFONE_FIXO VARCHAR(11) NOT NULL,
    NR_TELEFONE_CELULAR VARCHAR(11) NOT NULL
);
CREATE TABLE TB_CLIENTE_ENDERECO
(
    ID_CLIENTE_ENDERECO INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    ID_CLIENTE INT NOT NULL REFERENCES TB_CLIENTE (ID_CLIENTE),
    TX_LOGRADOURO VARCHAR(80) NOT NULL,
    NR_LOGRADOURO INT NOT NULL,
    TX_BAIRRO VARCHAR(50),
    TX_COMPLEMENTO VARCHAR(80),
    TX_CIDADE VARCHAR(50) NOT NULL,
    SG_ESTADO VARCHAR(2) NOT NULL,
    NR_CEP VARCHAR(8) NOT NULL
);