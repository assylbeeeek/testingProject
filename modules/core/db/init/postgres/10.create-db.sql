-- begin TEST_CONTACT
create table TEST_CONTACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ACCOUNT_ID uuid,
    CONTACT_TYPE integer not null,
    CONTACT_VALUE varchar(50) not null,
    --
    primary key (ID)
)^
-- end TEST_CONTACT
-- begin TEST_ACCOUNT
create table TEST_ACCOUNT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(100) not null,
    MIDDLE_NAME varchar(100) not null,
    LAST_NAME varchar(100) not null,
    AVATAR_ID uuid,
    --
    primary key (ID)
)^
-- end TEST_ACCOUNT
-- begin TEST_ORDERS
create table TEST_ORDERS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ timestamp not null,
    ACCOUNT_ID uuid not null,
    AMOUNT double precision,
    --
    primary key (ID)
)^
-- end TEST_ORDERS
-- begin TEST_PRODUCT
create table TEST_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    QUANTITY double precision not null,
    PRICE double precision not null,
    DESCRIPTION varchar(255),
    IMAGE_ID uuid,
    ORDER_ID uuid,
    --
    primary key (ID)
)^
-- end TEST_PRODUCT
