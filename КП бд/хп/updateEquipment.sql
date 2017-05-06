USE [toy_factory]
GO
CREATE PROC UpdateEquipment (@ID int, @Название char(100), @ДатаИзготовления date,@Назначение char(60),@ТипПрибора int)
AS
	IF EXISTS (SELECT * 
				FROM Equipment
				WHERE @ID=ID)
		BEGIN
			IF (@ДатаИзготовления > SYSDATETIME() )
				PRINT 'Дата изготовления не может быть больше текущего года'
			ELSE
				UPDATE Equipment
				SET Название = @Название, 
					ДатаИзготовления = @ДатаИзготовления, 
					Назначение = @Назначение,
					ТипПрибора=@ТипПрибора
				WHERE @ID=ID
		END
	ELSE
		PRINT 'Прибора с таким ID не сущесвует!'

EXEC UpdateEquipment 14,'Формовочная линия', '2017-04-01', 'Изготовление упаковки',3