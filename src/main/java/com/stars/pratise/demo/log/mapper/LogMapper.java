package com.stars.pratise.demo.log.mapper;

import com.stars.pratise.demo.log.doamin.LogErrorInfo;
import com.stars.pratise.demo.log.doamin.LogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LogMapper {
    /**
     * 保存操作信息表
     *
     * @param logInfo 用户
     * @return 成功 - {@code 1} (---)失败 - {@code 0}
     */
    int saveLogInfo(LogInfo logInfo);

    /**
     * 保存异常信息表
     *
     * @param logErrorInfo 用户
     * @return 成功 - {@code 1} (---)失败 - {@code 0}
     */
    int saveLogErrorInfo(LogErrorInfo logErrorInfo);

    /**
     * 查询异常信息表
     * <p>
     * //     * @param logErrorInfo 用户
     *
     * @return 成功 - {@code list} (---)  失败 - {@code null}
     */
    List<LogInfo> findAllLogInfo();

    /**
     * 查询异常信息表
     *
     * @param logErrorInfo 用户
     * @return 成功 - {@code list} (---)  失败 - {@code null}
     */
    List<LogErrorInfo> findAllErrorInfo();
}
