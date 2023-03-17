alter table TEST_PRODUCT add constraint FK_TEST_PRODUCT_ON_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID);
alter table TEST_PRODUCT add constraint FK_TEST_PRODUCT_ON_ORDER foreign key (ORDER_ID) references TEST_ORDERS(ID);
create index IDX_TEST_PRODUCT_ON_IMAGE on TEST_PRODUCT (IMAGE_ID);
create index IDX_TEST_PRODUCT_ON_ORDER on TEST_PRODUCT (ORDER_ID);
