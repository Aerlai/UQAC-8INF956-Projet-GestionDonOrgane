/*All User's gets stored in APP_USER table*/
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   state VARCHAR(30) NOT NULL,
   birthday DATE NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (sso_id)
);

/*
create table SPECIALITE (
	id int NOT NULL auto_increment,
	specialite varchar(30) NOT NULL,
    primary key (id),
    UNIQUE (specialite)
);*/



    
create table ADRESSE(
	id bigint NOT NULL auto_increment,
	Address1 VARCHAR(120) NOT NULL,
	Address2    VARCHAR(120),
	Address3    VARCHAR(120),
	City        VARCHAR(100) NOT NULL,
    State       CHAR(2),
    Country     CHAR(2) NOT NULL,
    PostalCode  VARCHAR(16) NOT NULL,
    primary key (id)
    
);

create table HOPITAL(
	id bigint not null auto_increment,
    nom VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    id_adresse bigint,
    constraint FK_ADRESSE foreign key (id_adresse) REFERENCES ADRESSE (id),
    UNIQUE(id_adresse),
    UNIQUE(nom),
    primary key (id)
);

create table DOCTEUR (
	#Hopital + Spécialité
    id_personne bigint,
    id_hopital bigint,
    specialite varchar(30) NOT NULL,
    #id_specialite int,
    constraint FK_PERSONNE foreign key (id_personne) REFERENCES APP_USER (id),
    constraint FK_HOPITAL foreign key (id_hopital) REFERENCES HOPITAL (id),
    #constraint FK_SPRECIALITE foreign key (id_specialite) REFERENCES SPECIALITE (id),
    PRIMARY KEY (id_personne)#, id_hopital),#, id_specialite), #Un docteur peut bosser que dans un seul hopital
    #UNIQUE(id_personne)
);
  
create table TRANSPORTEUR (
	id INT NOT NULL AUTO_INCREMENT,
    nom varchar(30) NOT NULL,    
    email VARCHAR(30) NOT NULL,
    id_adresse bigint,
    constraint FK_ADRESSE_TRANSPORTEUR foreign key (id_adresse) REFERENCES ADRESSE (id),
    UNIQUE(nom),
    unique(id_adresse),
    primary key (id)
    
);

/*
create table TYPE_PATIENT(
	id int NOT NULL AUTO_INCREMENT,
    type_patient varchar(10) NOT NULL,
    primary key (id)
);*/



create table PATIENT(
	id_personne bigint,
    groupe_sang varchar(3) NOT NULL,
    id_docteur bigint,
    #id_hopital bigint,
    id_adresse bigint,
    constraint FK_ADRESSE_PATIENT foreign key (id_adresse) REFERENCES ADRESSE (id),
    #constraint FK_HOPITAL_PATIENT foreign key (id_hopital) REFERENCES HOPITAL (id),
	constraint FK_PERSONNE_PATIENT foreign key (id_personne) REFERENCES APP_USER (id),
    constraint FK_DOCTEUR_PATIENT foreign key (id_docteur) REFERENCES DOCTEUR (id_personne),
    primary key(id_personne) #Une personne peut être à la foi donneur et receveur, du coup deux entrées
);

create table DONNEUR(
	id bigint not null auto_increment,
    nom VARCHAR(30) NOT NULL,
    groupe_sang varchar(3) NOT NULL,
    primary key(id),
    UNIQUE(nom)
);

create table ORGANE(
	id int not null auto_increment,
    organe varchar(20) NOT NULL,
    UNIQUE (organe),
    primary key (id)
);

create table DON(
	#id int not null auto_increment, #Ca marche avec
    date_don date not null,
    id_donneur bigint,
    id_organe int,
    constraint FK_DONNEUR_DON foreign key (id_donneur) references DONNEUR(id),
    constraint FK_ORGANE_DON foreign key (id_organe) references ORGANE(id),
    primary key (id_donneur,id_organe)#(id, id_donneur, id_organe)
);

create table BESOIN(
	#id int not null auto_increment,
    id_organe int,
    id_patient bigint,
    constraint FK_ORGANE_BESOIN foreign key (id_organe) references ORGANE(id),
    constraint FK_PATIENT_BEOSIN foreign key (id_patient) REFERENCES PATIENT (id_personne),
    rank int NOT NULL,
    primary key (id_organe, id_patient) #(id, id_organe, id_patient)
);


/* USER_PROFILE table contains all possible roles */ 
create table USER_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
  
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_USER_PROFILE (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);
 
/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
 
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');

INSERT INTO USER_PROFILE(type)
VALUES ('TRANS');

INSERT INTO USER_PROFILE(type)
VALUES ('DOCTEUR');

INSERT INTO USER_PROFILE(type)
VALUES ('PATIENT');
 
/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state, birthday)
VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com', 'Active', '1995-05-22');
 
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state, birthday)
VALUES ('maximePatient','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Maxime','Patient','maxPatient@xyz.com', 'Active', '1995-05-22');
 
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email, state, birthday)
VALUES ('docteur','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Maxime','Docteur','doc@xyz.com', 'Active', '1995-05-22');
 
 INSERT INTO ORGANE (organe)
 values ('rein');
 
  INSERT INTO ORGANE (organe)
 values ('coeur');
 
  INSERT INTO ORGANE (organe)
 values ('foie');
 
  INSERT INTO ORGANE (organe)
 values ('peau');
 
  INSERT INTO ORGANE (organe)
 values ('poumon');
 
 
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='sam' and profile.type='ADMIN';