CREATE VIEW ShowProduce
AS
	SELECT Employees.��� AS '��� ����������',Toys.�������� AS '�������� �������',Equipment.�������� AS '�������� �������',Materials.��������,������������������� AS '����������� ���������� ���������',Toys.�������������������,ToyTypes.��� AS '��� �������' FROM ToyProduce 
	INNER JOIN Employees 
	ON Employees.ID=ToyProduce.���������
	INNER JOIN Toys
	ON Toys.ID=ToyProduce.�������
	INNER JOIN Equipment
	ON Equipment.ID=ToyProduce.������
	INNER JOIN ToyTypes 
	ON ToyTypes.ID=Toys.����������
	INNER JOIN Materials
	ON Materials.ID=Toys.��������
GO