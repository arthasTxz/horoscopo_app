CREATE TABLE horoscopo(
    id SERIAL PRIMARY KEY ,
    animal VARCHAR(30),
    fecha_inicio DATE,
    fecha_final DATE,
    UNIQUE (animal, fecha_inicio, fecha_final)
);

CREATE TABLE usuarios(
  id SERIAL PRIMARY KEY,
    nombre VARCHAR(30),
    username VARCHAR(30) UNIQUE,
    email VARCHAR(30) UNIQUE ,
    fecha_nacimiento DATE,
    password VARCHAR(30),
    horoscopo_id INTEGER,
    CONSTRAINT fk_horoscopo FOREIGN KEY (horoscopo_id) REFERENCES horoscopo (id)
);



