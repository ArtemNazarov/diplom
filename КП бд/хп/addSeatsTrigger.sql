CREATE TRIGGER addSeat ON Seats
AFTER INSERT
AS
DECLARE @�������� money
SELECT @��������=�������� FROM inserted
IF @��������<10000
BEGIN
	PRINT '�������� �� ����� ���� ������ 10000!'
	ROLLBACK TRAN
END