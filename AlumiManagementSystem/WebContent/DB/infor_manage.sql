/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost
 Source Database       : infor_manage

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : utf-8

 Date: 08/14/2014 18:28:35 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_num` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `manage_range` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `admin_pw` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `admin_right` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `admin`
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('1', 'admin', null, 'ISMvKXpXpadDiUoOSoAfww==', '高级管理员');
COMMIT;

-- ----------------------------
--  Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classes_id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `classes_remarks` longtext COLLATE utf8_bin,
  PRIMARY KEY (`classes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `classes`
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('161', '31212P', 0xe794b5e5ad90e794b5e8b7afe8aebee8aea1e4b88ee5b7a5e889ba), ('162', '31213D', 0xe794b5e5ad90e794b5e8b7afe8aebee8aea1e4b88ee5b7a5e889baefbc88e5afb9e58fa3e58d95e68b9befbc89), ('163', '31214D', 0xe794b5e5ad90e794b5e8b7afe8aebee8aea1e4b88ee5b7a5e889baefbc88e5afb9e58fa3e58d95e68b9befbc89), ('164', '31215P', 0xe794b5e5ad90e794b5e8b7afe8aebee8aea1e4b88ee5b7a5e889baefbc88e59381e8b4a8e7aea1e79086e68a80e69cafefbc89), ('165', '31221P', 0xe58589e794b5e5ad90e68a80e69caf), ('166', '31222P', 0xe58589e794b5e5ad90e68a80e69caf), ('167', '31223P', 0xe58589e794b5e5ad90e68a80e69caf), ('168', '31231P', 0xe5beaee794b5e5ad90e68a80e69caf), ('169', '31241P', 0xe5b7a5e4b89ae78eafe4bf9de4b88ee5ae89e585a8e68a80e69caf), ('170', '31251P', 0xe5ba94e794a8e99fa9e8afad), ('171', '31211P', 0xe794b5e5ad90e794b5e8b7afe8aebee8aea1e4b88ee5b7a5e889baefbc88e5b7a5e7a88be8aebee8aea1efbc89);
COMMIT;

-- ----------------------------
--  Table structure for `doc_protitle`
-- ----------------------------
DROP TABLE IF EXISTS `doc_protitle`;
CREATE TABLE `doc_protitle` (
  `doc_protitle_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_protitle_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `doc_protitle_remarks` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`doc_protitle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `doc_protitle`
-- ----------------------------
BEGIN;
INSERT INTO `doc_protitle` VALUES ('1', '无', '无');
COMMIT;

-- ----------------------------
--  Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `major_remarks` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `major`
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES ('8', '电子电路设计与工艺（工程设计）', '略'), ('9', '电子电路设计与工艺（对口单招）', '略'), ('10', '电子电路设计与工艺（品质管理技术）', '略'), ('11', '光电子技术', '略'), ('12', '微电子技术', '略'), ('13', '工业环保与技术安全', '略'), ('14', '应用韩语', '略');
COMMIT;

-- ----------------------------
--  Table structure for `operate_log`
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class` longtext COLLATE utf8_bin,
  `method` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `createtime` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `loglevel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `logmsg` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `que_quebank`
-- ----------------------------
DROP TABLE IF EXISTS `que_quebank`;
CREATE TABLE `que_quebank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int(11) DEFAULT NULL,
  `que_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK911780FF23021C3C` (`que_id`),
  KEY `FK911780FF93DD8D59` (`questionnaire_id`),
  CONSTRAINT `FK911780FF23021C3C` FOREIGN KEY (`que_id`) REFERENCES `question_bank` (`que_id`),
  CONSTRAINT `FK911780FF93DD8D59` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `que_type`
-- ----------------------------
DROP TABLE IF EXISTS `que_type`;
CREATE TABLE `que_type` (
  `que_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`que_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `question_bank`
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `que_id` int(11) NOT NULL AUTO_INCREMENT,
  `que_type_id` int(11) DEFAULT NULL,
  `que_title` longtext COLLATE utf8_bin,
  `que_option` longtext COLLATE utf8_bin,
  `key_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `recycle_bin` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`que_id`),
  KEY `FKC28E02F59FB10C1C` (`que_type_id`),
  CONSTRAINT `FKC28E02F59FB10C1C` FOREIGN KEY (`que_type_id`) REFERENCES `que_type` (`que_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `questionnaire`
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `questionnaire_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `questionnaire_title` longtext COLLATE utf8_bin,
  `questionnaire_des` longtext COLLATE utf8_bin,
  `remarks` longtext COLLATE utf8_bin,
  `que_date` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`),
  KEY `FKC3610DA3EEB98CD9` (`admin_id`),
  CONSTRAINT `FKC3610DA3EEB98CD9` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `stu_infor`
-- ----------------------------
DROP TABLE IF EXISTS `stu_infor`;
CREATE TABLE `stu_infor` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_id` int(11) DEFAULT NULL,
  `doc_protitle_id` int(11) DEFAULT NULL,
  `tea_protitle_id` int(11) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  `stu_num` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_jg` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `stu_work_place` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_work_post` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_work_address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_work_zc` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_telephone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_qq` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_comm_address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_sex` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_start_time` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_end_time` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_photo_path` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_sfzh` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_nation` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_birth` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `stu_postcode` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `last_xl` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_xw` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sru_honour` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stu_resume` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stu_type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `delete_type` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `FK8216DBB971D590EA` (`doc_protitle_id`),
  KEY `FK8216DBB9FAC02A9A` (`tea_protitle_id`),
  KEY `FK8216DBB9636065B9` (`classes_id`),
  KEY `FK8216DBB92A747C99` (`major_id`),
  CONSTRAINT `FK8216DBB92A747C99` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`),
  CONSTRAINT `FK8216DBB9636065B9` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`classes_id`),
  CONSTRAINT `FK8216DBB971D590EA` FOREIGN KEY (`doc_protitle_id`) REFERENCES `doc_protitle` (`doc_protitle_id`),
  CONSTRAINT `FK8216DBB9FAC02A9A` FOREIGN KEY (`tea_protitle_id`) REFERENCES `tea_protitle` (`tea_protitle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `stu_infor`
-- ----------------------------
BEGIN;
INSERT INTO `stu_infor` VALUES ('217', '161', '1', '1', '8', '1111', 'test', '1111', 'iUISaJDym8tO+n+kTHMmcg==', '1111', '111', '1111', '1111', '111', '111', '111', '111', '111', '908813343@qq.com', '男', '2014-07-30', '2014-07-28', null, '234321234323456578', '1111', '111', '1111', '1111', '1111', '11', '11', '理事', '1'), ('222', '161', '1', '1', '8', '888888', '张三', '湖北武汉', '888888', '江苏南京', '软件开发', '江苏南京', '开发经理', '025-8888888', '18651765342', '908762341', '', '', 'test@test.com', '男', '2014-07-30', '2014-08-26', null, '420701234212888888', '', '', '210018', '', '', '', '', '普通校友', '1');
COMMIT;

-- ----------------------------
--  Table structure for `tea_protitle`
-- ----------------------------
DROP TABLE IF EXISTS `tea_protitle`;
CREATE TABLE `tea_protitle` (
  `tea_protitle_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_protitle_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `tea_protitle_remarks` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tea_protitle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `tea_protitle`
-- ----------------------------
BEGIN;
INSERT INTO `tea_protitle` VALUES ('1', '无', '无');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
