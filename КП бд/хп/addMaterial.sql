USE [toy_factory]
GO
CREATE PROC addMaterial(@�������� char(30))
AS
	INSERT INTO Materials (��������) VALUES (@��������)
GO
EXEC addMaterial '������'