package com.quark.data.rapid.server.controller;

import com.quark.data.rapid.server.controller.base.BaseController;
import com.quark.data.rapid.server.service.WorkflowGraphService;
import com.quark.data.rapid.server.util.ResponseBody;
import com.quark.data.rapid.server.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workflow_graph")
@Api(tags = {"WorkflowGraph Api"})
public class WorkflowGraphController extends BaseController {

    @Autowired
    private WorkflowGraphService workflowGraphService;

    @RequestMapping(value = "/get_static_nodes", method = RequestMethod.GET)
    @ApiOperation(value = "获取工作流节点模板列表", notes = "获取工作流节点模板列表")
    public ResponseBody getStaticNodes() {

        try {
            return workflowGraphService.getStaticNodes();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("获取节点模板列表失败");
        }
    }

    @RequestMapping(value = "/graph_detail", method = RequestMethod.GET)
    @ApiOperation(value = "根据工作流id查询工作流信息", notes = "根据工作流id查询工作流信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowId", value = "工作流id", required = true, paramType = "query", dataType = "Long")
    })
    public ResponseBody getGraphDetail(@RequestParam(value = "workflowId") Long workflowId) {

        try {
            return workflowGraphService.getGraphDetail(workflowId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("查询工作流信息失败");
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value = "更新工作流节点信息", notes = "编辑节点名称或节点配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeId", value = "节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "nodeName1", value = "节点名称", paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "workflowNodeJsonValue", value = "节点配置信息", paramType = "form", dataType = "String")
    })
    public ResponseBody editNode(@RequestParam(value = "nodeId") Long nodeId,
                                 @RequestParam(value = "nodeName1", required = false) String nodeName,
                                 @RequestParam(value = "workflowNodeJsonValue", required = false) String workflowNodeJsonValue) {

        try {
            return workflowGraphService.editNode(nodeId, nodeName, workflowNodeJsonValue);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("更新工作流节点信息失败");
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除工作流节点", notes = "删除工作流节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeId", value = "节点id", required = true, paramType = "form", dataType = "Long")
    })
    public ResponseBody deleteNode(@RequestParam(value = "nodeId") Long nodeId) {

        try {
            return workflowGraphService.deleteNode(nodeId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("删除工作流节点失败");
        }
    }

    @RequestMapping(value = "/add_node", method = RequestMethod.POST)
    @ApiOperation(value = "新建工作流节点", notes = "新建工作流节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowId", value = "工作流id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "templateId", value = "节点模板id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "nodeName1", value = "节点名称", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "workflowNodeJsonMetadata", required = true, value = "节点坐标信息", paramType = "form", dataType = "String")
    })
    public ResponseBody addNode(@RequestParam(value = "workflowId") Long workflowId,
                                @RequestParam(value = "templateId") Long templateId,
                                @RequestParam(value = "nodeName1") String nodeName,
                                @RequestParam(value = "workflowNodeJsonMetadata") String workflowNodeJsonMetadata) {
        try {
            return workflowGraphService.addNode(workflowId, templateId, nodeName, workflowNodeJsonMetadata);
        } catch (Exception e) {
            return ResultUtil.getErrorResponse("添加节点失败");
        }
    }

    @RequestMapping(value = "/add_node_rel", method = RequestMethod.POST)
    @ApiOperation(value = "新建工作流节点间关系", notes = "新建工作流节点间关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowId", value = "工作流id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "fromId", value = "起始节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "toId", value = "目标节点id", required = true, paramType = "form", dataType = "Long")
    })
    public ResponseBody addNodeRel(@RequestParam(value = "workflowId") Long workflowId,
                                   @RequestParam(value = "fromId") Long fromNodeId,
                                   @RequestParam(value = "toId") Long toNodeId) {

        try {
            return workflowGraphService.addNodeRel(workflowId, fromNodeId, toNodeId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("新建工作流节点间关系失败");
        }
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    @ApiOperation(value = "更新工作流节点坐标", notes = "更新工作流节点坐标")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeId", value = "节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "workflowNodeJsonMetadata", value = "节点坐标信息", required = true, paramType = "form", dataType = "String")
    })
    public ResponseBody moveNode(@RequestParam(value = "nodeId") Long nodeId,
                                 @RequestParam(value = "workflowNodeJsonMetadata") String workflowNodeJsonMetadata) {

        try {
            return workflowGraphService.moveNode(nodeId, workflowNodeJsonMetadata);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("更新工作流节点坐标失败");
        }
    }

    @RequestMapping(value = "/save_node_config", method = RequestMethod.POST)
    @ApiOperation(value = "保存工作流节点信息", notes = "保存工作流节点的配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeId", value = "节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "workflowNodeJsonValue", value = "节点配置信息", required = true, paramType = "form", dataType = "String")
    })
    public ResponseBody saveNodeConfig(@RequestParam(value = "nodeId") Long nodeId,
                                       @RequestParam(value = "workflowNodeJsonValue") String workflowNodeJsonValue) {

        try {
            return workflowGraphService.saveNodeConfig(nodeId, workflowNodeJsonValue);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("保存工作流节点信息失败");
        }
    }

    @RequestMapping(value = "/delete_node_rel", method = RequestMethod.POST)
    @ApiOperation(value = "删除工作流节点间关系", notes = "删除工作流节点间关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nodeRelId", value = "节点关系id", required = true, paramType = "form", dataType = "Long")
    })
    public ResponseBody deleteNodeRel(@RequestParam(value = "nodeRelId") Long nodeRelId) {

        try {
            return workflowGraphService.deleteNodeRel(nodeRelId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("删除工作流节点间关系失败");
        }
    }

    @RequestMapping(value = "/update_node_rel", method = RequestMethod.POST)
    @ApiOperation(value = "更新工作流节点间关系", notes = "更新工作流节点间关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fromId", value = "起始节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "toId", value = "原目标节点id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "newToId", value = "新目标节点id", required = true, paramType = "form", dataType = "Long")
    })
    public ResponseBody updateNodeRel(@RequestParam(value = "fromId") Long fromId,
                                      @RequestParam(value = "toId") Long toId,
                                      @RequestParam(value = "newToId") Long newToId) {

        try {
            return workflowGraphService.updateNodeRel(fromId, toId, newToId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getErrorResponse("更新工作流节点间关系失败");
        }
    }

    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
    @ApiOperation(value = "工作流部署", notes = "工作流部署")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowId", value = "待部署的工作流id", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "workflowInstName", value = "任务名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "runtimeEnvId", value = "运行环境id", required = true, paramType = "query", dataType = "Long")
    })
    public ResponseBody deploy(@RequestParam(value = "workflowId") Long workflowId,
                                      @RequestParam(value = "workflowInstName") String workflowInstName,
                                      @RequestParam(value = "runtimeEnvId") Long runtimeEnvId) {
            return workflowGraphService.deploy(workflowId, workflowInstName, runtimeEnvId);
    }

    @RequestMapping(value = "/job_statistics", method = RequestMethod.GET)
    @ApiOperation(value = "业务运行统计", notes = "业务运行统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowId", value = "工作流id", required = true, paramType = "query", dataType = "Long")
    })
    public ResponseBody jobStatistics(@RequestParam(value = "workflowId") Long workflowId) {
        return workflowGraphService.jobStatistics(workflowId);
    }

    @RequestMapping(value = "/redeploy", method = RequestMethod.POST)
    @ApiOperation(value = "工作流重新部署", notes = "工作流重新部署")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowInstId", value = "工作流运行时id", required = true, paramType = "query", dataType = "Long"),
    })
    public ResponseBody redeploy(@RequestParam(value = "workflowInstId") Long workflowInstId) {
        return workflowGraphService.redeploy(workflowInstId);
    }

    @RequestMapping(value = "/remove_deploy", method = RequestMethod.POST)
    @ApiOperation(value = "删除工作流的部署记录", notes = "删除工作流的部署记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workflowInstId", value = "工作流运行时id", required = true, paramType = "query", dataType = "Long"),
    })
    public ResponseBody removeDeploy(@RequestParam(value = "workflowInstId") Long workflowInstId) {
        return workflowGraphService.removeDeploy(workflowInstId);
    }
}
