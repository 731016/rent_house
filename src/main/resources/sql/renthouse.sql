/*
 Navicat Premium Data Transfer

 Source Server         : zhang
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : renthouse

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 13/10/2021 14:37:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkhouserecord
-- ----------------------------
DROP TABLE IF EXISTS `checkhouserecord`;
CREATE TABLE `checkhouserecord`  (
  `cId` int(11) NOT NULL AUTO_INCREMENT,
  `hId` int(11) NOT NULL,
  `account` int(11) DEFAULT NULL,
  `checkDate` datetime NOT NULL,
  PRIMARY KEY (`cId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for housing
-- ----------------------------
DROP TABLE IF EXISTS `housing`;
CREATE TABLE `housing`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rent` int(11) DEFAULT NULL,
  `houseType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `area` double DEFAULT NULL,
  `towardid` int(11) DEFAULT NULL,
  `imgList` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `facilities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for housingtype
-- ----------------------------
DROP TABLE IF EXISTS `housingtype`;
CREATE TABLE `housingtype`  (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of housingtype
-- ----------------------------
INSERT INTO `housingtype` VALUES (1, '普通');
INSERT INTO `housingtype` VALUES (2, '公寓');
INSERT INTO `housingtype` VALUES (3, '别墅');
INSERT INTO `housingtype` VALUES (4, ' 四合院');
INSERT INTO `housingtype` VALUES (5, ' 商住两用');
INSERT INTO `housingtype` VALUES (6, '新里洋房');
INSERT INTO `housingtype` VALUES (7, '平房');
INSERT INTO `housingtype` VALUES (8, '老公房');

-- ----------------------------
-- Table structure for landlord
-- ----------------------------
DROP TABLE IF EXISTS `landlord`;
CREATE TABLE `landlord`  (
  `lId` int(11) NOT NULL AUTO_INCREMENT,
  `lName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idCard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`lId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for toward
-- ----------------------------
DROP TABLE IF EXISTS `toward`;
CREATE TABLE `toward`  (
  `towardid` int(11) NOT NULL AUTO_INCREMENT,
  `towardName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`towardid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('root', 'root', '管理员', '管理员', '***', '***', '***', 2);

SET FOREIGN_KEY_CHECKS = 1;
