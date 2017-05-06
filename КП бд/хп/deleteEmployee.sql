CREATE TRIGGER deleteEmployee
ON Employees
INSTEAD OF DELETE
AS
	BEGIN
		IF EXISTS (SELECT Город FROM deleted WHERE Город='Рязань')
			PRINT 'Нельзя удалить сотрудника из Рязани!'
		ELSE
			BEGIN
				DELETE FROM ToyProduce WHERE ToyProduce.Сотрудник=(SELECT ID FROM deleted)
				DELETE FROM PackageFabricate WHERE PackageFabricate.Сотрудник=(SELECT ID FROM deleted)
				DELETE FROM Employees WHERE ID = (SELECT ID FROM deleted)
			END
	END