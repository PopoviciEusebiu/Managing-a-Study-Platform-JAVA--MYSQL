drop database if exists proiect;
CREATE DATABASE IF NOT EXISTS proiect;
use proiect;

CREATE TABLE if not exists student (
parola varchar(20) null,
CNP VARCHAR(13) NOT NULL,
nume VARCHAR(20) NULL,
prenume VARCHAR(20) NULL,
adresa VARCHAR(45) NULL,
telefon VARCHAR(10) NULL,
email VARCHAR(20) NULL,
IBAN VARCHAR(16) NULL,
nr_contact VARCHAR(10) NULL,
anstudiu int null,
nr_ore int null,
  PRIMARY KEY (CNP)
);

 CREATE  TABLE if not exists profesor(
 parola varchar(20) null,
CNP VARCHAR(13) NOT NULL,
nume VARCHAR(20) NULL,
prenume VARCHAR(20) NULL,
adresa VARCHAR(45) NULL,
telefon VARCHAR(10) NULL,
email VARCHAR(20) NULL,

IBAN VARCHAR(16) NULL,
nr_contact VARCHAR(10) NULL,
  PRIMARY KEY (CNP));
  
  CREATE TABLE if not exists administrator (
  parola varchar(20) null,
  CNP VARCHAR(13) NOT NULL,
  nume VARCHAR(20) NULL,
  prenume VARCHAR(20) NULL,
  adresa VARCHAR(45) NULL,
  telefon VARCHAR(10) NULL,

  email VARCHAR(20) NULL,
  IBAN VARCHAR(16) NULL,
  nr_contact VARCHAR(10) NULL,
  PRIMARY KEY (CNP));
  
CREATE TABLE if not exists superAdmin (
parola varchar(20) null,
CNP VARCHAR(13) NOT NULL,
nume VARCHAR(20) NULL,
prenume VARCHAR(20) NULL,
adresa VARCHAR(45) NULL,
telefon VARCHAR(10) NULL,

email VARCHAR(20) NULL,
IBAN VARCHAR(16) NULL,
nr_contact VARCHAR(10) NULL,
PRIMARY KEY (CNP));
  
  Alter table profesor 
  add column idprofesor int not null auto_increment first,
  change column cnp cnp varchar(13) NULL,
  drop primary key,
  add primary key (idprofesor);
  
  Alter table student
  add column idstudent int not null auto_increment first,
  change column cnp cnp varchar(13) NULL,
  drop primary key,
  add primary key (idstudent);
  
    Alter table administrator
  add column idadmin int not null auto_increment first,
  change column cnp cnp varchar(13) NULL,
  drop primary key,
  add primary key (idadmin);
  
  create table if not exists info_profesor(
  idinfo_prof int not null auto_increment,
  idprofesor int not null,
  idcurs int null,
  nr_min int null,
  nr_max int  null,
  departament varchar(45) null,
  primary key (idinfo_prof)
  );
  
  create table if not exists curs(
  idcurs int not null,
  nume_curs varchar(45) null,
  primary key (idcurs)
  );
  
  alter table info_profesor
  add index idprofesor_idx (idprofesor ASC) visible;
  ;
  
  alter table info_profesor 
  add constraint idprofesor
  foreign key (idprofesor) references profesor(idprofesor)
  on delete no action on update no action;
  
   alter table info_profesor
  add index idcurs_idx (idcurs ASC) visible;
  
  
  alter table info_profesor 
  add constraint idcurs
  foreign key (idcurs) references curs(idcurs)
  on delete no action on update no action;
  
 create table if not exists activitati(
 idcurs int not null primary key ,
 curspr int null,
 seminarpr int null,
 laboratorpr int null);
 
 alter table curs
 add constraint idcurs2 foreign key(idcurs) references activitati(idcurs) on delete no action on update no action;
 
 alter table curs
 add column descriere varchar(50) null after nume_curs,
 add column nr_max_studenti int null after descriere,
 add column nr_actual_studenti int null after nr_max_studenti;
 
 create table if not exists inscriere(
 idinscriere int not null primary key,
 idstudent int null,
 idprofesor int null,
 idcurs int null,
 data_inscriere date null
 );
 
 alter table inscriere
 add index idstudent2_idx (idstudent ASC) visible;
 ;
 alter table inscriere
 add constraint idstudent2
 foreign key (idstudent) references student(idstudent) on delete cascade on update cascade;
 
 alter table inscriere
 add index idprofesor2_idx (idprofesor ASC) visible;
 ;
 alter table inscriere
 add constraint idprofesor2
 foreign key (idprofesor) references profesor(idprofesor) on delete cascade on update cascade;
 
 alter table inscriere
 add index idcurs3_idx (idcurs ASC) visible;
 ;
 alter table inscriere
 add constraint idcurs3
 foreign key(idcurs) references curs(idcurs) on delete cascade on update cascade;
 
 create table if not exists note_student(
 idstudent int not null primary key,
 idlab int null,
 idseminar int null,
 idcurs int null
 );
 
 create table if not exists nota_seminar(
 idseminar_nota int not null primary key,
 nota_seminar int null,
 data_incepere date null,
 data_final date null
 );
 
 create table if not exists nota_lab(
 idlab_nota int not null primary key,
 nota_lab int null,
 data_incepere date null,
 data_final date null
 );
 
  create table if not exists nota_curs(
 idcurs_nota int not null primary key,
 nota_curs int null,
 data_incepere date null,
 data_final date null
 );
 
 alter table note_student
 add index idcurs4_idx (idcurs ASC) VISIBLE;
 ;
 alter table note_student
 add constraint idcurs4 foreign key(idcurs) references nota_curs (idcurs_nota) on delete no action on update no action;
 
 alter table note_student
 add  constraint id_student1 foreign key (idstudent) references student(idstudent) on delete no action on update no action;
 
  alter table note_student 
  add index idlab1_idx (idlab asc) VISIBLE;
  ;
  alter table note_student
  add constraint idlab1 foreign key (idlab) references nota_lab(idlab_nota) on delete no action on update no action;

alter table note_student
add index idseminar_idx (idseminar asc) visible;
;
alter table note_student
add constraint idseminar1 foreign key (idseminar) references nota_seminar(idseminar_nota) on delete no action on update no action;
  
alter table note_student
add constraint idcurs5 foreign key(idcurs) references activitati(idcurs) on delete no action on update no action;

alter table inscriere
add column data_renuntare varchar(10) null after data_inscriere;

alter table nota_lab
add column idcurs int null after data_final;
alter table nota_seminar
add column idcurs int null after data_final;
alter table nota_curs
add column idcurs int null after data_final;

alter table nota_lab
add index idcurs_lab_idx (idcurs asc) visible;
;
alter table nota_lab
add constraint idcurs_lab foreign key(idcurs) references curs(idcurs) on delete no action on update no action;

