CREATE RULE barcodeGeneration
AS
	@X LIKE '4601512[0-9][0-9][0-9][0-9][0-9][0-9]'
GO
EXEC sp_bindrule 'barcodeGeneration', 'toys.bardcode'