CREATE TRIGGER addSeat ON Seats
AFTER INSERT
AS
DECLARE @Зарплата money
SELECT @Зарплата=Зарплата FROM inserted
IF @Зарплата<10000
BEGIN
	PRINT 'Зарплата не может быть меньше 10000!'
	ROLLBACK TRAN
END