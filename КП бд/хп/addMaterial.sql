USE [toy_factory]
GO
CREATE PROC addMaterial(@Материал char(30))
AS
	INSERT INTO Materials (Материал) VALUES (@Материал)
GO
EXEC addMaterial 'каучук'