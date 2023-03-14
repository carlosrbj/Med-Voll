CREATE TABLE doctors (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   email VARCHAR(255) NULL,
   phone VARCHAR(255) NULL,
   crm VARCHAR(255) NULL,
   speciality VARCHAR(255) NULL,
   cep VARCHAR(255) NULL,
   street VARCHAR(255) NULL,
   number VARCHAR(255) NULL,
   complement VARCHAR(255) NULL,
   neighborhood VARCHAR(255) NULL,
   city VARCHAR(255) NULL,
   state VARCHAR(255) NULL,
   CONSTRAINT pk_doctors PRIMARY KEY (id)
);