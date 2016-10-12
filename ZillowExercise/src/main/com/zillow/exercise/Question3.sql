 
/*  
SQL 
Given the following SQL table: 
CREATE TABLE [dbo].[posts](
[id] [int] IDENTITY(1,1) NOT NULL,
[user_id] [int] NOT NULL,
[date_posted] [datetime] NOT NULL,
[date_modified] [datetime] NOT NULL,
[content] [text] NOT NULL,
CONSTRAINT [PK_posts] PRIMARY KEY CLUSTERED ( [id] ASC )
) 

Write a single query that will get the post id of the most recently modified post for each user  
*/  

/*
Test data
*/

CREATE TABLE [dbo].[posts](
[id] [int] IDENTITY(1,1) NOT NULL,
[user_id] [int] NOT NULL,
[date_posted] [datetime] NOT NULL,
[date_modified] [datetime] NOT NULL,
[content] [text] NOT NULL,
CONSTRAINT [PK_posts] PRIMARY KEY CLUSTERED ( [id] ASC )
) 

INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (1, '2016-10-12 09:41:59.000', '2016-10-12 09:42:00.000', 'a');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (1, '2016-10-12 09:43:59.000', '2016-10-12 09:42:00.000', 'same date_posted test, this should not be shown');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (1, '2016-10-12 09:43:59.000', '2016-10-12 09:42:00.000', 'show me');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (2, '2016-10-12 09:43:59.000', '2016-10-12 09:42:00.000', 'a');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (2, '2016-10-12 09:44:59.000', '2016-10-12 09:42:00.000', 'b');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (2, '2016-10-12 09:45:59.000', '2016-10-12 09:42:00.000', 'show me');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (3, '2016-10-12 09:46:59.000', '2016-10-12 09:42:00.000', 'a');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (3, '2016-10-12 09:47:59.000', '2016-10-12 09:42:00.000', 'b');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (3, '2016-10-12 09:48:59.000', '2016-10-12 09:42:00.000', 'show me');
INSERT INTO "posts" ("user_id", "date_posted", "date_modified", "content") VALUES (4, '2016-10-12 09:49:59.000', '2016-10-12 09:42:00.000', 'show me');



/*
Not familiar with SQL Server, this took me a while to find answer from google.
*/


SELECT id,user_id,date_posted,date_modified,content
FROM
(SELECT id,user_id,date_posted,date_modified,content,
ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY date_posted DESC,id DESC) as post_rank
FROM dbo.posts) ranked
   WHERE post_rank = 1;