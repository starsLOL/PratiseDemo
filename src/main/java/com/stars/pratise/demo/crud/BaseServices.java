package com.stars.pratise.demo.crud;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stars.pratise.demo.common.PageModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


public class BaseServices<T, K> implements IServices<T, K> {

    @Autowired
    protected Mappers<T> mapper;

    private Class<T> modelClass;//当前泛型的真实类型Class

    public BaseServices() {
//        通过泛型反射，获取子类中实际要操作的对象class，通过class，service就知道要对哪个对象进行增删改查操操作。
//        另外，我们注入了dao层的泛型Mappers<T, K>，通过Mybatis对数据库进行增删改查操作

        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public Object insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public Object update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public Object delete(K id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T get(K id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Object queryPageList(int pageSize, int pageIndex, Map<String, Object> params) {
        PageHelper.startPage(pageIndex, pageSize);
        Page page = mapper.queryPageList(params);//Page本身是一个ArrayList对象，转换为json时不会保留分页信息
        PageInfo pageInfo = page.toPageInfo();//将page转换成pageInfo会保存分页信息返回
        return new PageModel(pageInfo);
    }

    @Override
    public Object queryList(Map<String, Object> params) {
        return mapper.queryList(params);
    }
}
