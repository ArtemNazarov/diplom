CREATE RULE InstitutionType
AS
	@inst='������� ����' or
	@inst = '����������� �������' or
	@inst = '������' or
	@inst = '�������'
EXEC sp_bindrule 'InstitutionType', 'institutions.inst_type'
