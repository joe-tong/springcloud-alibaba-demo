package com.tpp.feign.service;

import com.tpp.common.bean.ProductInfo;
import com.tpp.feign.config.ProductCenterFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-center",configuration = ProductCenterFeignConfig.class)
public interface ProductService {

    /**
     * feign很坑的地方，get自动转post
     * 1.get请求一定要加@RequestParam,@PathVariable(必须是包装类型)
     * 2.post请求一定要加@RequestBody
     * 3.@PathVariable一定要{}值
     * @param id
     * @return
     */
    @RequestMapping("/product/get_product")
    ProductInfo getProductInfo(@RequestParam String id);

    @RequestMapping("/product/get_products")
    ProductInfo getProductInfos(@RequestParam int id);

}
