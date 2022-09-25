package com.stars.pratise.demo.crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.stars.pratise.demo.common.PageModel;
import com.stars.pratise.demo.common.TypeConversion;
import com.stars.pratise.demo.core.model.PageInfos;
import com.stars.pratise.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


public class BaseServices<T, K extends Serializable> implements IServices<T, K> {

    @Resource
    protected Mappers<T> mapper;

    private Class<T> modelClass;//当前泛型的真实类型Class

    public BaseServices() {
//        通过泛型反射，获取子类中实际要操作的对象class，通过class，service就知道要对哪个对象进行增删改查操操作。
//        另外，我们注入了dao层的泛型Mappers<T, K>，通过Mybatis对数据库进行增删改查操作

        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
//    @CachePut(value = "demo", key = "#root.args[0].id")
    @CachePut(keyGenerator = "keyGenerator", value = "demo")
//    @CachePut(key = "#root.args[0]+'_'+#root.args[0].id", value = "demo")
    public Object insert(T t) {
        //        说明：保存一个实体，null的属性不会保存，会使用数据库默认值
        //        mapper.insertSelective(t);
        int result = mapper.insertSelective(t);
        if (result > 0) {
            return t;
        } else {
//        说明：保存一个实体，null的属性不会保存，会使用数据库默认值
            return 0;
        }

    }

    @Override
//    @Cacheable(key = "#p0.id")
    @CachePut(keyGenerator = "keyGenerator", value = "demo")
    public Object update(T t) {

//        根据主键更新属性不为null的值
        int result = mapper.updateByPrimaryKeySelective(t);
        if (result > 0) {
            return t;
        } else {
            return 0;
        }

////        根据主键更新属性不为null的值
//        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
//    @CacheEvict(value = "demo", keyGenerator = "keyGenerator")
//    @CacheEvict(key = "#root.target+'_'+#p0", value = "demo")
    @CacheEvict(keyGenerator = "keyGenerator", value = "demo", beforeInvocation = true)
//    @CacheEvict(key = "#p0", allEntries = true)
    public Object delete(K id) {
        return mapper.deleteByPrimaryKey(id);
    }

    //    除了上面三个配置值之外，查看@Cacheable注解源码的童鞋可以看到还有condition设置，这个表示当它设置的条件达成时，才写入缓存
//    接下来是unless参数，从名字上可以看出它表示不满足条件时才写入缓存
    @Override
//    @Cacheable(key = "#root.target+'_'+#p0", value = "StarsPratiseDemo", condition = "#p0>0", unless = "#result==null")
    @Cacheable(keyGenerator = "keyGenerator", value = "demo", condition = "#p0>0", unless = "#result==null")
//    @Cacheable(key = "#root.caches[0].name+'_'+#p0", value = "demo", condition = "#p0>0", unless = "#result==null")
//    @Cacheable(key = "#root.target+'_'+#p0", value = "demo", condition = "#p0>0", unless = "#result==null")
    public T get(K id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Object queryPageList(int pageNum, int pageSize, Map<String, Object> params) {


        Example example = new Example(modelClass);
        for (String str : params.keySet()) {
            example.or().andLike(str, "%" + params.get(str) + "%");
        }
        PageHelper.startPage(pageNum, pageSize, true);
        return mapper.selectByExample(example);

//        PageInfo<T> pageInfo = PageHelper.startPage(pageNum, pageSize, true).doSelectPageInfo(mapper::selectAll);
//        return pageInfo;


        //        mapper.select
//        Gson gson = new Gson();
//        JsonElement jsonElement = gson.toJsonTree(params);
//        T t = gson.fromJson(jsonElement, modelClass);

//        PageHelper.startPage(pageNum, pageSize, true);
//        mapper.selectByCondition(params);

//        return mapper.selectByCondition(params);
//        System.out.println(t.toString());

//        System.out.println(this.getClass().toString());
//        System.out.println(modelClass.toString());
//        System.out.println((ParameterizedType) this.getClass().getGenericSuperclass());
//        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//        final T pojo = (T) mapper.convertValue(params, this.getClass());

//        Page page = PageHelper.startPage(pageIndex, pageSize, true);
//        return pageInfo;
//        PageHelper.startPage(pageIndex, pageSize);
//        Page page = mapper.queryPageList(params);//Page本身是一个ArrayList对象，转换为json时不会保留分页信息
//        PageInfo pageInfo = page.toPageInfo();//将page转换成pageInfo会保存分页信息返回
//        return new PageModel(pageInfo);
    }

    @Override
    public Object queryList(Map<String, Object> params) {
        Example example = new Example(modelClass);
        for (String str : params.keySet()) {
            example.or().andLike(str, "%" + params.get(str) + "%");
        }
        return mapper.selectByExample(example);

    }
}
