package com.stars.pratise.demo.redis;

import com.alibaba.fastjson2.support.spring.data.redis.GenericFastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.*;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.*;

@Slf4j
@Configuration
public class RedisConfig {
    // custom cache key
    public static final int NO_PARAM_KEY = 0;
    public static final int NULL_PARAM_KEY = 53;


//    /**
//     * 配置cacheManager
//     *
//     * @return
//     */
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
////      redisCacheManager构造器需要提供一个redisCacheWriter和一个redisCacheConfigurer
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
////      配置cache 序列化为jsonSerializer
//        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
//        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer);
//        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
////      设置默认过期时间一天
//        defaultCacheConfig.entryTtl(Duration.ofDays(1));
//
////        也可以通过builder来构建
////       RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(defaultCacheConfig).transactionAware().build();
//        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
//
//    }

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> {
//            return target.getClass().getSimpleName() + "_"
//                    + method.getName() + "_"
//                    + StringUtils.arrayToDelimitedString(params, "_");
//            StringBuffer key = new StringBuffer();
//            key.append(target.getClass().getSimpleName() + "_" + method.getName() + "(");
//            for (Object args : params) {
//                key.append(args + ",");
//            }
//            key.deleteCharAt(key.length() - 1);
//            key.append(")");
//            log.info(" redis 生成的值 :" + key.toString());
//            return key.toString();
//        };
//        return (target, method, params) -> {
//            return target.getClass().getSimpleName() + "_"
//                    + method.getName() + "_"
//                    + StringUtils.arrayToDelimitedString(params, "_");
//        };
//    }

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder key = new StringBuilder();
//            key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
//            if (params.length == 0) {
//                return key.append(NO_PARAM_KEY).toString();
//            }
//            for (Object param : params) {
//                if (param == null) {
//                    log.warn("input null param for Spring cache, use default key={}", NULL_PARAM_KEY);
//                    key.append(NULL_PARAM_KEY);
//                } else if (ClassUtils.isPrimitiveArray(param.getClass())) {
//                    int length = Array.getLength(param);
//                    for (int i = 0; i < length; i++) {
//                        key.append(Array.get(param, i));
//                        key.append(',');
//                    }
//                } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {
//                    key.append(param);
//                } else {
//                    log.warn("Using an object as a cache key may lead to unexpected results. " +
//                            "Either use @Cacheable(key=..) or implement CacheKey. Method is " + target.getClass() + "#" + method.getName());
//                    key.append(param.hashCode());
//                }
//                key.append('-');
//            }
//
//            key.deleteCharAt(key.length() - 1);
//            String finalKey = key.toString();
//            long cacheKeyHash = Hashing.murmur3_128().hashString(finalKey, Charset.defaultCharset()).asLong();
//            log.debug("using cache key={} hashCode={}", finalKey, cacheKeyHash);
//            return key.toString();
//        };
//
//
//    }


    //    自定义缓存key生成策略
    @Bean

    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {

//                System.out.printf(params.getClass().getName());

//                ParameterizedType pt = (ParameterizedType) params.getClass().getGenericSuperclass();
//                System.out.println(pt.getActualTypeArguments()[0]);

                if (params.length == 1 && params[0] != null && params[0].toString().contains("{") && params[0].toString().contains("}")) {
                    String key = params[0].toString();
//                    if (key.contains("{")) {
//                        int index = key.indexOf("{");
//                        key = key.substring(index, key.length());
//                    }
                    key = key.substring(key.indexOf("{"), key.length()).replaceAll("\\s+", "").replace("=", ":");
                    Gson gson = new Gson();
                    Map<String, Object> map = gson.fromJson(key, new TypeToken<Map<String, Object>>() {
                    }.getType());

                    if (map.isEmpty()) {
                        key = UUID.randomUUID().toString();
                    } else {
                        key = String.valueOf(map.get("id"));
                        key = key.substring(0, key.indexOf("."));
                    }

                    return target.getClass().getSimpleName() + "_" + key;
                } else {


                    return target.getClass().getSimpleName() + "_"
                            + StringUtils.arrayToDelimitedString(params, "_");
                }

//                StringBuilder key = new StringBuilder();
//                key.append(target.getClass().getName());
//                key.append(method.getName());
//                for (Object obj : params) {
//                    key.append(obj.toString() + ",");
//                }
//                log.info(" redis 生成的值 :" + sb.toString());
//                return key.toString();
            }
        };
    }

    /**
     * retemplate相关配置
     *
     * @param factory
     * @return
     */

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate(LettuceConnectionFactory factory) {
        // 自定义 String Object
        RedisTemplate<String, Object> template = new RedisTemplate();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        // Json 序列化配置
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        // ObjectMapper 转译
        ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        //        指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        //        setVisibility(forMethod,visibility)
        //        用来替换默认序列化检测（默认public fileds或者public getXXX()）
        //        formethod 为受影响属性（field/getter/setter）
        //        visibility 设置属性最小设定（可以是PUBLIC,ANY,PRIVATE）
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //      指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        //      指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//      弃用，换用activeDefaultTyping(PolymorphicTypeValidator,ObjectMapper.DefaultTyping,JsonTypeInfo.As)
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会报异
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //        配置redistemplate序列化

        // String 的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key 采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash 的key也采用 String 的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value 序列化方式采用 jackson
        template.setValueSerializer(objectJackson2JsonRedisSerializer);
        // hash 的 value 采用 jackson
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    /**
     * 配置缓存管理器
     *
     * @param factory Redis 线程安全连接工厂
     * @return 缓存管理器
     */
    /**
     * 缓存配置管理器
     */
    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory factory) {
        //以锁写入的方式创建RedisCacheWriter对象
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(factory);
        /*
        设置CacheManager的Value序列化方式为JdkSerializationRedisSerializer,
        但其实RedisCacheConfiguration默认就是使用
        StringRedisSerializer序列化key，
        JdkSerializationRedisSerializer序列化value,
        所以以下注释代码就是默认实现，没必要写，直接注释掉
         */
        // RedisSerializationContext.SerializationPair pair = RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer(this.getClass().getClassLoader()));
        // RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //创建默认缓存配置对象
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1))
                .disableCachingNullValues().serializeKeysWith(keyPair()).serializeValuesWith(valuePair());
        RedisCacheManager cacheManager = new RedisCacheManager(writer, config);
        return cacheManager;


