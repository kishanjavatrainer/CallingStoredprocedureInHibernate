CREATE PROCEDURE `sp_count_phones` (IN personId INT,OUT phoneCount INT)
BEGIN
SELECT COUNT(*) INTO phoneCount 
        FROM Phone p  
        WHERE p.person_id = personId; 
END
