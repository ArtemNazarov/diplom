USE [toy_factory]
GO
CREATE PROC updateCustomer (@ID int, @��� char(60),@������������� char(30),@����� char(30),@������� char(20),@Email char(30))
AS
	IF EXISTS (SELECT * 
			FROM Customers
			WHERE @ID=ID)
	BEGIN
			UPDATE Customers
			SET �������������=@�������������, 
				���=@���,
				�����=@�����,
				�������=@�������,
				[E-mail]=@Email
			WHERE @ID=ID
	END
	ELSE
		PRINT '���������� � ����� ID �� ������!'

EXEC updateCustomer 11,'������� �������� ��������','������������� ������','������-��-����','+79038384455','grishina_s@mail.ru'
