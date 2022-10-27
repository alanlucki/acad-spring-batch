DROP TABLE comercio IF EXISTS

CREATE TABLE comercio(
    ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
    contrato varchar(100) ,
    comercio varchar(100) ,
    validacion varchar(100)
);