-- Create table
create table PLACEPOINT
(
  PLACEPOINT_ID      NUMBER(5),
  PLACEPOINT_LONG    NUMBER(5) not null,
  PLACEPOINT_LAT     NUMBER(5) not null,
  PLACEPOINT_ADDRESS VARCHAR2(250)
) ;

-- Create/Recreate primary, unique and foreign key constraints 
alter table PLACEPOINT
  add constraint PK_PLACEPOINT_ID primary key (PLACEPOINT_ID) ;
alter table PLACEPOINT
  add constraint UNQ_PLACEPOINT unique (PLACEPOINT_LONG, PLACEPOINT_LAT) ;
-- Create/Recreate check constraints 
alter table PLACEPOINT
  add constraint NN_PLACEPOINT_ID
  check ("PLACEPOINT_ID" IS NOT NULL);