CREATE VIEW ShowPackageFabricate
AS
	SELECT Employees.��� AS '��� ����������',Equipment.�������� AS '�������� �������',Materials.��������,������������������� AS '����������� ���������� ���������' FROM PackageFabricate 
	INNER JOIN Employees 
	ON Employees.ID=PackageFabricate.���������
	INNER JOIN Packages
	ON Packages.ID=PackageFabricate.��������
	INNER JOIN Equipment
	ON Equipment.ID=PackageFabricate.������
	INNER JOIN Materials
	ON Materials.ID=Packages.��������