alter table nota_seminar
add index idcurs_seminar_idx (idcurs asc) visible;
;
alter table nota_seminar
add constraint idcurs_seminar foreign key(idcurs) references curs(idcurs) on delete no action on update no action;

create table if not exists grup_studiu(
idgrup int not null primary key,
nume varchar(20) null,
nr_max_studenti int null
);

create table if not exists relatii_grup(
idrelatii_grup int not null primary key,
idstudent int null,
idgrup int null,
constraint idstudent foreign key (idstudent) references student(idstudent) on delete no action on update no action,
constraint idgrup foreign key (idgrup) references grup_studiu(idgrup) on delete no action on update no action
);

alter table relatii_grup
add index idstud_idx (idstudent asc) visible;

alter table relatii_grup
add index idgrup_idx (idgrup asc) visible;

alter table note_student
add column idordine int null after idseminar;

alter table note_student
drop foreign key id_student1;
alter table note_student
change column idstudent idstudent int null,
drop primary key;
;
alter table note_student
add constraint idstudent1 foreign key(idstudent) references student(idstudent);

alter table note_student
change column idstudent idstudent int null,
change column idordine idordine int not null,
add primary key (idordine);
;

alter table activitati
add constraint idd foreign key (idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table curs
drop foreign key idcurs2;

alter table activitati
drop foreign key idd;
alter table activitati
add constraint idd foreign key (idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table note_student
drop foreign key idcurs4,
drop foreign key idcurs5,
drop foreign key idstudent1;
alter table note_student
add constraint idcurs4 foreign key(idcurs) references nota_curs(idcurs_nota) on delete cascade on update cascade,
add constraint idcurs5 foreign key(idcurs) references activitati(idcurs) on delete cascade on update cascade,
add constraint idstudent1 foreign key(idstudent) references student(idstudent) on delete cascade on update cascade;

alter table nota_curs
add constraint idcurs_curs foreign key(idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table nota_lab
add column lab int null after idcurs;
alter table nota_seminar
add column sem int null after idcurs;
alter table nota_curs
add column curs int null after idcurs;

alter table nota_lab
add column idstudent int null after lab;
alter table nota_curs
add column idstudent int null after curs;
alter table nota_seminar
add column idstudent int null after sem;

alter table nota_lab
drop foreign key idcurs_lab;
alter table nota_lab
add constraint idcurs_lab foreign key (idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table nota_seminar
drop foreign key idcurs_seminar;
alter table nota_seminar
add constraint idcurs_seminar foreign key (idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table grup_studiu
add column idcurs int not null default 0 after nr_max_studenti;
alter table grup_studiu
add index idcursdd_idx (idcurs asc) visible;
;
alter table grup_studiu
add constraint idcursdd foreign key(idcurs) references curs(idcurs) on delete cascade on update cascade;

create table if not exists activ_grup(
idactiv_grup int not null primary key,
id_grup_studiu int not null,
nr_min int null,
data_desf datetime null,
ora_desf varchar(10),
INDEX idcurs8_idx (id_grup_studiu asc) visible,
constraint idcurs8 foreign key (id_grup_studiu) references grup_studiu (idgrup) on delete cascade on update cascade
);

alter table relatii_grup
drop foreign key idgrup,
drop foreign key idstudent;
alter table relatii_grup
add constraint idgrup foreign key (idgrup) references grup_studiu(idgrup) on delete cascade on update cascade;
alter table relatii_grup
add constraint idstudent foreign key(idstudent) references student(idstudent) on delete cascade on update cascade;

create table if not exists orar_student(
idorar_student int not null primary key,
idstudent int null,
idcurs int null,
zi_curs varchar(45) null,
zi_lab varchar(45) null,
zi_sem varchar(45) null,
ora_curs int null,
ora_lab int null,
ora_sem int null
);

alter table activitati
add column zi_lab varchar(45) null after laboratorpr,
add column zi_curs varchar(45) null after zi_lab,
add column zi_sem varchar(45) null after zi_curs,
add column ora_lab int null after zi_sem,
add column ora_curs int null after ora_lab,
add column ora_sem int null after ora_curs;

alter table orar_student
add constraint idorar_student foreign key (idorar_student) references inscriere(idinscriere) on delete cascade on update cascade;

alter table grup_studiu
add column nr_actual_stud varchar(45) null default 0 after idcurs;
alter table grup_studiu
add column idprofesor int null after nr_actual_stud;

alter table activ_grup
change column data_desf data_desf varchar(20) NULL DEFAULT NULL;


alter table activ_grup
add column nr_actual int null default 0 after ora_desf,
add column activ_grupcol varchar(45) null after nr_actual;

CREATE TABLE if not exists studenti_activitate (
  idstudenti_activitate INT NOT NULL,
  idstudent INT NULL,
  idactiv_grup INT NULL,
  idgrup_studiu INT NULL,
  PRIMARY KEY (idstudenti_activitate));

ALTER TABLE studenti_activitate
ADD INDEX idactiv_grup_idx (idactiv_grup ASC) VISIBLE;
ALTER TABLE studenti_activitate
ADD CONSTRAINT idactiv_grup
  FOREIGN KEY (idactiv_grup)
  REFERENCES activ_grup (idactiv_grup)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE studenti_activitate
ADD INDEX idgrup_studiu_idx (idgrup_studiu ASC) VISIBLE;
ALTER TABLE studenti_activitate
ADD CONSTRAINT idgrup_studiu
  FOREIGN KEY (idgrup_studiu)
  REFERENCES activ_grup (id_grup_studiu)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE info_profesor 
DROP FOREIGN KEY idprofesor;
ALTER TABLE info_profesor 
ADD CONSTRAINT idprofesor
  FOREIGN KEY (idprofesor)
  REFERENCES profesor(idprofesor)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE info_profesor 
DROP FOREIGN KEY idcurs;
ALTER TABLE info_profesor 
ADD CONSTRAINT idcurs
  FOREIGN KEY (idcurs)
  REFERENCES curs(idcurs)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE nota_lab
DROP COLUMN data_final,
DROP COLUMN data_incepere;


ALTER TABLE nota_seminar
DROP COLUMN data_final,
DROP COLUMN data_incepere;

ALTER TABLE nota_curs
DROP COLUMN data_final,
DROP COLUMN data_incepere;

create table if not exists calendar(
idcurs int not null primary key,
data_curs date null,
data1_curs date null,
data_lab date null,
data_lab1 date null,
data_sem date null,
data1_sem date null
);

alter table calendar
add constraint idcursfinal foreign key(idcurs) references curs(idcurs) on delete cascade on update cascade;

alter table note_student
drop foreign key idcurs4,
drop foreign key idlab1,
drop foreign key idseminar1;

alter table note_student
add constraint idcurs4 foreign key(idcurs) references nota_curs (idcurs_nota) on delete cascade on update cascade,
add constraint idlab1 foreign key(idlab) references nota_lab (idlab_nota) on delete cascade on update cascade,
add constraint idseminar1 foreign key(idseminar) references nota_seminar(idseminar_nota) on delete cascade on update cascade;

#alter table nota_lab
#add constraint idlab1 foreign key(idlab_nota) references note_student (idlab) on delete no action on update no action;

#alter table nota_seminar
#add constraint idseminar1 foreign key(idseminar_nota) references note_student (idlab) on delete no action on update no action;

#alter table nota_curs
#add constraint idcurs4 foreign key(idcurs_nota) references note_student (idlab) on delete no action on update no action;

alter table note_student
drop foreign key idseminar1,
drop foreign key idlab1,
drop foreign key idcurs4,
drop foreign key idcurs5;
alter table note_student
drop index idseminar_idx,
drop index idlab1_idx,
drop index idcurs4_idx;
;


drop procedure if exists insertstudent
DELIMITER //
create procedure insertstudent(in parola varchar(20),in cnp varchar(13),in nume varchar(20),in prenume varchar(20),in adresa varchar(45),in telefon varchar(10),in email varchar(20),in iban varchar(16),in nr_contact varchar(10),in anstudiu int,in nr_ore int)
begin
set @ID=( SELECT MAX(student.idstudent) FROM student) + 1;
if @ID IS NULL then
set @ID=1;
end if;
insert into student 
values (@ID,parola,cnp,nume,prenume,adresa,telefon,email,iban,nr_contact, anstudiu, nr_ore);
end; //


drop procedure if exists insertprofesor
DELIMITER //
CREATE PROCEDURE insertprofesor(in parola varchar(20),in cnp varchar(13), in nume varchar(20), in prenume varchar(20), in adresa varchar(45), in telefon varchar(10), in email varchar(20), in iban varchar (16), in nr_contact varchar(10))
begin
set @ID=( SELECT MAX(profesor.idprofesor) FROM profesor) + 1;
if @ID IS NULL then
set @ID=1;
end if;
insert into profesor 
values (@ID,parola,cnp,nume,prenume,adresa,telefon,email,iban,nr_contact);
end; //

drop procedure if exists insertadministrator
DELIMITER //
CREATE  PROCEDURE insertadministrator( in parola varchar(20),in cnp varchar(13), in nume varchar(20), in prenume varchar(20), in adresa varchar(45), in telefon varchar(10), in email varchar(20), in iban varchar (16), in nr_contact varchar(10), in a varchar(10), in a1 varchar(10))
begin
set @ID=( SELECT MAX(administrator.idadmin) FROM administrator) + 1;
if @ID IS NULL then
set @ID=1;
end if;
insert into administrator values (@ID,parola,cnp,nume,prenume,adresa,telefon,email,iban,nr_contact);
end; //

drop procedure if exists insertsuperadministrator
DELIMITER //
CREATE  PROCEDURE insertsuperadministrator(in parola varchar(20), in cnp varchar(13), in nume varchar(20), in prenume varchar(20), in adresa varchar(45), in telefon varchar(10), in email varchar(20), in iban varchar (16), in nr_contact varchar(10))
begin
insert into superadmin values (parola,cnp,nume,prenume,adresa,telefon,email,iban,nr_contact);
end; //

drop procedure if exists insertcursuri
DELIMITER //
CREATE PROCEDURE insertcursuri( in nume varchar(45),in descriere varchar(45), in nr_max_stud int, in zi_lab varchar(20), in zi_curs varchar(20), in zi_sem varchar(20), in ora_curs int , in ora_lab int, in ora_sem int)
begin
set @ID=( SELECT MAX(curs.idcurs) FROM curs) + 1;
if @ID IS NULL then
set @ID=1;
end if;
INSERT INTO curs(idcurs, nume_curs,descriere,nr_max_studenti,nr_actual_studenti) 
VALUES (@ID, nume, descriere, nr_max_stud,'0');
insert into activitati (idcurs, zi_curs, zi_lab, zi_sem, ora_curs, ora_lab, ora_sem) 
values (@ID, zi_curs, zi_lab, zi_sem, ora_curs, ora_lab, ora_sem);
end; //






drop procedure if exists addTeacherToGroup
DELIMITER //
CREATE PROCEDURE addTeacherToGroup(in nume_grup varchar(35), in nume_prof varchar(25))
begin
set @id=(select idgrup from grup_studiu where grup_studiu.nume=nume_grup);
set @idProf=(select idprofesor from profesor where profesor.nume=nume_prof );
 update grup_studiu set idprofesor = @idProf where grup_studiu.idgrup=@id; 
end; //


drop procedure if exists CreateActivityGroup
DELIMITER //
CREATE PROCEDURE CreateActivityGroup(in nume_grup varchar(20), in nume_activ varchar(60),  in data_desf varchar(20), in ora_exp varchar(10), in nr_min int)
begin
set @ID=( SELECT MAX(activ_grup.idactiv_grup) FROM activ_grup) + 1;
if @ID IS NULL then
set @ID=1;
end if;
set @idgrup =( select idgrup from grup_studiu where grup_studiu.nume=nume_grup);
insert into activ_grup values (@ID, @idgrup, nr_min, data_desf, ora_exp,0, nume_activ);
end; //

drop procedure if exists addToCalendar
DELIMITER //
CREATE PROCEDURE addToCalendar(in nume_curs varchar(10), in data_sem date, in data1_sem date, in data_lab date, in data1_lab date, in data_curs date, in data1_curs date)
begin
set @idcurs = ( SELECT curs.idcurs
                from curs
                where curs.nume_curs = nume_curs );
insert into calendar values(@idcurs, data_curs, data1_curs, data_lab, data1_lab, data_sem, data1_sem);
end; //

drop procedure if exists insertinformatii_profesor
DELIMITER //
CREATE  PROCEDURE insertinformatii_profesor( in nume_curs varchar(45), in nume_prof varchar(20), in nr_min int, in nr_max int, in departament varchar(25))
begin
set @ID=( SELECT MAX(info_profesor.idcurs) FROM info_profesor) + 1;
if @ID IS NULL then
set @ID=1;
end if;
#SELECT @ID;
SET @IDprof = (SELECT profesor.idprofesor
               from profesor
			   where profesor.nume = nume_prof
			);

set @idcurs = ( SELECT curs.idcurs
                from curs
                where curs.nume_curs = nume_curs);
#SELECT @IDCURS;
insert into info_profesor 
values (@ID, @IDprof, @idcurs, nr_min, nr_max, departament); 
end; //

drop procedure if exists creategrup_studiu 
DELIMITER //
CREATE PROCEDURE creategrup_studiu( in nume varchar(20), in nr_max_studenti int, in nume_curs varchar(20), in nume_prof varchar(20), in prenume_prof varchar(20))
begin
set @idcurs = ( SELECT curs.idcurs
                from curs,info_profesor,profesor
                where curs.nume_curs = nume_curs
                and curs.idcurs = info_profesor.idcurs
                and info_profesor.idprofesor = profesor.idprofesor
                and profesor.nume = nume_prof
                and profesor.prenume = prenume_prof );
set @ID=( SELECT MAX(grup_studiu.idgrup) FROM grup_studiu) + 1;
if @ID IS NULL then
set @ID=1;
end if;
insert into grup_studiu(idgrup, nume, nr_max_studenti, idcurs,nr_actual_stud)
values (@ID, nume, nr_max_studenti,@idcurs,0);
end; //

drop procedure if exists addGrades
DELIMITER //
CREATE PROCEDURE addGrades(in nume_stud varchar(20), in prenume_stud varchar(20),  in nume_curs varchar(45),in nume_prof varchar(20), in notas int, in notal int, in notac int)
begin
SET @idstudent = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               and student.prenume = prenume_stud
               );
#select @idstudent;
set @idcurs = ( SELECT curs.idcurs
                from curs,info_profesor,profesor
                where curs.nume_curs = nume_curs
                and curs.idcurs = info_profesor.idcurs
                and info_profesor.idprofesor = profesor.idprofesor
                and profesor.nume = nume_prof);
                set @ordineNote=( SELECT MAX(note_student.idordine) FROM note_student) + 1;
if @ordineNote IS NULL then
set @ordineNote =1;

SET @idlaborator = ( SELECT MAX(nota_lab.idlab_nota) FROM nota_lab) + 1;
if @idlaborator IS NULL then
set @idlaborator=1;
end if; 


SET @idseminar = ( SELECT MAX(nota_seminar.idseminar_nota) FROM nota_seminar) + 1;
if @idseminar IS NULL then
set @idseminar=1;
end if; 


end if;
SET SQL_SAFE_UPDATES=0;
SET @data =(select inscriere.data_inscriere from inscriere where inscriere.idstudent=@idstudent and inscriere.idcurs=@idcurs);
set @data1 =(select inscriere.data_renuntare from inscriere where inscriere.idstudent=@idstudent and inscriere.idcurs=@idcurs);
	if @data IS NOT NULL then
    if @data1 is NULL then
   
     insert into nota_lab (idlab_nota, idcurs) 
		values (@ordineNote,@idcurs);
	insert into nota_seminar (idseminar_nota, idcurs) 
		values (@ordineNote, @idcurs);
		insert into nota_curs (idcurs_nota, idcurs)
		values (@ordineNote,@idcurs);
        
         insert into note_student
    values (@idstudent, @idcurs, @idcurs, @ordineNote,@idcurs);
	
       
    update nota_seminar set  nota_seminar.sem = @idseminar where nota_seminar.idseminar_nota=@ordineNote;
	update nota_curs set  nota_curs.curs = @idcurs where nota_curs.idcurs_nota=@ordineNote;
	update nota_lab set  nota_lab.lab = @idlaborator where nota_lab.idlab_nota=@ordineNote;
    
    update nota_seminar set  nota_seminar.nota_seminar = notas where nota_seminar.sem=@idseminar and nota_seminar.idseminar_nota=@ordineNote; 
	update nota_curs set  nota_curs.nota_curs = notac where nota_curs.curs=@idcurs and nota_curs.idcurs_nota=@ordineNote;
	update nota_lab set  nota_lab.nota_lab = notal where nota_lab.lab=@idlaborator and nota_lab.idlab_nota=@ordineNote;
    
    
    
    update nota_seminar set nota_seminar.idstudent = @idstudent where nota_seminar.sem=@idseminar and nota_seminar.idseminar_nota=@ordineNote; 
	update nota_curs set  nota_curs.idstudent = @idstudent where nota_curs.curs=@idcurs and nota_curs.idcurs_nota=@ordineNote;
	update nota_lab set  nota_lab.idstudent = @idstudent where nota_lab.lab=@idlaborator and nota_lab.idlab_nota=@ordineNote;
    end if;
    end if;
end; //

drop procedure if exists addProcente
DELIMITER //
CREATE PROCEDURE addProcente( in nume varchar(45),in curspr int, in seminarpr int, in labpr int)
begin
set @id =(select activitati.idcurs from activitati, curs where curs.nume_curs=nume and curs.idcurs=activitati.idcurs);
update activitati set activitati.laboratorpr=labpr where activitati.idcurs=@id;
update activitati set activitati.seminarpr=seminarpr where activitati.idcurs=@id;
update activitati set activitati.curspr=curspr where activitati.idcurs=@id;
end; //


drop procedure if exists studentGroup
DELIMITER //
CREATE PROCEDURE studentGroup( in nume_stud varchar(20),in CNP varchar(13), in nume_grup varchar(20))
begin
SET @idstudent1 = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               and  student.CNP = CNP);

#select @idstudent1;
               
               
set @idcurs1 = ( SELECT grup_studiu.idcurs
                from grup_studiu
                where grup_studiu.nume = nume_grup );
                
set @ID=( SELECT MAX(relatii_grup.idrelatii_grup) FROM relatii_grup) + 1;
if @ID IS NULL then
set @ID=1;
end if;
set @idstudent =(select idstudent from inscriere where inscriere.idstudent=@idstudent1 and inscriere.idcurs=@idcurs1);
SET @nrStudActual =(select nr_actual_stud from grup_studiu where grup_studiu.idcurs=@idcurs1 and grup_studiu.nume = nume_grup);
SET @nrStudMax =(select nr_max_studenti from grup_studiu where grup_studiu.idcurs=@idcurs1  and grup_studiu.nume = nume_grup);
SET @idgrup = (select idgrup from grup_studiu where grup_studiu.idcurs=@idcurs1  and grup_studiu.nume = nume_grup);
if @idstudent is not null then
  if(@nrStudActual<@nrStudMax) then
   insert into relatii_grup values (@ID, @idstudent, @idgrup);
   update grup_studiu set grup_studiu.nr_actual_stud= grup_studiu.nr_actual_stud+1 where grup_studiu.idcurs= @idcurs1  and grup_studiu.nume = nume_grup;
 end if;
 end if;
end; //

drop procedure if exists studentRegistration
DELIMITER //
CREATE PROCEDURE studentRegistration( in nume_stud varchar(20 ), in CNP_stud varchar(13), in nume_prof varchar(20), in nume_curs varchar(45))
begin
SET @idstudent1 = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
              
               and  student.cnp = CNP_stud);
SET @idprofesor1 = (SELECT profesor.idprofesor
               from curs,info_profesor,profesor
               where profesor.nume = nume_prof
               
               and curs.idcurs = info_profesor.idcurs
			   and info_profesor.idprofesor = profesor.idprofesor
               and curs.nume_curs = nume_curs);
set @idcurs1 = ( SELECT curs.idcurs
                from curs,info_profesor,profesor
                where curs.nume_curs = nume_curs
                and curs.idcurs = info_profesor.idcurs
                and info_profesor.idprofesor = profesor.idprofesor
                and profesor.nume = nume_prof
               );
set @data_inscriere1 = curdate();
set @ID=( SELECT MAX(orar_student.idorar_student) FROM orar_student) + 1;
if @ID IS NULL then
set @ID=1;
end if;

set @ID1=( SELECT MAX(inscriere.idinscriere) FROM inscriere) + 1;
if @ID1 IS NULL then
set @ID1=1;
end if;

SET @nrStudActual =(select nr_actual_studenti from curs where curs.idcurs=@idcurs1);
SET @nrStudMax =(select nr_max_studenti from curs where curs.idcurs=@idcurs1);

set @ziualab= (select zi_lab from activitati  where activitati.idcurs=@idcurs1);
set @ziuacurs= (select zi_curs from activitati where activitati.idcurs=@idcurs1);
set @ziuasem= (select zi_sem from activitati where activitati.idcurs=@idcurs1);

set @oracurs= (select ora_curs from activitati where activitati.idcurs=@idcurs1);
set @oralab= (select ora_lab from activitati where activitati.idcurs=@idcurs1);
set @orasem= (select ora_sem from activitati where activitati.idcurs=@idcurs1);

-- set @ziualab1= (select zi_lab from orar_student  where   orar_student.idstudent=idstudent1 and @ziualab=orar_student.zi_lab and @oralab<>orar_student.ora_lab);
-- set @ziuacurs1= (select zi_curs from orar_student where      orar_student.idstudent=idstudent1 and @ziuacurs=orar_student.zi_curs and @oracurs<>orar_student.ora_curs);
-- set @ziuasem1= (select zi_sem from orar_student where   orar_student.idstudent=idstudent1 and  @ziuasem=orar_student.zi_sem and @orasem<>orar_student.ora_sem);
 set @oracurs1=NULL;
set @oralab1= NULL;
set @orasem1= NULL;

set @idstud =  (select count(orar_student.idstudent) from orar_student where orar_student.idstudent= @idstudent1);
#(select orar_student.idstudent from orar_student where orar_student.idstudent= @idstudent1);
if(@idstud >0 ) then
if(@ziuacurs="Luni")then
set @oracurs1= (select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Luni" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Luni" and  @oracurs=orar_student.ora_sem) or (orar_student.zi_lab="Luni" and  @oracurs=orar_student.ora_lab)));
end if;
-- (select ora_curs from orar_student where  orar_student.idstudent=idstudent1 and (orar_student.zi_curs="Luni" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Luni" and @orasem=orar_student.ora_curs) or (orar_student.zi_lab="Luni" and @oralab=orar_student.ora_curs));
 
 if(@ziuacurs="Marti")then
set @oracurs1= (select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Marti" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Marti" and @oracurs=orar_student.ora_sem) or (orar_student.zi_lab="Marti" and @oracurs=orar_student.ora_lab)));
end if;
#(select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Marti" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Marti" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Marti" and @oralab=orar_student.ora_lab)));
if(@ziuacurs="Miercuri")then
set @oracurs1= (select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Miercuri" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Miercuri" and  @oracurs=orar_student.ora_sem) or (orar_student.zi_lab="Miercuri" and @oralab=orar_student.ora_lab)));
end if;

