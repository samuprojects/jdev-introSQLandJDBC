delete from userposjava where id = 9 -- não funciona pois a tabela filho tem dados atrelados

delete from telefoneuser where usuariopessoa = 9 -- aqui exclui os dados da tabela filho e libera o comando acima

select * from userposjava -- restará apenas um usuário com telefones

select * from telefoneuser -- restará apenas os dados filhos do usuario que restou

-- a próxima exclusão será feita diretamente em Java na IDE