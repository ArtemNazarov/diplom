USE [toy_factory]
GO
CREATE PROC DeleteCustomer (@ID int)
AS
	IF EXISTS (SELECT * 
				FROM Customers
				WHERE @ID=ID)
	DELETE FROM Customers
	WHERE @ID=ID
	ELSE
		PRINT 'Поставщика с таким ID не сущесвует!'

EXEC DeleteCustomer 11