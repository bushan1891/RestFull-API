CREATE TABLE rest_db.resturant (
  CON_ID int(11) NOT NULL AUTO_INCREMENT,
  FIRST_NAME varchar(45) DEFAULT NULL,
  LAST_NAME varchar(45) DEFAULT NULL,
  EMAIL varchar(50) DEFAULT NULL,
  RES_DATE  date() ,	
  PHONE varchar(10) DEFAULT NULL,
  PRIMARY KEY (CON_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

INSERT INTO `rest_db`.`resturant`
(`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`RES_DATE`,`PHONE`)
VALUES
('Bushan','nagendra','bush@gma.com','2008-11-11 13:23:44','8587660916'),

('vivek','kumar','bvivke@gmail.com','2008-11-11 13:23:44','4567464563'),

('nihar','patel','gfj@gmail.com','2008-11-11 13:23:44','6754563456');
