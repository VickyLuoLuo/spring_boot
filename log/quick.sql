CREATE DATABASE  IF NOT EXISTS `one_data_stream` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `one_data_stream`;
-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: 192.168.204.26    Database: one_data_stream
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data_stream_node_template`
--

DROP TABLE IF EXISTS `data_stream_node_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_node_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `node_type` char(1) NOT NULL COMMENT '节点类型（0：Source、1：Processor、2：Sink）',
  `belong_type` char(1) NOT NULL COMMENT '所属类型（0：通用节点、1：租户定制节点）',
  `node_template_name` varchar(50) NOT NULL COMMENT '节点模板名称',
  `json_metadata` longtext NOT NULL COMMENT '节点模板配置json元数据（供页面动态生成使用）',
  `jar_path` varchar(255) DEFAULT NULL COMMENT '节点实现 jar存放路径',
  `classname` varchar(100) DEFAULT NULL COMMENT '节点实现全类名',
  `icon_path` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nor_node_type` (`node_type`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流节点模板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_node_template`
--

LOCK TABLES `data_stream_node_template` WRITE;
/*!40000 ALTER TABLE `data_stream_node_template` DISABLE KEYS */;
INSERT INTO `data_stream_node_template` VALUES (1,'0','0','QuarkData','{\"类型\":[\"全部\",\"产品\",\"网关\",\"设备\"],\"Qos\":[\"0\",\"1\",\"2\"],\"数据格式\":[\"json\",\"string\",\"xml\"]}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/QuarkData.png'),(2,'0','0','Mqtt','{\"IP\":\"\",\"port\":\"\",\"clientId\":\"\",\"nowsession\":\"\",\"用户名\":\"\",\"密码\":\"\",\"主题\":\"\",\"Qos\":[\"0\",\"1\",\"2\"],\"数据格式\":[\"json\",\"string\",\"xml\"]}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/Mqtt.png'),(3,'0','0','Edgex','{\"edgex-core-dataIP\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/Edgex.png'),(4,'1','0','JsFunction','{\"函数\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/js-function.png'),(5,'1','0','SplitArray','{\"splitkey\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/split-array.png'),(6,'1','0','Template','{\"模板\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/template.png'),(7,'2','0','MysqlSink','{\"IP\":\"\",\"port\":\"\",\"database\":\"\",\"用户名\":\"\",\"密码\":\"\",\"table\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/mysql-sink.png'),(8,'2','0','EmailSink','{\"IP\":\"\",\"port\":\"\",\"用户名\":\"\",\"密码\":\"\",\"收件人\":\"\",\"自定义收件人\":\"\"}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/email-sink.png'),(9,'2','0','SmsSink','{}','/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar',NULL,'/assets/img/node/sms-sink.png');
/*!40000 ALTER TABLE `data_stream_node_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_runtime_env`
--

DROP TABLE IF EXISTS `data_stream_runtime_env`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_runtime_env` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `runtime_type` char(1) NOT NULL COMMENT '运行环境类型（0：Flink、1：Memory、2：Spark、3：other）',
  `runtime_name` varchar(50) NOT NULL COMMENT '运行环境名称',
  `runtime_ip` varchar(20) NOT NULL COMMENT '运行环境ip',
  `runtime_port` int(11) DEFAULT NULL COMMENT '运行环境端口',
  `runtime_username` varchar(50) DEFAULT NULL COMMENT '运行环境用户名',
  `runtime_password` varchar(50) DEFAULT NULL COMMENT '运行环境密码',
  `is_online` char(1) NOT NULL COMMENT '是否在线（0：否、1：是）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_tenant_name` (`runtime_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流运行环境';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_runtime_env`
--

LOCK TABLES `data_stream_runtime_env` WRITE;
/*!40000 ALTER TABLE `data_stream_runtime_env` DISABLE KEYS */;
INSERT INTO `data_stream_runtime_env` VALUES (1,'0','flink','192.168.204.37',8081,NULL,NULL,'1','2018-08-08 17:17:35','2018-08-08 17:17:35');
/*!40000 ALTER TABLE `data_stream_runtime_env` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_workflow`
--

DROP TABLE IF EXISTS `data_stream_workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_workflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `workflow_name` varchar(50) NOT NULL COMMENT '数据流工作流名称',
  `workflow_desc` varchar(500) DEFAULT NULL COMMENT '数据流工作流描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` char(1) NOT NULL COMMENT '是否删除（0：否、1：是）',
  PRIMARY KEY (`id`),
  KEY `nor_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流工作流';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_workflow`
--

LOCK TABLES `data_stream_workflow` WRITE;
/*!40000 ALTER TABLE `data_stream_workflow` DISABLE KEYS */;
INSERT INTO `data_stream_workflow` VALUES (1,'page-1','page-1','2018-08-07 14:26:55','2018-08-07 14:26:55','0'),(2,'luohl','测试','2018-08-07 16:03:32','2018-08-07 16:03:32','0'),(3,'画布1','画布1','2018-08-07 16:48:33','2018-08-07 16:48:33','1'),(4,'画布1','画布1','2018-08-07 16:49:15','2018-08-07 16:49:15','1');
/*!40000 ALTER TABLE `data_stream_workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_workflow_dir`
--

DROP TABLE IF EXISTS `data_stream_workflow_dir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_workflow_dir` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `data_stream_workflow_id` bigint(20) DEFAULT NULL COMMENT '数据流工作流id',
  `type` char(1) NOT NULL COMMENT '类型（0：文件夹、1：工作流）',
  `name` varchar(50) NOT NULL COMMENT '名字（type=0时为文件夹名字、type=1时为工作流名字）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='数据流工作流目录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_workflow_dir`
--

LOCK TABLES `data_stream_workflow_dir` WRITE;
/*!40000 ALTER TABLE `data_stream_workflow_dir` DISABLE KEYS */;
INSERT INTO `data_stream_workflow_dir` VALUES (1,0,NULL,'0','folder'),(2,1,1,'1','page-1'),(4,0,NULL,'0','文件夹2'),(5,4,2,'1','画布'),(6,0,NULL,'0','文件夹1'),(7,0,NULL,'0','新建文件夹');
/*!40000 ALTER TABLE `data_stream_workflow_dir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_workflow_inst`
--

DROP TABLE IF EXISTS `data_stream_workflow_inst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_workflow_inst` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `data_stream_workflow_id` bigint(20) NOT NULL COMMENT '数据流工作流id',
  `runtime_env_id` bigint(20) NOT NULL COMMENT '运行环境id',
  `workflow_inst_name` varchar(50) NOT NULL COMMENT '运行时名称',
  `start_time` datetime NOT NULL COMMENT '作业开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '作业结束时间',
  `status` char(1) NOT NULL COMMENT '工作流状态（0：运行中、1：已完成、2：已失败）',
  `runtime_job_id` varchar(50) NOT NULL COMMENT '运行环境作业id，用来获取作业状态',
  `runtime_json` longtext NOT NULL COMMENT '运行时json配置（供任务重启使用）',
  `total` int(10) DEFAULT '0' COMMENT '任务总数',
  `created` int(10) DEFAULT '0' COMMENT '任务已创建数',
  `scheduled` int(10) DEFAULT '0' COMMENT '任务已调度数',
  `deploying` int(10) DEFAULT '0' COMMENT '任务部署中数',
  `running` int(10) DEFAULT '0' COMMENT '任务运行中数',
  `finished` int(10) DEFAULT '0' COMMENT '任务已结束数',
  `canceling` int(10) DEFAULT '0' COMMENT '任务取消中数',
  `canceled` int(10) DEFAULT '0' COMMENT '任务已取消数',
  `failed` int(10) DEFAULT '0' COMMENT '任务失败数',
  `reconciling` int(10) DEFAULT '0',
  `duration` bigint(20) DEFAULT '0' COMMENT '作业运行时长（单位：秒）',
  `is_del` char(1) NOT NULL COMMENT '是否删除（0：否、1：是）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `nor_tenant_workflow` (`data_stream_workflow_id`),
  KEY `nor_name` (`workflow_inst_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流工作流运行记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_workflow_inst`
--

LOCK TABLES `data_stream_workflow_inst` WRITE;
/*!40000 ALTER TABLE `data_stream_workflow_inst` DISABLE KEYS */;
INSERT INTO `data_stream_workflow_inst` VALUES (1,2,1,'Linear Regression','2018-07-31 16:35:21',NULL,'0','011aba1e9a4614501588c6cdae98768d','{   \"workflowId\":1,   \"workflowName\":\"testWorkFlow\",   \"sources\":[     {       \"id\":5,       \"workflowId\":2,       \"workflowComponentBundleId\":2,       \"bundleName\":\"DPFW-SOURCE\",       \"bundleSubType\":\"DPFW\",       \"name\":\"DPFW-SOURCE\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"\",       \"classname\":\"\",       \"config\":{         \"properties\":{           \"dataType\":\"EZMQ\",           \"dataSource\":\"localhost:5555:test\"         }       },       \"outputStreams\":[         {           \"id\":5,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":6,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":7,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":8,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         }       ]     }   ],   \"sinks\":[     {       \"id\":7,       \"workflowId\":2,       \"workflowComponentBundleId\":3,       \"bundleName\":\"DPFW-SINK\",       \"bundleSubType\":\"DPFW\",       \"name\":\"DPFW-SINK\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"\",       \"classname\":\"\",       \"config\":{         \"properties\":{           \"dataType\":\"WS\",           \"dataSink\":\"localhost:7778\"         }       }     }   ],   \"processors\":[     {       \"id\":6,       \"workflowId\":2,       \"workflowComponentBundleId\":5,       \"bundleName\":\"regression-logistic\",       \"bundleSubType\":\"REGRESSION\",       \"name\":\"REGRESSION-LOGISTIC\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar\",       \"classname\":\"org.edgexfoundry.support.dataprocessing.runtime.task.model.LogisticRegressionModel\",       \"config\":{         \"properties\":{           \"weights\":[             1.24,             2.31,             1.24,             2.4           ],           \"error\":0.01,           \"type\":\"Logistic\",           \"inrecord\":[             \"/records/A-CUTTING_TIME\",             \"/records/B-CYCLE_TIME\"           ],           \"outrecord\":[             \"/records/*/estimate\"           ]         }       },       \"outputStreams\":[         {           \"id\":9,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"/records/*/estimate\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":10,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"def\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":11,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"/records/*/estimate\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":12,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"def\",               \"type\":\"STRING\",               \"optional\":true             }           ]         }       ]     }   ],   \"edges\":[     {       \"id\":3,       \"workflowId\":2,       \"fromId\":5,       \"toId\":6,       \"streamGroupings\":[         {           \"streamId\":8,           \"grouping\":\"SHUFFLE\"         }       ]     },     {       \"id\":4,       \"workflowId\":2,       \"fromId\":6,       \"toId\":7,       \"streamGroupings\":[         {           \"streamId\":12,           \"grouping\":\"SHUFFLE\"         }       ]     }   ],   \"workflowEditorMetadata\":{     \"workflowId\":2,     \"data\":\"{\\\"sources\\\":[{\\\"x\\\":317.5,\\\"y\\\":122,\\\"id\\\":1},{\\\"x\\\":-21.25,\\\"y\\\":65.5,\\\"id\\\":5}],\\\"processors\\\":[{\\\"x\\\":653.75,\\\"y\\\":164.25,\\\"id\\\":2},{\\\"x\\\":228.75,\\\"y\\\":121.75,\\\"id\\\":6}],\\\"sinks\\\":[{\\\"x\\\":987.5,\\\"y\\\":103,\\\"id\\\":3},{\\\"x\\\":546.25,\\\"y\\\":44.25,\\\"id\\\":7}],\\\"graphTransforms\\\":{\\\"dragCoords\\\":[132,78],\\\"zoomScale\\\":0.8},\\\"customNames\\\":[]}\",     \"timestamp\":1517460463920   },   \"config\":{     \"targetHost\":\"192.168.204.37:8081\",     \"workflowType\":\"algorithm\"   } }',1,0,0,0,1,0,0,0,0,0,858818028,'0','2018-08-08 18:36:36','2018-07-31 16:35:22'),(2,2,1,'Linear Regression','2018-08-02 14:51:35',NULL,'0','e1a662ed081291a39a036f52923e25c6','{   \"workflowId\":1,   \"workflowName\":\"testWorkFlow\",   \"sources\":[     {       \"id\":5,       \"workflowId\":2,       \"workflowComponentBundleId\":2,       \"bundleName\":\"DPFW-SOURCE\",       \"bundleSubType\":\"DPFW\",       \"name\":\"DPFW-SOURCE\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"\",       \"classname\":\"\",       \"config\":{         \"properties\":{           \"dataType\":\"EZMQ\",           \"dataSource\":\"localhost:5555:test\"         }       },       \"outputStreams\":[         {           \"id\":5,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":6,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":7,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":8,           \"streamId\":\"dpfw_stream_1\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"sample_key\",               \"type\":\"STRING\",               \"optional\":true             }           ]         }       ]     }   ],   \"sinks\":[     {       \"id\":7,       \"workflowId\":2,       \"workflowComponentBundleId\":3,       \"bundleName\":\"DPFW-SINK\",       \"bundleSubType\":\"DPFW\",       \"name\":\"DPFW-SINK\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"\",       \"classname\":\"\",       \"config\":{         \"properties\":{           \"dataType\":\"WS\",           \"dataSink\":\"localhost:7778\"         }       }     }   ],   \"processors\":[     {       \"id\":6,       \"workflowId\":2,       \"workflowComponentBundleId\":5,       \"bundleName\":\"regression-logistic\",       \"bundleSubType\":\"REGRESSION\",       \"name\":\"REGRESSION-LOGISTIC\",       \"description\":\"\",       \"engineType\":\"FLINK\",       \"path\":\"/runtime/data/jar/task/regression-0.1.0-SNAPSHOT.jar\",       \"classname\":\"org.edgexfoundry.support.dataprocessing.runtime.task.model.LogisticRegressionModel\",       \"config\":{         \"properties\":{           \"weights\":[             1.24,             2.31,             1.24,             2.4           ],           \"error\":0.01,           \"type\":\"Logistic\",           \"inrecord\":[             \"/records/A-CUTTING_TIME\",             \"/records/B-CYCLE_TIME\"           ],           \"outrecord\":[             \"/records/*/estimate\"           ]         }       },       \"outputStreams\":[         {           \"id\":9,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"/records/*/estimate\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":10,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"def\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":11,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"/records/*/estimate\",               \"type\":\"STRING\",               \"optional\":true             }           ]         },         {           \"id\":12,           \"streamId\":\"dpfw_stream_2\",           \"workflowId\":2,           \"fields\":[             {               \"name\":\"def\",               \"type\":\"STRING\",               \"optional\":true             }           ]         }       ]     }   ],   \"edges\":[     {       \"id\":3,       \"workflowId\":2,       \"fromId\":5,       \"toId\":6,       \"streamGroupings\":[         {           \"streamId\":8,           \"grouping\":\"SHUFFLE\"         }       ]     },     {       \"id\":4,       \"workflowId\":2,       \"fromId\":6,       \"toId\":7,       \"streamGroupings\":[         {           \"streamId\":12,           \"grouping\":\"SHUFFLE\"         }       ]     }   ],   \"workflowEditorMetadata\":{     \"workflowId\":2,     \"data\":\"{\\\"sources\\\":[{\\\"x\\\":317.5,\\\"y\\\":122,\\\"id\\\":1},{\\\"x\\\":-21.25,\\\"y\\\":65.5,\\\"id\\\":5}],\\\"processors\\\":[{\\\"x\\\":653.75,\\\"y\\\":164.25,\\\"id\\\":2},{\\\"x\\\":228.75,\\\"y\\\":121.75,\\\"id\\\":6}],\\\"sinks\\\":[{\\\"x\\\":987.5,\\\"y\\\":103,\\\"id\\\":3},{\\\"x\\\":546.25,\\\"y\\\":44.25,\\\"id\\\":7}],\\\"graphTransforms\\\":{\\\"dragCoords\\\":[132,78],\\\"zoomScale\\\":0.8},\\\"customNames\\\":[]}\",     \"timestamp\":1517460463920   },   \"config\":{     \"targetHost\":\"192.168.204.37:8081\",     \"workflowType\":\"algorithm\"   } }',6,0,0,0,6,0,0,0,0,0,692244760,'0','2018-08-08 18:34:36','2018-08-02 14:51:35');
/*!40000 ALTER TABLE `data_stream_workflow_inst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_workflow_node`
--

DROP TABLE IF EXISTS `data_stream_workflow_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_workflow_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `data_stream_workflow_id` bigint(20) NOT NULL COMMENT '数据流工作流id',
  `data_stream_node_template_id` bigint(20) NOT NULL COMMENT '数据流节点模板id',
  `workflow_node_name` varchar(50) NOT NULL COMMENT '数据流工作流节点名称',
  `workflow_node_json_value` longtext COMMENT '节点属性json',
  `workflow_node_json_metadata` longtext COMMENT '节点元数据json',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `nor_workflow_id` (`data_stream_workflow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流工作流节点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_workflow_node`
--

LOCK TABLES `data_stream_workflow_node` WRITE;
/*!40000 ALTER TABLE `data_stream_workflow_node` DISABLE KEYS */;
INSERT INTO `data_stream_workflow_node` VALUES (1,2,1,'s_1','{\"类型\"：\"全部\"}','{\"x\":1, \"y\":1}','2018-08-07 16:22:37','2018-08-07 17:28:45'),(2,2,4,'p_1',NULL,'{\"x\":2, \"y\":2}','2018-08-07 16:38:02','2018-08-07 16:38:02'),(4,2,7,'sink_1',NULL,'{\"x\":2, \"y\":3}','2018-08-07 16:40:58','2018-08-07 16:40:58'),(5,2,6,'p_3',NULL,'{\"x\":3, \"y\":0}','2018-08-07 16:41:54','2018-08-07 16:41:54'),(6,2,6,'sink_2','{\"x\":5, \"y\":0}','{\"x\":4, \"y\":0}','2018-08-07 16:42:24','2018-08-07 17:43:24'),(9,2,6,'sink_11',NULL,'{\"x\":5, \"y\":0}','2018-08-07 16:53:17','2018-08-07 18:42:32'),(10,2,6,'sink_6',NULL,'{\"x\":4, \"y\":0}','2018-08-07 16:55:24','2018-08-07 16:55:24'),(11,2,6,'sink_7',NULL,'{\"x\":4, \"y\":0}','2018-08-07 16:57:36','2018-08-07 16:57:36'),(12,2,9,'sink_10',NULL,'{\"x\":5, \"y\":0}','2018-08-07 18:42:12','2018-08-07 18:42:12');
/*!40000 ALTER TABLE `data_stream_workflow_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_stream_workflow_node_rel`
--

DROP TABLE IF EXISTS `data_stream_workflow_node_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_stream_workflow_node_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `data_stream_workflow_id` bigint(20) NOT NULL COMMENT '数据流工作流id',
  `from_id` bigint(20) NOT NULL COMMENT 'from节点id',
  `to_id` bigint(20) NOT NULL COMMENT 'to节点id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_from_to` (`from_id`,`to_id`),
  KEY `nor_workflow` (`data_stream_workflow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据流工作流节点关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_stream_workflow_node_rel`
--

LOCK TABLES `data_stream_workflow_node_rel` WRITE;
/*!40000 ALTER TABLE `data_stream_workflow_node_rel` DISABLE KEYS */;
INSERT INTO `data_stream_workflow_node_rel` VALUES (1,2,1,2),(3,2,2,4);
/*!40000 ALTER TABLE `data_stream_workflow_node_rel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-10 18:35:44