if(@ziuacurs="Joi")then
set @oracurs1= (select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Joi" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Joi" and  @oracurs=orar_student.ora_sem) or (orar_student.zi_lab="Joi" and  @oracurs=orar_student.ora_lab)));
end if;

if(@ziuacurs="Vineri")then
set @oracurs1= (select ora_curs from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Vineri" and @oracurs=orar_student.ora_curs) or (orar_student.zi_sem="Vineri" and  @oracurs=orar_student.ora_sem) or (orar_student.zi_lab="Vineri" and  @oracurs=orar_student.ora_lab)));
end if;

--
if(@ziualab="Luni")then
set @oralab1= (select ora_lab from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Luni" and @oralab=orar_student.ora_curs) or (orar_student.zi_sem="Luni" and @oralab=orar_student.ora_sem) or (orar_student.zi_lab="Luni" and @oralab=orar_student.ora_lab)));
end if;
 
 if(@ziualab="Marti")then
set @oralab1= (select ora_lab from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Marti" and @oralab=orar_student.ora_curs) or (orar_student.zi_sem="Marti" and @oralab=orar_student.ora_sem) or (orar_student.zi_lab="Marti" and @oralab=orar_student.ora_lab)));
end if;

if(@ziualab="Miercuri")then
set @oralab1= (select ora_lab from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Miercuri" and @oralabs=orar_student.ora_curs) or (orar_student.zi_sem="Miercuri" and @oralab=orar_student.ora_sem) or (orar_student.zi_lab="Miercuri" and @oralab=orar_student.ora_lab)));
end if;

if(@ziualab="Joi")then
set @oralab1= (select ora_lab  from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Joi" and @oralab=orar_student.ora_curs) or (orar_student.zi_sem="Joi" and @oralab=orar_student.ora_sem) or (orar_student.zi_lab="Joi" and @oralab=orar_student.ora_lab)));
end if;

if(@ziualab="Vineri")then
set @oralab1= (select ora_lab  from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Vineri" and @oralab=orar_student.ora_curs) or (orar_student.zi_sem="Vineri" and @oralab=orar_student.ora_sem) or (orar_student.zi_lab="Vineri" and @oralab=orar_student.ora_lab)));
end if;
-- (select ora_lab  from orar_student where  orar_student.idstudent=idstudent1 and (orar_student.zi_curs="Vineri" and @oracurs=orar_student.ora_lab) or (orar_student.zi_sem="Vineri" and @orasem=orar_student.ora_lab) or (orar_student.zi_lab="Vineri" and @oralab=orar_student.ora_lab));


if(@ziuasem="Luni")then
set @orasem1= (select ora_sem from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Luni" and @orasem=orar_student.ora_curs) or (orar_student.zi_sem="Luni" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Luni" and @orasem=orar_student.ora_lab)));
end if;
 
 if(@ziuasem="Marti")then
set @orasem1= (select ora_sem from orar_student where orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Marti" and @orasem=orar_student.ora_curs) or (orar_student.zi_sem="Marti" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Marti" and @orasem=orar_student.ora_lab)));
end if;
-- select ora_sem from orar_student where  orar_student.idstudent=idstudent1 and (orar_student.zi_sem="Marti" and @orasem=orar_student.ora_sem);
if(@ziuasem="Miercuri")then
set @orasem1= (select ora_sem from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Miercuri" and @orasem=orar_student.ora_curs) or (orar_student.zi_sem="Miercuri" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Miercuri" and @oralab=orar_student.ora_lab)));
end if;

