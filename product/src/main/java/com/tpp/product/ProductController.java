package com.tpp.product;

import com.tpp.common.bean.ProductInfo;
import com.tpp.common.bean.StockInfo;
import com.tpp.feign.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/3/31 17:27
 */
@RestController("产品")
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private int port;


    @Autowired
    private StockService stockService;

    @GetMapping("detail")
    public ProductInfo getProductInfo() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(String.valueOf(Math.random() * 100 + 1));
        productInfo.setName("product");
        productInfo.setPort(port);
        return productInfo;
    }


    @GetMapping("get/stock")
    public StockInfo getStockInfo(int id) {
        return stockService.getStockInfo(id);
    }


    @GetMapping("/get_product")
    public ProductInfo getProductInfo(String id) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(id);
        productInfo.setName("product");
        productInfo.setPort(port);
        return productInfo;
    }

    @GetMapping("/get_products")
    public ProductInfo getProductInfos(int id) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(String.valueOf(id));
        productInfo.setName("product");
        productInfo.setPort(port);
        return productInfo;
    }


    /**
     * sentinel整合springCloud
     * @return
     */
    @GetMapping("/sentinel/stock")
    public String sentinelGetStock(){
        return stockService.getStockInfo();
    }
}
