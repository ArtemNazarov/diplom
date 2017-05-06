CREATE VIEW ShowPackageFabricate
AS
	SELECT Employees.ФИО AS 'ФИО сотрудника',Equipment.Название AS 'Название прибора',Materials.Материал,КоличествоМатериала AS 'Необходимое количество материала' FROM PackageFabricate 
	INNER JOIN Employees 
	ON Employees.ID=PackageFabricate.Сотрудник
	INNER JOIN Packages
	ON Packages.ID=PackageFabricate.Упаковка
	INNER JOIN Equipment
	ON Equipment.ID=PackageFabricate.Прибор
	INNER JOIN Materials
	ON Materials.ID=Packages.Материал