if(@ziuasem="Joi")then
set @orasem1= (select ora_sem  from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Joi" and @orasem=orar_student.ora_curs) or (orar_student.zi_sem="Joi" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Joi" and @orasem=orar_student.ora_lab)));
end if;

if(@ziuasem="Vineri")then
set @orasem1= (select ora_sem  from orar_student where  orar_student.idstudent=@idstudent1 and ((orar_student.zi_curs="Vineri" and @orasem=orar_student.ora_curs) or (orar_student.zi_sem="Vineri" and @orasem=orar_student.ora_sem) or (orar_student.zi_lab="Vineri" and @orasem=orar_student.ora_lab)));
end if;
--
end if;

 
if((@oracurs1 is null) and (@orasem1 is  null) and (@oralab1 is null)) then
  if(@nrStudActual<@nrStudMax) then
insert into inscriere (idinscriere, idstudent, idprofesor,idcurs,data_inscriere) 
values  (@ID1, @idstudent1, @idprofesor1,@idcurs1,@data_inscriere1);
update curs set curs.nr_actual_studenti= curs.nr_actual_studenti+1 where curs.idcurs= @idcurs1;
insert into orar_student values(@ID, @idstudent1, @idcurs1, @ziuacurs, @ziualab, @ziuasem, @oracurs, @oralab, @orasem);
end if;
end if;
end; //

