CREATE DATABASE sistemaNotas_EduSmart;

CREATE TABLE rol(
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(400) NOT NULL
);

CREATE TABLE usuario(
	id_usuario SERIAL PRIMARY KEY,
	id_rol INT,
	username VARCHAR(100) NOT NULL,
	pass VARCHAR(20) NOT NULL,
	FOREIGN KEY (id_rol) REFERENCES Rol(id_rol)
);

CREATE TABLE estudiante(
	id_estudiante SERIAL PRIMARY KEY,
	id_usuario INT,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(150) NOT NULL,
	genero VARCHAR(30) NOT NULL,
	f_nacimiento DATE NOT NULL,
	telefono INT,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE tutor(
	id_tutor SERIAL PRIMARY KEY,
	ci INT UNIQUE,
	id_estudiante INT,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(150) NOT NULL,
	parentesco VARCHAR(50) NOT NULL,
	telefono INT NOT NULL,
	direccion VARCHAR(300) NOT NULL,
	FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante)
);

CREATE TABLE cargo(
    id_cargo SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(400)
);

CREATE TABLE personal(
    id_personal SERIAL PRIMARY KEY,
    id_cargo INT,
    id_usuario INT,
    ci INT UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(150) NOT NULL,
    genero VARCHAR(30) NOT NULL,
    f_nacimiento DATE NOT NULL,
    telefono INT,
    direccion VARCHAR(300) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (id_cargo) REFERENCES Cargo(id_cargo)
);

CREATE TABLE docente(
    id_docente SERIAL PRIMARY KEY,
    id_personal INT,
    especialidad VARCHAR(200) NOT NULL, 
    FOREIGN KEY (id_personal) REFERENCES Personal(id_personal)
);

CREATE TABLE materia(
    id_materia SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(400) NOT NULL
);

CREATE TABLE m_calificacion(
    id_mc SERIAL PRIMARY KEY,
    id_materia INT,
    id_estudiante INT,
    id_docente INT, 
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
    FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
    FOREIGN KEY (id_docente) REFERENCES Docente(id_docente)
);

CREATE TABLE d_calificacion(
	id_dc SERIAL PRIMARY KEY,
    id_mc INT,
	n_ser DOUBLE PRECISION NOT NULL,
	n_saber DOUBLE PRECISION NOT NULL,
	n_hacer DOUBLE PRECISION NOT NULL,
	n_decidir DOUBLE PRECISION NOT NULL,
	autoevaluacion DOUBLE PRECISION NOT NULL, 
	n_final DOUBLE PRECISION NOT NULL, 
	FOREIGN KEY (id_mc) REFERENCES MCalificacion(id_mc)
);

CREATE TABLE m_horario(
    id_mh SERIAL PRIMARY KEY,
    dia VARCHAR(20) NOT NULL,
    gestion INT NOT NULL
);

CREATE TABLE aula(
	id_aula SERIAL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	grado INT NOT NULL,
	paralelo VARCHAR(10) NOT NULL
);

CREATE TABLE d_horario (
    id_dh SERIAL PRIMARY KEY,
    id_mh INT NOT NULL,
    periodo INT NOT NULL,
    id_docente INT NOT NULL,
    id_materia INT NOT NULL,
    id_aula INT NOT NULL,
    FOREIGN KEY (id_mh) REFERENCES MHorario(id_mh),
    FOREIGN KEY (id_docente) REFERENCES Docente(id_docente),
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
    FOREIGN KEY (id_aula) REFERENCES Aula(id_aula)
);

CREATE TABLE inscripcion_materia(
	id_est_mat SERIAL PRIMARY KEY,
	id_materia INT,
	id_estudiante INT,
	id_docente INT,
	id_aula INT,
	f_inscription DATE NOT NULL,
	f_inicio DATE NOT NULL,
	f_final DATE NOT NULL,
	FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
	FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
	FOREIGN KEY (id_docente) REFERENCES Docente(id_docente),
	FOREIGN KEY (id_aula) REFERENCES Aula(id_aula)
);
