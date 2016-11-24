/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.39 : Database - madx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`madx` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `madx`;

/*Table structure for table `java_file_path` */

DROP TABLE IF EXISTS `java_file_path`;

CREATE TABLE `java_file_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `now_line` int(11) DEFAULT NULL COMMENT '最近一次统计总行数',
  `now_num` int(11) DEFAULT NULL COMMENT '最近一次统计总个数',
  `is_big_path` int(1) DEFAULT NULL COMMENT '是否是大路径，小路径则统计其他',
  `creation_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `java_file_path` */

insert  into `java_file_path`(`id`,`user_id`,`path`,`now_line`,`now_num`,`is_big_path`,`creation_time`,`creator`,`modify_time`,`modifier`) values (1,1,'C:\\Users\\A-mdx\\Desktop\\java学习\\java_learn',4375,100,9,'2016-11-24 17:56:54',1,'2016-11-24 18:18:48',1);

/*Table structure for table `java_line_num` */

DROP TABLE IF EXISTS `java_line_num`;

CREATE TABLE `java_line_num` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_num` int(11) DEFAULT NULL,
  `line_num` int(11) DEFAULT NULL,
  `line_than_provious` int(11) DEFAULT NULL COMMENT '较上次新增行数',
  `num_than_provious` int(11) DEFAULT NULL COMMENT '较上次新增文件个数',
  `creation_time` datetime DEFAULT NULL COMMENT '发生时间',
  `creator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `java_line_num` */

insert  into `java_line_num`(`id`,`file_num`,`line_num`,`line_than_provious`,`num_than_provious`,`creation_time`,`creator`) values (1,0,0,0,0,'2016-11-24 17:57:34',1),(2,100,4375,4375,100,'2016-11-24 18:18:48',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(30) DEFAULT NULL,
  `login_name` char(30) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `java_line` int(11) DEFAULT NULL,
  `java_file` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`login_name`,`creation_time`,`phone`,`email`,`address`,`creator`,`modify_time`,`modifier`,`java_line`,`java_file`) values (1,'马东旭','madx','2016-11-24 11:36:47','17316399295','634187415@qq.com','上海市沪宜公路4199号练祁佳苑',1,NULL,NULL,NULL,NULL),(2,'马大哈','mahaha','2016-11-24 17:53:14','15099539295','634187412@qq.com','新疆省乌鲁木齐市天津北路38号',1,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
