DROP TABLE comercio IF EXISTS

CREATE TABLE comercio(
    ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
    contrato varchar(20) ,
    comercio varchar(8) ,
    estado_contr varchar(2),
    estado_comer varchar(3),
    ind_180_dias varchar(1),
    ind_comerc_deb varchar(1),
    ind_banco_deb varchar(1)
);