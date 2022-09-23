package com.stars.pratise.demo.constants;

/**
 * @Auther: stars
 * @Description: 项目名常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.stars.pratise.demo";    //项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".core.model";    //Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".core.mapper";    //Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".core.service";    //Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".core.service.impl";    //ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + "core.controller";    //Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".crud.Mapper";    //Mapper插件基础接口的完全限定名
    public static final String TKMAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.TkMapper";    //TkMapper插件基础接口的完全限定名无ID
}
