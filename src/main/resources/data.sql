insert into tb_venda (id, data) values (1, now());
insert into tb_venda (id, data) values (2, now());
insert into tb_produto (descricao, valor) values ('çola', 234);
insert into tb_produto (descricao, valor) values ('macaco', 300);
insert into tb_itemvenda (quantidade, produto_id, venda_id) values (5, 1,1);
insert into tb_itemvenda (quantidade, produto_id, venda_id) values (2, 2,2);

insert into tb_pessoa (nome, tipo, telefone, cpf) values ('Marcelo', 'F', '67261271282', '03878698754');
insert into tb_pessoa (nome, tipo, telefone, cnpj) values ('CANDANGUIN', 'J', '377384947', '6385774600');