create database currencyExchnage;
use  currencyExchnage;
create table exchange_value(

id int primary key,
currency_from varchar(10),
currency_to varchar(10),
conversion_multiple decimal
);

ALTER TABLE exchange_value
add column port int;
truncate table exchange_value;
select * from exchange_value;
insert into exchange_value
values(1000,'USD','INR',65,1000);
insert into exchange_value
values(1001,'EUR','INR',60,900);


