CREATE PROC ShowProduceInfo
AS
DECLARE @employee char (60), 
@toyName char(80), 
@equipment char (100), 
@customer char (60),
@toytype TToy,
@age char (20),
@customer_phone char (20),
@customer_town char (30)
DECLARE producing CURSOR FORWARD_ONLY
FOR
	SELECT Employees.ФИО,Equipment.Название,Toys.Название,ToyTypes.Тип,ВозрастнаяКатегория,Customers.ФИО,Customers.Город,Customers.Телефон FROM ToyProduce 
	INNER JOIN Orders ON Orders.ID=ToyProduce.Заказ 
	INNER JOIN Customers ON Orders.Покупатель=Customers.ID
	INNER JOIN Equipment ON Equipment.ID=ToyProduce.Прибор
	INNER JOIN Toys ON ToyProduce.Игрушка=Toys.ID
	INNER JOIN Employees ON Employees.ID=ToyProduce.Сотрудник
	INNER JOIN ToyTypes ON Toys.ТипИгрушки=ToyTypes.ID
	OPEN producing
	FETCH NEXT FROM producing
	INTO @employee, @equipment, @toyName, @toytype, @age, @customer, @customer_town,  @customer_phone
	WHILE @@FETCH_STATUS = 0
	BEGIN
		PRINT '----------------------------------------------------------'
		PRINT 'ФИО сотрудника: ' + @employee
		PRINT 'Оборудование: ' + @equipment
		PRINT 'Игрушка: ' + @toyName
		PRINT 'Тип игрушки: ' + @toytype
		PRINT 'Возрастная категория: ' + @age
		PRINT 'ФИО заказчика: '+ @customer
		PRINT 'Телефон заказчика: '+ @customer_phone
		PRINT 'Город проживания заказчика: ' + @customer_town
		FETCH NEXT FROM producing
		INTO @employee, @equipment, @toyName, @toytype, @age, @customer, @customer_town, @customer_phone
	END
	CLOSE producing
	DEALLOCATE producing
GO