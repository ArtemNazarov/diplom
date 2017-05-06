USE [toy_factory]
GO
CREATE PROC DeleteMaterial (@ID int)
AS
	IF EXISTS (SELECT * 
				FROM Materials
				WHERE @ID=ID)
	DELETE FROM Materials
	WHERE @ID=ID
	ELSE
		PRINT '��������� � ����� ID �� ���������!'
GO
EXEC DeleteMaterial 2