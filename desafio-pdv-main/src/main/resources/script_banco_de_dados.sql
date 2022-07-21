
CREATE TABLE public.empresa (
	id_empresa int8 NOT NULL,
	nome_fantasia varchar(50) NOT NULL,
	razao_social varchar(100) NOT NULL,
	cnpj varchar(14) NOT NULL,
	telefone varchar(11) NULL,
	responsavel_legal varchar(50) NULL,
	CONSTRAINT empresa_pk PRIMARY KEY (id_empresa),
	CONSTRAINT empresa_un UNIQUE (cnpj)
);

CREATE TABLE public.cliente (
	id_cliente int8 NOT NULL,
	nome varchar(50) NULL,
	cpf varchar(11) NOT NULL,
	telefone varchar(11) NOT NULL,
	id_empresa int8 NULL,
	CONSTRAINT cliente_pk PRIMARY KEY (id_cliente),
	CONSTRAINT cliente_un UNIQUE (cpf, id_empresa),
	CONSTRAINT cliente_fk FOREIGN KEY (id_empresa) REFERENCES public.empresa(id_empresa)
);

CREATE TABLE public.cliente_endereco (
	id_endereco int8 NOT NULL,
	id_cliente int8 NOT NULL,
	cep varchar NULL,
	logradouro varchar(76) NOT NULL,
	numero varchar(36) NOT NULL,
	complemento varchar(36) NULL,
	bairro varchar(36) NOT NULL,
	cidade varchar(36) NOT NULL,
	uf varchar(2) NOT NULL,
	CONSTRAINT cliente_endereco_pk PRIMARY KEY (id_endereco),
	CONSTRAINT cliente_endereco_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente)
);

CREATE TABLE public.produto (
	id_produto int8 NOT NULL,
	produto varchar(30) NOT NULL,
	descricao varchar(100) NULL,
	valor_base float8 NOT NULL,
	imagem_produto bytea NULL,
	id_empresa int8 NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id_produto),
	CONSTRAINT produto_un UNIQUE (produto, id_empresa),
	CONSTRAINT produto_fk FOREIGN KEY (id_empresa) REFERENCES public.empresa(id_empresa)
);

CREATE TABLE public.venda (
	id_venda int8 NOT NULL,
	id_cliente int8 NOT NULL,
	id_empresa int8 NOT NULL,
	dt_venda timestamp(0) NOT NULL,
	valor_total float8 NOT NULL DEFAULT 0.0,
	valor_desconto float8 NOT NULL DEFAULT 0.0,
	valor_acrescimo float8 NOT NULL DEFAULT 0.0,
	valor_pago float8 NOT NULL DEFAULT 0.0,
	metodo_pagamento varchar(20) NOT NULL,
	CONSTRAINT venda_pk PRIMARY KEY (id_venda),
	CONSTRAINT venda_fk FOREIGN KEY (id_empresa) REFERENCES public.empresa(id_empresa),
	CONSTRAINT venda_fk_1 FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente)
);

CREATE TABLE public.venda_produto (
	id_venda int8 NOT NULL,
	id_produto int8 NOT NULL,
	valor_unitario float8 NOT NULL,
	qtd int4 NOT NULL,
	valor_total float8 NOT NULL,
	CONSTRAINT venda_produto_pk PRIMARY KEY (id_venda, id_produto),
	CONSTRAINT venda_produto_fk FOREIGN KEY (id_venda) REFERENCES public.venda(id_venda),
	CONSTRAINT venda_produto_fk_1 FOREIGN KEY (id_produto) REFERENCES public.produto(id_produto)
);
