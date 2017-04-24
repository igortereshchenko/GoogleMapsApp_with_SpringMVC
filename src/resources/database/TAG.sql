-- Create table TAG
create table TAG
(
  TAG_NAME        VARCHAR2(30) not null,
  TAG_NAME_PARENT_FK VARCHAR2(30) not null,
  TAG_DISCRIPTION VARCHAR2(250)
) ;

-- Create/Recreate primary, unique and foreign key constraints
alter table TAG
  add constraint PK_TAG primary key (TAG_NAME) ;

alter table TAG
  add constraint FK_TAG
foreign key (TAG_NAME_PARENT_FK)
references TAG(TAG_NAME);

