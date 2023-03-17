alter table TEST_CONTACT add column CONTACT_TYPE integer ;
alter table TEST_CONTACT add column CONTACT_VALUE varchar(50) ^
update TEST_CONTACT set CONTACT_VALUE = '' where CONTACT_VALUE is null ;
alter table TEST_CONTACT alter column CONTACT_VALUE set not null ;
