USE [toy_factory]
GO
CREATE PROC DeleteOrder (@ID int)
AS
	IF EXISTS (SELECT * 
				FROM Orders
				WHERE @ID=ID)
	DELETE FROM Orders
	WHERE @ID=ID
	ELSE
		PRINT 'Заказчика с таким ID не сущесвует!'

EXEC DeleteOrder 45 