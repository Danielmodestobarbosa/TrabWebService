CREATE TABLE medicos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    crm VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(50) NOT NULL CHECK (especialidade IN ('Ortopedia', 'Cardiologia', 'Ginecologia', 'Dermatologia')),
    endereco_logradouro VARCHAR(255) NOT NULL,
    endereco_numero VARCHAR(20),
    endereco_complemento VARCHAR(255),
    endereco_bairro VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE paciente (
	id SERIAL PRIMARY KEY,
	nome VARCHAR (255) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	telefone VARCHAR(20) NOT NULL,
	cpf VARCHAR (11) NOT NULL UNIQUE,
	endereco_logradouro VARCHAR(255) NOT NULL,
	endereco_numero VARCHAR (20),
	endereco_complemento VARCHAR(255),
	endereco_bairro VARCHAR(255) NOT NULL,
	endereco_cidade VARCHAR (255) NOT NULL,
	endereco_uf VARCHAR(2) NOT NULL,
	endereco_cep VARCHAR (8) NOT NULL,
	ativo BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE consultas (
    id SERIAL PRIMARY KEY,
    id_paciente INT REFERENCES paciente(id) ON DELETE CASCADE,
    id_medico INT REFERENCES medicos(id) ON DELETE CASCADE,
    data_hora TIMESTAMP NOT NULL,
    motivo_cancelamento VARCHAR(255),
    status VARCHAR(20) CHECK (status IN ('agendada', 'realizada', 'cancelada')) DEFAULT 'agendada',
    ativo BOOLEAN DEFAULT TRUE NOT NULL
);

-- Índice exclusivo para garantir que um paciente tenha apenas uma consulta por dia
CREATE UNIQUE INDEX idx_consulta_unica_paciente
ON consultas (id_paciente, DATE(data_hora));

-- Índice exclusivo para garantir que um médico tenha apenas uma consulta por horário
CREATE UNIQUE INDEX idx_consulta_unica_medico
ON consultas (id_medico, data_hora);

CREATE TABLE motivo_cancelamento (
	id SERIAL PRIMARY KEY,
	motivo VARCHAR(255) NOT NULL CHECK(motivo IN('paciente desistiu', 'médico cancelou', 'outros'))	
);

CREATE TABLE historico_medico (
	id SERIAL PRIMARY KEY,
	id_medico INT REFERENCES medicos(id) ON DELETE CASCADE,
	nome_anterior VARCHAR(255),
	telefone_anterior VARCHAR(255),
	data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
