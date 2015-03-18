/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - db_fc_crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_fc_crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_fc_crm`;

/*Table structure for table `t_crm_customer` */

DROP TABLE IF EXISTS `t_crm_customer`;

CREATE TABLE `t_crm_customer` (
  `cusid` int(20) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `cusname` varchar(20) DEFAULT NULL COMMENT '客户名称',
  `custel` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `trade` varchar(20) DEFAULT NULL COMMENT '行业',
  `leading` varchar(20) DEFAULT NULL COMMENT '负责人',
  `touchnum` varchar(20) DEFAULT NULL COMMENT '联系次数',
  `creatdate` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `creatuser` varchar(20) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`cusid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_crm_customer` */

insert  into `t_crm_customer`(`cusid`,`cusname`,`custel`,`city`,`trade`,`leading`,`touchnum`,`creatdate`,`creatuser`) values (1,'山东蓝翔技工学校','0000-8888888','山东','教育','24','0','2015-03-17 20:40:00','24');

/*Table structure for table `t_moduleinfo` */

DROP TABLE IF EXISTS `t_moduleinfo`;

CREATE TABLE `t_moduleinfo` (
  `moduleid` int(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `modulename` varchar(20) NOT NULL COMMENT '模块名称',
  `fatherid` varchar(20) DEFAULT NULL COMMENT '父菜单名称',
  `modulepath` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `createuser` varchar(20) NOT NULL COMMENT '创建者编号',
  `createdate` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`moduleid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_moduleinfo` */

insert  into `t_moduleinfo`(`moduleid`,`modulename`,`fatherid`,`modulepath`,`createuser`,`createdate`) values (1,'系统管理','0','/','24','2015-03-16 10:33:00'),(2,'菜单管理','1','/getpage.do?pageInfo.currentPage=1','24','2015-03-16 10:33:00'),(3,'用户管理','0','/','24','2015-03-16 10:33:00'),(4,'用户信息管理','3','/getuserpage.do?pageInfo.currentPage=1','24','2015-03-16 10:33:00'),(5,'角色信息管理','3','/getrolepage.do?pageInfo.currentPage=1','24','2015-03-16 10:33:00'),(6,'客户管理','0','/','24','2015-03-17 19:45:56'),(7,'客户列表','6','/','24','2015-03-17 19:46:14'),(8,'客户关怀','6','/','24','2015-03-17 19:46:28'),(9,'纪念日','6','/','24','2015-03-17 19:46:39'),(10,'联系人管理','6','/','24','2015-03-17 19:46:48'),(11,'消息管理','0','/','24','2015-03-17 20:28:08'),(12,'新建发送','11','/','24','2015-03-17 20:28:36'),(13,'已发送邮件','11','/','24','2015-03-17 20:28:57'),(14,'销售管理','0','/','24','2015-03-17 20:29:16'),(15,'合同信息管理','14','/','24','2015-03-17 20:29:27'),(16,'发货单','14','/','24','2015-03-17 20:29:43');

/*Table structure for table `t_role_module` */

DROP TABLE IF EXISTS `t_role_module`;

CREATE TABLE `t_role_module` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `roleid` varchar(20) NOT NULL,
  `moduleid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_module` */

insert  into `t_role_module`(`id`,`roleid`,`moduleid`) values (1,'1','1'),(2,'1','2'),(3,'1','3'),(4,'1','4'),(5,'1','5'),(22,'2','1'),(23,'2','3'),(24,'1','6'),(25,'1','7'),(26,'1','8'),(27,'1','9'),(28,'1','10'),(29,'1','11'),(30,'1','12'),(31,'1','13'),(32,'1','14'),(33,'1','15'),(34,'1','16');

/*Table structure for table `t_roleinfo` */

DROP TABLE IF EXISTS `t_roleinfo`;

CREATE TABLE `t_roleinfo` (
  `roleid` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `roledescribe` varchar(20) DEFAULT NULL COMMENT '角色描述',
  `createuser` varchar(20) DEFAULT NULL COMMENT '创建人',
  `createdate` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_roleinfo` */

insert  into `t_roleinfo`(`roleid`,`rolename`,`roledescribe`,`createuser`,`createdate`) values (1,'超级管理员','系统权限最高的管理员','24','2015-03-11 16:24:00'),(2,'管理员','管理员','24','2015-03-11 16:24:00'),(3,'测试角色2','测试角色','24','2015-03-11 16:24:00');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL,
  `roleid` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`userid`,`roleid`) values (1,'24','1'),(10,'25','2'),(11,'26','2'),(12,'27','1');

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `userid` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别 0-女 1-男',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄',
  `mail` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phonenum` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `state` varchar(1) DEFAULT NULL COMMENT '状态 0-正常 1-已删除',
  `createdate` varchar(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`userid`,`username`,`password`,`realname`,`sex`,`age`,`mail`,`phonenum`,`state`,`createdate`) values (24,'admin','9024553d33698a66595c688dc479da8c','管理员','1','20','zhangyw_001@126.com','18234036647','0','2015-03-13 17:07:00'),(25,'zhangyw','9024553d33698a66595c688dc479da8c','张英伟','1','20','zhangyw_001@126.com','111','0','2015-03-13 17:07:00'),(26,'songping','9024553d33698a66595c688dc479da8c','宋萍','0','20','111','111','0','2015-03-13 17:07:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
