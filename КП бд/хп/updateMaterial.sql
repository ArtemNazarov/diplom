USE [toy_factory]
GO
CREATE PROC updateMaterial (@ID int, @Материал char(30))
AS
	IF EXISTS (SELECT * 
			FROM Materials
			WHERE @ID=ID)
	BEGIN
		UPDATE Materials
			SET Материал=@Материал
		WHERE @ID=ID
	END
	ELSE
		PRINT 'Материал с таким ID не найден!'
GO
EXEC updateMaterial 4,'ясень'