USE [toy_factory]
GO
CREATE PROC updateCustomer (@ID int, @ФИО char(60),@НазваниеФирмы char(30),@Город char(30),@Телефон char(20),@Email char(30))
AS
	IF EXISTS (SELECT * 
			FROM Customers
			WHERE @ID=ID)
	BEGIN
			UPDATE Customers
			SET НазваниеФирмы=@НазваниеФирмы, 
				ФИО=@ФИО,
				Город=@Город,
				Телефон=@Телефон,
				[E-mail]=@Email
			WHERE @ID=ID
	END
	ELSE
		PRINT 'Покупатель с таким ID не найден!'

EXEC updateCustomer 11,'Гришина Светлана Лукьевна','Пластмассовые друзья','Ростов-на-Дону','+79038384455','grishina_s@mail.ru'
