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


  
------------------------------------NEXT FILE!!!------------------------------------  

create table USERS
(
  USER_PHONE     NUMBER(10) not null,
  USER_NAME      VARCHAR2(30) not null,
  USER_EMAIL     VARCHAR2(250) not null,
  USER_BIRTHDATE DATE not null
);

-- Create table PLACEPOINT
create table PLACEPOINT
(
  PLACEPOINT_ID      NUMBER(5) not null,
  PLACEPOINT_LONG    NUMBER(5) not null,
  PLACEPOINT_LAT     NUMBER(5) not null,
  PLACEPOINT_ADDRESS VARCHAR2(250) not null
) ;

-- Create table USEREXPENSES
create table USEREXPENSES
(
  USEREXPENSES_ID   NUMBER(5) not null,
  USER_PHONE_FK     NUMBER(5) not null,
  PLACEPOINT_ID_FK  NUMBER(5) not null,
  USEREXPERSES_DATE DATE default SYSDATE not null
) ;

-- Create table USEREXPENSESTAG
create table USEREXPENSESTAG
(
  TAG_NAME_FK         VARCHAR2(30) not null,
  USER_EXPENSES_ID_FK NUMBER(5) not null
) ;



-- Create/Recreate primary, unique and foreign key constraints 
alter table USERS
  add constraint PK_USER_PHONE unique (USER_PHONE) ;
alter table USERS
  add constraint UNQ_USERS_NAME unique (USER_NAME) ;
  
  
  -- Create/Recreate primary, unique and foreign key constraints 
alter table PLACEPOINT
  add constraint PK_PLACEPOINT_ID primary key (PLACEPOINT_ID) ;
alter table PLACEPOINT
  add constraint UNQ_PLACEPOINT unique (PLACEPOINT_LONG, PLACEPOINT_LAT) ;
-- Create/Recreate check constraints 
alter table PLACEPOINT
  add constraint NN_PLACEPOINT_ID
  check ("PLACEPOINT_ID" IS NOT NULL);
  
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
  references USERS (USER_PHONE);
  
  -- Create/Recreate primary, unique and foreign key constraints 
alter table USEREXPENSESTAG
  add constraint FK_TAG_NAME_FK foreign key (TAG_NAME_FK)
  references TAG (TAG_NAME);
alter table USEREXPENSESTAG
  add constraint FK_USER_EXPENSES_ID_FK foreign key (USER_EXPENSES_ID_FK)
  references USEREXPENSES (USEREXPENSES_ID);
  
  
  
  
  --Create FUNCTION
 CREATE OR REPLACE FUNCTION getPlacePointID 
(longitude IN PLACEPOINT.PLACEPOINT_LONG%TYPE, 
 latitude IN PLACEPOINT.PLACEPOINT_LAT%TYPE) RETURN NUMBER
IS
place_point_ID NUMBER;
BEGIN
  SELECT p.PLACEPOINT_ID
  INTO place_point_ID
  FROM PLACEPOINT p
  WHERE longitude = p.PLACEPOINT_LONG AND latitude = p.PLACEPOINT_LAT;
  RETURN(place_point_ID);
END;


CREATE OR REPLACE FUNCTION getUserExpencesID 
(user_phone IN USERS.USER_PHONE%TYPE,
 longitude IN PLACEPOINT.PLACEPOINT_LONG%TYPE, 
 latitude IN PLACEPOINT.PLACEPOINT_LAT%TYPE,
 expenses_date IN USEREXPENSES.USEREXPERSES_DATE%TYPE) RETURN NUMBER
IS
user_expense_ID NUMBER;
place_point_ID NUMBER;
BEGIN
    
  place_point_ID := getPlacePointID(longitude,latitude);
    
  SELECT ue.USEREXPENSES_ID
  INTO user_expense_ID
  FROM USEREXPENSES ue
  WHERE ue.USER_PHONE_FK = user_phone 
        AND ue.PLACEPOINT_ID_FK = place_point_ID
        AND ue.USEREXPERSES_DATE = expenses_date;
        
  RETURN(user_expense_ID);
END;
