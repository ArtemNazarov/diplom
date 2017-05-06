USE [toy_factory]
GO
CREATE PROC UpdateOrder (@ID int, @�������� char(60), @����� money, @������ char(10),@���������������� int, @������������������� char(30),@�������������� date,@���������� int)
AS
	IF EXISTS (SELECT * 
				FROM Orders
				WHERE @ID=ID)
		BEGIN
			IF (DATEPART(yyyy,@��������������) < DATEPART(yyyy,SYSDATETIME()) )
				PRINT '���� ���������� �� ����� ���� ������ �������� ����'
			ELSE
				UPDATE Orders
				SET ��������������� = @��������, 
					����� = @�����, 
					������ = @������, 
					���������������� = @����������������, 
					�������������������=@�������������������, 
					�������������� = @��������������, 
					���������� = @����������
				WHERE @ID=ID
		END
	ELSE
		PRINT '��������� � ����� ID �� ���������!'

EXEC UpdateOrder 45,'���������� ����', '400', '���.', 1, '�������� � �������', '2017-04-01',9