drop procedure if exists studentToAGroupActivity
DELIMITER //
CREATE PROCEDURE studentToAGroupActivity(in nume_stud varchar(20),in CNP varchar(15), in nume_grup varchar(40), in nume_activ varchar(70))
begin
set @ID=( SELECT MAX(studenti_activitate.idstudenti_activitate) FROM studenti_activitate) + 1;
if @ID IS NULL then
set @ID=1;
end if;
SET @idstud = (SELECT student.idstudent
from student
where student.nume = nume_stud
and student.cnp = CNP);
set @idgrup =(select idgrup from grup_studiu where grup_studiu.nume=nume_grup);
set @idstud1 = (select relatii_grup.idstudent from relatii_grup where relatii_grup.idstudent=@idstud and relatii_grup.idgrup=@idgrup);
set @idactiv= (select idactiv_grup from activ_grup where nume_activ=activ_grup.activ_grupcol and activ_grup.id_grup_studiu = @idgrup);

if(@idstud is not null)then
update activ_grup set activ_grup.nr_actual = activ_grup.nr_actual+1 where nume_activ=activ_grup.activ_grupcol and activ_grup.id_grup_studiu = @idgrup;
insert into studenti_activitate values(@ID, @idstud, @idactiv, @idgrup);
end if;
end; //

