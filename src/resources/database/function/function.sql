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