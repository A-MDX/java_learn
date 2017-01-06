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

/*Table structure for table `eat_memu` */

DROP TABLE IF EXISTS `eat_memu`;

CREATE TABLE `eat_memu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '饭菜类型',
  `status` int(11) DEFAULT NULL,
  `max_dian` int(11) DEFAULT '20' COMMENT '最大点数',
  `now_dian` int(11) DEFAULT NULL COMMENT '当前点数，点一次少一次',
  `picture` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址 or 名字',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `eat_memu` */

insert  into `eat_memu`(`id`,`name`,`address`,`type`,`status`,`max_dian`,`now_dian`,`picture`,`remark`,`creation_time`,`creator`,`modify_time`,`modifier`) values (1,'黄焖老土豆','上海定西路小巷子',2,10021001,21,21,'http://ww3.sinaimg.cn/mw690/72689c07gw1fbemucvmtcj21kw11x7ct.jpg','我还是想来测试一下。','2017-01-04 20:01:51',1,'2017-01-05 17:51:26',1),(2,'红烧牛肉面','小巷子口',1,10021001,20,NULL,'http://ww2.sinaimg.cn/mw690/7d191febgw1fbh27p2w6aj20ge0gewg7.jpg','测试成功吧','2017-01-06 17:57:28',1,NULL,NULL);

/*Table structure for table `eat_type` */

DROP TABLE IF EXISTS `eat_type`;

CREATE TABLE `eat_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `max_dian` int(11) DEFAULT '20' COMMENT '最大点数',
  `now_dian` int(11) DEFAULT NULL COMMENT '当前点数，点一次少一次',
  `picture` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片地址 or 名字',
  `remark` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `eat_type` */

insert  into `eat_type`(`id`,`name`,`status`,`max_dian`,`now_dian`,`picture`,`remark`,`creation_time`,`creator`,`modify_time`,`modifier`) values (1,'拉面',10021001,20,20,'http://ww3.sinaimg.cn/mw690/7d191febgw1fb6ioe3k74j20jg0czdhc.jpg','好吃的，哈哈哈哈哈哈哈','2016-12-26 17:57:56',1,'2017-01-05 15:23:00',1),(2,'黄焖鸡1',10021001,21,17,'http://ww1.sinaimg.cn/mw690/7d191febgw1fb8uekvzqwj20ht0aa3zs.jpg','还行,EN132','2016-12-28 16:05:03',1,'2016-12-30 15:21:31',1),(3,'大白米饭',10021001,20,NULL,'http://ww3.sinaimg.cn/mw690/7d191febgw1fb7o4f6vnjj20go0bm404.jpg','普通大白米饭','2016-12-29 15:18:05',1,NULL,NULL);

/*Table structure for table `fix_code` */

DROP TABLE IF EXISTS `fix_code`;

