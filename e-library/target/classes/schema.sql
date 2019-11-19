DROP TABLE IF EXISTS E_BOOK;
DROP TABLE IF EXISTS E_LIBRARIAN;
DROP TABLE IF EXISTS E_ISSUEBOOK;

--create table customer
--(
--   id integer(5) not null AUTO_INCREMENT,
--   customer_code varchar(15) not null,
--   name varchar(40),
--   email varchar(40),
--   ph_number varchar2(10),
--   status character(1),
--   created_on date,
--   updated_on date,
--   primary key(id)
--);

CREATE TABLE  E_BOOK
   (	CALLNO VARCHAR(400), 
	NAME VARCHAR(400), 
	AUTHOR VARCHAR(400), 
	PUBLISHER VARCHAR(400), 
	QUANTITY INTEGER, 
	ISSUED INTEGER, 
	 PRIMARY KEY (CALLNO)
   );
   
CREATE TABLE  E_LIBRARIAN 
   (	ID INTEGER not null AUTO_INCREMENT, 
	NAME VARCHAR(400), 
	PASSWORD VARCHAR(400), 
	EMAIL VARCHAR(400), 
	MOBILE VARCHAR(10), 
	 PRIMARY KEY (ID)
   );
   
CREATE TABLE  E_ISSUEBOOK 
   (	CALLNO VARCHAR(400) NOT NULL, 
	STUDENTID VARCHAR(400) NOT NULL, 
	STUDENTNAME VARCHAR(400), 
	STUDENTMOBILE INTEGER, 
	ISSUEDDATE DATE, 
	RETURNSTATUS VARCHAR(400)
   );   