USE [toy_factory]
GO
CREATE PROC AddCustomer(@��� char(60),@������������� char(30),@����� char(30),@������� char(20),@Email char(30))
AS
	INSERT INTO Customers(���,�������������,�����,�������,[E-mail]) VALUES (@���,@�������������,@�����,@�������,@Email)
GO

EXEC AddCustomer '�������� ������ ����������','�������������','������','+79351265','maximov_e@yandex.ru'