drop procedure if exists deletecurs
DELIMITER //
CREATE PROCEDURE deletecurs( in nume_curs varchar(45), in nume_prof varchar(20), in prenume_prof varchar(20))
BEGIN
set @idcurs = ( SELECT curs.idcurs
                from curs,info_profesor,profesor
                where curs.nume_curs = nume_curs
                and curs.idcurs = info_profesor.idcurs
                and info_profesor.idprofesor = profesor.idprofesor
                and profesor.nume = nume_prof
                and profesor.prenume = prenume_prof );
DELETE curs , activitati 
 FROM curs  INNER JOIN activitati 
WHERE curs.idcurs= activitati.idcurs 
and curs.idcurs = @idcurs;
END; //


drop procedure if exists deleteprofesor
DELIMITER //
CREATE PROCEDURE deleteprofesor(in nume varchar(20), in prenume varchar(20),in cnp varchar(13))
BEGIN
SET @idprof = (SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume
               and profesor.prenume = prenume
               and  profesor.cnp = CNP);
DELETE  
FROM profesor
WHERE profesor.idprofesor = @idprof;
END; //

drop procedure if exists deleteadmin
DELIMITER //
CREATE PROCEDURE deleteadmin(in nume varchar(20), in prenume varchar(20),in cnp varchar(13))
BEGIN
SET @idadm = (SELECT administrator.idadmin
               from administrator
               where administrator.nume = nume 
               and administrator.prenume = prenume
               and  administrator.cnp = cnp);
DELETE FROM administrator 
WHERE
    administrator.idadmin = @idadm;

END; //






drop procedure if exists dropCourse
DELIMITER //
CREATE PROCEDURE dropCourse(in curs1 varchar(20), in data_renuntare varchar(10), in idStud int)
begin
set @id =(select curs.idcurs from curs where curs.nume_curs= curs1);
update curs set curs.nr_actual_studenti= curs.nr_actual_studenti-1 where curs.idcurs = @id;
update inscriere set inscriere.data_renuntare=data_renuntare  where inscriere.idstudent = idStud and inscriere.idcurs=@id;
end; //

drop procedure if exists dropStudyGroup
DELIMITER //
CREATE PROCEDURE dropStudyGroup(in nume_stud varchar(20),in CNP varchar(13), in nume_grup varchar(20))
begin
SET @idstudent = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               and  student.cnp = CNP);
set @idcurs = ( SELECT grup_studiu.idcurs
                from grup_studiu
                where grup_studiu.nume = nume_grup );
set @idgrup = (SELECT grup_studiu.idgrup
               from grup_studiu
               where grup_studiu.nume = nume_grup );
set @nr_actual = (select grup_studiu.nr_actual_stud
                 from grup_studiu
				 where grup_studiu.nume = nume_grup );
set @idrelatii = (SELECT relatii_grup.idrelatii_grup
                  from relatii_grup
                  where relatii_grup.idstudent = @idstudent
                  and relatii_grup.idgrup = @idgrup);
if @idrelatii is not null then
if @idstudent is not null then
update grup_studiu set grup_studiu.nr_actual_stud = @nr_actual-1 where grup_studiu.idcurs= @idcurs  and grup_studiu.nume = nume_grup;
delete relatii_grup from relatii_grup where relatii_grup.idgrup = @idgrup and relatii_grup.idstudent = @idstudent;
end if;
 end if;
end; //

drop procedure if exists membersGroup;
DELIMITER //
CREATE PROCEDURE membersGroup( in nume_grup varchar(20))
BEGIN
set @idgrup = (SELECT idgrup_studiu from grup_studiu where grup_studiu.nume = nume_grup );
select student.nume, student.prenume
from student,relatii_grup
where student.idstudent = relatii_grup.idstudent
and relatii_grup.idgrup = @idgrup;
END; //

drop procedure if exists obtinmaterie
DELIMITER //
CREATE PROCEDURE obtinmaterie(in nume_prof varchar(45))
BEGIN
SELECT curs.nume_curs FROM curs,profesor,info_profesor WHERE nume_prof = profesor.nume AND profesor.idprofesor = info_profesor.idprofesor AND curs.idcurs = info_profesor.idcurs;
end; //

