DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
	`uid`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email`	varchar(40)	NULL,
	`pw`	varchar(12)	NULL,
	`nick`	varchar(15)	NULL,
	`gender`	int	NULL,
	`age`	int	NULL,
	`regdate`	datetime	NULL
);

DROP TABLE IF EXISTS `Diary`;

CREATE TABLE `Diary` (
	`did`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`uid`	int	NOT NULL,
	`title`	varchar(50)	NULL,
	`content`	varchar(500)	NULL,
	`postdate`	datetime	NULL,
	`uptdate`	datetime	NULL,
	`like`	int	NULL,
	`tag`	varchar(20)	NULL,
	`state`	int	NULL
);

DROP TABLE IF EXISTS `Reply`;

CREATE TABLE `Reply` (
	`rid`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`did`	int	NOT NULL,
	`uid`	int	NOT NULL,
	`parentid`	int	NULL,
	`content`	varchar(200)	NULL,
	`postdate`	datetime	NULL,
	`uptdate`	datetime	NULL
);

DROP TABLE IF EXISTS `Friend`;

CREATE TABLE `Friend` (
	`fid`	int	NOT NULL,
	`uid`	int	NOT NULL
);

DROP TABLE IF EXISTS `Notify`;

CREATE TABLE `Notify` (
	`nid`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`uid`	int	NOT NULL,
	`type`	int	NULL,
	`title`	varchar(30)	NULL,
	`content`	varchar(100)	NULL,
	`regdate`	datetime	NULL,
	`condate`	datetime	NULL,
	`check`	datetime	NULL
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`uid`
);

ALTER TABLE `Diary` ADD CONSTRAINT `PK_DIARY` PRIMARY KEY (
	`did`
);

ALTER TABLE `Reply` ADD CONSTRAINT `PK_REPLY` PRIMARY KEY (
	`rid`
);

ALTER TABLE `Friend` ADD CONSTRAINT `PK_FRIEND` PRIMARY KEY (
	`fid`,
	`uid`
);

ALTER TABLE `Notify` ADD CONSTRAINT `PK_NOTIFY` PRIMARY KEY (
	`nid`,
	`uid`
);

ALTER TABLE `Friend` ADD CONSTRAINT `FK_User_TO_Friend_1` FOREIGN KEY (
	`uid`
)
REFERENCES `User` (
	`uid`
);

ALTER TABLE `Notify` ADD CONSTRAINT `FK_User_TO_Notify_1` FOREIGN KEY (
	`uid`
)
REFERENCES `User` (
	`uid`
);