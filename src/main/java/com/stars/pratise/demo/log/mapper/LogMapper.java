package com.stars.pratise.demo.log.mapper;

import com.stars.pratise.demo.log.doamin.LogErrorInfo;
import com.stars.pratise.demo.log.doamin.LogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface LogMapper {
    /**
     * 保存用户
     *
     * @param logInfo 用户
     * @return 成功 - {@code 1} (---)失败 - {@code 0}
     */
    int saveLogInfo(@Param("logInfo") LogInfo logInfo);

    /**
     * 保存用户
     *
     * @param logErrorInfo 用户
     * @return 成功 - {@code 1} (---)失败 - {@code 0}
     */
    int saveLogErrorInfo(@Param("logErrorInfo") LogErrorInfo logErrorInfo);

}
