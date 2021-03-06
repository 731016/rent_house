/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : renthouse

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 15/10/2021 16:48:12
*/

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `aid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `aname` varchar(255)
) DEFAULT charset=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '江岸区');
INSERT INTO `area` VALUES (2, '江汉区');
INSERT INTO `area` VALUES (3, ' 硚口区');
INSERT INTO `area` VALUES (4, ' 汉阳区');
INSERT INTO `area` VALUES (5, '武昌区');
INSERT INTO `area` VALUES (6, ' 青山区');
INSERT INTO `area` VALUES (7, '洪山区');
INSERT INTO `area` VALUES (8, '蔡甸区');
INSERT INTO `area` VALUES (9, '江夏区');
INSERT INTO `area` VALUES (10, '黄陂区');
INSERT INTO `area` VALUES (11, ' 新洲区');
INSERT INTO `area` VALUES (12, '东西湖区');
INSERT INTO `area` VALUES (13, ' 汉南区');

-- ----------------------------
-- Table structure for checkhouserecord
-- ----------------------------
DROP TABLE IF EXISTS `checkhouserecord`;
CREATE TABLE `checkhouserecord`  (
  `cId` int(11) PRIMARY KEY AUTO_INCREMENT,
  `hId` varchar(50) NOT NULL,
  `account` int(11) DEFAULT NULL,
  `checkDate` datetime(0) NOT NULL
) DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Table structure for housing
-- ----------------------------
DROP TABLE IF EXISTS `housing`;
CREATE TABLE `housing`  (
  `hid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `rent` int(11) ,
  `houseType` varchar(50),
  `area` double ,
  `towardid` int(11),
  `imgList` varchar(1024) ,
  `lid` int(11) ,
  `typeId` int(11) ,
  `facilities` varchar(255),
  `state` int(11),
  `aid` int(11),
  `address` varchar(255),
  `describe` varchar(255)
) DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Records of housing
-- ----------------------------
INSERT INTO `housing` VALUES (1, '精品房屋曙光新城c区', 1000, '两室', 95, 1, '*****', 1, 2, '******', 1, 2, '曙光星城', NULL);
INSERT INTO `housing` VALUES (2, '精品房屋曙光新城c区aaa', 1500, '三世', 120, 1, '****', 1, 3, '******', 1, 5, '曙光星城', NULL);

-- ----------------------------
-- Table structure for housingtype
-- ----------------------------
DROP TABLE IF EXISTS `housingtype`;
CREATE TABLE `housingtype`  (
  `typeId` int(11) PRIMARY KEY AUTO_INCREMENT,
  `typename` varchar(255)
) DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Records of housingtype
-- ----------------------------
INSERT INTO `housingtype` VALUES (1, '普通');
INSERT INTO `housingtype` VALUES (2, '公寓');
INSERT INTO `housingtype` VALUES (3, '别墅');
INSERT INTO `housingtype` VALUES (4, '四合院');
INSERT INTO `housingtype` VALUES (5, ' 商住两用');
INSERT INTO `housingtype` VALUES (6, '新里洋房');
INSERT INTO `housingtype` VALUES (7, '平房');
INSERT INTO `housingtype` VALUES (8, '老公房');

-- ----------------------------
-- Table structure for landlord
-- ----------------------------
DROP TABLE IF EXISTS `landlord`;
CREATE TABLE `landlord`  (
  `lId` int(11) PRIMARY KEY AUTO_INCREMENT,
  `lName` varchar(50),
  `phone` varchar(50),
  `address` varchar(50),
  `idCard` varchar(50),
  `account` varchar(255)
)DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Table structure for toward
-- ----------------------------
DROP TABLE IF EXISTS `toward`;
CREATE TABLE `toward`  (
  `towardid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `towardName` varchar(255)
) DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Records of toward
-- ----------------------------
INSERT INTO `toward` VALUES (1, '东');
INSERT INTO `toward` VALUES (2, '南');
INSERT INTO `toward` VALUES (3, '西');
INSERT INTO `toward` VALUES (4, '北');
INSERT INTO `toward` VALUES (5, '东南');
INSERT INTO `toward` VALUES (6, '东北');
INSERT INTO `toward` VALUES (7, '西南');
INSERT INTO `toward` VALUES (8, '西北');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `account` varchar(50) PRIMARY KEY,
  `password` varchar(50),
  `username` varchar(50),
  `nickname` varchar(50),
  `email` varchar(50),
  `phone` varchar(50),
  `img` varchar(255),
  `state` int(11) DEFAULT NULL
) DEFAULT CHARSET=UTF8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('root', '63a9f0ea7bb98050796b649e85481845', '管理员', '管理员', '***', '***', '***', 2);

SET FOREIGN_KEY_CHECKS = 1;
