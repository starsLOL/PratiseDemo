package com.stars.pratise.demo.log.aspect;


import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.stars.pratise.demo.log.annotation.OperLog;
import com.stars.pratise.demo.log.doamin.LogErrorInfo;
import com.stars.pratise.demo.log.doamin.LogInfo;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 使用 aop 切面记录请求日志信息
 * </p>
 *
 * @author yangkai.shen
 * @author chen qi
 * @date Created in 2018-10-01 22:05
 */
@Aspect
@Component
@Slf4j
public class AopLog {


    /**
     * 操作版本号
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     */
    @Value("${version}")
    private String version;

    /**
     * 统计请求的处理时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码å
     */
    @Pointcut("@annotation(com.stars.pratise.demo.log.annotation.OperLog)")

    public void operateLogPoinCut() {
    }

    @Before("operateLogPoinCut()")
    public void doBefore() {
        // 接收到请求，记录请求开始时间
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作 - 切入点
     */
    @Pointcut("execution(public * com.stars.pratise.demo.controller.*Controller.*(..))")
//    @Pointcut("execution(* com.stars.pratise.demo.controller.*.*(..))")
    public void operateExceptionLogPoinCut() {
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作 - 切入点
     */
//    @Pointcut("execution(public * com.stars.pratise.demo.handler.RestExceptionHandler.*(..))")
//    public void restExceptionHandlerPoinCut() {
//    }

    /**
     * 环绕操作
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("operateLogPoinCut()")
    public Object aroundOperateLog(ProceedingJoinPoint point) throws Throwable {

        // 开始打印请求日志
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = Objects.requireNonNull(attributes).getResponse();
        HttpServletRequest request = Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        // 打印请求相关参数

        // 记录执行时间
//        long startTime = System.currentTimeMillis();
        //处理请求
        Object result = point.proceed();
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        assert response != null;
        //记录日志
        try {

            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) point.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);

            assert opLog != null;

            final LogInfo l = LogInfo.builder()
                    .threadId(Long.toString(Thread.currentThread().getId()))
                    .threadName(Thread.currentThread().getName())
                    .ip(getIp(request))
                    .url(request.getRequestURL().toString())
                    .classMethod(String.format("%s.%s", point.getSignature().getDeclaringTypeName(),
                            point.getSignature().getName()))
                    .httpMethod(request.getMethod())
                    .httpStatus(response.getStatus())
                    .operateModul(opLog.operateModul())
                    .operateType(opLog.operateType())
                    .operateDesc(opLog.operatesDesc())
                    .requestParams(JSON.toJSONString(getNameAndValue(point)))
                    .result(JSON.toJSONString(result))
                    .timeCost(System.currentTimeMillis() - startTime.get())
                    .userAgent(header)
                    .browser(userAgent.getBrowser().toString())
                    .os(userAgent.getOperatingSystem().toString()).build();

            log.info("Request Log Info : {}", JSONUtil.toJsonStr(l));
            log.info("请求参数和处理信息 : {}", JSONUtil.toJsonStr(l));
        } catch (Exception e) {
            log.error("==前置通知异常==");
            log.warn("日志异常信息,记录请求日志失败：", e);
        }
        return result;
    }


    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "operateExceptionLogPoinCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) throws Throwable {
//        // 获取RequestAttributes
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        // 从获取RequestAttributes中获取HttpServletRequest的信息
//        assert requestAttributes != null;
//        HttpServletRequest request = (HttpServletRequest) requestAttributes
//                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

//        System.out.println(" -------------------- ok just it  ---------------------");
//        System.out.println(e.getClass().getName());
//        System.out.println(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));
//
//        // 设置方法名称
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(className + " -------------------test------------------ " + methodName);
        HttpServletRequest request = Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        // 记录执行时间
//        long startTime = System.currentTimeMillis();


        //处理请求
//        Object result = joinPoint.proceed();
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        assert response != null;
        //记录错误日志
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
//            Method method = signature.getMethod();
            // 获取请求的类名
//            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
//            String methodName = method.getName();
//            methodName = className + "." + methodName;
//            // 请求的参数
//            Map<String, String> rtnMap = converMap(request.getParameterMap());
//            // 将参数所在的数组转换成json
//            String params = JSON.toJSONString(rtnMap);
            final LogErrorInfo exceptionLog = LogErrorInfo.builder()
                    .threadId(Long.toString(Thread.currentThread().getId()))
                    .threadName(Thread.currentThread().getName())
                    .ip(getIp(request))
                    .url(request.getRequestURL().toString())
                    .classMethod(String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(),
                            joinPoint.getSignature().getName()))
                    .httpMethod(request.getMethod())
                    .exceptionName(e.getClass().getName())
                    .exceptionMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()))
                    .httpStatus(response.getStatus())
                    .requestParams(getNameAndValue(joinPoint))
                    .userAgent(header)
                    .browser(userAgent.getBrowser().toString())
                    .os(userAgent.getOperatingSystem().toString()).build();

            log.error("Request Log Info : {}", JSONUtil.toJsonStr(exceptionLog));
            log.error("请求参数和处理信息 : {}", JSONUtil.toJsonStr(exceptionLog));

//            excepLog.setExcRequParam(params); // 请求参数
//            excepLog.setOperMethod(methodName); // 请求方法名
//            excepLog.setExcName(e.getClass().getName()); // 异常名称
//            excepLog.setExcMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace())); // 异常信息
//            excepLog.setOperUserId(UserShiroUtil.getCurrentUserLoginName()); // 操作员ID
//            excepLog.setOperUserName(UserShiroUtil.getCurrentUserName()); // 操作员名称
//            excepLog.setOperUri(request.getRequestURI()); // 操作URI
//            excepLog.setOperIp(IPUtil.getRemortIP(request)); // 操作员IP
//            excepLog.setOperVer(operVer); // 操作版本号
//            excepLog.setOperCreateTime(new Date()); // 发生异常时间
//
//            exceptionLogService.insert(excepLog);

        } catch (Exception e2) {
            e2.printStackTrace();
            log.error("==前置通知异常==");
            log.error("日志异常信息,记录请求日志失败：", e2);
//            log.warn("日志异常信息,记录请求日志失败：", e2);
        }

    }

    /**
     * 获取方法参数名和参数值
     *
     * @param joinPoint
     * @return
     */
    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {

        // 从切面织入点处通过反射机制获取织入点处的方法
        final Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        final String[] names = methodSignature.getParameterNames();
        final Object[] args = joinPoint.getArgs();

        if (ArrayUtil.isEmpty(names) || ArrayUtil.isEmpty(args)) {
            return Collections.emptyMap();
        }
        if (names.length != args.length) {
            log.warn("{}方法参数名和参数值数量不一致", methodSignature.getName());
            return Collections.emptyMap();
        }
        Map<String, Object> map = Maps.newHashMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], args[i]);
        }
        return map;
    }

    /**
     * 获取方法参数名和参数值
     *
     * @param joinPoint
     * @return
     */
    private Map<String, Object> getNameAndValue(JoinPoint joinPoint) {

        // 从切面织入点处通过反射机制获取织入点处的方法
        final Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        final String[] names = methodSignature.getParameterNames();
        final Object[] args = joinPoint.getArgs();

        if (ArrayUtil.isEmpty(names) || ArrayUtil.isEmpty(args)) {
            return Collections.emptyMap();
        }
        if (names.length != args.length) {
            log.warn("{}方法参数名和参数值数量不一致", methodSignature.getName());
            return Collections.emptyMap();
        }
        Map<String, Object> map = Maps.newHashMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], args[i]);
        }
        return map;
    }


    private static final String UNKNOWN = "unknown";

    /**
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     * 获取ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
//        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("X-Real-IP");
//        }
        String comma = ",";
        String localhost = "127.0.0.1";
        if (ip.contains(comma)) {
            ip = ip.split(",")[0];
        } else {
            return ip;
        }
        if (localhost.equals(ip)) {
            // 获取本机真正的ip地址
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.error(e.getMessage(), e);
            }
        }
        return ip;
//        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    static class Log {
//        // 线程id
//        private String threadId;
//        // 线程名称
//        private String threadName;
//        // ip
//        private String ip;
//        // url
//        private String url;
//        // http方法 GET POST PUT DELETE PATCH
//        private String httpMethod;
//        // 类方法
//        private String classMethod;
//        // 请求参数
//        private Object requestParams;
//        // 返回参数
//        private Object result;
//        // 接口耗时
//        private Long timeCost;
//        // 操作系统
//        private String os;
//        // 浏览器
//        private String browser;
//        // user-agent
//        private String userAgent;
//    }


    /**
     * 180      * 转换request 请求参数
     * 181      *
     * 182      * @param paramMap request获取的参数数组
     * 183
     */
//    public Map<String, String> converMap(Map<String, String[]> paramMap) {
//        Map<String, String> rtnMap = new HashMap<String, String>();
//        for (String key : paramMap.keySet()) {
//            rtnMap.put(key, paramMap.get(key)[0]);
//        }
//        return rtnMap;
//    }

    /**
     * 获取请求参数
     */
//    private Object[] getRequestParam(ProceedingJoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        Object[] arguments = new Object[args.length];
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
//                //ServletRequest，ServletResponse,MultipartFile不能序列化
//                continue;
//            }
//            arguments[i] = args[i];
//        }
//        return arguments;
//    }


    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        return message;
    }

}