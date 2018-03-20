/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - travel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`travel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `travel`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `userID` int(11) NOT NULL COMMENT '用户的ID',
  `account` int(11) NOT NULL DEFAULT '0' COMMENT '用户的积分',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `complain` */

DROP TABLE IF EXISTS `complain`;

CREATE TABLE `complain` (
  `commentID` int(11) NOT NULL COMMENT '所进行举报的评论的ID',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '该举报信息的处理管理员处理情况',
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `essay` */

DROP TABLE IF EXISTS `essay`;

CREATE TABLE `essay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '攻略的ID',
  `userID` int(11) NOT NULL COMMENT '攻略发布人的ID',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章的审核状态，默认为未审核',
  `country` varchar(30) DEFAULT NULL COMMENT '攻略所描述的国家',
  `validate` tinyint(1) NOT NULL DEFAULT '0' COMMENT '当地旅游认证状态，默认为未认证',
  `time` datetime NOT NULL COMMENT '攻略的发布时间',
  `essayHeader` varchar(100) NOT NULL COMMENT '文章的标题',
  `pictureURL` varchar(100) NOT NULL DEFAULT '/default',
  `context` text NOT NULL COMMENT '攻略的内容',
  `managerState` tinyint(1) DEFAULT '0' COMMENT '管理员的文章的审核情况',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `essaycomment` */

DROP TABLE IF EXISTS `essaycomment`;

CREATE TABLE `essaycomment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论的ID',
  `userID` int(11) NOT NULL COMMENT '评论人的用户ID',
  `essayID` int(11) NOT NULL COMMENT '攻略的ID',
  `context` text NOT NULL COMMENT '攻略评论的内容',
  `time` datetime NOT NULL COMMENT '攻略评论的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '提问的ID',
  `userID` int(11) NOT NULL COMMENT '提问发布人的用户ID',
  `time` datetime NOT NULL COMMENT '提问的发布时间',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '提问的状态，false表示未完成',
  `context` text NOT NULL COMMENT '提问的内容',
  `answerID` int(11) DEFAULT NULL COMMENT '所采纳的回答的ID',
  `questionHeader` varchar(200) NOT NULL COMMENT '提问的标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `questionanswer` */

DROP TABLE IF EXISTS `questionanswer`;

CREATE TABLE `questionanswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回答的ID',
  `userID` int(11) NOT NULL COMMENT '回答的用户的ID',
  `questionID` int(11) NOT NULL COMMENT '提问的ID',
  `time` datetime NOT NULL COMMENT '回答的发布时间',
  `context` text NOT NULL COMMENT '回答的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色类型的ID',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `available` tinyint(1) DEFAULT '1' COMMENT '角色的使用可使用状态，true表示可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户的ID',
  `email` varchar(50) DEFAULT NULL COMMENT '用户的邮箱，单用户为管理员的时候，允许其值为null',
  `name` varchar(100) NOT NULL COMMENT '昵称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `timestamp` varchar(13) NOT NULL COMMENT '时间戳，用于加密密码',
  `quote` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `locked` tinyint(1) DEFAULT '0' COMMENT '账号锁定状态，true为锁定',
  `pictureURL` varchar(200) NOT NULL DEFAULT 'http://localhost:8080/picture/default.jpg' COMMENT '用户头像的URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `userID` int(11) NOT NULL COMMENT '用户的ID',
  `roleID` int(11) NOT NULL COMMENT '用户角色的ID',
  PRIMARY KEY (`userID`,`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
