CREATE VIEW ShowToys
AS
SELECT  Toys.Название,
		Materials.Материал,
		ToyTypes.Тип,
		Institutions.Название AS 'Учреждение',
		Institutions.Город 
		FROM Toys INNER JOIN ToyTypes 
		ON Toys.ТипИгрушки=ToyTypes.ID 
		INNER JOIN Institutions 
		ON Institutions.ID=Toys.Учреждение
		INNER JOIN Materials 
		ON Toys.Материал=Materials.ID   
GO