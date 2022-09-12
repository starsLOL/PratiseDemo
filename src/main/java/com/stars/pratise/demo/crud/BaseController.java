package com.stars.pratise.demo.crud;


import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.util.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class BaseController<T, K> extends AbstractController<T, K> {

    @Autowired
    private IServices<T, K> service;

    @PostMapping("/insert")
    @Override
    public ResponseData insert(@RequestBody T t) {
        return ResponseDataUtil.success(service.insert(t));
    }

    @PostMapping("/update")
    @Override
    public ResponseData update(@RequestBody T t) {
        return ResponseDataUtil.success(service.update(t));
    }

    @GetMapping("/delete")
    @Override
    public ResponseData delete(K id) {
        return ResponseDataUtil.success(service.delete(id));
    }

    @GetMapping("/get")
    @Override
    public ResponseData get(K id) {
        return ResponseDataUtil.success(service.get(id));
    }

    @GetMapping("/page-list")
    @Override
    public ResponseData queryPageList(@RequestParam(required = false, defaultValue = "20") int pageSize,
                                      @RequestParam(required = false, defaultValue = "1") int pageIndex,
                                      @RequestParam Map<String, Object> params) {
        return ResponseDataUtil.success(service.queryPageList(pageSize, pageIndex, params));
    }

    @GetMapping("/list")
    @Override
    public ResponseData queryList(@RequestParam Map<String, Object> params) {
        return ResponseDataUtil.success(service.queryList(params));
    }
}
