/*
MySQL Data Transfer
Source Host: localhost
Source Database: elec
Target Host: localhost
Target Database: elec
Date: 2016/4/20 21:00:03
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
  `seqId` int(11) NOT NULL COMMENT '–Ú¡–id',
  `keyword` varchar(20) NOT NULL COMMENT '¿‡–Õπÿº¸◊÷',
  `ddlCode` int(11) NOT NULL COMMENT '≤Ÿ◊˜code',
  `ddlname` varchar(30) NOT NULL COMMENT '≤Ÿ◊˜√˚',
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
-- Table structure for elec_user
-- ----------------------------
DROP TABLE IF EXISTS `elec_user`;
CREATE TABLE `elec_user` (
  `UserId` varchar(50) NOT NULL COMMENT '”√ªßid',
  `JctId` varchar(50) NOT NULL COMMENT 'À˘ Ùµ•Œªcode',
  `UserName` varchar(50) NOT NULL COMMENT '”√ªß–’√˚',
  `LogonName` varchar(50) NOT NULL COMMENT 'µ«¬º√˚',
  `LogonPassword` varchar(50) NOT NULL COMMENT 'µ«¬º√‹¬Î',
  `SexId` varchar(10) NOT NULL COMMENT '–‘±',
  `BirthDay` datetime DEFAULT NULL COMMENT '…˙»’',
  `Address` varchar(100) DEFAULT NULL COMMENT 'µÿ÷∑',
  `ContactTel` varchar(50) DEFAULT NULL COMMENT '¡™œµµÁª∞',
  `Email` varchar(50) DEFAULT NULL COMMENT '” œ‰',
  `Mobile` varchar(50) DEFAULT NULL COMMENT ' ÷ª˙∫≈',
  `IsDuty` varchar(10) DEFAULT NULL COMMENT ' «∑Ò‘⁄÷∞',
  `OnDutyDate` datetime DEFAULT NULL COMMENT '»Î÷∞ ±º‰',
  `OffDutyDate` datetime DEFAULT NULL COMMENT '¿Î÷∞ ±º‰',
  `remark` varchar(500) DEFAULT NULL COMMENT '±∏◊¢',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `elec_commonmsg` VALUES ('1', 'ËøòÂ•ΩÊ≠£Â∏∏', 'Ë≤å‰ºº‰∏çÊ≠£Â∏∏', '2016-03-06 13:47:51');
INSERT INTO `elec_commonmsg` VALUES ('2', 'fdsgdfs', 'gfh', '2016-03-26 11:15:57');
INSERT INTO `elec_systemddl` VALUES ('1', 'ÊâÄÂ±ûÂçï‰Ωç', '1', 'ÈáçÂ∫Ü');
INSERT INTO `elec_systemddl` VALUES ('2', 'ÊâÄÂ±ûÂçï‰Ωç', '2', '‰∏äÊµ∑');
INSERT INTO `elec_systemddl` VALUES ('3', 'ÊÄßÂà´', '1', 'Â•≥');
INSERT INTO `elec_systemddl` VALUES ('4', 'ÊÄßÂà´', '2', 'Áî∑');
INSERT INTO `elec_systemddl` VALUES ('5', 'ÊòØÂê¶Âú®ËÅå', '1', 'Âú®ËÅå');
INSERT INTO `elec_systemddl` VALUES ('6', 'ÊòØÂê¶Âú®ËÅå', '2', 'Á¶ªËÅå');
INSERT INTO `elec_systemddl` VALUES ('7', 'ÊâÄÂ±ûÂçï‰Ωç', '3', 'Âåó‰∫¨');
INSERT INTO `elec_text` VALUES ('40288ac8527775a201527775af8a0001', 'yzx', '2016-01-25 14:25:46', 'ÊµãËØïmark', null, null, null, null);
INSERT INTO `elec_user` VALUES ('1', '1', 'Âº†‰∏â', 'zhangsan', '123456', '1', null, null, '155556666', null, null, '1', '2016-04-20 13:44:42', null, null);
INSERT INTO `elec_user` VALUES ('2', '2', 'ÊùéÂõõ', 'lisi', '1234567', '2', null, null, '125478965', null, null, '1', '2016-04-21 13:45:39', null, null);
