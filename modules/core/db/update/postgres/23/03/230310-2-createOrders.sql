alter table TEST_ORDERS add constraint FK_TEST_ORDERS_ON_ACCOUNT foreign key (ACCOUNT_ID) references TEST_ACCOUNT(ID);
create index IDX_TEST_ORDERS_ON_ACCOUNT on TEST_ORDERS (ACCOUNT_ID);
