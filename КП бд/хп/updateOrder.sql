USE [toy_factory]
GO
CREATE PROC UpdateOrder (@ID int, @Название char(60), @Сумма money, @Валюта char(10),@КоличествоТовара int, @СостояниеВыполнения char(30),@ДатаВыполнения date,@Покупатель int)
AS
	IF EXISTS (SELECT * 
				FROM Orders
				WHERE @ID=ID)
		BEGIN
			IF (DATEPART(yyyy,@ДатаВыполнения) < DATEPART(yyyy,SYSDATETIME()) )
				PRINT 'Дата выполнения не может быть меньше текущего года'
			ELSE
				UPDATE Orders
				SET НазваниеИгрушки = @Название, 
					Сумма = @Сумма, 
					Валюта = @Валюта, 
					КоличествоТовара = @КоличествоТовара, 
					СостояниеВыполнения=@СостояниеВыполнения, 
					ДатаВыполнения = @ДатаВыполнения, 
					Покупатель = @Покупатель
				WHERE @ID=ID
		END
	ELSE
		PRINT 'Заказчика с таким ID не сущесвует!'

EXEC UpdateOrder 45,'Деревянный лось', '400', 'руб.', 1, 'Поступил в очередь', '2017-04-01',9