-- to update address by JAIPUR for addressline2 column in members table
UPDATE members SET addressline2="JAIPUR";


-- to show members table
SELECT * FROM members;


-- to update addressline1 by EPIP Sitapura where category column in members have F
UPDATE members SET addressline1="EPIP Sitapura" where category='F';


-- to show members table
SELECT * FROM members;


-- to delete all the rows from publisher table
DELETE FROM publisher;

SELECT * FROM publisher;


-- set subtitution variable
SET @publication_name1:='SHARMA';
SET @publication_name2:='JAIN';
SET @publication_name3:='MITTAL';
SET @publication_name4:='PANDIT'; 

SET @pblisherID1:=1001;
SET @pblisherID2:=1002;
SET @pblisherID3:=1003;
SET @pblisherID4:=1004;


-- again insert values in publishers by substitution variable
INSERT INTO publisher(publisher_id,publisher_name)VALUES(@pblisherID1,@publication_name1);
INSERT INTO publisher(publisher_id,publisher_name)VALUES(@pblisherID2,@publication_name2);
INSERT INTO publisher(publisher_id,publisher_name)VALUES(@pblisherID3,@publication_name3);
INSERT INTO publisher(publisher_id,publisher_name)VALUES(@pblisherID4,@publication_name4);

SELECT * FROM publisher;
