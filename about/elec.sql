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
-- Table structure for elec_user
-- ----------------------------
DROP TABLE IF EXISTS `elec_user`;
CREATE TABLE `elec_user` (
  `UserId` varchar(50) NOT NULL COMMENT '用户id',
  `JctId` varchar(50) NOT NULL COMMENT '所属单位code',
  `UserName` varchar(50) NOT NULL COMMENT '用户姓名',
  `LogonName` varchar(50) NOT NULL COMMENT '登录名',
  `LogonPassword` varchar(50) NOT NULL COMMENT '登录密码',
  `SexId` varchar(10) NOT NULL COMMENT '性别',
  `BirthDay` datetime DEFAULT NULL COMMENT '生日',
  `Address` varchar(100) DEFAULT NULL COMMENT '地址',
  `ContactTel` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `Email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `Mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `IsDuty` varchar(10) DEFAULT NULL COMMENT '是否在职',
  `OnDutyDate` datetime DEFAULT NULL COMMENT '入职时间',
  `OffDutyDate` datetime DEFAULT NULL COMMENT '离职时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `elec_commonmsg` VALUES ('1', '杩樺ソ姝ｅ父', '璨屼技涓嶆甯�', '2016-03-06 13:47:51');
INSERT INTO `elec_commonmsg` VALUES ('2', 'fdsgdfs', 'gfh', '2016-03-26 11:15:57');
INSERT INTO `elec_systemddl` VALUES ('1', '鎵�灞炲崟浣�', '1', '閲嶅簡');
INSERT INTO `elec_systemddl` VALUES ('2', '鎵�灞炲崟浣�', '2', '涓婃捣');
INSERT INTO `elec_systemddl` VALUES ('3', '鎬у埆', '1', '濂�');
INSERT INTO `elec_systemddl` VALUES ('4', '鎬у埆', '2', '鐢�');
INSERT INTO `elec_systemddl` VALUES ('5', '鏄惁鍦ㄨ亴', '1', '鍦ㄨ亴');
INSERT INTO `elec_systemddl` VALUES ('6', '鏄惁鍦ㄨ亴', '2', '绂昏亴');
INSERT INTO `elec_systemddl` VALUES ('7', '鎵�灞炲崟浣�', '3', '鍖椾含');
INSERT INTO `elec_text` VALUES ('40288ac8527775a201527775af8a0001', 'yzx', '2016-01-25 14:25:46', '娴嬭瘯mark', null, null, null, null);
INSERT INTO `elec_user` VALUES ('1', '1', '寮犱笁', 'zhangsan', '123456', '1', null, null, '155556666', null, null, '1', '2016-04-20 13:44:42', null, null);
INSERT INTO `elec_user` VALUES ('2', '2', '鏉庡洓', 'lisi', '1234567', '2', null, null, '125478965', null, null, '1', '2016-04-21 13:45:39', null, null);
