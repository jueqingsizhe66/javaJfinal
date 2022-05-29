CREATE DATABASE jfinal_demo;

USE jfinal_demo;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `article` (
                        `id` int(11) NOT NULL auto_increment,
                        `title` varchar(200) NOT NULL,
                        `subtitle` varchar(200) NOT NULL,
                        `content` mediumtext NOT NULL,
                        PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `blog` VALUES ('1', 'JFinal Demo Title here', 'JFinal Demo Content here');
INSERT INTO `blog` VALUES ('2', 'test 1', 'test 1');
INSERT INTO `blog` VALUES ('3', 'test 2', 'test 2');
INSERT INTO `blog` VALUES ('4', 'test 3', 'test 3');
INSERT INTO `blog` VALUES ('5', 'test 4', 'test 4');


INSERT INTO `article` VALUES ('1', 'Jfinal Record 1', 'jR1','funny place');
INSERT INTO `article` VALUES ('2', 'Jfinal Record 2', 'jR2','funny place2');
