create database if not exists springsecuritydb1;

create table if not exists articles(

    article_id int(5) not null AUTO_INCREMENT,
    title varchar(200) not null,
    category varchar(100) not null,
    primary key (article_id)
);


insert into articles(title,category)
values ('Java concurrency','Java'),('Hibernate HQL','Hibernate'),('Spring MVC','Spring');


CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `country` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
);


INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('krishna', '$2a$10$0thNwVljwc64rVnIcBFGW.ECbah9/U3SyqJL8Zlusc82ygmWBbakO', 'KrishnaM', 'ROLE_ADMIN', 'India', 1),
	('moorthy', '$2a$10$GedZ5GC63Q90tn9Mgyalye6TPptoINim9wKo0x7Ei5/nvffiNjhva', 'MoorthyK', 'ROLE_USER', 'India', 1);


select * from articles;
select * from users;
