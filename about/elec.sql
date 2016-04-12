/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : elec

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-04-12 21:53:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for elec_commonmsg
-- ----------------------------
DROP TABLE IF EXISTS `elec_commonmsg`;
CREATE TABLE `elec_commonmsg` (
  `ComId` varchar(50) NOT NULL,
  `StationRun` varchar(1000) DEFAULT NULL,
  `DevRun` varchar(1000) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ComId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elec_commonmsg
-- ----------------------------
INSERT INTO `elec_commonmsg` VALUES ('1', '正常', '正常', '2016-02-13 22:31:04');
INSERT INTO `elec_commonmsg` VALUES ('2', '有小毛病', '没问题', '2016-02-12 22:32:05');
INSERT INTO `elec_commonmsg` VALUES ('3', 'fd', 'ghh', '2016-02-14 22:59:27');
INSERT INTO `elec_commonmsg` VALUES ('4', '已经可以了', '没问题', '2016-02-14 23:03:15');

-- ----------------------------
-- Table structure for elec_text
-- ----------------------------
DROP TABLE IF EXISTS `elec_text`;
CREATE TABLE `elec_text` (
  `textid` varchar(50) NOT NULL,
  `textname` varchar(50) DEFAULT NULL,
  `textdate` datetime DEFAULT NULL,
  `textremark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`textid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elec_text
-- ----------------------------
INSERT INTO `elec_text` VALUES ('4028818452ab12d30152ab12d52b0001', 'yzx', '2016-02-10 21:49:15', '520yzx');
INSERT INTO `elec_text` VALUES ('4028828252cb6fc50152cb6fc8280001', '测试service1', '2016-02-10 21:47:26', 'service测试1');
INSERT INTO `elec_text` VALUES ('4028828252cb716d0152cb716f310001', '测试service1', '2016-02-10 21:49:14', 'service测试1');
INSERT INTO `elec_text` VALUES ('4028828d52bad7910152bad792ea0001', '测试service', '2016-02-07 16:27:15', 'service测试');
INSERT INTO `elec_text` VALUES ('4028828d52c4a6dd0152c4a6e18a0001', '张三', '2013-03-03 00:00:00', '李四');
INSERT INTO `elec_text` VALUES ('4028828d52ca5da10152ca5dc3120001', '测试service1', '2016-02-10 16:48:05', 'service测试1');
INSERT INTO `elec_text` VALUES ('4028828d52ca835f0152ca8363c70001', 'gfd', null, 'gyh');
INSERT INTO `elec_text` VALUES ('4028828d52ca835f0152ca8479f40003', '测试001', null, '测试备注');
INSERT INTO `elec_text` VALUES ('4028828d52ca86460152ca864af20001', 'test 001', null, 'tt123');
INSERT INTO `elec_text` VALUES ('4028828d52ca86460152ca86d9970003', 'test 002', '2015-06-06 11:11:11', 'tt 123');
INSERT INTO `elec_text` VALUES ('4028828d52ca88a30152ca88a76c0001', 'test 003', '2015-06-06 00:00:00', 'tt1234');
INSERT INTO `elec_text` VALUES ('4028828d52ca8a570152ca8a5ce40001', null, null, null);
INSERT INTO `elec_text` VALUES ('4028828d52ca8a570152ca8ab0080003', 'test 005', '2015-06-06 00:00:00', 'tt456');
INSERT INTO `elec_text` VALUES ('4028828d52ca8a570152ca8b72120005', 'test 006', '2015-01-01 00:00:00', 'tt45');
INSERT INTO `elec_text` VALUES ('4028828d52ca8a570152ca8bba810007', 'ter', '2014-05-04 00:00:00', 'tr');
INSERT INTO `elec_text` VALUES ('4028828d52ca91010152ca9106ba0001', 'test 007', '2014-04-04 00:00:00', 'tt456');

