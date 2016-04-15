/*
MySQL Data Transfer
Source Host: localhost
Source Database: elec
Target Host: localhost
Target Database: elec
Date: 2016/4/13 20:42:29
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
-- Table structure for elec_systemddl
-- ----------------------------
DROP TABLE IF EXISTS `elec_systemddl`;
CREATE TABLE `elec_systemddl` (
  `seqId` int(11) NOT NULL COMMENT '序列id',
  `keyword` varchar(20) NOT NULL COMMENT '类型关键字',
  `ddlCode` int(11) NOT NULL COMMENT '操作code',
  `ddlname` varchar(30) NOT NULL COMMENT '操作名',
  PRIMARY KEY (`seqId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for elec_text
-- ----------------------------
DROP TABLE IF EXISTS `elec_text`;
CREATE TABLE `elec_text` (
  `elecid` varchar(32) NOT NULL DEFAULT '',
  `elecname` varchar(30) NOT NULL,
  `electime` datetime DEFAULT NULL,
  `elecremark` varchar(200) DEFAULT NULL,
  `textid` varchar(50) DEFAULT NULL,
  `textname` varchar(50) DEFAULT NULL,
  `textdate` datetime DEFAULT NULL,
  `textremark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`elecid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `elec_commonmsg` VALUES ('1', '还好正常', '貌似不正常', '2016-03-06 13:47:51');
INSERT INTO `elec_commonmsg` VALUES ('2', 'fdsgdfs', 'gfh', '2016-03-26 11:15:57');
INSERT INTO `elec_text` VALUES ('40288ac8527775a201527775af8a0001', 'yzx', '2016-01-25 14:25:46', '测试mark', null, null, null, null);
