alter table TEST_CONTACT add column EMAIL varchar(255) ;
alter table TEST_CONTACT add column NUMBER_ varchar(255) ;
update TEST_CONTACT set CONTACT_TYPE = 10 where CONTACT_TYPE is null ;
alter table TEST_CONTACT alter column CONTACT_TYPE set not null ;