drop procedure if exists obtinidprof
DELIMITER //
CREATE PROCEDURE obtinidprof(in nume_prof varchar(45))
BEGIN
SELECT profesor.idprofesor FROM profesor WHERE nume_prof = profesor.nume;
end; //

drop procedure if exists obtinidstud
DELIMITER //
CREATE PROCEDURE obtinidstud(in nume_st varchar(45))
BEGIN
SELECT student.idstudent FROM student WHERE nume_st = student.nume;
end; //

drop procedure if exists selectUser
DELIMITER //
CREATE PROCEDURE selectUser(in tblName1 varchar (50), in nume varchar(45), in prenume varchar(20), in cnp varchar(15))
begin
  SET @ddl = CONCAT(' SELECT * FROM ', tblName1, ' where ' , tblName1, '.CNP="', cnp, '" and ',  tblName1,'.nume="', nume, '" and ',  tblName1,'.prenume="', prenume,'";');
  PREPARE STMT FROM @ddl;
  EXECUTE STMT;
END; //


drop procedure if exists showActivitati
DELIMITER //
CREATE PROCEDURE showActivitati( in nume_stud varchar(20), in prenume_stud varchar(20), in CNP_stud varchar(13))
begin
SET @idstudent1 = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               and student.prenume = prenume_stud
               and  student.cnp = CNP_stud);


select nume_curs from curs, inscriere where inscriere.idstudent=@idstudent1 and curs.idcurs=inscriere.idcurs;
end; //

drop procedure if exists showCourses
DELIMITER //
CREATE PROCEDURE showCourses( in nume1 varchar(20))
begin
select nume_curs, nume from curs, profesor, info_profesor 
where curs.nume_curs=nume1 
and profesor.idprofesor=info_profesor.idprofesor 
and curs.idcurs=info_profesor.idcurs;
end; //

drop procedure if exists showGroups
DELIMITER //
CREATE PROCEDURE showGroups( in nume_curs varchar(45))
begin
SELECT grup_studiu.nume, grup_studiu.nr_max_studenti,curs.nume_curs
from grup_studiu,curs
where curs.idcurs = (SELECT curs.idcurs 
                      FROM curs
                      WHERE curs.nume_curs = nume_curs )
and grup_studiu.idcurs = curs.idcurs;
end; //

drop procedure if exists showGrupuriStud
DELIMITER //
CREATE PROCEDURE showGrupuriStud( in nume_stud varchar(20), in prenume_stud varchar(20), in CNP_stud varchar(13))
begin
SET @idstudent1 = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               and student.prenume = prenume_stud
               and  student.cnp = CNP_stud);

select nume from grup_studiu, relatii_grup where relatii_grup.idstudent=@idstudent1 and grup_studiu.idgrup=relatii_grup.idgrup;
end; //

drop procedure if exists showInfoAdmin
DELIMITER //
CREATE PROCEDURE showInfoAdmin( in nume varchar(13))
begin
SELECT *
FROM administrator
WHERE nume = administrator.nume;
end; //

drop procedure if exists showInfoProf
DELIMITER //
CREATE PROCEDURE showInfoProf( in nume varchar(13))
begin
SELECT *
FROM profesor
WHERE nume = profesor.nume;
end; //

drop procedure if exists showInfoStud
DELIMITER //
CREATE PROCEDURE showInfoStud( in nume varchar(13))
begin
SELECT *
FROM student
WHERE nume = student.nume;
end; //

drop procedure if exists showInfoSuperAdmin
DELIMITER //
CREATE PROCEDURE showInfoSuperAdmin( in nume varchar(13))
begin
SELECT *
FROM superadmin
WHERE nume = superadmin.nume;
end; //

drop procedure if exists showNotes
DELIMITER //
CREATE PROCEDURE showNotes(in nume_stud varchar(20))
begin
SET @idstud = (SELECT student.idstudent
               from student
               where student.nume = nume_stud 
               );
select distinct  nume_curs, nota_curs, nota_lab, nota_seminar from curs, nota_curs, nota_lab, nota_seminar, student, note_student, inscriere 
where @idstud=student.idstudent and student.idstudent = note_student.idstudent 
and student.idstudent =  inscriere.idstudent 
and note_student.idlab=nota_lab.idcurs
and note_student.idcurs=nota_curs.idcurs 
and note_student.idseminar=nota_seminar.idcurs
and note_student.idcurs=curs.idcurs;
end; //

