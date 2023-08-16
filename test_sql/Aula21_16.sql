INSERT INTO public.userposjava(nome, email) VALUES ('João Maria', 'joaomaria@gmail.com');

select * from userposjava

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
	VALUES ('(45) 9 9979-5800', 
			'celular', 8);
			
INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
	VALUES ('(45) 9 8821-2355', 
			'celular', 9);
			
INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
	VALUES ('(45) 9 7845-8454', 
			'celular', 8);
			
INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
	VALUES ('(45) 9 7845-87454', 
			'celular', 9);

INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa)
	VALUES ('(45) 9 7845-787878', 
			'celular', 9);
			
select * from telefoneuser

select * from telefoneuser where usuariopessoa = 9