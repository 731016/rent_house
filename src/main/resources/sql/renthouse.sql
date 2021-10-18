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

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `cId` int(11) NOT NULL AUTO_INCREMENT,
  `hId` varchar(50) NOT NULL,
  `account` int(11) DEFAULT NULL,
  `checkDate` datetime(0) NOT NULL,
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
  `imgList` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `facilities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `lId` int(11) NOT NULL AUTO_INCREMENT,
  `lName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idCard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
INSERT INTO `userinfo` VALUES ('root', '63a9f0ea7bb98050796b649e85481845', '管理员', '管理员', '***', '***', '***', 2);

SET FOREIGN_KEY_CHECKS = 1;
