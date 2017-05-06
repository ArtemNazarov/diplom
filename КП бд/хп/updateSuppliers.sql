USE [toy_factory]
GO
CREATE PROC UpdateSuppliers (@ID int, @Название char(40), @ФИО char(40), @СрокДействияКонтракта int,@ДатаПодписанияКонтракта date)
AS 
	IF EXISTS (SELECT * 
				FROM Suppliers
				WHERE @ID=ID)
		BEGIN
			IF (DATEPART(yyyy,@ДатаПодписанияКонтракта) + @СрокДействияКонтракта < DATEPART(yyyy,SYSDATETIME()) )
				PRINT 'Вы должны ввести дату подписания контракта и срок действия так, чтобы контракт был в силе'
			ELSE
				UPDATE Suppliers
				SET НазваниеФирмы = @Название, 
					ФИО_директора=@ФИО,
					СрокДействияКонтракта=@СрокДействияКонтракта,
					ДатаПодписанияКонтракта=@ДатаПодписанияКонтракта
				WHERE @ID=ID
		END
	ELSE
		PRINT 'Поставщика с таким ID не сущесвует!'

EXEC UpdateSuppliers 12,'КировЛес', '2017-04-01', 'Изготовление упаковки',3