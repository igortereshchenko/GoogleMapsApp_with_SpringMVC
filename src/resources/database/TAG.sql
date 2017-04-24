-- Create table
create table TAG
(
  TAG_ID          NUMBER(5) not null,
  TAG_NAME        VARCHAR2(30) not null,
  TAG_DISCRIPTION VARCHAR2(250)
) ;


-- Create/Recreate primary, unique and foreign key constraints 
alter table TAG
  add constraint PK_TAG_ID primary key (TAG_ID) ;
alter table TAG
  add constraint UNQ_TAG_NAME unique (TAG_NAME) ;