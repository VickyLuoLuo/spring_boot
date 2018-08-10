package com.quark.data.rapid.server.service.impl;

import com.quark.data.rapid.server.mapper.RunTimeEnvMapper;
import com.quark.data.rapid.server.model.RunTimeEnv;
import com.quark.data.rapid.server.model.RunTimeEnvExample;
import com.quark.data.rapid.server.service.RuntimeEnvService;
import com.quark.data.rapid.server.util.ResponseBody;
import com.quark.data.rapid.server.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RuntimeEnvServiceImpl implements RuntimeEnvService {

    @Autowired
    RunTimeEnvMapper runTimeEnvMapper;

    /**
     * 添加流处理运行环境
     *
     * @param runtimeName
     * @param runtimeType
     * @param runtimeIp
     * @param runtimePort
     * @param runtimeUsername
     * @param runtimePassword
     * @return
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponseBody addRuntimeEnv(String runtimeName, String runtimeType, String runtimeIp, Integer runtimePort, String runtimeUsername, String runtimePassword) {

        RunTimeEnvExample envExample = new RunTimeEnvExample();
        envExample.createCriteria().andRuntimeNameEqualTo(runtimeName);
        List<RunTimeEnv> runTimeEnvs = runTimeEnvMapper.selectByExample(envExample);
        if (!runTimeEnvs.isEmpty()){
            // 存在同名的运行环境
            return ResultUtil.getErrorResponse("运行环境名称已存在");
        }

        Date now = new Date();
        RunTimeEnv runtimeEnv = new RunTimeEnv();
        runtimeEnv.setCreateTime(now);
        runtimeEnv.setUpdateTime(now);
        runtimeEnv.setRuntimeIp(runtimeIp);
        runtimeEnv.setRuntimeName(runtimeName);
        runtimeEnv.setRuntimePort(runtimePort);
        runtimeEnv.setRuntimeType(runtimeType);
        runtimeEnv.setRuntimeUsername(runtimeUsername);
        runtimeEnv.setRuntimePassword(runtimePassword);

        runTimeEnvMapper.insertSelective(runtimeEnv);
        return ResultUtil.getSuccessResponse(runtimeEnv.getId());
    }

	@Override
	public ResponseBody env_list(Integer page, Integer pageSize, Integer sort, Integer sortType) {
		return null;
	}
}
