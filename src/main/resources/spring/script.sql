create table mypersondata (
    id integer primary key auto_increment,
    name varchar(20) not null ,
    mail varchar(50),
    age integer
);

insert into mypersondata (name, mail, age) values ( 'taro', 'taro@yamada', 34 );
insert into mypersondata (name, mail, age) values ( 'hanako', 'hanako@flower', 28 );