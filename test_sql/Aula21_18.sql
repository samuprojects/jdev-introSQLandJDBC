select * from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id

select numero, nome from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id

select * from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id
where userp.id = 8

select nome, numero, email from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id
where userp.id = 8

select * from telefoneuser