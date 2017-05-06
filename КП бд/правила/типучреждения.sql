CREATE RULE InstitutionType
AS
	@inst='Главный офис' or
	@inst = 'Центральный магазин' or
	@inst = 'Филиал' or
	@inst = 'Магазин'
EXEC sp_bindrule 'InstitutionType', 'institutions.inst_type'
