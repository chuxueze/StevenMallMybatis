package com.steven.mall.mapper;

import com.steven.mall.domain.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定义接口映射器
 */
@Repository
//@Mapper
public interface DealMapper {
    // 查询所有商品
    //@Select("Select * from deal")
    List<Deal> getAllDeals();
}
