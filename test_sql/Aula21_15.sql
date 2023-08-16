alter table userposjava add unique (id);

create table telefoneuser
(
id bigint not null,
numero character varying(255) not null,
tipo character varying (255) not null,
usuariopessoa bigint not null,
constraint telefone_id primary key (id));

alter table telefoneuser add foreign key (usuariopessoa) references userposjava (id)

CREATE SEQUENCE user_telefone_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE user_telefone_seq
  OWNER TO postgres;
  
ALTER TABLE telefoneuser ALTER COLUMN id SET DEFAULT nextval('user_telefone_seq'::regclass);