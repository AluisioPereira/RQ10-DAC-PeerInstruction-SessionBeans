CREATE TABLE pessoa(
    id SERIAL NOT NULL, 
    nome VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO pessoa (id, nome) VALUES ('1', 'Joao');
INSERT INTO pessoa (id, nome) VALUES ('2', 'Maria');
