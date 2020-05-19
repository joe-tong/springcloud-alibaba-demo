package com.tpp.feign.service;

import com.tpp.common.bean.ProductInfo;
import com.tpp.common.bean.StockInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "stock-center")
public interface StockService {


    /**
     * fe
     * @param id
     * @return
     */
    @GetMapping("/stock/{productId}/detail")
    StockInfo getStockInfo(@PathVariable("productId") Integer id);

    @GetMapping("/stock/sentinel/detail")
    String getStockInfo();
}
