-- Create table
create table USEREXPENSES
(
  USEREXPENSES_ID   NUMBER(5) not null,
  USER_PHONE_FK     NUMBER(5) not null,
  PLACEPOINT_ID_FK  NUMBER(5) not null,
  USEREXPERSES_DATE DATE default SYSDATE not null
) ;

-- Create/Recreate primary, unique and foreign key constraints 
alter table USEREXPENSES
  add constraint PK_USEREXPENSES_ID primary key (USEREXPENSES_ID) ;
alter table USEREXPENSES
  add constraint UNQ_USEREXPENSES unique (USER_PHONE_FK, PLACEPOINT_ID_FK, USEREXPERSES_DATE) ;
alter table USEREXPENSES
  add constraint FK_PLACEPOINT_ID_FK foreign key (PLACEPOINT_ID_FK)
  references PLACEPOINT (PLACEPOINT_ID);
alter table USEREXPENSES
  add constraint FK_USER_PHONE_FK foreign key (USER_PHONE_FK)
  references USERS_ (USER_PHONE);