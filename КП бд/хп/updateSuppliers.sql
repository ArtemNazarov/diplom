USE [toy_factory]
GO
CREATE PROC UpdateSuppliers (@ID int, @�������� char(40), @��� char(40), @��������������������� int,@����������������������� date)
AS 
	IF EXISTS (SELECT * 
				FROM Suppliers
				WHERE @ID=ID)
		BEGIN
			IF (DATEPART(yyyy,@�����������������������) + @��������������������� < DATEPART(yyyy,SYSDATETIME()) )
				PRINT '�� ������ ������ ���� ���������� ��������� � ���� �������� ���, ����� �������� ��� � ����'
			ELSE
				UPDATE Suppliers
				SET ������������� = @��������, 
					���_���������=@���,
					���������������������=@���������������������,
					�����������������������=@�����������������������
				WHERE @ID=ID
		END
	ELSE
		PRINT '���������� � ����� ID �� ���������!'

EXEC UpdateSuppliers 12,'��������', '2017-04-01', '������������ ��������',3