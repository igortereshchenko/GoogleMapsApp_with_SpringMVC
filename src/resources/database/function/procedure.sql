/*повертає користувачів, тег і витрати по тегу
 а вхідний параметр - це період*/
CREATE OR REPLACE PROCEDURE GetUserExpenses
(
dateFrom DATE, 
dateTill DATE
)
IS
BEGIN
  
FOR rec IN (
            
            select u.USER_NAME as user_name, et.TAG_NAME_FK as tag_name, sum(ue.COLUMNUSEREXPERSES_COUNT) as summa
            from USERS u     
            join USEREXPENSES ue on ue.user_phone_fk = u.user_phone
            join USEREXPENSESTAG et on et.user_expenses_id_fk = ue.userexpenses_id
            where ue.userexperses_date between dateFrom and dateTill
            group by u.USER_NAME, et.TAG_NAME_FK
           )
LOOP
   INSERT INTO UserExpensesSession(user_name, tag_name, SUMMA) VALUES (rec.user_name, rec.tag_name, rec.summa);
END LOOP;

END;