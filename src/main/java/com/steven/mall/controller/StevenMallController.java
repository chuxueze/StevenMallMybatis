package com.steven.mall.controller;

import com.steven.mall.domain.Deal;
import com.steven.mall.mapper.DealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StevenMallController {

    // 注入用户Service
    @Autowired
    private DealMapper dealMapper;

    @RequestMapping("/hello")
    public String index(){
        return "Hello Steven Mall";
    }

    @RequestMapping("/list")
    public List<Deal> getAllDeals(){
        List<Deal> deals = dealMapper.getAllDeals();
        return  deals;
    }

}
