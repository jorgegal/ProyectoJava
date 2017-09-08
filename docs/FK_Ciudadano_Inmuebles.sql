USE [TrabajoJava]
GO

/****** Object:  Table [dbo].[Inmuebles]    Script Date: 09/05/2017 16:55:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

ALTER TABLE [dbo].[Inmuebles]     
WITH CHECK ADD CONSTRAINT [FK_Ciudado_Inmuebles] FOREIGN KEY ([id_ciudadano])     
    REFERENCES [dbo].[Ciudadanos](id)     
    ON UPDATE CASCADE
;  

GO

SET ANSI_PADDING OFF
GO


