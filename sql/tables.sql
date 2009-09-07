CREATE TABLE webUsers (
	created datetime default getdate(),
	id int IDENTITY (0, 1) NOT NULL ,
	name nvarchar (50) NOT NULL ,
	full_name nvarchar (200) NOT NULL ,
	passwd nvarchar (50) NOT NULL ,
	disabled bit NOT NULL DEFAULT (0),
	is_template bit NOT NULL DEFAULT (0),
	is_admin bit not null default(0),
	is_manager bit not null default(0),
	last_login datetime,
	total_logins int default 0,
	CONSTRAINT PK_webUsers PRIMARY KEY  CLUSTERED 
	(
		id
	)  
)
GO

CREATE TABLE webUserPrivs (
	id int IDENTITY (0, 1) NOT NULL ,
	name nvarchar (50) NOT NULL ,
	description nvarchar (50) NOT NULL ,
	screen_name nvarchar (50) NOT NULL ,
	type nvarchar (50) NOT NULL ,
	access varchar(32),
	sValue nvarchar (200),
	iValue int default 0,
	user_id int NOT NULL references webUsers(id),
	CONSTRAINT PK_webUserPrivs PRIMARY KEY  CLUSTERED 
	(
		id
	)  
)
GO

CREATE TABLE webLog (
	created datetime default getdate(),
	id int IDENTITY (0, 1) NOT NULL ,
	msg nvarchar (250) NOT NULL ,
	screen_name nvarchar (50) NOT NULL ,
	msg_action nvarchar (50) NOT NULL ,
	sValue nvarchar (200),
	user_id int NOT NULL references webUsers(id),
	CONSTRAINT PK_webLog PRIMARY KEY  CLUSTERED 
	(
		id
	)  
)
GO

--------------------------------------------------------------------
------------------ p_web_new_user
-- Вызывается для вставки нового товара
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'p_web_new_user' AND type = 'P')
   DROP PROCEDURE p_web_new_user
GO
CREATE PROCEDURE p_web_new_user
	@i_name nvarchar(50),
	@i_full_name nvarchar(200),
	@i_passwd nvarchar(50),
	@i_is_manager bit,
	@i_is_admin bit
AS
BEGIN TRANSACTION

insert into webUsers (name,
			full_name,
			passwd,
			is_manager,
			is_admin,
			disabled
			)
	values (@i_name, @i_full_name, @i_passwd, @i_is_manager, @i_is_admin, 1);


COMMIT TRANSACTION
GO

exec p_new_web_user '1', '2', '3', 1, 0

drop view v_webLog
go
create view v_webLog
	(
		created,
		id,
		msg,
		screen_name,
		msg_action,
		sValue,
		user_id,
		user_name,
		user_full_name
	) as
select 
		webLog.created,
		webLog.id,
		webLog.msg,
		webLog.screen_name,
		webLog.msg_action,
		webLog.sValue,
		webLog.user_id,
		webUsers.name,
		webUsers.full_name
from webLog, webUsers
where 
	webLog.user_id = webUsers.id
go

