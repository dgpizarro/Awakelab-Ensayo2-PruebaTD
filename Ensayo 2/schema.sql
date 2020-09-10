-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-08-18 19:28:52 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE categoria (
    categoriaid  INTEGER NOT NULL,
    nombre       VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( categoriaid );

CREATE TABLE factura (
    facturaid  INTEGER NOT NULL,
    cliente    VARCHAR2(50 CHAR) NOT NULL,
    fecha      VARCHAR2(10 CHAR) NOT NULL
);

ALTER TABLE factura ADD CONSTRAINT factura_pk PRIMARY KEY ( facturaid );

CREATE TABLE producto (
    productoid   INTEGER NOT NULL,
    nombre       VARCHAR2(30 CHAR) NOT NULL,
    valor        INTEGER NOT NULL,
    categoriaid  INTEGER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( productoid );

CREATE TABLE detallefactura (
    facturaid   INTEGER NOT NULL,
    productoid  INTEGER NOT NULL,
    cantidad    INTEGER NOT NULL
);

ALTER TABLE detallefactura ADD CONSTRAINT detallefactura_pk PRIMARY KEY ( facturaid,
                                                                  productoid );

ALTER TABLE producto
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY ( categoriaid )
        REFERENCES categoria ( categoriaid );

ALTER TABLE detallefactura
    ADD CONSTRAINT detallefactura_f_fk FOREIGN KEY ( facturaid )
        REFERENCES factura ( facturaid );

ALTER TABLE detallefactura
    ADD CONSTRAINT detallefactura_producto_fk FOREIGN KEY ( productoid )
        REFERENCES producto ( productoid );
