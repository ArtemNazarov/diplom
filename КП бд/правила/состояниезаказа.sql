CREATE RULE OrderState
AS
	@ostate = '������� ���������' or
	@ostate = '���������������' or
	@ostate = '�������������' or
	@ostate = '�������� � �������'
GO
EXEC sp_bindrule 'OrderState', 'Orders.�������������������'