USE [toy_factory]
GO
CREATE PROC UpdateEquipment (@ID int, @�������� char(100), @���������������� date,@���������� char(60),@���������� int)
AS
	IF EXISTS (SELECT * 
				FROM Equipment
				WHERE @ID=ID)
		BEGIN
			IF (@���������������� > SYSDATETIME() )
				PRINT '���� ������������ �� ����� ���� ������ �������� ����'
			ELSE
				UPDATE Equipment
				SET �������� = @��������, 
					���������������� = @����������������, 
					���������� = @����������,
					����������=@����������
				WHERE @ID=ID
		END
	ELSE
		PRINT '������� � ����� ID �� ���������!'

EXEC UpdateEquipment 14,'����������� �����', '2017-04-01', '������������ ��������',3