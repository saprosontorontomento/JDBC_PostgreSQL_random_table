# JDBC_PostgreSQL_random_table

## how created
```
create table public.info_user ( 
	id serial primary key,
	first_name character varying(30),
	last_name character varying(30),
	email character varying(30));

create table public.info_pass (
	id serial primary key,
	first_name character varying(30),
	last_name character varying(30),
	pass_num character varying(15),
	phone character varying(15),
	FOREIGN KEY (id) REFERENCES public.info_user (id));

create table public.info_acc (
	id serial primary key,
	login character varying(30),
	password character varying(30),
	email character varying(30),
	creation_date date,
	FOREIGN KEY (id) REFERENCES public.info_user (id),
	FOREIGN KEY (id) REFERENCES public.info_pass (id));
```
 ## test data input
```
INSERT INTO info_user (first_name,last_name,email) VALUES ('Serega', 'Pirat', 'pirat@bk.ru');
INSERT INTO info_user (first_name,last_name,email) VALUES ('Tom', 'Cruze', 'cruzak@bk.ru');
INSERT INTO info_user (first_name,last_name,email) VALUES ('Cheri', 'Lady', 'chericherilady@mail.ru');
INSERT INTO info_user (first_name,last_name,email) VALUES ('Michael', 'Schumacher', 'schumacher@bk.ru');

INSERT INTO info_pass (first_name,last_name,pass_num,phone) VALUES ('serega', 'pirat', '4518 834525', '84561475236');
INSERT INTO info_pass (first_name,last_name,pass_num,phone) VALUES ('Tom', 'Cruze', '4512 478248', '89887523645');
INSERT INTO info_pass (first_name,last_name,pass_num,phone) VALUES ('Cheri', 'Lady', '4509 482848', '89874563275');
INSERT INTO info_pass (first_name,last_name,pass_num,phone) VALUES ('Michael', 'Schumacher', '4578 240895', '87896541235');

INSERT INTO info_acc (login,password,email,creation_date) VALUES ('seregalogin', 'seregapass', 'pirat@bk.ru', '2022-08-02');
INSERT INTO info_acc (login,password,email,creation_date) VALUES ('tomLogin', 'Cruzepass', 'cruzak@bk.ru', '2022-08-02');
INSERT INTO info_acc (login,password,email,creation_date) VALUES ('CheriCheriLady', 'ladycheri', 'chericherilady@mail.ru', '2022-08-02');
INSERT INTO info_acc (login,password,email,creation_date) VALUES ('Schumacher228', 'SchumacherPass', 'schumacher@bk.ru', '2022-08-02');
```
