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
    NAME varchar(255),
    QUANTITY double precision,
    PRICE double precision,
    DESCRIPTION varchar(255),
    IMAGE_ID uuid,
    ORDER_ID uuid,
    --
    primary key (ID)
);