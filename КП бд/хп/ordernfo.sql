CREATE PROC ShowOrdersInfo
AS
	DECLARE @toyName char(60),
	@summ money, 
	@currency char(10), 
	@prodAmount int, 
	@orderState char(30), 
	@implemDate date, 
	@customerName char(60), 
	@firmName char(30),
	@town char(30)
	DECLARE C1 CURSOR FORWARD_ONLY
	FOR
		SELECT ФИО , НазваниеФирмы, Город, НазваниеИгрушки, Сумма, Валюта, КоличествоТовара, ДатаВыполнения FROM Orders INNER JOIN Customers 
		ON Orders.Покупатель=Customers.ID
	OPEN C1
	FETCH NEXT FROM C1
	INTO @customerName,@firmName,@town,@toyName,@summ,@currency,@prodAmount,@implemDate
	WHILE @@FETCH_STATUS = 0
	BEGIN
		PRINT '----------------------------------------------------------'
		PRINT 'ФИО покупателя: ' + @customerName
		PRINT 'Название фирмы: ' + @firmName
		PRINT 'Город: ' + @town
		PRINT 'Название игрушки: ' + @toyName
		PRINT 'Заплаченная сумма: ' + LTRIM(CONVERT(CHAR, @summ)) + ' ' + @currency
		PRINT 'Количество товара: ' + CONVERT(CHAR, @prodAmount)
		PRINT 'Дата выполнения заказа: ' + CONVERT(CHAR, @implemDate)
		FETCH NEXT FROM C1
		INTO @customerName,@firmName,@town,@toyName,@summ,@currency,@prodAmount,@implemDate
	END
	CLOSE C1
	DEALLOCATE C1
GO