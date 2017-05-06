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
	SELECT Employees.���,Equipment.��������,Toys.��������,ToyTypes.���,�������������������,Customers.���,Customers.�����,Customers.������� FROM ToyProduce 
	INNER JOIN Orders ON Orders.ID=ToyProduce.����� 
	INNER JOIN Customers ON Orders.����������=Customers.ID
	INNER JOIN Equipment ON Equipment.ID=ToyProduce.������
	INNER JOIN Toys ON ToyProduce.�������=Toys.ID
	INNER JOIN Employees ON Employees.ID=ToyProduce.���������
	INNER JOIN ToyTypes ON Toys.����������=ToyTypes.ID
	OPEN producing
	FETCH NEXT FROM producing
	INTO @employee, @equipment, @toyName, @toytype, @age, @customer, @customer_town,  @customer_phone
	WHILE @@FETCH_STATUS = 0
	BEGIN
		PRINT '----------------------------------------------------------'
		PRINT '��� ����������: ' + @employee
		PRINT '������������: ' + @equipment
		PRINT '�������: ' + @toyName
		PRINT '��� �������: ' + @toytype
		PRINT '���������� ���������: ' + @age
		PRINT '��� ���������: '+ @customer
		PRINT '������� ���������: '+ @customer_phone
		PRINT '����� ���������� ���������: ' + @customer_town
		FETCH NEXT FROM producing
		INTO @employee, @equipment, @toyName, @toytype, @age, @customer, @customer_town, @customer_phone
	END
	CLOSE producing
	DEALLOCATE producing
GO