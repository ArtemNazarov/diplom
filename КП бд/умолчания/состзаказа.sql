CREATE DEFAULT OrderStateDefault
AS
	'Поступил в очередь'
GO
EXEC sp_bindefault 'OrderStateDefault','Orders.СостояниеВыполнения'