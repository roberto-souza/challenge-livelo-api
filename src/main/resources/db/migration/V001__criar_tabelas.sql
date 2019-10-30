-- -----------------------------------------------------
-- Table Cities
-- -----------------------------------------------------
CREATE TABLE cities ( 
    id bigserial NOT NULL,
    name character varying(255) NOT NULL,
    country character varying(255) NOT NULL,
    CONSTRAINT pk_city PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table Clients
-- -----------------------------------------------------
CREATE TABLE clients ( 
    id bigserial NOT NULL,
    name character varying(255) NOT NULL,
    gender character varying(1) NOT NULL,
    birth_day date,
    age integer,
    city_id integer,
    CONSTRAINT pk_client PRIMARY KEY (id),
    CONSTRAINT fk_cities FOREIGN KEY (city_id) REFERENCES cities (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE SET NULL
);