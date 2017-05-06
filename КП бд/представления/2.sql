CREATE VIEW ShowProduce
AS
	SELECT Employees.ФИО AS 'ФИО сотрудника',Toys.Название AS 'Название игрушки',Equipment.Название AS 'Название прибора',Materials.Материал,КоличествоМатериала AS 'Необходимое количество материала',Toys.ВозрастнаяКатегория,ToyTypes.Тип AS 'Тип Игрушки' FROM ToyProduce 
	INNER JOIN Employees 
	ON Employees.ID=ToyProduce.Сотрудник
	INNER JOIN Toys
	ON Toys.ID=ToyProduce.Игрушка
	INNER JOIN Equipment
	ON Equipment.ID=ToyProduce.Прибор
	INNER JOIN ToyTypes 
	ON ToyTypes.ID=Toys.ТипИгрушки
	INNER JOIN Materials
	ON Materials.ID=Toys.Материал
GO