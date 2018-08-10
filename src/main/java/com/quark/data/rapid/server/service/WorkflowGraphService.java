package com.quark.data.rapid.server.service;

import com.quark.data.rapid.server.util.ResponseBody;

/**
 * @author luohl0703
 */
public interface WorkflowGraphService {

    /**
     * 获取工作流节点模板列表
     *
     * @return
     */
    ResponseBody getStaticNodes();

    /**
     * 根据工作流id查询工作流信息
     *
     * @param workflowId 工作流id
     * @return
     */
    ResponseBody getGraphDetail(Long workflowId);


    /**
     * 更新工作流节点信息
     *
     * @param nodeId                节点id
     * @param nodeName              节点名称
     * @param workflowNodeJsonValue 节点配置信息
     * @return
     */
    ResponseBody editNode(Long nodeId, String nodeName, String workflowNodeJsonValue);

    /**
     * 删除节点
     *
     * @param nodeId 节点id
     * @return
     */
    ResponseBody deleteNode(Long nodeId);

    /**
     * 新建工作流节点
     *
     * @param workflowId               工作流id
     * @param templateId               节点类型id
     * @param workflowNodeJsonMetadata 节点坐标信息
     * @return
     */
    ResponseBody addNode(Long workflowId, Long templateId, String nodeName, String workflowNodeJsonMetadata);

    /**
     * 新建工作流节点间关系
     *
     * @param workflowId 工作流id
     * @param fromNodeId 起始节点
     * @param toNodeId   目标节点
     * @return
     */
    ResponseBody addNodeRel(Long workflowId, Long fromNodeId, Long toNodeId);

    /**
     * 更新工作流节点坐标
     *
     * @param nodeId                   节点id
     * @param workflowNodeJsonMetadata 节点坐标信息
     * @return
     */
    ResponseBody moveNode(Long nodeId, String workflowNodeJsonMetadata);

    /**
     * 保存工作流节点信息
     *
     * @param nodeId                节点id
     * @param workflowNodeJsonValue 节点配置信息
     * @return
     */
    ResponseBody saveNodeConfig(Long nodeId, String workflowNodeJsonValue);

    /**
     * 删除工作流节点间关系
     *
     * @param nodeRelId 节点关系id
     * @return
     */
    ResponseBody deleteNodeRel(Long nodeRelId);

    /**
     * 更新工作流节点间关系
     *
     * @param fromId     起始节点id
     * @param toId       原目标节点id
     * @param newToId    新目标节点id
     * @return
     */
    ResponseBody updateNodeRel(Long fromId, Long toId, Long newToId);

    /**
     * 部署工作流
     *
     * @param workflowId 工作流id
     * @param workflowInstName 运行时名称
     * @param runtimeEnvId 运行环境id
     * @return
     */
    ResponseBody deploy(Long workflowId, String workflowInstName, Long runtimeEnvId);

    /**
     * 工作流业务运行统计
     *
     * @param workflowId
     * @return
     */
    ResponseBody jobStatistics(Long workflowId);

    /**
     * 重新部署工作流
     *
     * @param workflowInstId 运行时id
     * @return
     */
    ResponseBody redeploy(Long workflowInstId);

    /**
     * 删除工作流部署记录
     *
     * @param workflowInstId 运行时id
     * @return
     */
    ResponseBody removeDeploy(Long workflowInstId);

    ResponseBody saveWorkflow();
}
