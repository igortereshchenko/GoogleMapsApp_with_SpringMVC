create or replace PACKAGE userExpenses_pkg
IS

  type userExpenses_row1 is record(
    userexpersescount UserExpenses.userexpenses_count%TYPE,
    tag_name tag.tag_name%TYPE);

  type userExpenses_table_info1 is table of userExpenses_row1;

  type userExpenses_row3 is record(
    placepoint_address PlacePoint.placepoint_address%TYPE,
    tag_name tag.tag_name%TYPE,
    expenses_date USEREXPENSES.USEREXPERSES_DATE%TYPE
  );

  type userExpenses_table_info3 is table of userExpenses_row3;


  function GetUserExpenses1(dateFrom DATE, dateTill DATE, user_phone NUMBER)
    return userExpenses_table_info1
  pipelined;

  function GetUserExpenses3(userPhone users.USER_PHONE%type)
    return userExpenses_table_info3
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
      where user_phone = u.user_phone and ue.userexperses_date between dateFrom and dateTill
      group by et.tag_name_fk
      )
      LOOP
        pipe row(userExpenses_iterator);
      END LOOP;
    END;


  /*3)
  входить користувач
  виходить відсортована по даті табличка з полями | адреса | тег | дата*/
  function GetUserExpenses3(
    userPhone users.USER_PHONE%type
  )
    return userExpenses_table_info3
  pipelined
  IS
    BEGIN
      FOR userExpenses_iterator IN
      (
      select DISTINCT pp.placepoint_address as address, et.TAG_NAME_FK as tag_name, ue.USEREXPERSES_DATE as exp_date
      from users u
        join UserExpenses ue on ue.user_phone_fk = u.user_phone
        join UserExpensesTag et on et.user_expenses_id_fk = ue.userexpenses_id
        join PlacePoint pp on pp.placepoint_id = ue.placepoint_id_fk
      where u.USER_PHONE = userPhone
      order by exp_date
      )
      LOOP
        pipe row(userExpenses_iterator);
      END LOOP;
    END;

END;