//        //创建FastJson对象，用于序列化
//        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
//        //创建一个RedisCache的配置对象
//        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
//        //过期时间设置为一天
//        //对存的的key,value进行序列化
//        config=config.entryTtl(Duration.ofDays(1))
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer))
//                .disableCachingNullValues();
//        //自己定义要缓存的内存空间名字
//        Set<String> cacheNames=new HashSet<>();
//        cacheNames.add("user");
//        //对缓存空间设置单独的配置，在这个可根据业务，如果数据很久才会变一次时间就可设成永久
//        Map<String,RedisCacheConfiguration> configMap=new HashMap<>();
//        configMap.put("user",config);
//        //创建RedisCacheManage对象，将上面的配置导入
//        RedisCacheManager redisCacheManager=RedisCacheManager.builder(factory)
//                .initialCacheNames(cacheNames)
//                .withInitialCacheConfigurations(configMap)
//                .build();
//        return redisCacheManager;
    }


    /**
     * 配置键序列化
     *
     * @return StringRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * 配置值序列化，使用 GenericJackson2JsonRedisSerializer 替换默认序列化
     *
     * @return GenericJackson2JsonRedisSerializer
     */
    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }

    /**
     * 对hash类型的数据操作
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * 对redis字符串类型数据操作
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * 对链表类型的数据操作
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * 对无序集合类型的数据操作
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * 对有序集合类型的数据操作
     */
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

}
