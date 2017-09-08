USE [TrabajoJava]
GO

/****** Object:  Table [dbo].[Inmuebles]    Script Date: 09/05/2017 16:50:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Inmuebles](
	[codigo_nacional] [varchar](50) NOT NULL,
	[id_ciudadano] [varchar](50) NOT NULL,
	[tipo] [varchar](10) NOT NULL,
	[direccion] [varchar](100) NOT NULL,
	[area] [numeric](10,2) NOT NULL,
	[valor_comercial] [numeric](15,2) NOT NULL,
	[estrato] [smallint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[codigo_nacional] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


