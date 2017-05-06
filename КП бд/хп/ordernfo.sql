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
		SELECT ��� , �������������, �����, ���������������, �����, ������, ����������������, �������������� FROM Orders INNER JOIN Customers 
		ON Orders.����������=Customers.ID
	OPEN C1
	FETCH NEXT FROM C1
	INTO @customerName,@firmName,@town,@toyName,@summ,@currency,@prodAmount,@implemDate
	WHILE @@FETCH_STATUS = 0
	BEGIN
		PRINT '----------------------------------------------------------'
		PRINT '��� ����������: ' + @customerName
		PRINT '�������� �����: ' + @firmName
		PRINT '�����: ' + @town
		PRINT '�������� �������: ' + @toyName
		PRINT '����������� �����: ' + LTRIM(CONVERT(CHAR, @summ)) + ' ' + @currency
		PRINT '���������� ������: ' + CONVERT(CHAR, @prodAmount)
		PRINT '���� ���������� ������: ' + CONVERT(CHAR, @implemDate)
		FETCH NEXT FROM C1
		INTO @customerName,@firmName,@town,@toyName,@summ,@currency,@prodAmount,@implemDate
	END
	CLOSE C1
	DEALLOCATE C1
GO