CREATE TRIGGER addCustomerTrigger ON Customers
AFTER INSERT
AS
DECLARE @phone char(20)
DECLARE add_with_check_phone CURSOR FORWARD_ONLY
FOR
SELECT Телефон FROM Customers WHERE Телефон NOT LIKE '+7[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
OPEN add_with_check_phone
FETCH NEXT FROM add_with_check_phone INTO @phone
WHILE @@FETCH_STATUS = 0
	BEGIN
		SELECT @phone=Телефон FROM Customers WHERE Телефон NOT LIKE '+7[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		IF @phone IS NOT NULL
		PRINT 'Вы неправильно ввели телефон!'
		ROLLBACK TRANSACTION
		FETCH NEXT FROM add_with_check_phone
		INTO @phone
	END
	CLOSE add_with_check_phone
	DEALLOCATE add_with_check_phone
GO
