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
		PRINT '��������� � ����� ID �� ���������!'

EXEC DeleteOrder 45 