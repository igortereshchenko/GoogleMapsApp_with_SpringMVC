-- Create table
create global temporary table USEREXPENSESSESSION
(
  USER_NAME          VARCHAR2(30),
  TAG_NAME           VARCHAR2(30),
  SUMMA              NUMBER(30)
)
on commit preserve rows;