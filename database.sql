CREATE DATABASE SistemaNotas;

CREATE TABLE Usuario(
	id_usuario SERIAL PRIMARY KEY,
	username VARCHAR(20) NOT NULL,
	pass VARCHAR(20) NOT NULL
);

CREATE TABLE Estudiante(
	id_estudiante SERIAL PRIMARY KEY,
	id_usuario INT,
	nombre VARCHAR(80) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	genero VARCHAR(30) NOT NULL,
	f_nacimiento DATE NOT NULL,
	telefono INT,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Tutor(
	id_tutor SERIAL PRIMARY KEY,
	ci INT UNIQUE,
	id_estudiante INT,
	nombre VARCHAR(80) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	parentesco VARCHAR(40) NOT NULL,
	telefono INT NOT NULL,
	direccion VARCHAR(150) NOT NULL,
	FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante)
);

CREATE TABLE Docente(
	id_docente SERIAL PRIMARY KEY,
	id_usuario INT,
	ci INT UNIQUE,
	nombre VARCHAR(80) NOT NULL,	
	apellido VARCHAR(100) NOT NULL,
	genero VARCHAR(30) NOT NULL,
	f_nacimiento DATE,
	especialidad VARCHAR(80) NOT NULL,
	direccion VARCHAR(150) NOT NULL,
	telefono INT NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Materia(
	id_materia SERIAL PRIMARY KEY,
	nombre VARCHAR(80) NOT NULL,
	descripcion VARCHAR(400) NOT NULL
);

CREATE TABLE MCalificacion(
	id_mc SERIAL PRIMARY KEY,
	id_materia INT,
	id_estudiante INT,
	id_docente INT, 
	FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
	FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
	FOREIGN KEY (id_docente) REFERENCES Docente(id_docente)
);

CREATE TABLE DCalificacion(
	id_dc SERIAL PRIMARY KEY,
	id_mc INT,
	n_ser INT NOT NULL,
	n_saber INT NOT NULL,
	n_hacer INT NOT NULL,
	n_decidir INT NOT NULL,
	autoevaluacion INT NOT NULL, 
	n_final INT NOT NULL, 
	FOREIGN KEY (id_mc) REFERENCES MCalificacion(id_mc)
);



CREATE TABLE Horario(
	cod_horario SERIAL PRIMARY KEY,
	dia VARCHAR(20) NOT NULL,
	periodo INT NOT NULL
);



CREATE TABLE Aula(
	cod_aula SERIAL PRIMARY KEY,
	cod_horario INT,
	grado INT NOT NULL,
	paralelo VARCHAR(15) NOT NULL,
	FOREIGN KEY (cod_horario) REFERENCES Horario(cod_horario)
);


CREATE TABLE Estudiante_Materia(
	cod_est_mat SERIAL PRIMARY KEY,
	cod_mateia INT,
	cod_estudiante INT,
	cod_docente INT,
	cod_aula INT,
	fecha_inicio DATE NOT NULL,
	fecha_final DATE NOT NULL,
	FOREIGN KEY (cod_mateia) REFERENCES Materia(id_materia),
	FOREIGN KEY (cod_estudiante) REFERENCES Estudiante(id_estudiante),
	FOREIGN KEY (cod_docente) REFERENCES Docente(id_docente),
	FOREIGN KEY (cod_aula) REFERENCES Aula(cod_aula)
);








