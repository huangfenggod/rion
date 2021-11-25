/*
 Navicat Premium Data Transfer

 Source Server         : 120.24.176.228_3306
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 120.24.176.228:3306
 Source Schema         : rion

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 25/11/2021 17:07:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rion1
-- ----------------------------
DROP TABLE IF EXISTS `rion1`;
CREATE TABLE `rion1`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '钱包地址',
  `pay` int(5) NOT NULL COMMENT '0为未付款，1为已付款',
  `pid` int(20) NULL DEFAULT NULL COMMENT '父id',
  `time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`, `address`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rion1
-- ----------------------------
INSERT INTO `rion1` VALUES (1, 'aaaaa', 1, 0, '2021-11-24 19:26:13');
INSERT INTO `rion1` VALUES (2, 'aaaaa', 1, 0, '2021-11-24 19:28:49');
INSERT INTO `rion1` VALUES (3, 'aaaaa', 1, 0, '2021-11-24 19:29:40');
INSERT INTO `rion1` VALUES (4, 'aaaaa', 1, 0, '2021-11-24 19:30:37');
INSERT INTO `rion1` VALUES (5, 'aaaaa', 1, 0, '2021-11-24 19:31:34');
INSERT INTO `rion1` VALUES (6, 'aaaaa', 1, 0, '2021-11-24 19:34:57');
INSERT INTO `rion1` VALUES (7, 'aaaaa', 1, 0, '2021-11-24 19:35:51');
INSERT INTO `rion1` VALUES (8, 'aaaaa', 1, 0, '2021-11-24 19:37:28');
INSERT INTO `rion1` VALUES (9, 'aaaaa', 1, 0, '2021-11-24 19:49:50');
INSERT INTO `rion1` VALUES (10, 'aaaaa', 1, 0, '2021-11-24 19:50:38');
INSERT INTO `rion1` VALUES (11, 'aaaaaa', 1, 0, '2021-11-24 19:57:32');
INSERT INTO `rion1` VALUES (12, 'aaaaaaa', 1, 0, '2021-11-24 19:58:05');
INSERT INTO `rion1` VALUES (13, 'fsww33', 0, 0, '2021-11-24 22:51:34');
INSERT INTO `rion1` VALUES (14, 'fsww331', 0, 0, '2021-11-24 22:54:37');
INSERT INTO `rion1` VALUES (15, 'fsww3312', 1, 0, '2021-11-24 22:54:42');
INSERT INTO `rion1` VALUES (16, 'fsww3312ss', 0, 0, '2021-11-24 22:57:20');
INSERT INTO `rion1` VALUES (17, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c67', 0, 0, '2021-11-24 22:57:32');
INSERT INTO `rion1` VALUES (18, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c56', 0, 0, '2021-11-24 22:58:02');
INSERT INTO `rion1` VALUES (19, 'fsww3312sssw', 1, 0, '2021-11-24 23:16:49');
INSERT INTO `rion1` VALUES (20, 'fsww3312sssw54', 0, 0, '2021-11-24 23:16:55');
INSERT INTO `rion1` VALUES (21, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c59', 0, 0, '2021-11-24 23:30:07');
INSERT INTO `rion1` VALUES (22, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c45', 0, 0, '2021-11-25 09:19:50');
INSERT INTO `rion1` VALUES (23, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c47', 0, 0, '2021-11-25 09:19:56');
INSERT INTO `rion1` VALUES (24, ',0x8151c3f63E358ED8a15728b9bB3BE227c6842c47', 1, 0, '2021-11-25 09:20:02');
INSERT INTO `rion1` VALUES (25, ',0x8151c3f63E358ED8a15728b9bB3BE22456642c47', 1, 0, '2021-11-25 09:20:06');
INSERT INTO `rion1` VALUES (26, ',0x831c3463E358ED8a15728b9bB3BE221456642c47', 1, 0, '2021-11-25 09:20:33');
INSERT INTO `rion1` VALUES (27, ',0x8151c3f63E358ED8a15728b9bB3BE027c6842c99', 1, 0, '2021-11-25 13:33:13');

SET FOREIGN_KEY_CHECKS = 1;
