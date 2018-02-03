DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CreateUsers`(
	OUT p_userCreationOP INT,
	IN p_userName VARCHAR(18),
    IN p_userFname VARCHAR(15),
	IN p_userLname VARCHAR(15),
    IN p_userMailID VARCHAR(50),
    IN p_userMobileNo VARCHAR(10),
    IN p_userType VARCHAR(15)
)
BEGIN
	 DECLARE cntUname,cntMailId,cntMobile tinyINT;
     
   SELECT 
    SUM(userName = p_userName),
    SUM(userMailID = p_userMailID),
    SUM(userMobileNo = p_userMobileNo)
    into cntUname,cntMailId,cntMobile
	FROM tblUser ;
    
    IF cntUname !=0 THEN
		SET p_userCreationOP=-9;
    ELSEIF cntMailId!=0 THEN
		SET p_userCreationOP=-99;
    ELSEIF cntMobile!=0 THEN
		SET p_userCreationOP=-999;
    ELSE
		INSERT INTO tbluser (userName,userFname,userLname,userMailID,userMobileNo,userType)
		VALUES (p_userName,p_userFname,p_userLname,p_userMailID,p_userMobileNo,p_userType);
        
		SELECT userId into p_userCreationOP 
		from tbluser order by 1 desc limit 1;
    END IF;
    
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ForgetPassword`(
	IN p_UserEmail VARCHAR(50),
    IN p_UserMobileNo VARCHAR(10),
    OUT p_UserId INT,
    OUT p_EncryptedPwd VARCHAR(300)
)
BEGIN

    SELECT userId INTO p_UserId
    FROM tblUser
    WHERE (userMailID=p_UserEmail or userMobileNo=p_UserMobileNo);
    
	IF p_UserId > 0 THEN
		select pwdChar into p_EncryptedPwd 
        from tblpassword where usrId=p_UserId;
    ELSE
		SET p_UserId = 0;
        SET p_EncryptedPwd='No Entry Found In Database.';
    END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_UpdatePassword`(
	IN p_UsrID INT,
    IN p_OldPwd VARCHAR(300),
    IN p_NewPwd VARCHAR(300),
    OUT opRes INT
)
BEGIN

	SELECT COUNT(*) into opRes
    FROM tblpassword
    WHERE usrId=p_UsrID and pwdChar=p_OldPwd;
    
    IF opRes !=0 THEN
		UPDATE tblpassword
        SET pwdChar=p_NewPwd
        WHERE usrId=p_UsrID and pwdChar=p_OldPwd;
    ELSE
		SET opRes=0;
    END IF;

END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_UserLogin`(
	IN userIdenInput varchar(50),
    IN userPassword varchar(50),
    OUT userType varchar(20)
)
BEGIN
	
        DECLARE md5pwd VARCHAR(128);
        
        IF  LENGTH(userPassword) > 4 THEN
			SET md5pwd = MD5(userPassword);
		END IF;

		IF LENGTH(md5pwd) > 5 and LENGTH(userIdenInput) > 5 THEN
			select users.userType into userType
			from tbluser users 
			inner join tblpassword userspwd on users.userId=userspwd.usrId
			where (users.userName=userIdenInput or users.userMailID=userIdenInput or users.userMobileNo=userIdenInput)
			and userspwd.pwdChar=md5pwd;
		END IF;

END$$
DELIMITER ;

DELIMITER $$
create trigger after_user_insert
AFTER INSERT ON tbluser
for each row
BEGIN
	INSERT into tblpassword
    SET usrId=NEW.userId,
    usrPwd= reverse(upper(NEW.userName)),
    pwdChar=MD5(reverse(upper(NEW.userName)));
END;