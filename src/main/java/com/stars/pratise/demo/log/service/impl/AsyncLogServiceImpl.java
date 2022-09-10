package com.stars.pratise.demo.log.service.impl;

import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.log.domain.LogErrorInfo;
import com.stars.pratise.demo.log.domain.LogInfo;
import com.stars.pratise.demo.log.mapper.LogMapper;
import com.stars.pratise.demo.log.service.AsyncLogService;
import com.stars.pratise.demo.util.ResponseDataUtil;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Service("asyncLogService")
public class AsyncLogServiceImpl implements AsyncLogService {

    // 注入mapper类

    @Resource
    private LogMapper logMapper;


    @Override
    public <T> ResponseData addLogInfo(LogInfo logInfo) {
        int result = logMapper.saveLogInfo(logInfo);
        if (result > 0) {
            return ResponseDataUtil.success();
        } else {
            return ResponseDataUtil.failure();
        }
    }

    @Override
    public <T> ResponseData addLogErrorInfo(LogErrorInfo logErrorInfo) {
        int result = logMapper.saveLogErrorInfo(logErrorInfo);
        if (result > 0) {
            return ResponseDataUtil.success();
        } else {
            return ResponseDataUtil.failure();
        }
    }

    @Override
    public <T> ResponseData findAllLogInfo() {
        List<LogInfo> logInfos = logMapper.findAllLogInfo();
        if (logInfos == null) {
            return ResponseDataUtil.buildError();
        } else {
            return ResponseDataUtil.success(logInfos);
        }
    }

    @Override
    public <T> ResponseData findAllErrorInfo() {
        List<LogErrorInfo> logErrorInfos = logMapper.findAllErrorInfo();
        if (logErrorInfos == null) {
            return ResponseDataUtil.buildError();
        } else {
            return ResponseDataUtil.success(logErrorInfos);
        }
    }

}
