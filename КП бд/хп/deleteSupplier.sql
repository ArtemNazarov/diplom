USE [toy_factory]
GO
CREATE PROC DeleteSupplier (@ID int)
AS
	IF EXISTS (SELECT * 
				FROM Suppliers
				WHERE @ID=ID)
	DELETE FROM Suppliers
	WHERE @ID=ID
	ELSE
		PRINT '���������� � ����� ID �� ���������!'

EXEC DeleteSupplier 12