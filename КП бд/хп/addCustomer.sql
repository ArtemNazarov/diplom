USE [toy_factory]
GO
CREATE PROC AddCustomer(@ФИО char(60),@НазваниеФирмы char(30),@Город char(30),@Телефон char(20),@Email char(30))
AS
	INSERT INTO Customers(ФИО,НазваниеФирмы,Город,Телефон,[E-mail]) VALUES (@ФИО,@НазваниеФирмы,@Город,@Телефон,@Email)
GO

EXEC AddCustomer 'Максимов Эдуард Георгиевич','КоронаХолдинг','Москва','+79351265','maximov_e@yandex.ru'