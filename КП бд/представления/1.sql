CREATE VIEW ShowToys
AS
SELECT  Toys.��������,
		Materials.��������,
		ToyTypes.���,
		Institutions.�������� AS '����������',
		Institutions.����� 
		FROM Toys INNER JOIN ToyTypes 
		ON Toys.����������=ToyTypes.ID 
		INNER JOIN Institutions 
		ON Institutions.ID=Toys.����������
		INNER JOIN Materials 
		ON Toys.��������=Materials.ID   
GO