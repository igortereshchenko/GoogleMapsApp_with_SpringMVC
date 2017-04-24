-- Create table
create table USEREXPENSESTAG
(
  TAG_NAME_FK         VARCHAR2(30) not null,
  USER_EXPENSES_ID_FK NUMBER(5) not null
) ;
-- Create/Recreate primary, unique and foreign key constraints 
alter table USEREXPENSESTAG
  add constraint FK_TAG_NAME_FK foreign key (TAG_NAME_FK)
  references TAG (TAG_NAME);
alter table USEREXPENSESTAG
  add constraint FK_USER_EXPENSES_ID_FK foreign key (USER_EXPENSES_ID_FK)
  references USEREXPENSES (USEREXPENSES_ID);