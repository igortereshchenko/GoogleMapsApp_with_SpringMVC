CREATE OR REPLACE PACKAGE userExpenses_pkg
IS
  
  type userExpenses_row1 is record(
        userexpersescount UserExpenses.userexpenses_count%TYPE,
        tag_name tag.tag_name%TYPE
);

  type userExpenses_table_info1 is table of userExpenses_row1;
  
  function GetUserExpenses1(dateFrom DATE, dateTill DATE)
return userExpenses_table_info1
pipelined;
END;

create or replace PACKAGE BODY  userExpenses_pkg 
IS

/*1)
 повертає користувача, тег і витрати по тегу
 а вхідний параметр це період*/
function GetUserExpenses1(
                         dateFrom DATE, 
                         dateTill DATE, 
                         user_phone NUMBER
                        )
return userExpenses_table_info1
pipelined
IS
 BEGIN
    FOR userExpenses_iterator IN 
      (
            select sum(ue.userexpenses_count) as userexpenses_count, et.tag_name_fk as tag_name
            from users u
            join UserExpenses ue on ue.user_phone_fk = u.user_phone
            join UserExpensesTag et on et.user_expenses_id_fk = ue.userexpenses_id
            where ue.userexperses_date between dateFrom and dateTill and user_phone = u.user_phone
            group by et.tag_name_fk 
     )
    LOOP
     pipe row(userExpenses_iterator);
    END LOOP;
  END;


END;
