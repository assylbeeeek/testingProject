update TEST_PRODUCT set NAME = '' where NAME is null ;
alter table TEST_PRODUCT alter column NAME set not null ;
update TEST_PRODUCT set QUANTITY = 0 where QUANTITY is null ;
alter table TEST_PRODUCT alter column QUANTITY set not null ;
update TEST_PRODUCT set PRICE = 0 where PRICE is null ;
alter table TEST_PRODUCT alter column PRICE set not null ;
