CREATE TRIGGER deleteEmployee
ON Employees
INSTEAD OF DELETE
AS
	BEGIN
		IF EXISTS (SELECT ����� FROM deleted WHERE �����='������')
			PRINT '������ ������� ���������� �� ������!'
		ELSE
			BEGIN
				DELETE FROM ToyProduce WHERE ToyProduce.���������=(SELECT ID FROM deleted)
				DELETE FROM PackageFabricate WHERE PackageFabricate.���������=(SELECT ID FROM deleted)
				DELETE FROM Employees WHERE ID = (SELECT ID FROM deleted)
			END
	END