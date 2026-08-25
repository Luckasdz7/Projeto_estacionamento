
create database estacionamento;
use estacionamento;


create table Pessoa(
    idpessoa integer auto_increment not null primary key,
    nome varchar(100) not null,
    cpf varchar(14) not null
);


create table Veiculo(
    idveiculo integer auto_increment not null primary key,
    modelo varchar(100) not null,
    marca varchar(100) not null,
    placa varchar(100) not null,
    ano int not null,
    idpessoa integer,
    foreign key(idpessoa) references Pessoa(idpessoa)
);

SELECT * FROM Veiculo where idveiculo = 5;

-- --------------------------------------------------------
-- 1. INSERINDO PESSOAS
-- --------------------------------------------------------
INSERT INTO Pessoa (nome, cpf) VALUES 
('João Silva', '111.111.111-11'),
('Maria Oliveira', '222.222.222-22'),
('Carlos Santos', '333.333.333-33'),
('Ana Souza', '444.444.444-44'),
('Pedro Costa', '555.555.555-55');

-- --------------------------------------------------------
-- 2. INSERINDO VEÍCULOS
-- --------------------------------------------------------

-- O João (idpessoa 1) tem 2 carros
INSERT INTO Veiculo (modelo, marca, placa, ano, idpessoa) VALUES 
('Civic', 'Honda', 'ABC-1234', 2020, 1),
('Fit', 'Honda', 'DEF-5678', 2015, 1);

-- A Maria (idpessoa 2) tem 1 carro
INSERT INTO Veiculo (modelo, marca, placa, ano, idpessoa) VALUES 
('Corolla', 'Toyota', 'XYZ-9876', 2022, 2);

-- O Carlos (idpessoa 3) tem 1 carro
INSERT INTO Veiculo (modelo, marca, placa, ano, idpessoa) VALUES 
('Onix', 'Chevrolet', 'GHI-9012', 2019, 3);

-- A Ana (idpessoa 4) tem 3 carros (uma frota pequena!)
INSERT INTO Veiculo (modelo, marca, placa, ano, idpessoa) VALUES 
('HB20', 'Hyundai', 'JKL-3456', 2021, 4),
('Tucson', 'Hyundai', 'MNO-7890', 2018, 4),
('Gol', 'Volkswagen', 'PQR-1122', 2010, 4);

-- Nota: O Pedro (idpessoa 5) não recebeu nenhum veículo de propósito.
-- Assim você pode testar se o seu Java vai bugar quando procurar os carros dele!