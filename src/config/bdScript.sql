------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: Account
------------------------------------------------------------
CREATE TABLE public.Account(
	id_account SERIAL NOT NULL ,
	login      VARCHAR (25) NOT NULL UNIQUE,
	password   VARCHAR (25) NOT NULL ,
	FirstName  VARCHAR (25)  ,
	LastName   VARCHAR (25)  ,
	Email      VARCHAR (25)  ,
	address    VARCHAR (252)  ,
	Phone      VARCHAR (15)  ,
	CONSTRAINT prk_constraint_Account PRIMARY KEY (id_account)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: product_category
------------------------------------------------------------
CREATE TABLE public.product_category(
	id_category       SERIAL NOT NULL ,
	title             VARCHAR (25)  ,
	description       VARCHAR (25)  ,
	short_description VARCHAR (25)  ,
	id_product        INT   ,
	CONSTRAINT prk_constraint_product_category PRIMARY KEY (id_category)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: user_account
------------------------------------------------------------
CREATE TABLE public.user_account(
	id_user    SERIAL NOT NULL ,
	id_profile INT  NOT NULL ,
	CONSTRAINT prk_constraint_user_account PRIMARY KEY (id_user,id_profile)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: product
------------------------------------------------------------
CREATE TABLE public.product(
	id_product    SERIAL NOT NULL ,
	name          VARCHAR (25)  ,
	description   VARCHAR (25)  ,
	unitPrice     NUMERIC (25,0)   ,
	stockQuantity VARCHAR (25)  ,
	id_category   INT  NOT NULL ,
	id_seller     INT   ,
	id_profile    INT   ,
	CONSTRAINT prk_constraint_product PRIMARY KEY (id_product)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: seller_account
------------------------------------------------------------
CREATE TABLE public.seller_account(
	id_seller   SERIAL NOT NULL ,
	nameShop    VARCHAR (25)  ,
	siret       VARCHAR (25)  ,
	website     VARCHAR (25)  ,
	description VARCHAR (25)  ,
	id_profile  INT  NOT NULL ,
	CONSTRAINT prk_constraint_seller_account PRIMARY KEY (id_seller,id_profile)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: admin_account
------------------------------------------------------------
CREATE TABLE public.admin_account(
	id_admin   SERIAL NOT NULL ,
	id_profile INT  NOT NULL ,
	CONSTRAINT prk_constraint_admin_account PRIMARY KEY (id_admin,id_profile)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: wishlist
------------------------------------------------------------
CREATE TABLE public.wishlist(
	id_wishlist SERIAL NOT NULL ,
	label       VARCHAR (25)  ,
	id_user     INT   ,
	id_profile  INT   ,
	CONSTRAINT prk_constraint_wishlist PRIMARY KEY (id_wishlist)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: order
------------------------------------------------------------
CREATE TABLE public.order(
	id_order        SERIAL NOT NULL ,
	dateOrder       DATE   ,
	totalPrice      FLOAT   ,
	DeliveryAddress VARCHAR (25)  ,
	id_user         INT   ,
	id_profile      INT   ,
	CONSTRAINT prk_constraint_order PRIMARY KEY (id_order)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: journal_entry
------------------------------------------------------------
CREATE TABLE public.journal_entry(
	id_journal_entry SERIAL NOT NULL ,
	visibility       BOOL  NOT NULL ,
	date_post        DATE  NOT NULL ,
	title            VARCHAR (128)  ,
	content          VARCHAR (512)  ,
	id_user          INT   ,
	id_profile       INT   ,
	CONSTRAINT prk_constraint_journal_entry PRIMARY KEY (id_journal_entry)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: activity_category
------------------------------------------------------------
CREATE TABLE public.activity_category(
	id_activity_category SERIAL NOT NULL ,
	label                VARCHAR (50)  ,
	short_description    VARCHAR (128)  ,
	description          VARCHAR (512)  ,
	id_user              INT   ,
	id_profile           INT   ,
	CONSTRAINT prk_constraint_activity_category PRIMARY KEY (id_activity_category)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: activity
------------------------------------------------------------
CREATE TABLE public.activity(
	title                VARCHAR (25)  ,
	id_activity          SERIAL NOT NULL ,
	description          VARCHAR (512)  ,
	id_activity_category INT   ,
	id_user              INT   ,
	id_profile           INT   ,
	CONSTRAINT prk_constraint_activity PRIMARY KEY (id_activity)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: task
------------------------------------------------------------
CREATE TABLE public.task(
	id_task     SERIAL NOT NULL ,
	title       VARCHAR (50)  ,
	id_activity INT   ,
	id_category INT   ,
	id_user     INT   ,
	id_profile  INT   ,
	CONSTRAINT prk_constraint_task PRIMARY KEY (id_task)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: objective
------------------------------------------------------------
CREATE TABLE public.objective(
	id_objective SERIAL NOT NULL ,
	title        VARCHAR (50)  ,
	description  VARCHAR (500)  ,
	deadLine     DATE   ,
	id_activity  INT   ,
	id_category  INT   ,
	id_user      INT   ,
	id_profile   INT   ,
	CONSTRAINT prk_constraint_objective PRIMARY KEY (id_objective)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: category
------------------------------------------------------------
CREATE TABLE public.category(
	id_category SERIAL NOT NULL ,
	title       VARCHAR (25)  ,
	description VARCHAR (25)  ,
	id_user     INT   ,
	id_profile  INT   ,
	CONSTRAINT prk_constraint_category PRIMARY KEY (id_category)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: profile
------------------------------------------------------------
CREATE TABLE public.profile(
	id_profile SERIAL NOT NULL ,
	id_account INT  NOT NULL ,
	CONSTRAINT prk_constraint_profile PRIMARY KEY (id_profile)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: notification
------------------------------------------------------------
CREATE TABLE public.notification(
	id_notification SERIAL NOT NULL ,
	content         VARCHAR (256)  ,
	id_profile      INT   ,
	CONSTRAINT prk_constraint_notification PRIMARY KEY (id_notification)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: tutorial
------------------------------------------------------------
CREATE TABLE public.tutorial(
	id_tutorial SERIAL NOT NULL ,
	title       VARCHAR (256)  ,
	description VARCHAR (1024)  ,
	difficulty  INT   ,
	CONSTRAINT prk_constraint_tutorial PRIMARY KEY (id_tutorial)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Composed
------------------------------------------------------------
CREATE TABLE public.Composed(
	quantity    NUMERIC (25,0)   ,
	unitPrice   NUMERIC (25,0)   ,
	id_product  INT  NOT NULL ,
	id_wishlist INT  NOT NULL ,
	CONSTRAINT prk_constraint_Composed PRIMARY KEY (id_product,id_wishlist)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Composed_order
------------------------------------------------------------
CREATE TABLE public.Composed_order(
	quantity   NUMERIC (25,0)   ,
	Price      NUMERIC (25,0)   ,
	id_order   INT  NOT NULL ,
	id_product INT  NOT NULL ,
	CONSTRAINT prk_constraint_Composed_order PRIMARY KEY (id_order,id_product)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: comment
------------------------------------------------------------
CREATE TABLE public.comment(
	date_comment     DATE   ,
	Content          VARCHAR (512)  ,
	id_journal_entry INT  NOT NULL ,
	id_account       INT  NOT NULL ,
	CONSTRAINT prk_constraint_comment PRIMARY KEY (id_journal_entry,id_account)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: contain_activity
------------------------------------------------------------
CREATE TABLE public.contain_activity(
	id_journal_entry INT  NOT NULL ,
	id_activity      INT  NOT NULL ,
	CONSTRAINT prk_constraint_contain_activity PRIMARY KEY (id_journal_entry,id_activity)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: contain_objective
------------------------------------------------------------
CREATE TABLE public.contain_objective(
	id_objective     INT  NOT NULL ,
	id_journal_entry INT  NOT NULL ,
	CONSTRAINT prk_constraint_contain_objective PRIMARY KEY (id_objective,id_journal_entry)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: contain_task
------------------------------------------------------------
CREATE TABLE public.contain_task(
	id_task          INT  NOT NULL ,
	id_journal_entry INT  NOT NULL ,
	CONSTRAINT prk_constraint_contain_task PRIMARY KEY (id_task,id_journal_entry)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: use
------------------------------------------------------------
CREATE TABLE public.use(
	id_activity INT  NOT NULL ,
	id_tutorial INT  NOT NULL ,
	CONSTRAINT prk_constraint_use PRIMARY KEY (id_activity,id_tutorial)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: propose_objective
------------------------------------------------------------
CREATE TABLE public.propose_objective(
	id_tutorial  INT  NOT NULL ,
	id_objective INT  NOT NULL ,
	CONSTRAINT prk_constraint_propose_objective PRIMARY KEY (id_tutorial,id_objective)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: propose_task
------------------------------------------------------------
CREATE TABLE public.propose_task(
	id_tutorial INT  NOT NULL ,
	id_task     INT  NOT NULL ,
	CONSTRAINT prk_constraint_propose_task PRIMARY KEY (id_tutorial,id_task)
)WITHOUT OIDS;



ALTER TABLE public.product_category ADD CONSTRAINT FK_product_category_id_product FOREIGN KEY (id_product) REFERENCES public.product(id_product);
ALTER TABLE public.user_account ADD CONSTRAINT FK_user_account_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.product ADD CONSTRAINT FK_product_id_category FOREIGN KEY (id_category) REFERENCES public.product_category(id_category);
ALTER TABLE public.product ADD CONSTRAINT FK_product_id_seller FOREIGN KEY (id_seller) REFERENCES public.seller_account(id_seller);
ALTER TABLE public.product ADD CONSTRAINT FK_product_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.seller_account ADD CONSTRAINT FK_seller_account_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.admin_account ADD CONSTRAINT FK_admin_account_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.wishlist ADD CONSTRAINT FK_wishlist_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.wishlist ADD CONSTRAINT FK_wishlist_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.order ADD CONSTRAINT FK_order_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.order ADD CONSTRAINT FK_order_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.journal_entry ADD CONSTRAINT FK_journal_entry_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.journal_entry ADD CONSTRAINT FK_journal_entry_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.activity_category ADD CONSTRAINT FK_activity_category_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.activity_category ADD CONSTRAINT FK_activity_category_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.activity ADD CONSTRAINT FK_activity_id_activity_category FOREIGN KEY (id_activity_category) REFERENCES public.activity_category(id_activity_category);
ALTER TABLE public.activity ADD CONSTRAINT FK_activity_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.activity ADD CONSTRAINT FK_activity_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.task ADD CONSTRAINT FK_task_id_activity FOREIGN KEY (id_activity) REFERENCES public.activity(id_activity);
ALTER TABLE public.task ADD CONSTRAINT FK_task_id_category FOREIGN KEY (id_category) REFERENCES public.category(id_category);
ALTER TABLE public.task ADD CONSTRAINT FK_task_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.task ADD CONSTRAINT FK_task_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.objective ADD CONSTRAINT FK_objective_id_activity FOREIGN KEY (id_activity) REFERENCES public.activity(id_activity);
ALTER TABLE public.objective ADD CONSTRAINT FK_objective_id_category FOREIGN KEY (id_category) REFERENCES public.category(id_category);
ALTER TABLE public.objective ADD CONSTRAINT FK_objective_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.objective ADD CONSTRAINT FK_objective_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.category ADD CONSTRAINT FK_category_id_user FOREIGN KEY (id_user) REFERENCES public.user_account(id_user);
ALTER TABLE public.category ADD CONSTRAINT FK_category_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.profile ADD CONSTRAINT FK_profile_id_account FOREIGN KEY (id_account) REFERENCES public.Account(id_account);
ALTER TABLE public.notification ADD CONSTRAINT FK_notification_id_profile FOREIGN KEY (id_profile) REFERENCES public.profile(id_profile);
ALTER TABLE public.Composed ADD CONSTRAINT FK_Composed_id_product FOREIGN KEY (id_product) REFERENCES public.product(id_product);
ALTER TABLE public.Composed ADD CONSTRAINT FK_Composed_id_wishlist FOREIGN KEY (id_wishlist) REFERENCES public.wishlist(id_wishlist);
ALTER TABLE public.Composed_order ADD CONSTRAINT FK_Composed_order_id_order FOREIGN KEY (id_order) REFERENCES public.order(id_order);
ALTER TABLE public.Composed_order ADD CONSTRAINT FK_Composed_order_id_product FOREIGN KEY (id_product) REFERENCES public.product(id_product);
ALTER TABLE public.comment ADD CONSTRAINT FK_comment_id_journal_entry FOREIGN KEY (id_journal_entry) REFERENCES public.journal_entry(id_journal_entry);
ALTER TABLE public.comment ADD CONSTRAINT FK_comment_id_account FOREIGN KEY (id_account) REFERENCES public.Account(id_account);
ALTER TABLE public.contain_activity ADD CONSTRAINT FK_contain_activity_id_journal_entry FOREIGN KEY (id_journal_entry) REFERENCES public.journal_entry(id_journal_entry);
ALTER TABLE public.contain_activity ADD CONSTRAINT FK_contain_activity_id_activity FOREIGN KEY (id_activity) REFERENCES public.activity(id_activity);
ALTER TABLE public.contain_objective ADD CONSTRAINT FK_contain_objective_id_objective FOREIGN KEY (id_objective) REFERENCES public.objective(id_objective);
ALTER TABLE public.contain_objective ADD CONSTRAINT FK_contain_objective_id_journal_entry FOREIGN KEY (id_journal_entry) REFERENCES public.journal_entry(id_journal_entry);
ALTER TABLE public.contain_task ADD CONSTRAINT FK_contain_task_id_task FOREIGN KEY (id_task) REFERENCES public.task(id_task);
ALTER TABLE public.contain_task ADD CONSTRAINT FK_contain_task_id_journal_entry FOREIGN KEY (id_journal_entry) REFERENCES public.journal_entry(id_journal_entry);
ALTER TABLE public.use ADD CONSTRAINT FK_use_id_activity FOREIGN KEY (id_activity) REFERENCES public.activity(id_activity);
ALTER TABLE public.use ADD CONSTRAINT FK_use_id_tutorial FOREIGN KEY (id_tutorial) REFERENCES public.tutorial(id_tutorial);
ALTER TABLE public.propose_objective ADD CONSTRAINT FK_propose_objective_id_tutorial FOREIGN KEY (id_tutorial) REFERENCES public.tutorial(id_tutorial);
ALTER TABLE public.propose_objective ADD CONSTRAINT FK_propose_objective_id_objective FOREIGN KEY (id_objective) REFERENCES public.objective(id_objective);
ALTER TABLE public.propose_task ADD CONSTRAINT FK_propose_task_id_tutorial FOREIGN KEY (id_tutorial) REFERENCES public.tutorial(id_tutorial);
ALTER TABLE public.propose_task ADD CONSTRAINT FK_propose_task_id_task FOREIGN KEY (id_task) REFERENCES public.task(id_task);
