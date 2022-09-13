package com.stars.pratise.demo.demo.cores;


import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

//上面两个mapper中，第一个多继承了IdsMapper，其余都是一样的，那为什么需要TkMapper呢，因为继承了IdsMapper的业务Mapper，其实体类中必须且只能有一个主键ID，联合主键或者没有主键都不行，否则启动会报错。
public interface TkMapper<T> extends
        BaseMapper<T>,
        MySqlMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T> {
}