drop procedure if exists showOrarProf
DELIMITER //
CREATE PROCEDURE showOrarProf(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin

select ora_lab from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_lab=zi;
select ora_sem from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_sem=zi;
select ora_curs from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_curs=zi;
end; //

drop procedure if exists showOrarProfCurs
DELIMITER //
CREATE PROCEDURE showOrarProfCurs(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin
select ora_curs from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_curs=zi;
end; //

drop procedure if exists showOrarProfLab
DELIMITER //
CREATE PROCEDURE showOrarProfLab(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin

select ora_lab from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_lab=zi;
end; //

drop procedure if exists showOrarProfSem
DELIMITER //
CREATE PROCEDURE showOrarProfSem(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin
select ora_sem from activitati join (select idcurs from info_profesor where info_profesor.idprofesor=(SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume 
               and profesor.prenume = prenume
               and  profesor.cnp = cnp) ) as curs on activitati.idcurs=curs.idcurs where activitati.zi_sem=zi;
end; //

drop procedure if exists showOrarStud
DELIMITER //
CREATE PROCEDURE showOrarStud( in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in ziua varchar(45))
begin

SELECT orar_student.ora_curs, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_curs = ziua
AND curs.idcurs = orar_student.idcurs;

SELECT orar_student.ora_lab, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_lab = ziua
AND curs.idcurs = orar_student.idcurs;

SELECT orar_student.ora_sem, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_sem = ziua
AND curs.idcurs = orar_student.idcurs;

end; //

drop procedure if exists showOrarStudCurs
DELIMITER //
CREATE PROCEDURE showOrarStudCurs(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin
SELECT orar_student.ora_curs, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_curs = zi
AND curs.idcurs = orar_student.idcurs;
end; //

drop procedure if exists showOrarStudLab
DELIMITER //
CREATE PROCEDURE showOrarStudLab(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin
SELECT orar_student.ora_lab, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_lab = zi
AND curs.idcurs = orar_student.idcurs;
end; //

drop procedure if exists showOrarStudSem
DELIMITER //
CREATE PROCEDURE showOrarStudSem(in nume varchar(20), in prenume varchar(20), in cnp varchar(20), in zi varchar(10))
begin
SELECT orar_student.ora_lab, curs.nume_curs
FROM orar_student,curs
WHERE orar_student.idstudent = (SELECT student.idstudent from student where student.nume = nume and student.prenume = prenume and  student.cnp = cnp)
AND orar_student.zi_sem = zi
AND curs.idcurs = orar_student.idcurs;
end; //

drop procedure if exists updateactivitati
DELIMITER //
CREATE PROCEDURE updateactivitati( in nume varchar(45),in curspr int, in seminarpr int, in labpr int)
begin
set @id =(select activitati.idcurs from activitati, curs where curs.nume_curs=nume and curs.idcurs=activitati.idcurs);
update activitati set activitati.laboratorpr=labpr where activitati.idcurs=@id;
update activitati set activitati.seminarpr=seminarpr where activitati.idcurs=@id;
update activitati set activitati.curspr=curspr where activitati.idcurs=@id;
end; //

drop procedure if exists updatecursuri
DELIMITER //
CREATE PROCEDURE updatecursuri(in nume_prof varchar(20), in prenume_prof varchar(20), in numeinit varchar(45),in nume varchar(45),in descriere varchar(45), in nr_max_stud int,in curspr int, in seminarpr int, in labpr int)
begin

set @idcurs = ( SELECT curs.idcurs
                from curs,info_profesor,profesor
                where curs.nume_curs = numeinit
                and curs.idcurs = info_profesor.idcurs
                and info_profesor.idprofesor = profesor.idprofesor
                and profesor.nume = nume_prof
                and profesor.prenume = prenume_prof );

if nume IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE curs
SET curs.nume_curs = nume
where curs.idcurs = @idcurs; 
end if;

if descriere IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE curs
SET curs.descriere = descriere
where curs.idcurs = @idcurs; 
end if;

if nr_max_stud IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE curs 
SET curs.nr_max_studenti = nr_max_stud
where curs.idcurs = @idcurs; 
end if;

if curspr IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE activitati 
SET activitati.curspr = curspr
where activitati.idcurs = @idcurs; 
end if;

if seminarpr IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE activitati 
SET activitati.seminarpr = seminarpr
where activitati.idcurs = @idcurs; 
end if;

if labpr IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE activitati 
SET activitati.laboratorpr = labpr
where activitati.idcurs = @idcurs; 
end if;
end; //

drop procedure if exists updategrup_studiu
DELIMITER //
CREATE PROCEDURE updategrup_studiu( in nume_init varchar(20), in nume varchar(20), in nr_max_studenti char(10))
begin
SET @idgrup_studiu = (SELECT grup_studiu.idgrup
                      from grup_studiu
                      where grup_studiu.nume = nume_init);
if nume IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE grup_studiu 
SET grup_studiu.nume = nume
where grup_studiu.idgrup = @idgrup_studiu; 
end if;

if nr_max_studenti IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE grup_studiu 
SET grup_studiu.nr_max_studenti = nr_max_studenti
where grup_studiu.idgrup = @idgrup_studiu; 
end if;
end; //

drop procedure if exists updateprofesor
DELIMITER //
CREATE PROCEDURE updateprofesor(in parola varchar(20), in cnp varchar(13), in nume varchar(20), in prenume varchar(20), in adresa varchar(10), in telefon varchar(10), in email varchar(20), in iban varchar (16), in nr_contact varchar(10))
BEGIN
SET @idprof = (SELECT profesor.idprofesor
               from profesor
               where profesor.nume = nume
               and profesor.prenume = prenume
               and  profesor.cnp = cnp);
               
if parola IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.parola = parola
where profesor.idprofesor = @idprof; 
end if;               
               
if cnp IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.cnp = cnp
where profesor.idprofesor = @idprof; 
end if;

if nume IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.nume = nume
where profesor.idprofesor = @idprof; 
end if;

if prenume is not null then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.prenume = prenume
where profesor.idprofesor = @idprof; 
end if;

if(adresa IS NOT null) then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor
SET profesor.adresa = adresa
where profesor.idprofesor = @idprof; 
end if;

if(telefon is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor
SET profesor.telefon = telefon
where profesor.idprofesor = @idprof; 
end if;

if(email is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor
SET profesor.email = email
where profesor.idprofesor = @idprof; 
end if;

if(iban is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.IBAN = iban
where profesor.idprofesor = @idprof; 
end if;

if(nr_contact is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE profesor 
SET profesor.nr_contact = nr_contact
where profesor.idprofesor = @idprof; 
end if;
END; //

drop procedure if exists updatestudent
DELIMITER //
CREATE PROCEDURE updatestudent(in parola varchar(20),in cnp varchar(13), in nume varchar(20), in prenume varchar(20), in adresa varchar(20), in telefon varchar(10), in email varchar(20), in iban varchar (16), in nr_contact varchar(10), in anstudiu int, in nr_ore int)
BEGIN
SET @idstud = (SELECT student.idstudent
               from student
               where student.nume = nume 
               and student.prenume = prenume
               and  student.cnp = cnp);
              
#drop procedure if exists sugestiiParticipanti
#DELIMITER //
#create procedure sugestiiParticipanti(
               
if cnp IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.cnp = cnp
where student.idstudent = @idstud; 
end if;

if nume IS NOT NULL then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.nume = nume
where student.idstudent = @idstud; 
end if;

if prenume is not null then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.prenume = prenume
where student.idstudent = @idstud; 
end if;

if(adresa IS NOT null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.adresa = adresa
where student.idstudent = @idstud; 
end if;


if(parola IS NOT null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.parola = parola
where student.idstudent = @idstud; 
end if;

if(telefon is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student
SET student.telefon = telefon
where student.idstudent = @idstud; 
end if;

if(email is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student
SET student.email = email
where student.idstudent = @idstud; 
end if;

if(iban is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.IBAN = iban
where student.idstudent = @idstud; 
end if;

if(nr_contact is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.nr_contact = nr_contact
where student.idstudent = @idstud; 
end if;

if(anstudiu is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.anstudiu = anstudiu
where student.idstudent = @idstud; 
end if;

if(nr_ore is not null) then
SET SQL_SAFE_UPDATES=0;
UPDATE student 
SET student.nr_ore = nr_ore
where student.idstudent = @idstud; 
end if;
END; //

drop trigger if exists ifDelCurs
DELIMITER //
CREATE TRIGGER ifDelCurs
AFTER DELETE ON curs
FOR EACH ROW
BEGIN
DELETE nota_curs
from nota_curs
where nota_curs.idcurs= old.idcurs;

DELETE nota_lab
from nota_lab
where nota_lab.idcurs = old.idcurs;

DELETE nota_seminar
from nota_seminar
where nota_seminar.idcurs = old.idcurs;

DELETE inscriere
from inscriere
where inscriere.idcurs = old.idcurs;

DELETE info_profesor
from info_profesor
where info_profesor.idcurs = old.idcurs;

END; // 

drop trigger if exists Delgrup
delimiter //
CREATE TRIGGER Delgrup
AFTER DELETE ON grup_studiu
for each row
begin
DELETE relatii_grup
from relatii_grup
where relatii_grup.id_grup = old.idgrup;
end; //