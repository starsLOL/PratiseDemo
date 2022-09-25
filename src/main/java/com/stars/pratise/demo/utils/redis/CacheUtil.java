package com.stars.pratise.demo.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 缓存操作工具类
 */
@Component
public class CacheUtil {

    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        CacheUtil.redisTemplate = redisTemplate;
    }

    /**
     * 获得RedisTemplate
     *
     * @return RedisTemplate
     */
    public static RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 是否包含某个key
     *
     * @param key key
     * @return booble
     */
    public static Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 添加或更新
     *
     * @param key   键
     * @param value 值
     */
    public static void set(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取
     *
     * @param key 键
     */
    public static Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除
     *
     * @param key 键
     */
    public static void delete(Object key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除
     *
     * @param keys 键集合
     */
    public static void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

}