CREATE TABLE `fix_code` (
  `code` int(11) NOT NULL COMMENT '代码号',
  `code_type` int(11) DEFAULT NULL COMMENT '代码类型',
  `code_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '代码名称',
  `creation_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人id',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注详情',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `fix_code` */

insert  into `fix_code`(`code`,`code_type`,`code_name`,`creation_time`,`creator`,`remark`) values (10011001,1001,'小路径','2016-12-01 17:25:14',1,'是否是大路径，小路径则统计其他'),(10011002,1001,'大路径','2016-12-01 17:25:15',1,'是否是大路径，小路径则统计其他'),(10021001,1002,'是','2016-12-11 12:13:16',1,'是否状态'),(10021002,1002,'否','2016-12-11 12:16:38',1,'是否状态');

/*Table structure for table `java_file_path` */

DROP TABLE IF EXISTS `java_file_path`;

CREATE TABLE `java_file_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `now_line` int(11) DEFAULT NULL COMMENT '最近一次统计总行数',
  `now_num` int(11) DEFAULT NULL COMMENT '最近一次统计总个数',
  `is_big_path` int(11) DEFAULT NULL COMMENT '是否是大路径，小路径则统计其他',
  `creation_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL COMMENT '是否激活，启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `java_file_path` */

insert  into `java_file_path`(`id`,`user_id`,`path`,`now_line`,`now_num`,`is_big_path`,`creation_time`,`creator`,`modify_time`,`modifier`,`remark`,`is_active`) values (1,1,'C:\\Users\\A-mdx\\Desktop\\java学习\\java_learn',6210,121,10011002,'2016-11-24 17:56:54',1,'2016-12-30 16:08:00',1,NULL,10021001),(2,1,'E:\\workspace',87918,734,10011002,'2016-12-13 10:37:46',1,'2016-12-30 16:08:07',1,'test1',10021001);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `java_line_num` */

insert  into `java_line_num`(`id`,`file_num`,`line_num`,`line_than_provious`,`num_than_provious`,`creation_time`,`creator`) values (1,0,0,0,0,'2016-11-24 17:57:34',1),(2,100,4375,4375,100,'2016-11-24 18:18:48',1),(3,105,4742,367,5,'2016-11-28 18:24:47',1),(4,105,4756,14,0,'2016-12-01 15:54:24',1),(5,110,5075,319,5,'2016-12-05 15:42:54',1),(6,110,5080,5,0,'2016-12-05 15:43:46',1),(7,847,93180,88100,737,'2016-12-21 15:52:42',1),(8,855,94128,948,8,'2016-12-30 16:08:07',1);

/*Table structure for table `line_day_old` */

DROP TABLE IF EXISTS `line_day_old`;

CREATE TABLE `line_day_old` (
  `id` int(7) NOT NULL AUTO_INCREMENT COMMENT '一个统计所有次数的列',
  `name` varchar(15) DEFAULT NULL COMMENT '用日期来做为名字',
  `java_file_num` int(8) DEFAULT NULL COMMENT 'java所有文件的个数',
  `java_line` int(11) DEFAULT NULL COMMENT 'java所有文件的行数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '该统计发生的具体时间',
  `increase_file` int(11) DEFAULT NULL COMMENT '距离上一次统计,新增的文件',
  `increase_line` int(11) DEFAULT NULL COMMENT '距离上一次统计,新增的行数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

/*Data for the table `line_day_old` */

insert  into `line_day_old`(`id`,`name`,`java_file_num`,`java_line`,`create_time`,`increase_file`,`increase_line`) values (1,'2016-02-20',607,25437,'2016-02-21 16:19:15',0,0),(2,'2016-02-21',611,25707,'2016-02-21 19:52:30',4,270),(3,'2016-02-22',618,25928,'2016-02-22 21:04:01',7,221),(4,'2016-02-23',618,25995,'2016-02-23 21:36:50',0,67),(5,'2016-02-24',624,26231,'2016-02-24 21:33:17',6,236),(6,'2016-02-25',631,26473,'2016-02-25 19:07:55',7,242),(7,'2016-02-26',631,26521,'2016-02-26 18:52:26',0,48),(8,'2016-02-27',631,26556,'2016-02-27 20:18:06',0,35),(9,'2016-02-28',646,27351,'2016-02-28 20:34:30',15,795),(10,'2016-02-29',647,27363,'2016-02-29 20:55:54',1,12),(11,'2016-03-01',647,27363,'2016-03-01 21:28:57',0,0),(12,'2016-03-02',657,27831,'2016-03-02 19:31:44',10,468),(13,'2016-03-03',657,27833,'2016-03-03 19:50:49',0,2),(14,'2016-03-04',659,27852,'2016-03-04 17:49:51',2,19),(15,'2016-03-05',659,27852,'2016-03-05 19:06:52',0,0),(16,'2016-03-10',671,28210,'2016-03-10 23:22:49',12,358),(17,'2016-03-11',672,28218,'2016-03-11 19:47:16',1,8),(18,'2016-03-12',672,28218,'2016-03-12 16:38:44',0,0),(19,'2016-03-14',679,28938,'2016-03-14 19:41:06',7,720),(20,'2016-03-15',690,29161,'2016-03-15 23:21:14',11,223),(21,'2016-03-16',691,29221,'2016-03-16 19:59:39',1,60),(22,'2016-03-17',695,29421,'2016-03-17 20:35:11',4,200),(23,'2016-03-18',700,29567,'2016-03-18 20:55:53',5,146),(24,'2016-03-19',700,29567,'2016-03-19 11:47:37',0,0),(25,'2016-03-20',700,29574,'2016-03-20 10:54:41',0,7),(26,'2016-03-21',701,29582,'2016-03-21 20:24:39',1,8),(27,'2016-03-22',706,29863,'2016-03-22 19:37:51',5,281),(28,'2016-03-23',708,30008,'2016-03-23 19:26:26',2,145),(29,'2016-03-24',713,30319,'2016-03-24 19:54:07',5,311),(30,'2016-03-25',716,30642,'2016-03-25 20:28:31',3,323),(31,'2016-03-26',716,30642,'2016-03-26 11:14:16',0,0),(32,'2016-03-27',716,30712,'2016-03-27 21:00:28',0,70),(33,'2016-03-28',724,30886,'2016-03-28 20:24:15',8,174),(34,'2016-03-29',732,31080,'2016-03-29 18:27:22',8,194),(35,'2016-04-01',777,33393,'2016-04-01 19:35:12',45,2313),(36,'2016-04-02',785,33627,'2016-04-02 23:13:44',8,234),(37,'2016-04-03',785,33627,'2016-04-03 14:23:39',0,0),(38,'2016-04-04',785,33627,'2016-04-04 18:55:04',0,0),(39,'2016-04-05',798,34230,'2016-04-05 19:26:37',13,603),(40,'2016-04-06',803,34501,'2016-04-06 19:55:01',5,271),(41,'2016-04-07',830,35594,'2016-04-07 20:28:57',27,1093),(42,'2016-04-08',830,35606,'2016-04-08 22:21:16',0,12),(43,'2016-04-09',830,35606,'2016-04-09 21:58:07',0,0),(44,'2016-04-10',830,35606,'2016-04-10 21:00:38',0,0),(45,'2016-04-11',830,35606,'2016-04-11 20:53:18',0,0),(46,'2016-04-12',831,35634,'2016-04-12 21:51:48',1,28),(47,'2016-04-13',833,35674,'2016-04-13 20:07:00',2,40),(48,'2016-04-14',833,35677,'2016-04-14 22:16:38',0,3),(49,'2016-04-15',837,35873,'2016-04-15 23:27:39',4,196),(50,'2016-04-16',837,35873,'2016-04-16 19:40:27',0,0),(51,'2016-04-17',837,35873,'2016-04-17 22:19:05',0,0),(52,'2016-04-18',837,35873,'2016-04-18 21:59:26',0,0),(53,'2016-04-19',851,36467,'2016-04-19 21:56:13',14,594),(54,'2016-04-20',851,36467,'2016-04-20 19:58:31',0,0),(55,'2016-04-21',875,37647,'2016-04-21 22:29:00',24,1180),(56,'2016-04-22',884,38021,'2016-04-22 21:58:37',9,374),(57,'2016-04-23',884,38021,'2016-04-23 10:45:09',0,0),(58,'2016-04-24',898,38772,'2016-04-24 21:08:10',14,751),(59,'2016-04-25',898,38772,'2016-04-25 09:14:37',0,0),(60,'2016-04-26',911,39262,'2016-04-26 09:30:56',13,490),(61,'2016-04-27',933,40482,'2016-04-27 21:32:19',22,1220),(62,'2016-04-28',940,40806,'2016-04-28 21:47:30',7,324),(63,'2016-04-29',945,40937,'2016-04-29 20:55:20',5,131),(64,'2016-04-30',945,40937,'2016-04-30 12:03:42',0,0),(65,'2016-05-01',945,40937,'2016-05-01 18:14:49',0,0),(66,'2016-05-02',945,40937,'2016-05-02 21:23:53',0,0),(67,'2016-05-03',945,40937,'2016-05-03 09:28:59',0,0),(68,'2016-05-04',945,40937,'2016-05-04 20:33:35',0,0),(69,'2016-05-05',945,40937,'2016-05-05 21:42:34',0,0),(70,'2016-05-06',945,40937,'2016-05-06 09:40:14',0,0),(71,'2016-05-07',948,41004,'2016-05-07 21:05:34',3,67),(72,'2016-05-08',948,41004,'2016-05-08 19:28:19',0,0),(73,'2016-05-09',948,41004,'2016-05-09 09:26:28',0,0),(74,'2016-05-10',950,41102,'2016-05-10 21:46:02',2,98),(75,'2016-05-11',950,41102,'2016-05-11 20:42:28',0,0),(76,'2016-05-12',954,41185,'2016-05-12 22:05:37',4,83),(77,'2016-05-13',955,41302,'2016-05-13 22:45:16',1,117),(78,'2016-05-14',955,41302,'2016-05-14 11:24:02',0,0),(79,'2016-05-16',955,41302,'2016-05-16 09:26:55',0,0),(80,'2016-05-19',959,41445,'2016-05-19 20:39:54',4,143),(81,'2016-05-20',959,41445,'2016-05-20 21:36:24',0,0),(82,'2016-05-21',961,41712,'2016-05-21 20:14:57',2,267),(83,'2016-05-22',966,41901,'2016-05-22 21:43:36',5,189),(84,'2016-05-23',978,42444,'2016-05-23 23:31:33',12,543),(85,'2016-05-24',991,43293,'2016-05-24 21:54:53',13,849),(86,'2016-05-25',991,43293,'2016-05-25 20:22:20',0,0),(87,'2016-05-26',991,43293,'2016-05-26 09:26:49',0,0),(88,'2016-05-27',991,43371,'2016-05-27 22:49:45',0,78),(89,'2016-05-28',991,43371,'2016-05-28 21:23:22',0,0),(90,'2016-05-29',991,43371,'2016-05-29 21:11:19',0,0),(91,'2016-05-31',991,43371,'2016-05-31 09:44:17',0,0),(92,'2016-06-01',991,43371,'2016-06-01 09:47:16',0,0),(93,'2016-06-04',1000,43671,'2016-06-04 11:02:28',9,300);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`login_name`,`creation_time`,`phone`,`email`,`address`,`creator`,`modify_time`,`modifier`,`java_line`,`java_file`) values (1,'马东旭','madx','2016-11-24 11:36:47','17316399295','634187415@qq.com','上海市沪宜公路4199号练祁佳苑',1,'2016-12-30 16:08:07',1,94128,855),(2,'马大哈','mahaha','2016-11-24 17:53:14','15099539295','634187412@qq.com','新疆省乌鲁木齐市天津北路38号',1,NULL,NULL,250,20),(3,'小马哈','xiaohaha','2016-12-21 15:49:48','15392681525','1459763277@qq.com','哪里',NULL,NULL,NULL,500,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
