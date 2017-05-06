USE [toy_factory]
GO
CREATE PROC DeleteEquipment (@ID int)
AS
	IF EXISTS (SELECT * 
				FROM Equipment
				WHERE @ID=ID)
	DELETE FROM Equipment
	WHERE @ID=ID
	ELSE
		PRINT '������������ � ����� ID �� ���������!'

EXEC DeleteEquipment 12