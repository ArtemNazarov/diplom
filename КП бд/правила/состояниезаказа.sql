CREATE RULE OrderState
AS
	@ostate = 'Ожидает заказчика' or
	@ostate = 'Изготавливается' or
	@ostate = 'Упаковывается' or
	@ostate = 'Поступил в очередь'
GO
EXEC sp_bindrule 'OrderState', 'Orders.СостояниеВыполнения'