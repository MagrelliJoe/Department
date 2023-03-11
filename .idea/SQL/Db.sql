CREATE TABLE departments
  (
    id_department			BIGINT NOT NULL,
    name				    VARCHAR(32) NOT NULL,
    address			        VARCHAR(32) NOT NULL,
    max_capacity       		INT NOT NULL

    CONSTRAINT PK_departments PRIMARY KEY(id_department)
  );
  CREATE SEQUENCE departments_sequence
    start 1
    increment 1
    OWNED BY departments.id_department;


CREATE TABLE dependents
(
	id_dependent 		     BIGINT NOT NULL,
	name					 VARCHAR(32) NOT NULL,
	lastname				 VARCHAR(32) NOT NULL,
	sex				         VARCHAR(32) NOT NULL,
	Date_of_employment		 DATE,
	id_department            BIGINT

	CONSTRAINT PK_dependents PRIMARY KEY(id_dependent),
	CONSTRAINT FK_dependents_departments FOREIGN KEY(id_department)
    REFERENCES departments(id_department)
);

CREATE SEQUENCE dependents_sequence
  start 1
  increment 1
  OWNED BY dependents.id_dependent;


