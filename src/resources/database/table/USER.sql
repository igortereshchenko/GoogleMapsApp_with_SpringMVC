-- Create table
create table USERS
(
  USER_NAME      VARCHAR2(30) not null,
  USER_PHONE     NUMBER(10) not null,
  USER_EMAIL     VARCHAR2(250),
  USER_BIRTHDATE DATE
);


-- Create/Recreate primary, unique and foreign key constraints 
alter table USERS
  add constraint PK_USER_PHONE unique (USER_PHONE) ;
alter table USERS
  add constraint UNQ_USERS_NAME unique (USER_NAME) ;