create table remedio (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    via varchar(100) not null,
    lote tinyint not null,
    quantidade tinyint not null,
    validade date not null,
    laboratorio varchar(100) not null,
    primary key(id)
);