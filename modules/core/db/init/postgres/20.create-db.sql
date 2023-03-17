-- begin TEST_CONTACT
alter table TEST_CONTACT add constraint FK_TEST_CONTACT_ON_ACCOUNT foreign key (ACCOUNT_ID) references TEST_ACCOUNT(ID)^
create index IDX_TEST_CONTACT_ON_ACCOUNT on TEST_CONTACT (ACCOUNT_ID)^
-- end TEST_CONTACT
-- begin TEST_ACCOUNT
alter table TEST_ACCOUNT add constraint FK_TEST_ACCOUNT_ON_AVATAR foreign key (AVATAR_ID) references SYS_FILE(ID)^
create index IDX_TEST_ACCOUNT_ON_AVATAR on TEST_ACCOUNT (AVATAR_ID)^
-- end TEST_ACCOUNT
-- begin TEST_ORDERS
alter table TEST_ORDERS add constraint FK_TEST_ORDERS_ON_ACCOUNT foreign key (ACCOUNT_ID) references TEST_ACCOUNT(ID)^
create index IDX_TEST_ORDERS_ON_ACCOUNT on TEST_ORDERS (ACCOUNT_ID)^
-- end TEST_ORDERS
-- begin TEST_PRODUCT
alter table TEST_PRODUCT add constraint FK_TEST_PRODUCT_ON_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID)^
alter table TEST_PRODUCT add constraint FK_TEST_PRODUCT_ON_ORDER foreign key (ORDER_ID) references TEST_ORDERS(ID)^
create index IDX_TEST_PRODUCT_ON_IMAGE on TEST_PRODUCT (IMAGE_ID)^
create index IDX_TEST_PRODUCT_ON_ORDER on TEST_PRODUCT (ORDER_ID)^
-- end TEST_PRODUCT
