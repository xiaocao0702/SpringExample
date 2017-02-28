use test;
DELIMITER $$
DROP PROCEDURE IF EXISTS `test`.`getRecord` $$
CREATE PROCEDURE `test`.`getRecord` (
IN in_id INTEGER,
OUT out_name VARCHAR(20),
OUT out_age  INTEGER)
BEGIN
   SELECT name, age
   INTO out_name, out_age
   FROM Student where id = in_id;
END $$
DELIMITER ;