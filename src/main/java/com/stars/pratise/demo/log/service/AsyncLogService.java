package com.stars.pratise.demo.log.service;

import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.log.domain.LogErrorInfo;
import com.stars.pratise.demo.log.domain.LogInfo;

public interface AsyncLogService {
    <T> ResponseData addLogInfo(LogInfo logInfo);

    <T> ResponseData addLogErrorInfo(LogErrorInfo logErrorInfo);

    <T> ResponseData findAllLogInfo();

    <T> ResponseData findAllErrorInfo();
}
