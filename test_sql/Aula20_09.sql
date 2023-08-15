create table userposjava (
id bigint not null,
nome character varying(255),
email character varying (255),
constraint user_pk primary key (id)
)

insert into userposjava (id, nome, email)
values (1, 'alex', 'alex.fernando.egidio@gmail.com')

select * from userposjava

INSERT INTO userposjava(
	id, nome, email)
	VALUES (2, 'samu', 'teste@gmail.com');