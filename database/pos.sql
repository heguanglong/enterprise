/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : pos

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-07-21 22:39:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ano` varchar(20) NOT NULL DEFAULT '',
  `aname` varchar(20) DEFAULT NULL,
  `apassword` varchar(20) DEFAULT NULL,
  `asex` varchar(3) DEFAULT NULL,
  `aphone` varchar(20) DEFAULT NULL,
  `adate` varchar(20) DEFAULT NULL,
  `apost` varchar(5) DEFAULT NULL,
  `aremark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', '超级管理员', '丑丒专', '男', '000000000', '2015-12-20 ', '管理员', '最高');
INSERT INTO `admin` VALUES ('123000', 'fsf', '丑丒专', '男', '54243434204', '2015-12-27 00:00:00', '销售员', '嘎嘎嘎嘎嘎嘎费');

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `cno` varchar(20) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `cpassword` varchar(20) NOT NULL,
  `csex` varchar(3) NOT NULL,
  `caddress` varchar(50) NOT NULL,
  `cphone` varchar(20) NOT NULL,
  `cdate` varchar(20) NOT NULL,
  `cremark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('111133', '何广龙', '123456', '男', '广东茂名', '18318865105', '2015-12-24 00:00:00', '很好的');
INSERT INTO `client` VALUES ('333333', 'gfagag试', '000000', '女', 'sssssssssssssssssss', '4253252', '2014-01-01 00:00:00', 'dddddddddddddddddddddd');
INSERT INTO `client` VALUES ('46666', 'fafaf', '789456', '男', 'gaggagagggagaaagaga', '27227272', '2015-12-24 00:00:00', 'gassssssss');
INSERT INTO `client` VALUES ('6657567', 'fssgfgg', '111111', '男', 'dfaaaaaaaaaa', '01102544', '2012-01-01 00:00:00', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gno` varchar(20) NOT NULL,
  `gname` varchar(20) DEFAULT NULL,
  `pno` varchar(20) DEFAULT NULL,
  `gprice` double(11,3) DEFAULT NULL,
  `gcount` int(11) DEFAULT NULL,
  `gclass` varchar(10) DEFAULT NULL,
  `gdate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gno`),
  KEY `pno` (`pno`),
  CONSTRAINT `pno` FOREIGN KEY (`pno`) REFERENCES `provide` (`pno`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('12', '神药好', '123', '12.000', '105', '药品类', '2015-12-06');

-- ----------------------------
-- Table structure for `provide`
-- ----------------------------
DROP TABLE IF EXISTS `provide`;
CREATE TABLE `provide` (
  `pno` varchar(20) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `paddress` varchar(50) NOT NULL,
  `ptelephone` varchar(20) NOT NULL,
  `premark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provide
-- ----------------------------
INSERT INTO `provide` VALUES ('123', '最大的', '来自星星的你', '000000', null);

-- ----------------------------
-- Table structure for `sell`
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `sno` varchar(20) NOT NULL,
  `cno` varchar(20) DEFAULT NULL,
  `gno` varchar(20) DEFAULT NULL,
  `price` double(10,3) DEFAULT NULL,
  `sellcount` int(10) DEFAULT NULL,
  `sumprice` double(10,3) DEFAULT NULL,
  `ano` varchar(20) DEFAULT NULL,
  `sdate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('12', '46666', '12', '12.650', '10', '120.000', '123456', '2015-12-20 00:00:00');
INSERT INTO `sell` VALUES ('123456', '', '12', '12.000', '3', '36.000', null, '2016-05-18');
INSERT INTO `sell` VALUES ('12355', '', '12', '12.000', '3', '36.000', '123456', '2016-05-17');
INSERT INTO `sell` VALUES ('1869180', null, '12', '12.000', '10', '120.000', '123456', '2015-12-20 00:00:00');
INSERT INTO `sell` VALUES ('37455440', null, '12', '12.000', '100', '1200.000', '123456', '2015-12-20 00:00:00');
