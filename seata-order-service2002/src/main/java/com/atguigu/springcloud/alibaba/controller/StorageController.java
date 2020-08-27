package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {
    @Resource
    private StorageService storageService;


    /**
     * 创建订单
     *
     * @param productId
     * @return
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功");
    }
}
