package com.quark.data.rapid.server.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.quark.data.rapid.server.mapper.*;
import com.quark.data.rapid.server.model.*;
import com.quark.data.rapid.server.model.vo.WorkflowEnvVO;
import com.quark.data.rapid.server.service.WorkflowGraphService;
import com.quark.data.rapid.server.service.WorkflowInstService;
import com.quark.data.rapid.server.util.Constants;
import com.quark.data.rapid.server.util.PropertiesUtil;
import com.quark.data.rapid.server.util.ResponseBody;
import com.quark.data.rapid.server.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class WorkflowGraphServiceImpl implements WorkflowGraphService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    NodeTemplateMapper nodeTemplateMapper;

    @Autowired
    WorkflowNodeRelMapper workflowNodeRelMapper;

    @Autowired
    WorkflowNodeMapper2 workflowNodeMapper2;

    @Autowired
    WorkflowNodeMapper workflowNodeMapper;

    @Autowired
    WorkflowMapper workflowMapper;

    @Autowired
    RunTimeEnvMapper runTimeEnvMapper;

    @Autowired
    WorkflowInstMapper workflowInstMapper;

    @Autowired
    RuntimeEnvMapper2 runtimeEnvMapper2;

    @Autowired
    PropertiesUtil propertiesUtil;

    @Autowired
    WorkflowInstService workflowInstService;

    /**
     * 获取工作流节点模板列表
     *
     * @return
     */
    @Override
    public ResponseBody getStaticNodes() {
        Map<String, Object> nodes = new HashMap<>();

        NodeTemplateExample sourceNodeExample = new NodeTemplateExample();
        sourceNodeExample.createCriteria().andNodeTypeEqualTo(Constants.SOURCE).andBelongTypeEqualTo(Constants.COMMON);
        List<NodeTemplate> sourceNode = nodeTemplateMapper.selectByExampleWithBLOBs(sourceNodeExample);

        NodeTemplateExample processNodeExample = new NodeTemplateExample();
        processNodeExample.createCriteria().andNodeTypeEqualTo(Constants.PROCESSOR).andBelongTypeEqualTo(Constants.COMMON);
        List<NodeTemplate> processNode = nodeTemplateMapper.selectByExampleWithBLOBs(processNodeExample);

        NodeTemplateExample sinkNodeExample = new NodeTemplateExample();
        sinkNodeExample.createCriteria().andNodeTypeEqualTo(Constants.SINK).andBelongTypeEqualTo(Constants.COMMON);
        List<NodeTemplate> sinkNode = nodeTemplateMapper.selectByExampleWithBLOBs(sinkNodeExample);

        nodes.put("input", sourceNode);
        nodes.put("process", processNode);
        nodes.put("sink", sinkNode);

        return ResultUtil.getSuccessResponse(nodes);
    }

    /**
     * 根据工作流id查询工作流信息
     *
     * @param workflowId 工作流id
     * @return
     */
    @Override
    public ResponseBody getGraphDetail(Long workflowId) {

        Workflow workflow = workflowMapper.selectByPrimaryKey(workflowId);
        if (null == workflow || "1".equals(workflow.getIsDel())) {
            return ResultUtil.getErrorResponse("该工作流不存在");
        }

        // 获取工作流下所有source节点元数据
        List<WorkflowNodeWithBLOBs> sourceNodes = workflowNodeMapper2.getSourceNode(workflowId);
        List<Map<String, Object>> sourceNodeMetadatas = new ArrayList<>();

        if (!CollectionUtils.isEmpty(sourceNodes)) {
            for (WorkflowNodeWithBLOBs node : sourceNodes) {
                Map<String, Object> sourceNodeMetadata = new HashMap<>();
                Map metadata = (Map) JSON.parse(node.getWorkflowNodeJsonMetadata());
                sourceNodeMetadata.put("id", node.getId());
                sourceNodeMetadata.put("name", node.getWorkflowNodeName());
                sourceNodeMetadata.put("x", metadata.get("x"));
                sourceNodeMetadata.put("y", metadata.get("y"));
                sourceNodeMetadatas.add(sourceNodeMetadata);
            }
        }

        // 获取工作流下所有process节点元数据
        List<WorkflowNodeWithBLOBs> processNodes = workflowNodeMapper2.getProcessNode(workflowId);
        List<Map<String, Object>> processNodeMetadatas = new ArrayList<>();

        if (!CollectionUtils.isEmpty(processNodes)) {
            for (WorkflowNodeWithBLOBs node : processNodes) {
                Map<String, Object> processNodeMetadata = new HashMap<>();
                Map metadata = (Map) JSON.parse(node.getWorkflowNodeJsonMetadata());
                processNodeMetadata.put("id", node.getId());
                processNodeMetadata.put("name", node.getWorkflowNodeName());
                processNodeMetadata.put("x", metadata.get("x"));
                processNodeMetadata.put("y", metadata.get("y"));
                processNodeMetadatas.add(processNodeMetadata);
            }
        }


        // 获取工作流下所有sink节点元数据
        List<WorkflowNodeWithBLOBs> sinkNodes = workflowNodeMapper2.getSinkNode(workflowId);
        List<Map<String, Object>> sinkNodeMetadatas = new ArrayList<>();

        if (!CollectionUtils.isEmpty(sinkNodes)) {
            for (WorkflowNodeWithBLOBs node : sinkNodes) {
                Map<String, Object> sinkNodeMetadata = new HashMap<>();
                Map metadata = (Map) JSON.parse(node.getWorkflowNodeJsonMetadata());
                sinkNodeMetadata.put("id", node.getId());
                sinkNodeMetadata.put("name", node.getWorkflowNodeName());
                sinkNodeMetadata.put("x", metadata.get("x"));
                sinkNodeMetadata.put("y", metadata.get("y"));
                sinkNodeMetadatas.add(sinkNodeMetadata);
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("sources", sourceNodeMetadatas);
        data.put("processors", processNodeMetadatas);
        data.put("sinks", sinkNodeMetadatas);

        Map<String, Object> workflowEditorMetadata = new HashMap<>();
        workflowEditorMetadata.put("workflowId", workflowId);
        workflowEditorMetadata.put("data", data);
        workflowEditorMetadata.put("timestamp", new Date());

        // 获取工作流下所有节点关系数据
        WorkflowNodeRelExample relExample = new WorkflowNodeRelExample();
        relExample.createCriteria().andDataStreamWorkflowIdEqualTo(workflowId);
        List<WorkflowNodeRel> nodeRels = workflowNodeRelMapper.selectByExample(relExample);

        List<Map<String, Object>> edges = new ArrayList<>();
        if (!CollectionUtils.isEmpty(nodeRels)) {
            for (WorkflowNodeRel nodeRel : nodeRels) {
                Map<String, Object> nodeRelMetadata = new HashMap<>();
                nodeRelMetadata.put("id", nodeRel.getId());
                nodeRelMetadata.put("workflowId", nodeRel.getDataStreamWorkflowId());
                nodeRelMetadata.put("fromId", nodeRel.getFromId());
                nodeRelMetadata.put("toId", nodeRel.getToId());
                nodeRelMetadata.put("streamGroupings", "");
                edges.add(nodeRelMetadata);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("edges", edges);
        resultMap.put("workflowEditorMetadata", workflowEditorMetadata);

        return ResultUtil.getSuccessResponse(resultMap);
    }


    /**
     * 更新工作流节点信息
     *
     * @param nodeId                节点id
     * @param nodeName              节点名称
     * @param workflowNodeJsonValue 节点配置信息
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody editNode(Long nodeId, String nodeName, String workflowNodeJsonValue) {

        Date updateTime = new Date();
        WorkflowNodeWithBLOBs node = workflowNodeMapper.selectByPrimaryKey(nodeId);

        logger.info("-----start edit dataStreamWorkflowNode, param is--> nodeId: {}, WorkflowNodeName: {}, WorkflowNodeJsonValue: {}, UpdateTime: {}",
                nodeId, nodeName, workflowNodeJsonValue, updateTime);
        if (null != nodeName) {

            // 检查节点名称在本工作流中是否已存在
            WorkflowNodeExample nodeExample = new WorkflowNodeExample();
            nodeExample.createCriteria().andWorkflowNodeNameEqualTo(nodeName).andDataStreamWorkflowIdEqualTo(node.getDataStreamWorkflowId());

            if (!CollectionUtils.isEmpty(workflowNodeMapper.selectByExample(nodeExample))) {
                return ResultUtil.getErrorResponse("节点名称已存在");
            }

            node.setWorkflowNodeName(nodeName);
        }
        if (null != workflowNodeJsonValue) {
            node.setWorkflowNodeJsonValue(workflowNodeJsonValue);
        }
        node.setUpdateTime(updateTime);
        workflowNodeMapper.updateByPrimaryKeyWithBLOBs(node);
        logger.info("-----edit dataStreamWorkflowNode success!");

        return ResultUtil.getSuccessResponse();
    }

    /**
     * 删除节点
     *
     * @param nodeId 节点id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody deleteNode(Long nodeId) {

        WorkflowNode node = workflowNodeMapper.selectByPrimaryKey(nodeId);

        // 删除节点
        logger.info("-----start delete WorkflowNode, nodeId -->{}", node.getId());
        workflowNodeMapper.deleteByPrimaryKey(nodeId);
        logger.info("-----delete WorkflowNode success!");

        // 删除节点关系
        WorkflowNodeRelExample fromThisNode = new WorkflowNodeRelExample();
        fromThisNode.createCriteria().andDataStreamWorkflowIdEqualTo(node.getDataStreamWorkflowId()).andFromIdEqualTo(nodeId);
        workflowNodeRelMapper.deleteByExample(fromThisNode);
        WorkflowNodeRelExample toThisNode = new WorkflowNodeRelExample();
        toThisNode.createCriteria().andDataStreamWorkflowIdEqualTo(node.getDataStreamWorkflowId()).andToIdEqualTo(nodeId);
        workflowNodeRelMapper.deleteByExample(toThisNode);

        return ResultUtil.getSuccessResponse();
    }

    /**
     * 新建工作流节点
     *
     * @param workflowId               工作流id
     * @param templateId               节点类型id
     * @param nodeName
     * @param workflowNodeJsonMetadata 节点坐标信息
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody addNode(Long workflowId, Long templateId, String nodeName, String workflowNodeJsonMetadata) {
        Date date = new Date();

        // 检查节点名称在本工作流中是否已存在
        WorkflowNodeExample nodeExample = new WorkflowNodeExample();
        nodeExample.createCriteria().andWorkflowNodeNameEqualTo(nodeName).andDataStreamWorkflowIdEqualTo(workflowId);

        if (!CollectionUtils.isEmpty(workflowNodeMapper.selectByExample(nodeExample))) {
            return ResultUtil.getErrorResponse("节点名称已存在");
        }

        logger.info("-----start add dataStreamWorkflowNode, param is--> DataStreamWorkflowId: {}, DataStreamNodeTemplateId: {}, " +
                        "WorkflowNodeName: {}, WorkflowNodeJsonMetadata: {}, UpdateTime: {}", workflowId, templateId, nodeName,
                workflowNodeJsonMetadata, date);
        WorkflowNodeWithBLOBs node = new WorkflowNodeWithBLOBs();
        node.setDataStreamWorkflowId(workflowId);
        node.setDataStreamNodeTemplateId(templateId);
        node.setWorkflowNodeName(nodeName);
        node.setWorkflowNodeJsonMetadata(workflowNodeJsonMetadata);
        node.setCreateTime(date);
        node.setUpdateTime(date);
        workflowNodeMapper.insertSelective(node);
        logger.info("-----add dataStreamWorkflowNode success!");

        return ResultUtil.getSuccessResponse(node.getId());
    }

    /**
     * 新建工作流节点间关系
     *
     * @param workflowId 工作流id
     * @param fromNodeId 起始节点
     * @param toNodeId   目标节点
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody addNodeRel(Long workflowId, Long fromNodeId, Long toNodeId) {

        logger.info("start add WorkflowNodeRel, param is--> WorkflowId: {}, FromId: {}, ToId: {}",
                workflowId, fromNodeId, toNodeId);
        WorkflowNodeRel nodeRel = new WorkflowNodeRel();
        nodeRel.setDataStreamWorkflowId(workflowId);
        nodeRel.setFromId(fromNodeId);
        nodeRel.setToId(toNodeId);
        workflowNodeRelMapper.insertSelective(nodeRel);
        logger.info("add WorkflowNodeRel success!");

        return ResultUtil.getSuccessResponse(nodeRel.getId());
    }

    /**
     * 更新工作流节点坐标
     *
     * @param nodeId                   节点id
     * @param workflowNodeJsonMetadata 节点坐标信息
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody moveNode(Long nodeId, String workflowNodeJsonMetadata) {

        Date updateTime = new Date();

        logger.info("start move WorkflowNode, param is--> nodeId: {}, workflowNodeJsonMetadata: {}, UpdateTime: {}",
                nodeId, workflowNodeJsonMetadata, updateTime);
        WorkflowNodeWithBLOBs node = workflowNodeMapper.selectByPrimaryKey(nodeId);
        node.setWorkflowNodeJsonMetadata(workflowNodeJsonMetadata);
        node.setUpdateTime(updateTime);
        workflowNodeMapper.updateByPrimaryKeyWithBLOBs(node);
        logger.info("move WorkflowNode success!");

        return ResultUtil.getSuccessResponse();
    }

    /**
     * 保存工作流节点信息
     *
     * @param nodeId                节点id
     * @param workflowNodeJsonValue 节点配置信息
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody saveNodeConfig(Long nodeId, String workflowNodeJsonValue) {

        Date updateTime = new Date();

        logger.info("-----start move WorkflowNode, param is--> nodeId: {}, WorkflowNodeJsonValue: {}, UpdateTime: {}",
                nodeId, workflowNodeJsonValue, updateTime);
        WorkflowNodeWithBLOBs node = workflowNodeMapper.selectByPrimaryKey(nodeId);
        node.setWorkflowNodeJsonValue(workflowNodeJsonValue);
        node.setUpdateTime(updateTime);
        workflowNodeMapper.updateByPrimaryKeyWithBLOBs(node);
        logger.info("-----move WorkflowNode success!");

        return ResultUtil.getSuccessResponse();
    }

    /**
     * 删除工作流节点间关系
     *
     * @param nodeRelId 节点关系id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody deleteNodeRel(Long nodeRelId) {

        WorkflowNodeRel nodeRel = workflowNodeRelMapper.selectByPrimaryKey(nodeRelId);
        if (null == nodeRel) {
            return ResultUtil.getErrorResponse("该节点关系不存在");
        }
        logger.info("-----start delete WorkflowNodeRel, id is {}", nodeRelId);
        workflowNodeRelMapper.deleteByPrimaryKey(nodeRelId);
        logger.info("-----delete WorkflowNodeRel success!");
        return ResultUtil.getSuccessResponse();
    }

    /**
     * 更新工作流节点间关系
     *
     * @param fromId  起始节点id
     * @param toId    原目标节点id
     * @param newToId 新目标节点id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody updateNodeRel(Long fromId, Long toId, Long newToId) {

        WorkflowNodeRelExample nodeRelExample = new WorkflowNodeRelExample();

        nodeRelExample.createCriteria().andFromIdEqualTo(fromId).andToIdEqualTo(toId);
        List<WorkflowNodeRel> rels = workflowNodeRelMapper.selectByExample(nodeRelExample);

        if (CollectionUtils.isEmpty(rels)) {
            return ResultUtil.getErrorResponse("该节点关系不存在");
        } else {
            logger.info("-----start update WorkflowNodeRel, param is --> ToId: {}", newToId);
            rels.get(0).setToId(newToId);
            workflowNodeRelMapper.updateByPrimaryKeySelective(rels.get(0));
            logger.info("-----update WorkflowNodeRel success!");
        }

        return ResultUtil.getSuccessResponse();
    }

    /**
     * 部署工作流
     *
     * @param workflowId       工作流id
     * @param workflowInstName 运行时名称
     * @param runtimeEnvId     运行环境id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBody deploy(Long workflowId, String workflowInstName, Long runtimeEnvId) {

        String workflowName = null;
        List<Map<String, Object>> sources = null;
        List<Map<String, Object>> sinks = null;
        List<Map<String, Object>> processors = null;
        List<Map<String, Object>> edges = null;
        Map<String, Object> config = null;

        // 工作流基本信息
        Workflow workflow = workflowMapper.selectByPrimaryKey(workflowId);
        if (null != workflow) {
            workflowName = workflow.getWorkflowName();
        }

        // 获取运行环境配置
        RunTimeEnv runtimeEnv = runTimeEnvMapper.selectByPrimaryKey(runtimeEnvId);
        String workflowType = "";
        String targetHost = "";
        if (null != runtimeEnv) {
            config = new HashMap<>();
            targetHost = runtimeEnv.getRuntimeIp() + ":" + runtimeEnv.getRuntimePort();
            switch (runtimeEnv.getRuntimeType()) {
                case "0":
                    workflowType = "FLINK";
                    break;
                case "1":
                    workflowType = "MEMORY";
                    break;
                case "2":
                    workflowType = "SPARK";
                    break;
                case "3":
                    workflowType = "OTHER";
                    break;
            }
            config.put("targetHost", targetHost);
            config.put("workflowType", workflowType);
        }

        // 获取工作流下所有source节点信息
        List<WorkflowNodeWithBLOBs> sourceNodes = workflowNodeMapper2.getSourceNode(workflowId);
        sources = parseNodeProperties(sourceNodes, workflowId, workflowType);

        // 获取工作流下所有process节点信息
        List<WorkflowNodeWithBLOBs> processNodes = workflowNodeMapper2.getProcessNode(workflowId);
        processors = parseNodeProperties(processNodes, workflowId, workflowType);

        // 获取工作流下所有sink节点信息
        List<WorkflowNodeWithBLOBs> sinkNodes = workflowNodeMapper2.getSinkNode(workflowId);
        sinks = parseNodeProperties(sinkNodes, workflowId, workflowType);

        // 获取工作流下所有节点关系数据
        WorkflowNodeRelExample relExample = new WorkflowNodeRelExample();
        relExample.createCriteria().andDataStreamWorkflowIdEqualTo(workflowId);
        List<WorkflowNodeRel> nodeRels = workflowNodeRelMapper.selectByExample(relExample);

        if (CollUtil.isNotEmpty(nodeRels)) {
            edges = new ArrayList<>();
            for (WorkflowNodeRel nodeRel : nodeRels) {
                Map<String, Object> nodeRelMetadata = new HashMap<>();
                nodeRelMetadata.put("id", nodeRel.getId());
                nodeRelMetadata.put("workflowId", nodeRel.getDataStreamWorkflowId());
                nodeRelMetadata.put("fromId", nodeRel.getFromId());
                nodeRelMetadata.put("toId", nodeRel.getToId());
                nodeRelMetadata.put("streamGroupings", "");
                edges.add(nodeRelMetadata);
            }
        }

        if (null == workflowName || null == sources || null == sinks || null == processors || null == edges || null == config) {
            return ResultUtil.getErrorResponse("json异常,存在空值");
        }
        // json 组装
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("workflowId", workflowId);
        resultMap.put("workflowName", workflowName);
        resultMap.put("sources", sources);
        resultMap.put("sinks", sinks);
        resultMap.put("processors", processors);
        resultMap.put("edges", edges);
        resultMap.put("config", config);

        // 部署
        String result = HttpUtil.post(propertiesUtil.getTopologip() + propertiesUtil.getTopologrun(), resultMap, 10000);
        ResponseBody runRes = JSONUtil.toBean(result, ResponseBody.class);
        if (!HttpStatus.OK.name().equals(runRes.getCode())) {
            logger.error("runtime api 请求异常，request host == {}, response == {}", targetHost, result);
            return ResultUtil.getErrorResponse("部署出现异常");
        }

        // 解析返回的job信息
        Map<String, Object> jobInfo = JSONUtil.parseObj(runRes.getResponseBody().toString());
        String jobId = (String) jobInfo.get("jobId");
        String jobName = (String) jobInfo.get("jobName");
        String state = (String) jobInfo.get("state");

        // 新建运行时
        workflowInstService.deploy_workflow(runtimeEnvId, workflowId, jobId, jobName, state, JSONUtil.toJsonStr(resultMap));
        return ResultUtil.getSuccessResponse();
    }

    /**
     * 工作流业务运行统计
     *
     * @param workflowId
     * @return count: 工作流部署的数量 data：部署列表
     */
    @Override
    public ResponseBody jobStatistics(Long workflowId) {
        HashMap<String, Object> result = new HashMap<>();
        List<WorkflowEnvVO> workflowEnvVOs = runtimeEnvMapper2.getRuntimeEnvByWorkflowId(workflowId);
        result.put("count", workflowEnvVOs.size());
        result.put("data", workflowEnvVOs);
        return ResultUtil.getSuccessResponse(result);
    }

    /**
     * 重新部署工作流
     *
     * @param workflowInstId 运行时id
     * @return
     */
    @Override
    public ResponseBody redeploy(Long workflowInstId) {

        WorkflowInst workflowInst = workflowInstMapper.selectByPrimaryKey(workflowInstId);
        String workflowInstName = workflowInst.getWorkflowInstName();
        String status = workflowInst.getStatus();
        Long runtimeEnvId = workflowInst.getRuntimeEnvId();
        String jobId = workflowInst.getRuntimeJobId();
        Long workflowId = workflowInst.getDataStreamWorkflowId();

        RunTimeEnv runTimeEnv = runTimeEnvMapper.selectByPrimaryKey(runtimeEnvId);
        String runtimeType = runTimeEnv.getRuntimeType();
        String runtimeIp = runTimeEnv.getRuntimeIp();
        Integer runtimePort = runTimeEnv.getRuntimePort();
        String host = runtimeIp + ":" + runtimePort;

        if ("0".equals(status)) { //运行中
            //先停止
            Map<String, Object> json = new HashMap<>();
            json.put("host", host);
            json.put("engineType", Constants.RUNTIME_TYPE_MAP.get(runtimeType));
            json.put("engineId", jobId);

            String stopRes = HttpUtil.post(propertiesUtil.getTopologip() + propertiesUtil.getTopologstop(), json, 10000);
            ResponseBody runRes = JSONUtil.toBean(stopRes, ResponseBody.class);
            if (!HttpStatus.OK.name().equals(runRes.getCode())) {
                logger.error("runtime api 请求异常，request host == {}, response == {}", host, stopRes);
                return ResultUtil.getErrorResponse("工作流停止运行出现异常");
            }
        }

        // 工作流不在运行中
        // 先直接将旧的运行时记录逻辑删除
        workflowInst.setIsDel("1");
        workflowInst.setUpdateTime(new Date());
        workflowInstMapper.updateByPrimaryKeySelective(workflowInst);

        // 然后执行部署，会添一条新的运行时记录
        return deploy(workflowId, workflowInstName, runtimeEnvId);
    }

    /**
     * 删除工作流部署记录
     *
     * @param workflowInstId 运行时id
     * @return
     */
    @Override
    public ResponseBody removeDeploy(Long workflowInstId) {

        WorkflowInst workflowInst = workflowInstMapper.selectByPrimaryKey(workflowInstId);
        String status = workflowInst.getStatus();
        Long runtimeEnvId = workflowInst.getRuntimeEnvId();
        String jobId = workflowInst.getRuntimeJobId();

        RunTimeEnv runTimeEnv = runTimeEnvMapper.selectByPrimaryKey(runtimeEnvId);
        String runtimeType = runTimeEnv.getRuntimeType();
        String runtimeIp = runTimeEnv.getRuntimeIp();
        Integer runtimePort = runTimeEnv.getRuntimePort();
        String host = runtimeIp + ":" + runtimePort;

        if ("0".equals(status)) { //运行中
            //先停止
            Map<String, Object> json = new HashMap<>();
            json.put("host", host);
            json.put("engineType", Constants.RUNTIME_TYPE_MAP.get(runtimeType));
            json.put("engineId", jobId);

            String stopRes = HttpUtil.post(propertiesUtil.getTopologip() + propertiesUtil.getTopologstop(), json, 10000);
            ResponseBody runRes = JSONUtil.toBean(stopRes, ResponseBody.class);
            if (!HttpStatus.OK.name().equals(runRes.getCode())) {
                logger.error("runtime api 请求异常，request host == {}, response == {}", host, stopRes);
                return ResultUtil.getErrorResponse("工作流停止运行出现异常");
            }
        }

        // 工作流不在运行中
        // 先直接将旧的运行时记录逻辑删除
        workflowInst.setIsDel("1");
        workflowInst.setUpdateTime(new Date());
        workflowInstMapper.updateByPrimaryKeySelective(workflowInst);

        return ResultUtil.getSuccessResponse();
    }

    @Override
    public ResponseBody saveWorkflow() {
        return null;
    }

    /**
     * 解析节点属性，拼成需要的json
     *
     * @param nodes
     * @param workflowId
     * @param workflowType
     * @return
     */
    private List<Map<String, Object>> parseNodeProperties(List<WorkflowNodeWithBLOBs> nodes, Long workflowId, String workflowType) {
        List<Map<String, Object>> list = null;

        if (CollUtil.isNotEmpty(nodes)) {
            list = new ArrayList<>();
            for (WorkflowNodeWithBLOBs node : nodes) {
                if (null != node) {
                    NodeTemplate template = nodeTemplateMapper.selectByPrimaryKey(node.getDataStreamNodeTemplateId());
                    Map<String, Object> nodeMetadata = new HashMap<>();

                    nodeMetadata.put("id", node.getId());
                    nodeMetadata.put("workflowId", workflowId);
                    nodeMetadata.put("workflowComponentBundleId", "");
                    nodeMetadata.put("bundleName", "");
                    nodeMetadata.put("bundleSubType", "");
                    nodeMetadata.put("name", node.getWorkflowNodeName());
                    nodeMetadata.put("description", "");
                    nodeMetadata.put("engineType", workflowType);
                    nodeMetadata.put("path", template.getJarPath());
                    nodeMetadata.put("classname", template.getClassname());

                    Map<String, Object> properties = new HashMap<>();
                    Map jsonValue = (Map) JSON.parse(node.getWorkflowNodeJsonValue());
                    properties.put("properties", jsonValue);
                    nodeMetadata.put("config", properties);

                    nodeMetadata.put("outputStreams", "");
                    list.add(nodeMetadata);
                }
            }
        }
        return list;
    }
}
