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
    AMOUNT double precision not null,
    --
    primary key (ID)
);