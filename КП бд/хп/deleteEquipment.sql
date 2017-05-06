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
		PRINT 'Оборудования с таким ID не сущесвует!'

EXEC DeleteEquipment 12