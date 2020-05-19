package com.tpp.stock;

import com.tpp.common.bean.ProductInfo;
import com.tpp.common.bean.StockInfo;
import io.swagger.annotations.Tag;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/3/31 17:27
 */
@RestController()
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private int port;

    /**
     * feign第二坑：
     * feign使用@PathVariable的参数必须包装类型
     * @param id
     * @return
     */
    @GetMapping("/{productId}/detail")
    public StockInfo getStockInfo(@PathVariable("productId") Integer id) {
        StockInfo info = new StockInfo();
        info.setNum(id);
        info.setCategory(id+"级类别");
        return info;
    }

    @GetMapping("/sentinel/detail")
    public String sentinelStock(){
        return "ok";
    }


}
