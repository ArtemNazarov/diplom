USE [toy_factory]
GO
CREATE PROC updateMaterial (@ID int, @�������� char(30))
AS
	IF EXISTS (SELECT * 
			FROM Materials
			WHERE @ID=ID)
	BEGIN
		UPDATE Materials
			SET ��������=@��������
		WHERE @ID=ID
	END
	ELSE
		PRINT '�������� � ����� ID �� ������!'
GO
EXEC updateMaterial 4,'�����'