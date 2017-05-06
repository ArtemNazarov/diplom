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
		PRINT '���������� � ����� ID �� ���������!'

EXEC DeleteCustomer 11