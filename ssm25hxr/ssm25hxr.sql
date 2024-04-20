-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssm25hxr
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `biaoqianfenlei`
--

DROP TABLE IF EXISTS `biaoqianfenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biaoqianfenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fenlei` varchar(200) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082561878 DEFAULT CHARSET=utf8 COMMENT='标签分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biaoqianfenlei`
--

LOCK TABLES `biaoqianfenlei` WRITE;
/*!40000 ALTER TABLE `biaoqianfenlei` DISABLE KEYS */;
INSERT INTO `biaoqianfenlei` VALUES (61,'2021-03-18 13:58:27','分类1'),(62,'2021-03-18 13:58:27','分类2'),(63,'2021-03-18 13:58:27','分类3'),(64,'2021-03-18 13:58:27','分类4'),(65,'2021-03-18 13:58:27','分类5'),(66,'2021-03-18 13:58:27','分类6'),(1616082561877,'2021-03-18 15:49:21','css ');
/*!40000 ALTER TABLE `biaoqianfenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/ssm25hxr/upload/picture1.jpg'),(2,'picture2','http://localhost:8080/ssm25hxr/upload/picture2.jpg'),(3,'picture3','http://localhost:8080/ssm25hxr/upload/picture3.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjihuafenxiang`
--

DROP TABLE IF EXISTS `discussjihuafenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjihuafenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082636099 DEFAULT CHARSET=utf8 COMMENT='计划分享评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjihuafenxiang`
--

LOCK TABLES `discussjihuafenxiang` WRITE;
/*!40000 ALTER TABLE `discussjihuafenxiang` DISABLE KEYS */;
INSERT INTO `discussjihuafenxiang` VALUES (111,'2021-03-18 13:58:27',1,1,'用户名1','评论内容1','回复内容1'),(112,'2021-03-18 13:58:27',2,2,'用户名2','评论内容2','回复内容2'),(113,'2021-03-18 13:58:27',3,3,'用户名3','评论内容3','回复内容3'),(114,'2021-03-18 13:58:27',4,4,'用户名4','评论内容4','回复内容4'),(115,'2021-03-18 13:58:27',5,5,'用户名5','评论内容5','回复内容5'),(116,'2021-03-18 13:58:27',6,6,'用户名6','评论内容6','回复内容6'),(1616082159582,'2021-03-18 15:42:38',32,1616082068407,'666','测试',NULL),(1616082636098,'2021-03-18 15:50:35',1616082362010,1616082068407,'666','cs ',NULL);
/*!40000 ALTER TABLE `discussjihuafenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjingyanfenxiang`
--

DROP TABLE IF EXISTS `discussjingyanfenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjingyanfenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082137444 DEFAULT CHARSET=utf8 COMMENT='经验分享评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjingyanfenxiang`
--

LOCK TABLES `discussjingyanfenxiang` WRITE;
/*!40000 ALTER TABLE `discussjingyanfenxiang` DISABLE KEYS */;
INSERT INTO `discussjingyanfenxiang` VALUES (101,'2021-03-18 13:58:27',1,1,'用户名1','评论内容1','回复内容1'),(102,'2021-03-18 13:58:27',2,2,'用户名2','评论内容2','回复内容2'),(103,'2021-03-18 13:58:27',3,3,'用户名3','评论内容3','回复内容3'),(104,'2021-03-18 13:58:27',4,4,'用户名4','评论内容4','回复内容4'),(105,'2021-03-18 13:58:27',5,5,'用户名5','评论内容5','回复内容5'),(106,'2021-03-18 13:58:27',6,6,'用户名6','评论内容6','回复内容6'),(1616082137443,'2021-03-18 15:42:16',21,1616082068407,'666','测试',NULL);
/*!40000 ALTER TABLE `discussjingyanfenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussruanjiantuijian`
--

DROP TABLE IF EXISTS `discussruanjiantuijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussruanjiantuijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082674140 DEFAULT CHARSET=utf8 COMMENT='软件推荐评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussruanjiantuijian`
--

LOCK TABLES `discussruanjiantuijian` WRITE;
/*!40000 ALTER TABLE `discussruanjiantuijian` DISABLE KEYS */;
INSERT INTO `discussruanjiantuijian` VALUES (121,'2021-03-18 13:58:27',1,1,'用户名1','评论内容1','回复内容1'),(122,'2021-03-18 13:58:27',2,2,'用户名2','评论内容2','回复内容2'),(123,'2021-03-18 13:58:27',3,3,'用户名3','评论内容3','回复内容3'),(124,'2021-03-18 13:58:27',4,4,'用户名4','评论内容4','回复内容4'),(125,'2021-03-18 13:58:27',5,5,'用户名5','评论内容5','回复内容5'),(126,'2021-03-18 13:58:27',6,6,'用户名6','评论内容6','回复内容6'),(1616082179795,'2021-03-18 15:42:59',42,1616082068407,'666','测试',NULL),(1616082181575,'2021-03-18 15:43:00',42,1616082068407,'666','测试',NULL),(1616082654501,'2021-03-18 15:50:53',43,1616082068407,'666','cs ',NULL),(1616082674139,'2021-03-18 15:51:13',1616082415909,1616082068407,'666','测试',NULL);
/*!40000 ALTER TABLE `discussruanjiantuijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusswangzhituijian`
--

DROP TABLE IF EXISTS `discusswangzhituijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusswangzhituijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082691118 DEFAULT CHARSET=utf8 COMMENT='网址推荐评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusswangzhituijian`
--

LOCK TABLES `discusswangzhituijian` WRITE;
/*!40000 ALTER TABLE `discusswangzhituijian` DISABLE KEYS */;
INSERT INTO `discusswangzhituijian` VALUES (131,'2021-03-18 13:58:27',1,1,'用户名1','评论内容1','回复内容1'),(132,'2021-03-18 13:58:27',2,2,'用户名2','评论内容2','回复内容2'),(133,'2021-03-18 13:58:27',3,3,'用户名3','评论内容3','回复内容3'),(134,'2021-03-18 13:58:27',4,4,'用户名4','评论内容4','回复内容4'),(135,'2021-03-18 13:58:27',5,5,'用户名5','评论内容5','回复内容5'),(136,'2021-03-18 13:58:27',6,6,'用户名6','评论内容6','回复内容6'),(1616082199995,'2021-03-18 15:43:19',52,1616082068407,'666','测试',NULL),(1616082691117,'2021-03-18 15:51:31',1616082460352,1616082068407,'666','测试',NULL);
/*!40000 ALTER TABLE `discusswangzhituijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082224122 DEFAULT CHARSET=utf8 COMMENT='交流论坛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (71,'2021-03-18 13:58:27','帖子标题1','帖子内容1',1,1,'用户名1','开放'),(72,'2021-03-18 13:58:27','帖子标题2','帖子内容2',2,2,'用户名2','开放'),(73,'2021-03-18 13:58:27','帖子标题3','帖子内容3',3,3,'用户名3','开放'),(74,'2021-03-18 13:58:27','帖子标题4','帖子内容4',4,4,'用户名4','开放'),(75,'2021-03-18 13:58:27','帖子标题5','帖子内容5',5,5,'用户名5','开放'),(76,'2021-03-18 13:58:27','帖子标题6','帖子内容6',6,6,'用户名6','开放'),(1616082224121,'2021-03-18 15:43:43','学习','<p>测试111</p>',0,1616082068407,'666','开放');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jihuafenxiang`
--

DROP TABLE IF EXISTS `jihuafenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jihuafenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jihuamingcheng` varchar(200) DEFAULT NULL COMMENT '计划名称',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  `fangfaneirong` longtext COMMENT '方法内容',
  `fangfaxiangqing` longtext COMMENT '方法详情',
  `qitajianyi` longtext COMMENT '其他建议',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `fengmiantupian` varchar(200) DEFAULT NULL COMMENT '封面图片',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082362011 DEFAULT CHARSET=utf8 COMMENT='计划分享';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jihuafenxiang`
--

LOCK TABLES `jihuafenxiang` WRITE;
/*!40000 ALTER TABLE `jihuafenxiang` DISABLE KEYS */;
INSERT INTO `jihuafenxiang` VALUES (32,'2021-03-18 13:58:27','计划名称2','账号2','姓名2','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_zhaopian2.jpg','方法内容2','方法详情2','其他建议2','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_fengmiantupian2.jpg',3,3),(33,'2021-03-18 13:58:27','计划名称3','账号3','姓名3','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_zhaopian3.jpg','方法内容3','方法详情3','其他建议3','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_fengmiantupian3.jpg',3,3),(34,'2021-03-18 13:58:27','计划名称4','账号4','姓名4','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_zhaopian4.jpg','方法内容4','方法详情4','其他建议4','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_fengmiantupian4.jpg',4,4),(35,'2021-03-18 13:58:27','计划名称5','账号5','姓名5','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_zhaopian5.jpg','方法内容5','方法详情5','其他建议5','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_fengmiantupian5.jpg',5,5),(36,'2021-03-18 13:58:27','计划名称6','账号6','姓名6','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_zhaopian6.jpg','方法内容6','方法详情6','其他建议6','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jihuafenxiang_fengmiantupian6.jpg',6,6),(1616082362010,'2021-03-18 15:46:01','测试222','666','李四','http://localhost:8080/ssm25hxr/upload/1616082092595.jpg','测试','<p>测试</p>','测试','2021-03-18 23:45:49','http://localhost:8080/ssm25hxr/upload/1616082355063.jpg',2,1);
/*!40000 ALTER TABLE `jihuafenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingyanfenxiang`
--

DROP TABLE IF EXISTS `jingyanfenxiang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingyanfenxiang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) DEFAULT NULL COMMENT '标题',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `biaoqian` varchar(200) DEFAULT NULL COMMENT '标签',
  `neirong` longtext COMMENT '内容',
  `gerenxiangfa` longtext COMMENT '个人想法',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  `shipinfenxiang` varchar(200) DEFAULT NULL COMMENT '视频分享',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `fengmiantupian` varchar(200) DEFAULT NULL COMMENT '封面图片',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082320326 DEFAULT CHARSET=utf8 COMMENT='经验分享';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingyanfenxiang`
--

LOCK TABLES `jingyanfenxiang` WRITE;
/*!40000 ALTER TABLE `jingyanfenxiang` DISABLE KEYS */;
INSERT INTO `jingyanfenxiang` VALUES (22,'2021-03-18 13:58:27','标题2','账号2','姓名2','标签2','内容2','个人想法2','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_zhaopian2.jpg','','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_fengmiantupian2.jpg',2,2),(23,'2021-03-18 13:58:27','标题3','账号3','姓名3','标签3','内容3','个人想法3','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_zhaopian3.jpg','','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_fengmiantupian3.jpg',3,3),(24,'2021-03-18 13:58:27','标题4','账号4','姓名4','标签4','内容4','个人想法4','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_zhaopian4.jpg','','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_fengmiantupian4.jpg',4,4),(25,'2021-03-18 13:58:27','标题5','账号5','姓名5','标签5','内容5','个人想法5','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_zhaopian5.jpg','','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_fengmiantupian5.jpg',5,5),(26,'2021-03-18 13:58:27','标题6','账号6','姓名6','标签6','内容6','个人想法6','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_zhaopian6.jpg','','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/jingyanfenxiang_fengmiantupian6.jpg',6,6),(1616082320325,'2021-03-18 15:45:20','测试666','666','李四','分类1','测试','<p>测试</p>','http://localhost:8080/ssm25hxr/upload/1616082092595.jpg','http://localhost:8080/ssm25hxr/upload/1616082302865.mp4','2021-03-18 23:45:05','http://localhost:8080/ssm25hxr/upload/1616082314158.jpg',0,0);
/*!40000 ALTER TABLE `jingyanfenxiang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '留言人id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '留言内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082244083 DEFAULT CHARSET=utf8 COMMENT='留言板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (91,'2021-03-18 13:58:27',1,'用户名1','留言内容1','回复内容1'),(92,'2021-03-18 13:58:27',2,'用户名2','留言内容2','回复内容2'),(93,'2021-03-18 13:58:27',3,'用户名3','留言内容3','回复内容3'),(94,'2021-03-18 13:58:27',4,'用户名4','留言内容4','回复内容4'),(95,'2021-03-18 13:58:27',5,'用户名5','留言内容5','回复内容5'),(96,'2021-03-18 13:58:27',6,'用户名6','留言内容6','回复内容6'),(1616082244082,'2021-03-18 15:44:03',1616082068407,'666','测试2123','测试');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` varchar(200) NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='学习资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (81,'2021-03-18 13:58:27','标题1','简介1','http://localhost:8080/ssm25hxr/upload/news_picture1.jpg','内容1'),(82,'2021-03-18 13:58:27','标题2','简介2','http://localhost:8080/ssm25hxr/upload/news_picture2.jpg','内容2'),(83,'2021-03-18 13:58:27','标题3','简介3','http://localhost:8080/ssm25hxr/upload/news_picture3.jpg','内容3'),(84,'2021-03-18 13:58:27','标题4','简介4','http://localhost:8080/ssm25hxr/upload/news_picture4.jpg','内容4'),(85,'2021-03-18 13:58:27','标题5','简介5','http://localhost:8080/ssm25hxr/upload/news_picture5.jpg','内容5'),(86,'2021-03-18 13:58:27','标题6','简介6','http://localhost:8080/ssm25hxr/upload/news_picture6.jpg','内容6');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruanjiantuijian`
--

DROP TABLE IF EXISTS `ruanjiantuijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruanjiantuijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ruanjianmingcheng` varchar(200) DEFAULT NULL COMMENT '软件名称',
  `ruanjianjieshao` longtext COMMENT '软件介绍',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  `ruanjianlaiyuan` varchar(200) DEFAULT NULL COMMENT '软件来源',
  `shipinfenxiang` varchar(200) DEFAULT NULL COMMENT '视频分享',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `ruanjianxiangqing` longtext COMMENT '软件详情',
  `fengmiantupian` varchar(200) DEFAULT NULL COMMENT '封面图片',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082415910 DEFAULT CHARSET=utf8 COMMENT='软件推荐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruanjiantuijian`
--

LOCK TABLES `ruanjiantuijian` WRITE;
/*!40000 ALTER TABLE `ruanjiantuijian` DISABLE KEYS */;
INSERT INTO `ruanjiantuijian` VALUES (42,'2021-03-18 13:58:27','软件名称2','软件介绍2','账号2','姓名2','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_zhaopian2.jpg','软件来源2','','2021-03-18 21:58:27','软件详情2','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_fengmiantupian2.jpg',4,4),(43,'2021-03-18 13:58:27','软件名称3','软件介绍3','账号3','姓名3','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_zhaopian3.jpg','软件来源3','','2021-03-18 21:58:27','软件详情3','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_fengmiantupian3.jpg',3,3),(44,'2021-03-18 13:58:27','软件名称4','软件介绍4','账号4','姓名4','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_zhaopian4.jpg','软件来源4','','2021-03-18 21:58:27','软件详情4','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_fengmiantupian4.jpg',4,4),(45,'2021-03-18 13:58:27','软件名称5','软件介绍5','账号5','姓名5','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_zhaopian5.jpg','软件来源5','','2021-03-18 21:58:27','软件详情5','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_fengmiantupian5.jpg',5,5),(46,'2021-03-18 13:58:27','软件名称6','软件介绍6','账号6','姓名6','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_zhaopian6.jpg','软件来源6','','2021-03-18 21:58:27','软件详情6','http://localhost:8080/ssm25hxr/upload/ruanjiantuijian_fengmiantupian6.jpg',6,6),(1616082415909,'2021-03-18 15:46:55','微信','测试','666','李四','http://localhost:8080/ssm25hxr/upload/1616082092595.jpg','测试','http://localhost:8080/ssm25hxr/upload/1616082394097.mp4','2021-03-18 23:46:35','<p>测试</p>','http://localhost:8080/ssm25hxr/upload/1616082412488.jpg',1,1);
/*!40000 ALTER TABLE `ruanjiantuijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1616082068407,'666','xuesheng','学生','qdbnnsripj6xlw0p00nch3q8co7s7bks','2021-03-18 15:41:15','2021-03-18 16:50:25'),(2,1,'abo','users','管理员','xc6o5gltjcxl6lhb20o4gtd0vp9d5u1b','2021-03-18 15:48:03','2021-03-18 16:48:04');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2021-03-18 13:58:27');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wangzhituijian`
--

DROP TABLE IF EXISTS `wangzhituijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wangzhituijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `wangzhimingcheng` varchar(200) DEFAULT NULL COMMENT '网址名称',
  `wangzhijieshao` longtext COMMENT '网址介绍',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `zhanghao` varchar(200) DEFAULT NULL COMMENT '账号',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  `wangzhilaiyuan` varchar(200) DEFAULT NULL COMMENT '网址来源',
  `shipinfenxiang` varchar(200) DEFAULT NULL COMMENT '视频分享',
  `caozuojianjie` longtext COMMENT '操作简介',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `fengmiantupian` varchar(200) DEFAULT NULL COMMENT '封面图片',
  `wangzhixiangqing` longtext COMMENT '网址详情',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082460353 DEFAULT CHARSET=utf8 COMMENT='网址推荐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wangzhituijian`
--

LOCK TABLES `wangzhituijian` WRITE;
/*!40000 ALTER TABLE `wangzhituijian` DISABLE KEYS */;
INSERT INTO `wangzhituijian` VALUES (52,'2021-03-18 13:58:27','网址名称2','网址介绍2','姓名2','账号2','http://localhost:8080/ssm25hxr/upload/wangzhituijian_zhaopian2.jpg','网址来源2','','操作简介2','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/wangzhituijian_fengmiantupian2.jpg','网址详情2',3,3),(53,'2021-03-18 13:58:27','网址名称3','网址介绍3','姓名3','账号3','http://localhost:8080/ssm25hxr/upload/wangzhituijian_zhaopian3.jpg','网址来源3','','操作简介3','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/wangzhituijian_fengmiantupian3.jpg','网址详情3',3,3),(54,'2021-03-18 13:58:27','网址名称4','网址介绍4','姓名4','账号4','http://localhost:8080/ssm25hxr/upload/wangzhituijian_zhaopian4.jpg','网址来源4','','操作简介4','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/wangzhituijian_fengmiantupian4.jpg','网址详情4',4,4),(55,'2021-03-18 13:58:27','网址名称5','网址介绍5','姓名5','账号5','http://localhost:8080/ssm25hxr/upload/wangzhituijian_zhaopian5.jpg','网址来源5','','操作简介5','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/wangzhituijian_fengmiantupian5.jpg','网址详情5',5,5),(56,'2021-03-18 13:58:27','网址名称6','网址介绍6','姓名6','账号6','http://localhost:8080/ssm25hxr/upload/wangzhituijian_zhaopian6.jpg','网址来源6','','操作简介6','2021-03-18 21:58:27','http://localhost:8080/ssm25hxr/upload/wangzhituijian_fengmiantupian6.jpg','网址详情6',6,6),(1616082460352,'2021-03-18 15:47:39','测试','测试','李四','666','http://localhost:8080/ssm25hxr/upload/1616082092595.jpg','测试','http://localhost:8080/ssm25hxr/upload/1616082449566.mp4','<p>测试</p>','2021-03-18 23:47:15','http://localhost:8080/ssm25hxr/upload/1616082440576.jpg','<p>测试</p>',2,2);
/*!40000 ALTER TABLE `wangzhituijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuesheng`
--

DROP TABLE IF EXISTS `xuesheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xuesheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` int(11) DEFAULT NULL COMMENT '年龄',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1616082068408 DEFAULT CHARSET=utf8 COMMENT='学生';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuesheng`
--

LOCK TABLES `xuesheng` WRITE;
/*!40000 ALTER TABLE `xuesheng` DISABLE KEYS */;
INSERT INTO `xuesheng` VALUES (12,'2021-03-18 13:58:27','学生2','123456','姓名2','男',2,'13823888882','773890002@qq.com','440300199202020002','http://localhost:8080/ssm25hxr/upload/xuesheng_zhaopian2.jpg'),(13,'2021-03-18 13:58:27','学生3','123456','姓名3','男',3,'13823888883','773890003@qq.com','440300199303030003','http://localhost:8080/ssm25hxr/upload/xuesheng_zhaopian3.jpg'),(14,'2021-03-18 13:58:27','学生4','123456','姓名4','男',4,'13823888884','773890004@qq.com','440300199404040004','http://localhost:8080/ssm25hxr/upload/xuesheng_zhaopian4.jpg'),(15,'2021-03-18 13:58:27','学生5','123456','姓名5','男',5,'13823888885','773890005@qq.com','440300199505050005','http://localhost:8080/ssm25hxr/upload/xuesheng_zhaopian5.jpg'),(16,'2021-03-18 13:58:27','学生6','123456','姓名6','男',6,'13823888886','773890006@qq.com','440300199606060006','http://localhost:8080/ssm25hxr/upload/xuesheng_zhaopian6.jpg'),(1616082068407,'2021-03-18 15:41:08','666','666','李四','男',21,'13066666666','456@qq.com','441581666666666666','http://localhost:8080/ssm25hxr/upload/1616082092595.jpg');
/*!40000 ALTER TABLE `xuesheng` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-19  9:57:10
