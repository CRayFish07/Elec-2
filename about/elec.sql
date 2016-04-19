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
  `seqId` int(11) NOT NULL COMMENT '搴忓垪id',
  `keyword` varchar(20) NOT NULL COMMENT '绫诲瀷鍏抽敭瀛�',
  `ddlCode` int(11) NOT NULL COMMENT '鎿嶄綔code',
  `ddlname` varchar(30) NOT NULL COMMENT '鎿嶄綔鍚�',
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
INSERT INTO `elec_commonmsg` VALUES ('1', '杩樺ソ姝ｅ父', '璨屼技涓嶆甯�', '2016-03-06 13:47:51');
INSERT INTO `elec_commonmsg` VALUES ('2', 'fdsgdfs', 'gfh', '2016-03-26 11:15:57');
INSERT INTO `elec_text` VALUES ('40288ac8527775a201527775af8a0001', 'yzx', '2016-01-25 14:25:46', '娴嬭瘯mark', null, null, null, null);

----------------------------------
---- Elec_User
----------------------------------
DROP TABLE IF EXISTS Elec_User;
CREATE TABLE Elec_User (
	UserId varchar(50) not null primary key comment '用户id',
	JctId varchar(50) not null comment '所属单位code',
	UserName varchar(50) not null comment '用户姓名',
	LogonName varchar(50) not null comment '登录名',
	LogonPassword varchar(50) not null comment '登录密码',
	SexId varchar(10) not null comment '性别',
	BirthDay datetime null comment '生日',
	Address varchar(100) null comment '地址',
	ContactTel varchar(50) null comment '联系电话',
	Email varchar(50) null comment '邮箱',
	Mobile varchar(50) null comment '手机号',
	IsDuty varchar(10) null comment '是否在职',
	OnDutyDate datetime null comment '入职时间',
	OffDutyDate datetime null comment '离职时间',
	remark varchar(500) null comment '备注'
) default charset='utf8';